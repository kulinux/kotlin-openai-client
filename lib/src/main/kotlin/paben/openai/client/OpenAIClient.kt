package paben.openai.client

import arrow.core.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Completion(val model: String = "gpt-3.5-turbo", val messages: List<Message>)

class OpenAIClientBuilder(private val key: Option<String>) {
    fun withKey(key: String) =
        OpenAIClientBuilder(key.some())

    fun build(): OpenAIClient? {
       return key
           .map { OpenAIClient( RestClient("https://api.openai.com/v1", it)) }
           .getOrNull()
    }

    companion object {
        fun builder() = OpenAIClientBuilder(None)
    }
}

class OpenAIClient(private val restClient: RestClient) {

    fun completions(messages: List<Message>): Boolean {
        val obj = Completion(model = "gpt-3.5-turbo", messages)
        val json = Json.encodeToString(obj)
        return restClient.post("/chat/completions", json).isSuccessful
    }
}
