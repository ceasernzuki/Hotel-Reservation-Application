package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;

public class ReservationService {
    public Map<String, IRoom> getAllRooms;
    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;
    private Collection<Reservation> reservations;

    public static ReservationService getInstance() {
        return null;
    }

    @Override
    public String toString() {
        return customer + " " + room + " " + checkInDate + " " + checkOutDate;

    }

    public static void printAllReservation() {
        ReservationService.printAllReservation();
    }

    public String getARoom(String roomNumber) {
        return roomNumber;
    }

    public Customer getCustomer(String customerEmail) {
        return customer;
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        return reservation;
    }

    public void addRoom(IRoom room) {
        room.roomNumber();
    }

    public Collection<IRoom> findRooms(Date checkIn, Date checkOut) {
        return findRooms(checkIn, checkOut);
    }

    public Collection<Reservation> getAllRooms() {
        return reservations;
    }
}


