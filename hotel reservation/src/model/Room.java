package model;

public class Room implements IRoom{
    private String roomNumber;
    private Double price;
    private String roomType;

    public Room(String roomNumber, double price, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType();

    }


    @Override
    public String toString() {
        return roomNumber + " "  + price + " " + roomType;
    }

    @Override
    public String roomNumber() {
        return null;
    }

    @Override
    public Double Price() {
        return null;
    }

    @Override
    public String roomType() {
        return null;
    }
}
