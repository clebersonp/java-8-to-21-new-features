package br.com.clebersonp.virtual_threads;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

/**
 * @author cleberson
 */
public class TestVirtualThreads {

  public static void main(String[] args) throws MalformedURLException, ExecutionException, InterruptedException {

    Instant start = Instant.now();
    try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
      IntStream.range(0, 10_000).forEach(i -> {
        executor.submit(() -> {
          Thread.sleep(Duration.ofSeconds(1));
          System.out.printf("Iteration: %d - [%s]\n", i, Thread.currentThread());
          return i;
        });
      });
    }  // executor.close() is called implicitly, and waits

    Instant finished = Instant.now();
    System.out.printf("%ss\n", Duration.between(start, finished).toSeconds());

    var url1 = URI.create("https://openjdk.org/jeps/444").toURL();
    var url2 = URI.create("https://www.oracle.com/java/technologies/javase/21-relnote-issues.html").toURL();

    start = Instant.now();
    try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
      Future<String> future1 = executor.submit(() -> {
        System.out.printf("[%s]\n", Thread.currentThread());
        return fetch(url1);
      });
      Future<String> future2 = executor.submit(() -> {
        System.out.printf("[%s]\n", Thread.currentThread());
        return fetch(url2);
      });
      String html1 = future1.get();
      String html2 = future2.get();
      System.out.printf("HTML_1: %s\n", html1);
      System.out.printf("HTML_2: %s\n", html2);

      finished = Instant.now();
      System.out.printf("%sm\n", Duration.between(start, finished).toMillis());
    }
  }

  public static String fetch(URL url) throws IOException {
    try (var in = url.openStream()) {
      return new String(in.readAllBytes(), StandardCharsets.UTF_8);
    }
  }

}
