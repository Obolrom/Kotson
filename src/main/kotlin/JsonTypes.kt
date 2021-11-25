
interface JsonType

class JsonObject : JsonType {

    private val internalFields: MutableList<JsonField<JsonType>> = mutableListOf()
    val fields: List<JsonField<JsonType>> = internalFields

    override fun equals(other: Any?): Boolean {
        if (other !is JsonObject) error("Not compatible types JsonObject and ${other?.javaClass}")
        return other.internalFields == internalFields
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    infix fun String.by(field: JsonType) {
        internalFields.add(JsonField(this, field))
    }

    infix fun String.by(jsonString: String) {
        internalFields.add(JsonField(this, JsonString(jsonString)))
    }

}

data class JsonString(private val value: String) : JsonType {
    override fun toString() = value
}

typealias JsonField<T> = Pair<String, T>