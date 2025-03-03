package com.task4;

public class SupportStaff {
    private int staffId;    // ID of the support staff
    private String name;    // Name of the support staff
    private String email;   // Email of the support staff

    // Constructor to initialize the staff
    public SupportStaff(int staffId, String name, String email) {
        this.staffId = staffId;
        this.name = name;
        this.email = email;
    }

    // Getter for staffId
    public int getStaffId() {
        return staffId;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Override toString() for better display of support staff info
    @Override
    public String toString() {
        return "Support Staff ID: " + staffId + "\n" +
               "Name: " + name + "\n" +
               "Email: " + email;
    }
}



