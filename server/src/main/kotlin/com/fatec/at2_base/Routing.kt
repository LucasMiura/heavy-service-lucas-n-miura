package com.fatec.at2_base

import com.fatec.at2_base.model.OrdemServico
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    val ordens = mutableListOf(

        OrdemServico(
            id = 1,
            cliente = "Transportadora Vale Sul",
            marca = "Volvo",
            modelo = "FH 540",
            ano = 2022,
            quilometragem = 185000,
            solicitacao = "Ruído no sistema de freios e perda de pressão",
            status = "Em análise",
            dataAbertura = "2026-05-20"
        ),

        OrdemServico(
            id = 2,
            cliente = "Logística Miura Express",
            marca = "Scania",
            modelo = "R450",
            ano = 2021,
            quilometragem = 243500,
            solicitacao = "Falha elétrica no painel e bateria descarregando",
            status = "Aguardando peças",
            dataAbertura = "2026-05-19"
        ),

        OrdemServico(
            id = 3,
            cliente = "Transportes Serra Azul",
            marca = "Mercedes-Benz",
            modelo = "Actros 2651",
            ano = 2023,
            quilometragem = 98000,
            solicitacao = "Troca preventiva de óleo e filtros",
            status = "Finalizado",
            dataAbertura = "2026-05-18"
        )
    )

    routing {

        get("/") {
            call.respondText(
                "API Heavy Service funcionando!"
            )
        }

        get("/ordens") {
            call.respond(ordens)
        }

        post("/ordens") {

            val novaOrdem =
                call.receive<OrdemServico>()

            ordens.add(novaOrdem)

            call.respond(
                HttpStatusCode.Created,
                novaOrdem
            )
        }
    }
}