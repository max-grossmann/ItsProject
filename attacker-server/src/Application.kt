package com.kleinmann

import com.kleinmann.util.getResourceContent
import io.ktor.application.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    routing {
        get("/") {
            call.respondText("IT Security Project")
        }

        post("/report") {
            val parameters = call.receiveParameters()
            println("${parameters["key"]} => ${parameters["value"]}")

            call.respondText("OK")
        }

        get("/attack") {
            var attackSH = getResourceContent("static/attack.sh")
            attackSH = attackSH.replace("\r\n", "\n")
                    .replace("\r", "\n")

            println(attackSH)

            call.respondText(attackSH)
        }

        static {
            static("static") {
                resources("static")
            }
        }

    }

}