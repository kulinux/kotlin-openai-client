package paben.openai.clientusage

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import paben.openai.client.Message
import paben.openai.client.OpenAIClientBuilder

class OpenAIClientBehave : BehaviorSpec({
    val key = "One key"
    Given("An authenticated OpenAI api") {
        val openAIClient = OpenAIClientBuilder
            .builder()
            .withKey(key)
            .build()!!

        When("I use the client api") {
            val res = openAIClient.completions(listOf( Message("system", "you are a happy servant")))
            Then("The api should respond") {
                res shouldBe true
            }
        }
    }

})