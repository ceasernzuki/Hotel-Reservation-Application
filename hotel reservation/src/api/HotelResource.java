package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class HotelResource {
    private HotelResource hotelResource = HotelResource.getInstance();

    public static HotelResource getInstance() {
        return null;
    }


    private CustomerService customerService = CustomerService.getInstance();
    private ReservationService reservationService = ReservationService.getInstance();


    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);

    }

    private void createACustomer(String email, String firstName, String lastName) {
        customerService.addCustomer(email, firstName, lastName);
    }

    public String getRoom(String roomNumber) {
        return reservationService.getARoom(roomNumber);
    }

    public Collection<Reservation> getCustomersReservations(String customerEmail) {
        final Customer customer = getCustomer(customerEmail);

        if (customer == null) {
            return Collections.emptyList();

        }
        return null;
    }
    public Collection<IRoom>findARoom(Date checkIn ,Date checkOut){
        return reservationService.findRooms(checkIn, checkOut);

    }
}