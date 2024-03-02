package paben.openai.client

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import okhttp3.Response

class OpenAIClientShould : StringSpec({
    val rest = mockk<RestClient>()
    val openAIClient = OpenAIClient(rest)
    "call post with completion message" {
        val messages = listOf(Message("system", "You are Darth Vader"))
        val response = mockk<Response>()
        every {  response.isSuccessful } returns true
        every {  rest.post(messages) } returns response

        val res = openAIClient.completions(messages)

        verify { rest.post(messages) }
        res shouldBe true
    }

})