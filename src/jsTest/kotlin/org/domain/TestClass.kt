package org.domain

import kotlin.test.Test
import kotlin.test.assertEquals

class TestClass {

    @Test
    fun testFail() {
//        assertEquals(1, 2, "1 not equals 2") //uncomment to check failed test execution
    }

    @Test
    fun testLogic() {
        assertEquals("Kotlin/JS", someLogic())
    }

}