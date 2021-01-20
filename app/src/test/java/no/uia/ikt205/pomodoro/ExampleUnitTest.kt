package no.uia.ikt205.pomodoro

import no.uia.ikt205.pomodoro.util.millisecondsToDescriptiveTime
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testTimeConversion_isCorrect(){
        assertEquals("00:00:00", millisecondsToDescriptiveTime(1))
        assertEquals("00:01:30", millisecondsToDescriptiveTime(90000))
        assertEquals("02:30:01",millisecondsToDescriptiveTime(9001000))
    }
}