package itbzqq.zoocatalogue;

import java.util.*;

import static itbzqq.zoocatalogue.Menu.drawMenu;

public class Main {

    public static void main(String[] args) {
        List<Animal> animalList = new ArrayList<>();

        String input;
        int counter = 0;
        do {

            if (counter > 0) {
                System.out.println("\n\nWrong command, please choose from the listed ones!\nTry again!\n");
            }
            drawMenu();
            input = scanTypedInput();
            if (input.equalsIgnoreCase("add")) {
                addAnimal(animalList);
                counter = -1;
            } else if (input.equalsIgnoreCase("list")) {
                listAnimals(animalList);
                counter = -1;
            } else if (input.equalsIgnoreCase("list desc")) {
                listAnimalsDesc(animalList);
                counter = -1;
            }
            counter++;
        } while (!input.equalsIgnoreCase("exit"));
        System.out.println("Program is exiting! \n\n\t Bye bye");
    }

    private static String scanTypedInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void addAnimal(List<Animal> animals) {
        System.out.print("Adding animal menu: \n\n");
        System.out.println("Please type in the animal's name: ");
        String animalsNameInput = scanTypedInput();

        System.out.println("Please type in the animal's species: ");
        String animalsSpeciesInput = scanTypedInput();

        System.out.println("Please type in the animal's country of origin: ");
        String animalsCOFInput = scanTypedInput();

        System.out.println("Is it borrowed animal? (Yes/No) ");
        String isBorrowedInput;
        boolean isBorrewedCondition=true;
        Animal animal = new Animal();
        int index = 0;

        do {
            if (index > 0) {
                System.out.println("Please use only 'yes' or 'no' as answer!");
                System.out.println("Is it borrowed animal? (Yes/No)  ");
            }
            isBorrowedInput = scanTypedInput();
            if(isBorrowedInput.equalsIgnoreCase("yes")){
                isBorrewedCondition=false;
                animal.setBorrowed(true);
            }else if (isBorrowedInput.equalsIgnoreCase("no")){
                isBorrewedCondition=false;
                animal.setBorrowed(false);
            }
            ++index;
        } while (isBorrewedCondition);

        animal.setId(System.currentTimeMillis());
        animal.setName(animalsNameInput);
        animal.setSpecies(animalsSpeciesInput);
        animal.setCountryOfOrigin(animalsCOFInput);

        animals.add(animal);
    }

    private static void listAnimals(List<Animal> collectedList) {
        Collections.sort(collectedList);
        for (Animal item : collectedList) {
            System.out.println(item);
        }
    }

    private static void listAnimalsDesc(List<Animal> animals) {
        Collections.reverse(animals);
        for (Animal item : animals) {
            System.out.println(item);
        }
    }
}
