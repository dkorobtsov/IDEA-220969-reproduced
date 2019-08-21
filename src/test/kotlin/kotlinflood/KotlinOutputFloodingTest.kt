package javaflood

import org.apache.commons.lang3.RandomStringUtils
import org.apache.logging.log4j.kotlin.Logging
import org.testng.annotations.Test
import java.util.*
import java.util.stream.Stream

class KotlinOutputFloodingTest : Logging {

    @Test
    fun generateLogOutput() {
        Stream.generate { RandomStringUtils.randomAlphabetic(10_000) }
                .limit(1_000)
                .forEach { this.randomLogEvent(it) }
    }

    private fun randomLogEvent(message: String) {
        val levels = arrayOf("trace", "debug", "info", "warn", "error")
        val index = Random().nextInt(levels.size)
        when (levels[index]) {
            "trace" -> logger.trace(message)
            "debug" -> logger.debug(message)
            "info" -> logger.info(message)
            "warn" -> logger.warn(message)
            "error" -> logger.error(message)
        }
    }

}
