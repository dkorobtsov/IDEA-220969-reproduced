package kotlinflood

import javaflood.KotlinOutputFloodingTest
import org.testng.annotations.Factory
import java.util.stream.Stream

class KotlinOutputFloodingTestFactory {

    @Factory
    fun factoryMethod(): Array<Any> {
        return Stream.generate { KotlinOutputFloodingTest() }
                .limit(200)
                .toArray()
    }

}
