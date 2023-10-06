package ramble.sokol.sberafisha.afisha.model.data

import com.google.gson.annotations.SerializedName

data class ResponseEvents(

    @SerializedName("id")
    val id: Long,

    @SerializedName("cover")
    val cover: String,

    @SerializedName("name")
    val name: String

    )
