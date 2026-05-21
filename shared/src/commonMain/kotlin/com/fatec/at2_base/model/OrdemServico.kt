package com.fatec.at2_base.model

import kotlinx.serialization.Serializable

@Serializable
data class OrdemServico(
    val id: Int,
    val cliente: String,
    val marca: String,
    val modelo: String,
    val ano: Int,
    val quilometragem: Int,
    val solicitacao: String,
    val status: String,
    val dataAbertura: String
)