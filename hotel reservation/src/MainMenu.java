import api.HotelResource;
import model.Customer;
import model.Reservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class MainMenu {
    Scanner scanner = new Scanner(System.in);
    HotelResource hotelResource = HotelResource.getInstance();

    private void displayMenu() {

        System.out.println("\n Welcome to the Hotel Reservation Application ");
        System.out.println(" ___________________________________________________");
        System.out.println("1." + "Find and Reserve a Room ");
        System.out.println("2." + "See my Reservations");
        System.out.println("3." + "Create an Account");
        System.out.println("4." + "Admin ");
        System.out.println("5." + "Exit");

    }

    private static void findAndReserveARoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter CheckIn Date mm/dd/yyyy example 01/01/2022");
        Date checkIn = getInputDate(scanner);
        System.out.println("Enter checkOut Date mm/dd/yyyy example 01/01/2022");
        Date checkOut = getInputDate(scanner);
    }

    private static String format = "MM/dd/yyyy";
    private static Date getInputDate(Scanner scanner) {
        try {
            return new SimpleDateFormat(format).parse(scanner.nextLine());
        } catch (ParseException ex) {
            System.out.println("Date is not valid");
            findAndReserveARoom();
        }
        return null;
    }

    private void seeMyReservations() {
        Collection<Reservation> myReservations = null;
        scanner.nextLine();
        System.out.println("Enter your email address");
        String email = scanner.nextLine();

        try {
            Customer customer = hotelResource.getCustomer(email);
            if (customer != null) {
                myReservations = hotelResource.getCustomersReservations(email);
                if (myReservations.isEmpty()) {
                    for (Reservation reservation : myReservations) {
                        System.out.println(reservation);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void createAnAccount() {
        String email = " ";
        String firstName = " ";
        String lastName = " ";
        Boolean validEmail = false;
        scanner.nextLine();
        while (validEmail) {
            System.out.println("Enter Email format: name@domain.com: ");
            email = scanner.nextLine();
            String emailRegex = "^ (.+) @ (.+).com ";

            Pattern pattern = Pattern.compile(emailRegex);
            if (pattern.matcher(email).matches()) {
                validEmail = true;
            } else System.out.println("invalid");
        }
        System.out.println("First Name");
        firstName = scanner.nextLine();
        System.out.println("Last Name");
        lastName = scanner.nextLine();
    }

    private void showAdminMenu() {
        AdminMenu adminMenu = new AdminMenu();
        adminMenu.start();
    }

    public void start() {
        boolean quit = false;
        String choice;

        do {
            displayMenu();
            choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        findAndReserveARoom();
                        break;
                    case "2":
                        seeMyReservations();
                        break;
                    case "3":
                        createAnAccount();
                        break;
                    case "4":
                        showAdminMenu();
                        break;
                    case "5":
                        quit = true;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid entry, retry!");
                scanner.nextLine();
            }
        }
                while (quit) ;

        }
    }



