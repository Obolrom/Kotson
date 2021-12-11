
interface JsonType

class JsonObject : JsonType {

    private val internalFields: MutableList<JsonField<JsonType>> = mutableListOf()
    val fields: List<JsonField<JsonType>> = internalFields

    val Null get() = JsonNull

    override fun toString(): String {
        return internalFields.joinToString()
    }

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

    infix fun String.by(jsonNumber: Number) {
        internalFields.add(JsonField(this, JsonNumber(jsonNumber)))
    }

    infix fun String.by(jsonBoolean: Boolean) {
        internalFields.add(JsonField(this, JsonBoolean(jsonBoolean)))
    }

    infix fun String.by(jsonNull: JsonNull) {
        internalFields.add(JsonField(this, JsonNull))
    }

}

data class JsonString(private val value: String) : JsonType {
    override fun toString() = value
}

data class JsonNumber(private val value: Number) : JsonType {
    override fun toString() = value.toString()
}

data class JsonBoolean(private val value: Boolean) : JsonType {
    override fun toString() = value.toString()
}

object JsonNull : JsonType {
    override fun toString() = "null"
}

data class JsonField<T>(val field: Pair<String, T>) {

    constructor(name: String, value: T): this(Pair(name, value))

    override fun toString() = "\"${field.first}\": ${field.second}"

}