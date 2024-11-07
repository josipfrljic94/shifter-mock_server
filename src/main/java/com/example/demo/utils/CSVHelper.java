package com.example.demo.utils;

import com.example.demo.model.Worker;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {
    private static final Logger logger = LoggerFactory.getLogger(CSVHelper.class);

    public static List<Worker> parseCSV(MultipartFile file) throws IOException, CsvException {
        List<Worker> workers = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new InputStreamReader(file.getInputStream()))) {
            String[] values;
            int lineNumber = 0;

            // Prolazak kroz svaki red u CSV fajlu
            csvReader.readNext(); // Preskoči zaglavlje, ako postoji

            while ((values = csvReader.readNext()) != null) {
                lineNumber++;
                try {
                    Worker worker = new Worker();
                   String[] keys = values[0].split(";");
                    worker.setIme(keys[0]);
                    worker.setPrezime(keys[1]);
                    worker.setPozicija(keys[2]);
                    worker.setBrojSati(Integer.parseInt(keys[3]));

                    workers.add(worker);
                    logger.info("Parsed worker: {}", worker.toString());
                } catch (Exception e) {
                    logger.warn("Failed to parse line {}: {}", lineNumber, String.join(", ", values), e);
                }
            }
        }
        return workers;
    }
}