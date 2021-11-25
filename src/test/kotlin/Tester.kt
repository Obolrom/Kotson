import org.junit.Before
import org.junit.Test
import kotlin.test.BeforeTest
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
        assertEquals(expectedField, oneFieldJsonObject.fields[0])
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

}