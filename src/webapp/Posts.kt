package dev.adaniel.webapp

import dev.adaniel.repository.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

const val POSTS = "/posts"

fun Route.posts(db: Repository) {
    get(POSTS) {
        val posts = db.posts()
        call.respond(posts.toArray())
    }
}