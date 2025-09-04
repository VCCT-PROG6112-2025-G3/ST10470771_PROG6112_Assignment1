
package tvseriesdetailstracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Handles TV Series records.
 */
public class Series {
    private List<SeriesModel> seriesList = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    // Add a series
    public void addSeries(SeriesModel series) {
        seriesList.add(series);
    }

    // Find a series by ID
    public SeriesModel getSeriesById(String id) {
        for (SeriesModel s : seriesList) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

   //  Search and print result
public void searchSeriesById() {
    Scanner sc = new Scanner(System.in);

    // Ask the user for the ID (like the PDF screenshot)
    System.out.print("Enter the series id to search: ");
    String id = sc.nextLine();

    SeriesModel series = getSeriesById(id);

    if (series != null) {
        System.out.println("Series found");
        System.out.println("-------------------------------");
        System.out.println("Series Id: " + series.getId());
        System.out.println("Series Name: " + series.getName());
        System.out.println("Age Restriction: " + series.getAgeRestriction());
        System.out.println("Number of Episodes: " + series.getNumEpisodes());
        System.out.println("-------------------------------");
    } else {
        System.out.println("Series with Series Id: " + id + " was not found!");
        System.out.println("-----------------------------------------");
    }

    System.out.println("Enter (1) to launch menu or any other key to exit");
}

    // Delete a series by ID
    public boolean deleteSeriesById(String id) {
        return seriesList.removeIf(s -> s.getId().equalsIgnoreCase(id));
    }

    // Update a series by ID
    public boolean updateSeriesById(String id, String newName, int newAge, int newEpisodes) {
        SeriesModel s = getSeriesById(id);
        if (s != null) {
            s.setName(newName);
            s.setAgeRestriction(newAge);
            s.setNumEpisodes(newEpisodes);
            return true;
        }
        return false;
    }

    // Check if age is valid (2–18)
    public boolean isValidAge(int age) {
        return age >= 2 && age <= 18;
    }

    // Return all series
    public List<SeriesModel> getAllSeries() {
        return seriesList;
    }

    // Capture a new series
    public void captureSeries() {
        System.out.print("Enter Series ID: ");
        String id = input.nextLine();

        System.out.print("Enter Series Name: ");
        String name = input.nextLine();

        int age = -1;
    while (true) {
        try {
            System.out.print("Enter Age Restriction (2 - 18): ");
            age = Integer.parseInt(input.nextLine());
            if (isValidAge(age)) break; // valid input -> exit loop

            // Message for the invalid number in range
            System.out.println("You have entered a incorrect series age!!!");
            System.out.println("Please re-enter the series age >> ");
        } catch (NumberFormatException e) {
            // Message for the invalid non-numeric input
            System.out.println("You have entered a incorrect series age!!!");
            System.out.println("Please re-enter the series age >> ");
        }
    }
    
        int episodes = 0;
        while (true) {
            try {
                System.out.print("Enter Number of Episodes: ");
                episodes = Integer.parseInt(input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Only numbers are allowed.");
            }
        }

        addSeries(new SeriesModel(id, name, age, episodes));
        System.out.println("Series details successfully saved.");
    }

    // Search for a series
public void searchSeries() {
    System.out.print("Enter the series id to search: ");
    String id = input.nextLine();
    SeriesModel s = getSeriesById(id);

    System.out.println("----------------------------------------------");
    if (s != null) {
        System.out.println("Series ID: " + s.getId());
        System.out.println("Series Name: " + s.getName());
        System.out.println("Age Restriction: " + s.getAgeRestriction());
        System.out.println("Number of Episodes: " + s.getNumEpisodes());
    } else {
        System.out.println("Series with Series Id: " + id + " was not found!");
    }
    System.out.println("----------------------------------------------");
    System.out.println("Enter (1) to launch menu or any other key to exit");
}


    // Update a series
    public void updateSeries() {
        System.out.print("Enter Series ID to update: ");
        String id = input.nextLine();
        SeriesModel s = getSeriesById(id);

        if (s == null) {
            System.out.println("Series not found.");
            return;
        }

        System.out.print("Enter new Series Name: ");
        String name = input.nextLine();

        int age = -1;
        while (true) {
            try {
                age = Integer.parseInt(input.nextLine());
                if (isValidAge(age)) break;
                System.out.println("You have entered a incorrect series age!!!");
                System.out.print("Please re-enter the series age >> ");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.Only numbers are allowed");
                System.out.println("Please re-enter the series age");
            }
        }

        int episodes = 0;
        while (true) {
            try {
                System.out.print("Enter new Number of Episodes: ");
                episodes = Integer.parseInt(input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }
        }

        updateSeriesById(id, name, age, episodes);
        System.out.println("Series updated successfully.");
    }

    // Delete a series
    public void deleteSeries() {
        System.out.print("\"Enter the series id to delete: \": ");
        String id = input.nextLine();
        SeriesModel s = getSeriesById(id);

        if (s == null) {
            System.out.println("Series not found.");
            return;
        }

        System.out.print("\"Are you sure you want to delete series \" + id + \" from the system? Yes (y) to delete. \": ");
        String confirm = input.nextLine();
        if (confirm.equalsIgnoreCase("Y")) {
            deleteSeriesById(id);
            System.out.println("------------------------------------");
        System.out.println("Series with Series Id: " + id + " WAS deleted!");
        System.out.println("------------------------------------");
        System.out.println("Enter (1) to launch menu or any other key to exit");

        } else {
            System.out.println("Delete cancelled.");
        }
    }

    // Show all series
    public void seriesReport() {
    if (seriesList.isEmpty()) {
        System.out.println("No series available.");
    } else {
        System.out.println("=== TV Series Report - 2025 ===");

        int count = 1;
        for (SeriesModel s : seriesList) {
            System.out.println("Series " + count);
            System.out.println("----------------------------------");
            System.out.println("SERIES ID: " + s.getId());
            System.out.println("SERIES NAME: " + s.getName());
            System.out.println("SERIES AGE RESTRICTION: " + s.getAgeRestriction());
            System.out.println("NUMBER OF EPISODES: " + s.getNumEpisodes());
            System.out.println("----------------------------------");
            count++;
        }
    }
}

    // Exit app
    public void exitSeriesApplication() {
        System.out.println("Exiting application... Goodbye!");
        input.close();
        System.exit(0);
    }
}
