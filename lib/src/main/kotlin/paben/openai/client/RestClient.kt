package paben.openai.client

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.logging.HttpLoggingInterceptor


const val OPENAPI_URL = ""

class RestClient(private val url: String = OPENAPI_URL, val key: String = "") {
    private val mediaType: MediaType = "application/json".toMediaType()

    fun post(path: String, json: String): Response {
        //val json = Json.encodeToString(obj)

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
        val client = OkHttpClient.Builder().addInterceptor(logging).build()

        val body: RequestBody = json.toRequestBody(mediaType)

        val request: Request = Request.Builder()
            .url(url + path)
            .addHeader("Authorization", "Bearer $key")
            .post(body)
            .build()
        return client.newCall(request).execute()
    }
}