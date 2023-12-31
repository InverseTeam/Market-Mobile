package ramble.sokol.inversemarket.authentication_and_splash.model.utils

import com.google.gson.JsonObject
import ramble.sokol.inversemarket.authentication_and_splash.model.models.ResponseAuth
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST

interface APIAuth {

    // request for login and get token
    @POST("users/auth/token/login/")
    fun entryAndGetToken(@Body body: JsonObject): Call<ResponseAuth>

}