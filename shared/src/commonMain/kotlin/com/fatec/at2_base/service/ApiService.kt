package com.fatec.at2_base.service

import com.fatec.at2_base.model.OrdemServico
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class ApiService {

    private val client = HttpClient()

    suspend fun buscarOrdens(): List<OrdemServico> {

        return client.get(
            "http://10.0.2.2:8080/ordens"
        ) {
            contentType(ContentType.Application.Json)
        }.body()

    }
}