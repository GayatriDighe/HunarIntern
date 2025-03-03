package com.task4;

	import java.util.Date;

	public class Ticket {
	    private int ticketId;       // Unique ID for each ticket
	    private int userId;         // ID of the user who created the ticket
	    private String title;       // Title/summary of the issue
	    private String description; // Detailed description of the issue
	    private String status;      // Status of the ticket (Open, In Progress, Resolved)
	    private String priority;    // Priority of the ticket (Low, Medium, High)
	    private Date createdAt;     // Date and time when the ticket was created
	    private Date updatedAt;     // Date and time when the ticket was last updated
	    private int assignedTo;     // ID of the support staff assigned to the ticket

	    // Constructor to create a new ticket
	    public Ticket(int ticketId, int userId, String title, String description, String status, String priority) {
	        this.ticketId = ticketId;
	        this.userId = userId;
	        this.title = title;
	        this.description = description;
	        this.status = status;
	        this.priority = priority;
	        this.createdAt = new Date(); // Current date and time
	        this.updatedAt = this.createdAt;
	        this.assignedTo = -1; // Initially, no staff assigned
	    }

	    // Getter for ticketId
	    public int getTicketId() {
	        return ticketId;
	    }

	    // Getter for userId
	    public int getUserId() {
	        return userId;
	    }

	    // Getter for title
	    public String getTitle() {
	        return title;
	    }

	    // Getter for description
	    public String getDescription() {
	        return description;
	    }

	    // Getter for status
	    public String getStatus() {
	        return status;
	    }

	    // Setter for status (used to update the status)
	    public void updateStatus(String status) {
	        this.status = status;
	        this.updatedAt = new Date(); // Update the time whenever the status changes
	    }

	    // Getter for priority
	    public String getPriority() {
	        return priority;
	    }

	    // Getter for createdAt
	    public Date getCreatedAt() {
	        return createdAt;
	    }

	    // Getter for updatedAt
	    public Date getUpdatedAt() {
	        return updatedAt;
	    }

	    // Getter for assignedTo (staff ID)
	    public int getAssignedTo() {
	        return assignedTo;
	    }

	    // Method to assign the ticket to support staff
	    public void assignTo(int staffId) {
	        this.assignedTo = staffId;
	        this.status = "In Progress"; // Automatically change the status when assigned
	        this.updatedAt = new Date(); // Update the time when the ticket is assigned
	    }

	    // Override the toString method to print ticket details
	    @Override
	    public String toString() {
	        return "Ticket ID: " + ticketId + "\n" +
	               "Title: " + title + "\n" +
	               "Description: " + description + "\n" +
	               "Status: " + status + "\n" +
	               "Priority: " + priority + "\n" +
	               "Created At: " + createdAt + "\n" +
	               "Updated At: " + updatedAt + "\n" +
	               "Assigned To: " + (assignedTo == -1 ? "None" : assignedTo);
	    }
	}
