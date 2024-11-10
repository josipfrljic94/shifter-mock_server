package com.example.demo.utils;

import com.example.demo.model.Worker;
import com.opencsv.CSVReader;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVHelper {
    private static final Logger logger = LoggerFactory.getLogger(CSVHelper.class);

    public static List<Worker> parseCSV(MultipartFile file) throws IOException, CsvException {
        List<Worker> workers = new ArrayList<>();


        try (CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(file.getInputStream()))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {
            String[] values;
            int lineNumber = 0;

            while ((values = csvReader.readNext()) != null) {
                lineNumber++;
                try {
                    if (values.length < 4) {
                        throw new ArrayIndexOutOfBoundsException("Min 4 columns");
                    }

                    Worker worker = new Worker();
                    worker.setIme(values[0].trim());
                    worker.setPrezime(values[1].trim());

                    String positionsString = values[2].trim();
                    List<String> positions = Arrays.asList(positionsString.split(","));
                    worker.setPozicije(positions);

                    worker.setBrojSati(Integer.parseInt(values[3].trim()));

                    workers.add(worker);
                    logger.info("Parsed worker: {}", worker.toString());
                } catch (ArrayIndexOutOfBoundsException e) {
                    logger.warn("Line {} has missing columns: {}", lineNumber, String.join(", ", values), e);
                } catch (NumberFormatException e) {
                    logger.warn("Failed to parse hours as integer on line {}: {}", lineNumber, String.join(", ", values), e);
                } catch (Exception e) {
                    logger.warn("Failed to parse line {}: {}", lineNumber, String.join(", ", values), e);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return workers;
    }
}
