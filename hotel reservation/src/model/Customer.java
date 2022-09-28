package model;

import java.util.regex.Pattern;

public class Customer {
    private String firstName;
    private String lastName;
    private String emailRegex = "^(.+)@(.+).com$";
    private String email = "name@domain.com";
    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

        Pattern pattern = Pattern.compile(emailRegex);
        if (emailRegex == null || email == null) {
            throw new IllegalArgumentException("The email cannot be null");
        }
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + email;

    }
}