package br.com.clebersonp.scope_values;

import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;

@FunctionalInterface
interface WeatherService {

  String getWeather();
}

/**
 * @author cleberson
 */
public class WeatherServiceTest {

  private final ScopedValue<String> location = ScopedValue.newInstance();

  public static void main(String[] args) {
    WeatherServiceTest weatherServiceTest = new WeatherServiceTest();
    ScopedValue.runWhere(weatherServiceTest.getLocation(), "New York", weatherServiceTest::getWeather);
  }

  public ScopedValue<String> getLocation() {
    return location;
  }

  public void getWeather() {
    try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
      Subtask<String> res1 = scope.fork(() -> new SunnyWeatherService(this).getWeather());
      Subtask<String> res2 = scope.fork(() -> new CloudyWeatherService(this).getWeather());
      Subtask<String> res3 = scope.fork(() -> new RainyWeatherService(this).getWeather());
      scope.join().throwIfFailed();
      System.out.printf("Res1: %s, Res2: %s, Res3: %s", res1.get(), res2.get(), res3.get());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}

class SunnyWeatherService implements WeatherService {

  private final WeatherServiceTest weatherServiceTest;

  public SunnyWeatherService(WeatherServiceTest weatherServiceTest) {
    this.weatherServiceTest = weatherServiceTest;
  }

  @Override
  public String getWeather() {
    System.out.printf("Thread in SunnyWeatherService: %s\n", Thread.currentThread());
    if (this.weatherServiceTest.getLocation().isBound()) { // check whether the value is available in the current thread
      return "Weather for '%s' Sunny".formatted(this.weatherServiceTest.getLocation().get());
    }
    throw new RuntimeException("Location not specified");
  }
}

class CloudyWeatherService implements WeatherService {

  private final WeatherServiceTest weatherServiceTest;

  public CloudyWeatherService(WeatherServiceTest weatherServiceTest) {
    this.weatherServiceTest = weatherServiceTest;
  }

  @Override
  public String getWeather() {
    System.out.printf("Thread in CloudyWeatherService: %s\n", Thread.currentThread());
    if (this.weatherServiceTest.getLocation().isBound()) { // check whether the value is available in the current thread
      return "Weather for '%s' Cloudy".formatted(this.weatherServiceTest.getLocation().get());
    }
    throw new RuntimeException("Location not specified");
  }
}

class RainyWeatherService implements WeatherService {

  private final WeatherServiceTest weatherServiceTest;

  public RainyWeatherService(WeatherServiceTest weatherServiceTest) {
    this.weatherServiceTest = weatherServiceTest;
  }

  @Override
  public String getWeather() {
    System.out.printf("Thread in RainyWeatherService: %s\n", Thread.currentThread());
    if (this.weatherServiceTest.getLocation().isBound()) { // check whether the value is available in the current thread
      return "Weather for '%s' Rainy".formatted(this.weatherServiceTest.getLocation().get());
    }
    throw new RuntimeException("Location not specified");
  }
}
