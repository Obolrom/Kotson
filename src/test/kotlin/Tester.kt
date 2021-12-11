import org.junit.Test
import kotlin.math.exp
import kotlin.test.assertEquals

class Tester {

    @Test
    fun emptyJsonObject() {
        val jsonObj = obj { }
        assert(jsonObj is JsonObject)
    }

    @Test
    fun oneFieldJsonObject() {
        val expectedField = JsonField("field1", JsonString("value1"))
        val oneFieldJsonObject = obj {
            "field1" by "value1"
        }
        assertEquals(expectedField, oneFieldJsonObject.fields[0] as JsonField<JsonString>)
    }

    @Test
    fun someStringFieldsJson() {
        val expected = JsonObject().apply {
            "firstName".by(JsonString("Billy"))
            "lastName".by(JsonString("Herrington"))
            "nickName".by(JsonString("fucking slave"))
        }
        val multipleStringFieldsJson = obj {
            "firstName" by "Billy"
            "lastName" by "Herrington"
            "nickName" by "fucking slave"
        }
        println(multipleStringFieldsJson)
        assertEquals(expected, multipleStringFieldsJson)
    }

    @Test
    fun someNumberFieldsJson() {
        val expected = JsonObject().apply {
            "one".by(JsonNumber(1))
            "oneLong".by(JsonNumber(1L))
            "double".by(JsonNumber(3.14))
            "float".by(JsonNumber(2.24f))
            "float2".by(JsonNumber(1.0f))
            "expo".by(JsonNumber(2.99792458e8))
        }
        val multipleNumberFieldsJson = obj {
            "one" by 1
            "oneLong" by 1L
            "double" by 3.14
            "float" by 2.24f
            "float2" by 1.0f
            "expo" by 2.99792458e8
        }
        println(multipleNumberFieldsJson)
        assertEquals(expected, multipleNumberFieldsJson)
    }

    @Test
    fun booleanFieldsTest() {
        val expected = JsonObject().apply {
            "true".by(JsonBoolean(true))
            "false".by(JsonBoolean(false))
        }
        val booleanFieldsJson = obj {
            "true" by true
            "false" by false
        }
        println(booleanFieldsJson)
        assertEquals(expected, booleanFieldsJson)
    }

    @Test
    fun nullFieldTest() {
        val expected = JsonObject().apply {
            "nullObj".by(JsonNull)
        }
        val nullFieldJson = obj {
            "nullObj" by Null
        }
        println(nullFieldJson)
        assertEquals(expected, nullFieldJson)
    }

}