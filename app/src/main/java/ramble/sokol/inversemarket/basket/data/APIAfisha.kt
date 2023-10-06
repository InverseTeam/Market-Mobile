package ramble.sokol.sberafisha.afisha.model.service

import ramble.sokol.sberafisha.afisha.model.data.ResponseEvents
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface APIAfisha {

    // get request for all events
    @GET("products/shops/")
    suspend fun getAllEvents(): Response<ArrayList<ResponseEvents>>

}