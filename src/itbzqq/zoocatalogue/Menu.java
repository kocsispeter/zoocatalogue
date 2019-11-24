package itbzqq.zoocatalogue;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Menu {

    public static final String NAME = "ANIMAL_NAME";
    public static final String ID = "ANIMAL_ID";
    public static final String REMOVEABLE = "REMOVE_NUTRITION";
    public static String argument2Result = "";

    static void drawMenu() {
        System.out.println("\n\n\t\t\t  +------------------------------------+\n"
                + " \t\t\t  |   Welcome to Zoo Catalogue 1.0     | \n"
                + "+--------------------------------------------------------------------------+\n"
                + "|                        Available commands:                               |\n"
                + "|                                                                          |\n"
                + "| 'Add'         (Save new animal's details)                                |\n"
                + "| 'List'        (Write out all animal from catalouge order by name asc.)   |\n"
                + "| 'List desc'   (Write out all animal from catalogue order by name desc.)  |\n"
                + "| 'Loan'        (Lookup animal's ID in database for borrowed state )       |\n"
                + "| 'Nutrition'   (Special nutrition treatment by individual)                |\n"
                + "| 'Export'      (Export animal data to file)                               |\n"
                + "| 'Import'      (Import animal data from file)                             |\n"
                + "| 'Exit'        (Quit from Zoo Catalogue application)                      |\n"
                + "|                                                                          |\n"
                + "|                                                                          |\n"
                + "+--------------------------------------------------------------------------+");
        System.out.print("\t\tPlease choose from available commands listed above:  ");
    }

    static void subMenuForLoan() {
        System.out.print(" \n\n\t\t\t  |  'loan' submenu    | \n"
                + "+--------------------------------------------------------------------------+\n"
                + "| Available commands:                                                      |\n"
                + "|                                                                          |\n"
                + "| (1) ( borrow this animal )                                               |\n"
                + "| (2) ( already borrowed animal came back from another Zoo )               |\n"
                + "| (3) ( CANCEL )                                                           |\n"
                + "|                                                                          |\n"
                + "|                                                                          |\n"
                + "+--------------------------------------------------------------------------+");
        System.out.print("\n\t\tPlease choose from available commands numbers listed above:  ");
    }

    static void nutritionSubMenu() {
        System.out.print(" \n\n\t\t\t  |   'feeding animals' submenu     | \n"
                + "+-----------------------------------------------------------------------------------+\n"
                + "|                        Available commands:                                        |\n"
                + "|                                                                                   |\n"
                + "| 'nutrition <animalID/name> add <nutrituin/or medical perscription name>'          |\n"
                + "| 'nutrition <animalID/name> list'                                                  |\n"
                + "| 'remove nutrition <animalID/name>'                                                |\n"
                + "|                                                                                   |\n"
                + "+-----------------------------------------------------------------------------------+");
        System.out.print("\n\t\tPlease choose from available commands listed above:  ");
    }

    public static void choosingMenuFunction(List<Animal> animalList) {
        String input;
        long animalID;
        int counter = 0;
        do {

            if (counter > 0) {
                System.out.println("\n\nWrong command, please choose from the listed ones!\nTry again!\n");
            }
            drawMenu();
            input = scanTypedInput();
            if (input.equalsIgnoreCase("add")) {
                addAnimalFunction(animalList);
                counter = -1;
            } else if (input.equalsIgnoreCase("list")) {
                listAnimalsFunction(animalList);
                counter = -1;
            } else if (input.equalsIgnoreCase("list desc")) {
                listAnimalsDescFunction(animalList);
                counter = -1;
            } else if (input.equalsIgnoreCase("loan")) {
                do {
                    animalID = isBorrowedAnimalFunction(animalList);
                } while (animalID == 0L);
                loanSubMenuFunction(animalID, animalList);
                counter = -1;
            } else if (input.equalsIgnoreCase("nutrition")) {

                nutritionSubMenu();
                loadNutritionMenuFunction(animalList);

                counter = -1;
            } else if (input.equalsIgnoreCase("export")) {
                Export.exportDataToCSV(animalList);
                counter = -1;
            } else if (input.equalsIgnoreCase("import")) {
                Import.readCsvFromFile(animalList);
                counter = -1;
            }
            counter++;
        } while (!input.equalsIgnoreCase("exit"));
    }

    private static void loadNutritionMenuFunction(List<Animal> animalList) {
        String[] nutritionInput = null;
        do {
            nutritionInput = validateSentenceInput();
            if (nutritionInput == null) {
                System.out.println("\nWrong command input, please try again.");
            }
        } while (nutritionInput == null);

        String resultCommandSentence = "";
        Animal animal = null;
        if (argument2Result.equals(ID)) {
            animal = findAnimalByID(animalList, nutritionInput[1]);
        } else if (argument2Result.equals(NAME)) {
            animal = findAnimalByName(animalList, nutritionInput[1]);
        }
        if (animal != null && nutritionInput[0].equalsIgnoreCase("nutrition") && nutritionInput[2].equalsIgnoreCase("add")) {
            for (Animal item : animalList) {
                if (argument2Result.equals(ID) && item.getId() == Long.parseLong(nutritionInput[1])) {
                    item.setNutrition(nutritionInput[3]);
                }
                if (argument2Result.equals(NAME) && item.getName().trim().equalsIgnoreCase(nutritionInput[1].trim())) {
                    item.setNutrition(nutritionInput[3]);
                }
            }
            System.out.println("\n\nNutrition records saved successfully.");
        }


        if (animal != null && nutritionInput[0].equalsIgnoreCase("nutrition") && nutritionInput[2].equalsIgnoreCase("list")) {
            for (Animal item : animalList) {
                if (item.getName().trim().equalsIgnoreCase(nutritionInput[1].trim()))
                    System.out.println("\n" + item);
            }
        }

        if (nutritionInput[0].equalsIgnoreCase("remove") && nutritionInput[1].equalsIgnoreCase("nutrition")) {
            for (Animal item : animalList) {
                if (argument2Result.equals(ID) && item.getId() == Long.parseLong(nutritionInput[2])) {
                    item.setNutrition(null);
                    item.setMedicalPrescript(null);
                }
                if (argument2Result.equals(NAME) && item.getName().trim().equalsIgnoreCase(nutritionInput[2].trim())) {
                    item.setNutrition(null);
                    item.setMedicalPrescript(null);
                }
            }
            System.out.println("\n\nAnimal's nutrition records has been deleted.");
        }
    }

    private static Animal findAnimalByName(List<Animal> animalList, String searchingForName) {
        Animal animal = new Animal();
        for (int i = 0; i < animalList.size(); i++) {
            if (animalList.get(i).getName().trim().equalsIgnoreCase(searchingForName.trim())) {
                animal.setId(animalList.get(i).getId());
                animal.setName(animalList.get(i).getName());
                animal.setSpecies(animalList.get(i).getSpecies());
                animal.setCountryOfOrigin(animalList.get(i).getCountryOfOrigin());
                animal.setBorrowed(animalList.get(i).isBorrowed());
                animal.setNutrition(animalList.get(i).getNutrition());
                animal.setMedicalPrescript(animalList.get(i).getMedicalPrescript());
            }
        }
        return animal;
    }

    private static Animal findAnimalByID(List<Animal> animalList, String searchingForID) {
        Animal animal = new Animal();
        for (int i = 0; i < animalList.size(); i++) {
            if (animalList.get(i).getId() == Long.parseLong(searchingForID)) {
                animal.setId(animalList.get(i).getId());
                animal.setName(animalList.get(i).getName());
                animal.setSpecies(animalList.get(i).getSpecies());
                animal.setCountryOfOrigin(animalList.get(i).getCountryOfOrigin());
                animal.setBorrowed(animalList.get(i).isBorrowed());
                animal.setNutrition(animalList.get(i).getNutrition());
                animal.setMedicalPrescript(animalList.get(i).getMedicalPrescript());
            }
        }
        return animal;
    }

    private static String[] validateSentenceInput() {
        String input = scanTypedInput();
        String command1 = null, argument1 = null, command2 = null, argument2 = "";
        String[] parseInputSentence;

        parseInputSentence = input.split(" ");
        for (int i = 0; i < parseInputSentence.length; i++) {
            if (!parseInputSentence[i].isEmpty() || !parseInputSentence[i].equals("")) {
                if (i == 0) command1 = parseInputSentence[i];
                if (i == 1) argument1 = parseInputSentence[i];
                if (i == 2) command2 = parseInputSentence[i];
                if (i >= 3) argument2 += parseInputSentence[i] + " ";
            }
        }

        /**
         * Test output
         */
    //    System.out.print("\ncommand1: " + command1 + "\nargument1: " + argument1 + "\ncommand2: " + command2 + "\nargument2: " + argument2);

        if (command1 == null || !command1.equalsIgnoreCase("nutrition") && !command1.equalsIgnoreCase("remove")) {
            parseInputSentence = null;
        }

        if (validateForAnimalID(argument1)) {
            argument2Result = ID;
        } else if (vaildateForAlphabets(argument1)) {
            argument2Result = NAME;
        }

        boolean isCommand2String = vaildateForAlphabets(command2);
        if (!isCommand2String || (!command2.equalsIgnoreCase("add") && !command2.equalsIgnoreCase("list"))) {
            parseInputSentence = null;
        }

        boolean isArgument2String = vaildateForAlphabetsWithSpaces(argument2);
        if (!isArgument2String && command2 != "" && command2 != null && !command2.equalsIgnoreCase("list") && !command2.equalsIgnoreCase("add")) {
            parseInputSentence = null;
        }

        if (parseInputSentence == null) {
            return null;
        } else {
            return new String[]{command1, argument1, command2, argument2};
        }
    }

    private static String scanTypedInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void loanSubMenuFunction(long animalID, List<Animal> animalsList) {
        Menu.subMenuForLoan();
        int isValid;
        boolean error;
        do {
            isValid = Integer.parseInt(validateAnimalID());
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

    private static void addAnimalFunction(List<Animal> animals) {
        System.out.print("Adding animal menu: \n\n");
        System.out.println("Please type in the animal's name: ");
        String animalsNameInput = scanTypedInput();

        System.out.println("Please type in the animal's species: ");
        String animalsSpeciesInput = scanTypedInput();

        System.out.println("Please type in the animal's country of origin: ");
        String animalsCountryInput = scanTypedInput();

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
        animal.setCountryOfOrigin(animalsCountryInput);

        animals.add(animal);
    }

    private static void listAnimalsFunction(List<Animal> collectedList) {
        if (collectedList.isEmpty()) {
            System.out.println("Sorry, there are no animal recorded in database yet.");
        } else {
            Collections.sort(collectedList);
            for (Animal item : collectedList) {
                System.out.println(item);
            }
        }
    }

    private static void listAnimalsDescFunction(List<Animal> animals) {
        Collections.reverse(animals);
        for (Animal item : animals) {
            System.out.println(item);
        }
    }

    private static long isBorrowedAnimalFunction(List<Animal> animals) {
        System.out.print("Please provide the animal's ID who needs treatment: \t");
        long inputAnimalID;
        String s;
        s = validateAnimalID();
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

    private static String validateAnimalID() {
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

    private static boolean vaildateForAlphabets(String inputStringToValidate) {
        return ((inputStringToValidate != null)
                && (!inputStringToValidate.equals(""))
                && (inputStringToValidate.matches("^[a-zA-Z]*$")));
    }

    private static boolean vaildateForAlphabetsWithSpaces(String inputStringToValidate) {
        return ((inputStringToValidate != null)
                && (!inputStringToValidate.equals(""))
                && (inputStringToValidate.matches("^[a-zA-Z ]*$")));
    }

    private static boolean validateForAnimalID(String inputIDtoValidate) {
        return ((inputIDtoValidate != null)
                && (!inputIDtoValidate.equals(""))
                && (inputIDtoValidate.matches("^[0-9]*$")));
    }
}



