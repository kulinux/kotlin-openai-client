package paben.openai.clientusage

import io.kotest.core.spec.style.BehaviorSpec
import paben.openai.client.OpenAIClient

class OpenAIClientBehave: BehaviorSpec({
    val KEY = "1234556"
    Given("An authenticated OpenAI api") {
        val openAIClient = OpenAIClient().withKey(KEY)
        And("a key") {
            When("I use the client api") {
                Then("The api should respond") {
                }
            }
        }
    }

})