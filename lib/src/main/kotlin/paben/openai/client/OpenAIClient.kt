package paben.openai.client

import kotlinx.serialization.Serializable


@Serializable
data class Completion(val model: String = "gpt-3.5-turbo", val messages: List<Message>)

class OpenAIClient(private val restClient: RestClient = RestClient("https://api.openai.com/v1/chat/completions")) {

    fun withKey(key: String): OpenAIClient {
        restClient.key = key
        return this
    }

    fun completions(messages: List<Message>): Boolean {
        return restClient.post(Completion(model = "gpt-3.5-turbo", messages)).isSuccessful
    }
}
