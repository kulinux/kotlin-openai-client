package paben.openai.client

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.Serializable

class RestClient(private val url: String) {

    private val mediaType: MediaType = "application/json".toMediaType()

    fun post(obj: Any): Response {
        val json = Json.encodeToString(obj)
        val client = OkHttpClient()
        val body: RequestBody = json.toRequestBody(mediaType)
        val request: Request = Request.Builder()
            .url(url)
            .post(body)
            .build()
        return client.newCall(request).execute()
    }
}