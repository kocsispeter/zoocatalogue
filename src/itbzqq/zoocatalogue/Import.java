package itbzqq.zoocatalogue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Import {
    public static void readCsvFromFile(List<Animal> animalList) {
        // try resource
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/itbzqq/zoocatalogue/animals.csv"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                Animal animal = new Animal();
                animal.setId(Long.parseLong(values[0]));
                animal.setName(values[1]);
                animal.setSpecies(values[2]);
                animal.setCountryOfOrigin(values[3]);
                animal.setBorrowed((values[4].trim().equalsIgnoreCase("true") ? true : false));
                animal.setNutrition(values[5]);
                animal.setMedicalPrescript(values[6]);
                animalList.add(animal);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong during recording importing from file.");
        }
        System.out.println("\nSuccessfully imported "+animalList.size()+" record(s).\n");
    }
}
