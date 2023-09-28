package br.com.rest.ui

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

//import khttp.delete as httpDelete

class HttpClient {
    suspend fun get(): String {
        val client = HttpClient(CIO)
        val response: HttpResponse = client.get("https://gita-api.vercel.app/odi/verse/1/1") {
            headers {
                append(HttpHeaders.Accept, "application/json")
            }
        }
        return response.body<String>()
    }
}