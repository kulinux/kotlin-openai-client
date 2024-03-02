package paben.openai.client

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import okhttp3.OkHttpClient
import okhttp3.Response

class OpenAIClientShould : StringSpec({
    val rest = mockk<RestClient>()
    val openAIClient = OpenAIClient(rest)
    "call post with completion message" {
        val messages = listOf(Message("system", "You are Darth Vader"))
        val response = mockk<Response>()
        val completion = Completion(model = "gpt-3.5-turbo", messages)

        every {  response.isSuccessful } returns true
        every {  rest.post(completion) } returns response

        val res = openAIClient.completions(messages)

        verify { rest.post(completion) }
        res shouldBe true
    }

})