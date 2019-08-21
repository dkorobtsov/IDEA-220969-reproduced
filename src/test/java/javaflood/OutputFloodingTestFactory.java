package javaflood;

import java.util.stream.Stream;
import org.testng.annotations.Factory;

public class OutputFloodingTestFactory {

  @Factory
  public Object[] factoryMethod(){
    return Stream.generate(OutputFloodingTest::new)
        .limit(200)
        .toArray(Object[]::new);
  }

}
