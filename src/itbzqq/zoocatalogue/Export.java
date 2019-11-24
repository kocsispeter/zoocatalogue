package itbzqq.zoocatalogue;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Export {
    public static void exportDataToCSV(List<Animal> animalList) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("src/itbzqq/zoocatalogue/export.csv"))) {
            for (int i = 0; i < animalList.size(); ++i) {
                String line = animalList.get(i).toString();
                bufferedWriter.write(line + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Something bad happend during exporting of data.");
            throw new RuntimeException(e);
        }
        System.out.println("\nSuccessfully exported " + animalList.size() + " record(s) into file.\n");
    }
}
