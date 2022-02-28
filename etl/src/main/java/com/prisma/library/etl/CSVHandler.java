package com.prisma.library.etl;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
class CSVHandler {

  public List<String[]> getRowsList(String fileName) {
    return readCSV(fileName);
  }

  private List<String[]> readCSV(String fileName) {
    File file = retrieveFile(fileName);
    List<String[]> rows = new ArrayList<>();
    try (CSVReader reader = new CSVReaderBuilder(new FileReader(file)).withSkipLines(1).build()) {
      String[] lineInArray;
      while ((lineInArray = reader.readNext()) != null) {
        rows.add(lineInArray);
      }
    } catch (CsvValidationException | IOException e) {
      throw new RuntimeException("CSV reading error!", e);
    }
    return rows;
  }

  private File retrieveFile(String fileName) {
    ClassLoader classLoader = getClass().getClassLoader();
    URL resource = classLoader.getResource(fileName);
    if (resource == null) {
      throw new IllegalArgumentException("file not found! " + fileName);
    }
    try {
      return new File(resource.toURI());
    } catch (URISyntaxException e) {
      throw new RuntimeException("Invalid file! " + fileName);
    }
  }
}
