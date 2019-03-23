package file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by Pavitra on 03/17/2019.
 */
public class ReadNthLineFromFile {
  public static void main(String[] args) throws Exception {

    String sLine = Files.readAllLines(Paths.get("tenth-line.txt")).get(9);
    System.out.println(sLine);

    String fLine;
    try (Stream<String> lines = Files.lines(Paths.get("tenth-line.txt"))) {
      fLine = lines.skip(9).findFirst().get();
      System.out.println(fLine);
    }

    String oLine;
    try (BufferedReader br = new BufferedReader(new FileReader("tenth-line.txt"))) {
      for (int i = 0; i < 9; i++) {
        br.readLine();
      }
      oLine = br.readLine();
      System.out.println(oLine);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
