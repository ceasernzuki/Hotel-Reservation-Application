package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class AdminResource {

    private static AdminResource adminResource;
    static ReservationService reservationService = ReservationService.getInstance();
    static CustomerService customerService = CustomerService.getInstance();

    public static Map<String, IRoom> getAllRooms() {
        return reservationService.getAllRooms;
    }

    public static Collection<Reservation> getReservations() {
       return reservationService.getAllRooms();
    }

    public Customer getCustomer(String email) {

        return customerService.getCustomer(email);
    }

    public void addRoom(List<IRoom>rooms){

        rooms.forEach(reservationService::addRoom);
    }
    public static Collection<Customer>getAllCustomers() {

        return customerService.getAllCustomers();
    }
    public void displayAllReservations () {
        reservationService.printAllReservation();

    }
    public static AdminResource getInstance(){
        return null;
    }
}
