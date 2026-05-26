package com.fatec.at2_base.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fatec.at2_base.model.OrdemServico
import com.fatec.at2_base.service.ApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class OrdemServicoViewModel : ViewModel() {

    private val apiService = ApiService()

    private val _ordens =
        MutableStateFlow<List<OrdemServico>>(emptyList())

    val ordens: StateFlow<List<OrdemServico>>
            = _ordens

    init {
        carregarOrdens()
    }

    fun carregarOrdens() {

        viewModelScope.launch {

            try {

                _ordens.value =
                    apiService.buscarOrdens()

            } catch (e: Exception) {

                println("Erro: ${e.message}")

            }
        }
    }
}