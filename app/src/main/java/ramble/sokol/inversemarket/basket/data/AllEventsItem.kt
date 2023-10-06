package ramble.sokol.sberafisha.afisha.model.data

data class AllEventsItem(
    val id: Long,
    val cover: String,
    val name: String
)

fun ResponseEvents.toAllEventsItem() = AllEventsItem(id, cover, name)