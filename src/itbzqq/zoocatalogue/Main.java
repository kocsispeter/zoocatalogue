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
            } else if (input.equalsIgnoreCase("loan")) {
                long animalID;
                do {
                    animalID = isBorrowedAnimal(animalList);
                } while (animalID == 0L);

                subMenuForLoan(animalID, animalList);


                counter = -1;
            } else if (input.equalsIgnoreCase("export")) {
                //  isBorrowedAnimal(animalList);
                counter = -1;
            } else if (input.equalsIgnoreCase("import")) {
                //isBorrowedAnimal(animalList);
                counter = -1;
            }
            counter++;
        } while (!input.equalsIgnoreCase("exit"));
        System.out.println("Program is exiting! \n\n\t Bye bye");
    }

    private static void subMenuForLoan(long animalID, List<Animal> animalsList) {
        Menu.subMenuForLoan();
        int isValid;
        boolean error;
        do {
            isValid = Integer.parseInt(validateInput());
            if ((isValid < 1) || (isValid > 3)) {
                System.out.println("The chosen option is not valid, please try again!");
                error = true;
            } else {
                error = false;
            }
        } while (error);

        switch (isValid) {
            case 1:
                for (Animal item :
                        animalsList) {
                    if (item.getId() == animalID) {
                        item.setBorrowed(true);
                        System.out.println(item);
                    }
                }
                System.out.println("==============From now on this animal is registered as borrowed.==============");
                break;
            case 2:
                for (Animal item :
                        animalsList) {
                    if (item.getId() == animalID) {
                        item.setBorrowed(false);
                        System.out.println(item);
                    }
                }
                System.out.println("============== This animal is now registered as not borrowed.==============");
                break;
            case 3:
                System.out.println("Cancel pushed, returning to Main menu.");
                break;
        }
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
        boolean isBorrewedCondition = true;
        Animal animal = new Animal();
        int index = 0;

        do {
            if (index > 0) {
                System.out.println("Please use only 'yes' or 'no' as answer!");
                System.out.println("Is it borrowed animal? (Yes/No)  ");
            }
            isBorrowedInput = scanTypedInput();
            if (isBorrowedInput.equalsIgnoreCase("yes")) {
                isBorrewedCondition = false;
                animal.setBorrowed(true);
            } else if (isBorrowedInput.equalsIgnoreCase("no")) {
                isBorrewedCondition = false;
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
        if (collectedList.isEmpty()) {
            System.out.println("Sorry, there are no animal recorded in database yet.");
        } else {
            Collections.sort(collectedList);
            for (Animal item : collectedList) {
                System.out.println(item);
            }
        }
    }

    private static void listAnimalsDesc(List<Animal> animals) {
        Collections.reverse(animals);
        for (Animal item : animals) {
            System.out.println(item);
        }
    }

    private static long isBorrowedAnimal(List<Animal> animals) {
        System.out.print("Please provide the animal's ID who needs treatment: \t");
        long inputAnimalID;
        String s;
        s = validateInput();
        inputAnimalID = Long.parseLong(s);
        int index = 0;
        int arraySize = animals.size();
        while (index < arraySize && (inputAnimalID != animals.get(index).getId())) {
            index++;
        }
        if (index < arraySize) {
            // TODO: szép megjelenítése a toString-nek
            System.out.println(animals.get(index));
        } else {
            System.out.println("There is no such animal ID exists or this animal was not registered as borrowed!");
            inputAnimalID = 0L;
        }
        return inputAnimalID;
    }

    private static String validateInput() {
        boolean validateInput = false;
        String s;
        do {
            s = scanTypedInput();
            if (s.matches("\\d+")) {
                validateInput = true;
            } else {
                System.out.println("This is not a number. Please write the animal's ID. Try again!");
            }
        } while (!validateInput);
        return s;
    }
}
