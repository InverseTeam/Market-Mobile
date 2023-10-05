package ramble.sokol.inversemarket.authentication_and_splash.model.models

import com.google.gson.annotations.SerializedName

data class ResponseAuth(

    @SerializedName("auth_token")
    var authToken: String

)
