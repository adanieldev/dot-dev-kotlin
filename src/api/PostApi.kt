package dev.adaniel.api

import dev.adaniel.*
import dev.adaniel.model.*
import dev.adaniel.repository.*
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

const val POST_ENDPOINT = "$API_VERSION/post"

fun Route.postApi(db: Repository) {

    post(POST_ENDPOINT) {
        val request = call.receive<Post>()
        val post = db.add(Post(request.title, request.content))
        call.respond(post)
    }
}