import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SiteManager manager = new SiteManager("./sites");

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Register new site");
            System.out.println("2. Display a site");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume the rest of the line

            switch (option) {
                case 1:
                    registerNewSite();
                    break;
                case 2:
                    displaySite();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void registerNewSite() {
        System.out.print("Enter site description: ");
        String description = scanner.nextLine();

        System.out.print("Enter site URL: ");
        String url = scanner.nextLine();

        Site site = new Site(description, url);
        try {
            int id = manager.saveSite(site);
            System.out.println("Site registered with ID: " + id);
        } catch (IOException e) {
            System.out.println("Error registering site: " + e.getMessage());
        }
    }

    private static void displaySite() {
        System.out.print("Enter site ID: ");
        int id = scanner.nextInt();

        try {
            Site site = manager.loadSite(id);
            System.out.println("Site information: ");
            System.out.println(site);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error displaying site: " + e.getMessage());
        }
    }
}