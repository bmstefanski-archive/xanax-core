package pl.bmstefanski.xanax.core.drop.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import pl.bmstefanski.xanax.core.XanaxCorePlugin;

public final class IOHelper {

  public static String readFile(String fileName) throws IOException {
    try (InputStream input = XanaxCorePlugin.class.getResourceAsStream(fileName)) {
      if (input == null) {
        throw new IOException("Couldn't locate file " + fileName);
      }

      try (BufferedReader reader = new BufferedReader(
          new InputStreamReader(input, StandardCharsets.UTF_8))) {

        StringBuilder stringBuilder = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
          stringBuilder.append(line);
        }

        return stringBuilder.toString().trim();
      }
    }
  }

  private IOHelper() {
  }

}