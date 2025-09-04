
package tvseriesdetailstracking; 

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Series seriesManager = new Series();
        Scanner input = new Scanner(System.in);

        // Intro screen
        System.out.println("LATEST SERIES - 2025");
        System.out.println("****************************");
        System.out.print("Enter (1) to launch menu or any other key to exit: ");

        String startChoice = input.nextLine();
        if (!startChoice.equals("1")) {
            System.out.println("Exiting application... Goodbye!");
            return;
        }

        int choice;
        do {
            // Main menu
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new series");
            System.out.println("(2) Search for a series");
            System.out.println("(3) Update series age restriction");
            System.out.println("(4) Delete a series");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application");
            System.out.print("Enter your choice: ");

            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                input.next();
            }
            choice = input.nextInt();
            input.nextLine(); // clear newline

            switch (choice) {
                case 1 -> seriesManager.captureSeries();
                case 2 -> seriesManager.searchSeries();
                case 3 -> seriesManager.updateSeries();
                case 4 -> seriesManager.deleteSeries();
                case 5 -> seriesManager.seriesReport();
                case 6 -> seriesManager.exitSeriesApplication();
                default -> System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        } while (choice != 6);
    }
}

