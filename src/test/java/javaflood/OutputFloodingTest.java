package javaflood;

import java.util.Random;
import java.util.stream.Stream;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class OutputFloodingTest {

  private static final Logger log = org.apache.logging.log4j.LogManager
      .getLogger(KotlinOutputFloodingTest.class);

  @Test
  public void generateLogOutput() {
    Stream.generate(() -> RandomStringUtils.randomAlphabetic(10_000))
        .limit(1_000)
        .forEach(this::randomLogEvent);
  }

  void randomLogEvent(String message) {
    String[] levels = {"trace", "debug", "info", "warn", "error"};
    int index = new Random().nextInt(levels.length);
    String random = (levels[index]);

    switch (random) {
      case "trace":
        log.trace(message);
        break;
      case "debug":
        log.debug(message);
        break;
      case "info":
        log.info(message);
        break;
      case "warn":
        log.warn(message);
        break;
      case "error":
        log.error(message);
        break;
    }
  }

}
