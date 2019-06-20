package dev.adaniel.repository

import dev.adaniel.model.Post
import java.lang.IllegalArgumentException
import java.util.concurrent.atomic.AtomicInteger

class InMemoryRepository : Repository {

    private val idCounter = AtomicInteger()
    private val posts = ArrayList<Post>()

    override suspend fun add(post: Post): Post {
        if (posts.contains(post)) {
            return posts.find { it == post }!!
        }
        post.id = idCounter.incrementAndGet()
        posts.add(post)
        return post
    }

    override suspend fun post(id: Int) = post(id.toString())

    override suspend fun post(id: String) =
        posts.find { it.id.toString() == id } ?: throw IllegalArgumentException("No post found for $id")

    override suspend fun posts() = posts.toList()

    override suspend fun remove(post: Post) {
        if (!posts.contains(post)) {
            throw IllegalArgumentException("No post found for id ${post.id}")
        }
        posts.remove(post)
    }

    override suspend fun remove(id: Int) = posts.remove(post(id))

    override suspend fun remove(id: String) = posts.remove(post(id))

    override suspend fun clear() = posts.clear()

}