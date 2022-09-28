import java.util.Map;

public class HotelApp {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.start();

        AdminMenu adminMenu = new AdminMenu();
        adminMenu.start();

    }
}
