package itbzqq.zoocatalogue;

public class Menu {
    static void drawMenu() {
        System.out.println("\n\n\t\t\t  +------------------------------------+\n"
                + " \t\t\t  |   Welcome to Zoo Catalogue 1.0     | \n"
                + "+--------------------------------------------------------------------------+\n"
                + "| Available commands:                                                      |\n"
                + "|                                                                          |\n"
                + "| 'Add' (Save new animal's details)                                        |\n"
                + "| 'List' (Write out all animal from catalouge order by name asc.)          |\n"
                + "| 'List desc' (Write out all animal from catalogue order by name desc.)    |\n"
                + "| 'Loan' (Given animal's ID is checked in database for the borrowed state )|\n"
                + "| 'Exit' (Quit from Zoo Catalogue application)                             |\n"
                + "|                                                                          |\n"
                + "|                                                                          |\n"
                + "+--------------------------------------------------------------------------+");
        System.out.print("\t\tPlease choose from available commands listed above:  ");
    }

    static void subMenuForLoan(){
        System.out.print(" \n\n\t\t\t  |   SubMenu for 'loan     | \n"
                + "+--------------------------------------------------------------------------+\n"
                + "| Available commands:                                                      |\n"
                + "|                                                                          |\n"
                + "| (1) (borrow this animal)                                                 |\n"
                + "| (2) (already borrowed animal came back from another Zoo)                 |\n"
                + "| (3) (CANCEL)                                                             |\n"
                + "|                                                                          |\n"
                + "|                                                                          |\n"
                + "+--------------------------------------------------------------------------+");
        System.out.print("\n\t\tPlease choose from available commands numbers listed above:  ");
    }
}
