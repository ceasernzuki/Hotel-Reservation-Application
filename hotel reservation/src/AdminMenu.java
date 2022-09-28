import api.AdminResource;
import api.HotelResource;
import model.*;
import service.ReservationService;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.Map;


public class AdminMenu extends MainMenu {
    static Scanner scanner = new Scanner(System.in);
    static AdminResource adminResource = AdminResource.getInstance();
    private static RoomType roomType;
    HotelResource hotelResource = HotelResource.getInstance();

    public AdminMenu() {
        super();
    }

    private static void displayMenu() {
        System.out.println("Admin Menu");
        System.out.println("------------------------------");
        System.out.println("1." + "See all Customers ");
        System.out.println("2." + "See all Rooms");
        System.out.println("3." + "See all Reservations");
        System.out.println("4." + "Add a Room");
        System.out.println("5." + "Main Menu");
        System.out.println("please choose one of the choices");
    }

    public static void seeAllCustomers() {
        Collection<Customer> customers = AdminResource.getAllCustomers();
        if (customers.isEmpty()) {
            System.out.println("No Customers at the moment");
            for (Customer customer : customers) {
                System.out.println(customer.toString());
            }
        } else {
            System.out.println("No customers as of now");
        }
    }

    public static void seeAllRooms() {
        Map<String, IRoom> rooms;
        rooms = AdminResource.getAllRooms();
        if (rooms.isEmpty()) {
            System.out.println("No room available");
        } else {
            AdminResource.getAllCustomers().forEach(System.out::println);
        }
    }

    public static void seeAllReservations() {
        Collection<Reservation> reservations;
        reservations = AdminResource.getReservations();
        if (reservations.isEmpty()) {
            ReservationService.printAllReservation();
        } else {
            System.out.println("No Reservations available");
        }
    }

    public static void addARoom() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter room number ");
        String roomNumber = scanner.nextLine();

        System.out.println("Enter price per night");
        Double roomPrice = RoomPrice(scanner);

        System.out.println("enter room type: 1 - Single bed, 2- Double bed ");
        Room room = new Room(roomNumber, roomPrice, roomType);

        System.out.println("Please add another room? Y or N ?");
        addARoom();
    }

    private static Double RoomPrice(Scanner scanner) {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException exp) {
            System.out.println("Room is invalid " + "please enter a valid room");
        }
        return RoomPrice(scanner);
    }

    private static void addTestData() {
        IRoom room1 = new Room("100", 0.0, RoomType.SINGLE);
        IRoom room2 = new Room("200", 250.0, RoomType.DOUBLE);
        try {
            adminResource.addRoom((List<IRoom>) room1);
            adminResource.addRoom((List<IRoom>) room2);
        } catch (Exception e) {
        }
    }


    public void start() {
        String choice;
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        do {
            displayMenu();
            choice = scanner.nextLine();

            try {
                switch (choice) {

                    case "1":
                        seeAllCustomers();
                        break;
                    case "2":
                        seeAllRooms();
                        break;
                    case "3":
                        seeAllReservations();
                        break;
                    case "4":
                        addARoom();
                        break;
                    case "5":
                        addTestData();
                        break;
                    case "6":
                        MainMenu mainMenu = new MainMenu();
                        mainMenu.start();
                        quit = true;
                        break;
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        while (quit);
    }
}




