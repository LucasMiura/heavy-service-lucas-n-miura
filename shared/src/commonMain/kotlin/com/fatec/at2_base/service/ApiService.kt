package com.fatec.at2_base.service

import com.fatec.at2_base.model.OrdemServico
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.client.request.post
import io.ktor.client.request.setBody

class ApiService {

    private val client = HttpClient {
        install(io.ktor.client.plugins.contentnegotiation.ContentNegotiation) {
            json()
        }
    }

    suspend fun buscarOrdens(): List<OrdemServico> {

        return client.get(
            "http://10.0.2.2:8080/ordens"
        ) {
            contentType(ContentType.Application.Json)
        }.body()

    }

    suspend fun adicionarOrdem(
        ordem: OrdemServico
    ) {

        client.post(
            "http://10.0.2.2:8080/ordens"
        ) {

            contentType(ContentType.Application.Json)

            setBody(ordem)

        }
    }
}