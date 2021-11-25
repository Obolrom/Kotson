
fun obj(block: JsonObject.() -> Unit): JsonObject {
    return JsonObject().apply(block)
}