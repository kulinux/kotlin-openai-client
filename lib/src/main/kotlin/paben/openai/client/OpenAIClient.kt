package paben.openai.client

class OpenAIClient(val restClient: RestClient = RestClient("")) {

    fun withKey(key: String): OpenAIClient {
        TODO("Not yet implemented")
    }

    fun completions(messages: List<Message>): Boolean {
        return restClient.post(messages).isSuccessful
    }
}
