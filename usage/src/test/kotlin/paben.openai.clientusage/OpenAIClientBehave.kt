package paben.openai.clientusage

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import paben.openai.client.Message
import paben.openai.client.OpenAIClient

class OpenAIClientBehave : BehaviorSpec({
    val KEY = "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"
    Given("An authenticated OpenAI api") {
        val openAIClient = OpenAIClient().withKey(KEY)
        When("I use the client api") {
            val res = openAIClient.completions(listOf( Message("system", "you are a happy servant")))
            Then("The api should respond") {
                res shouldBe true
            }
        }
    }

})