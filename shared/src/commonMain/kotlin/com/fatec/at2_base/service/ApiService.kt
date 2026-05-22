package com.fatec.at2_base.service

import com.fatec.at2_base.model.OrdemServico
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class ApiService {

    private val client = HttpClient {

        install(ContentNegotiation) {

            json(
                Json {
                    ignoreUnknownKeys = true
                }
            )
        }
    }

    suspend fun buscarOrdens(): List<OrdemServico> {

        return client
            .get("http://10.0.2.2:8080/ordens")
            .body()

    }
}