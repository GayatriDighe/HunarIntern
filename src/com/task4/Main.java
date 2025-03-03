package com.task4;

public class Main {
	 public static void main(String[] args) {
	        HelpDeskSystem helpDeskSystem = new HelpDeskSystem();

	        // Register users
	        User user1 = helpDeskSystem.registerUser("user1", "password123", "user1@example.com", "User");
	        User user2 = helpDeskSystem.registerUser("user2", "password123", "user2@example.com", "User");

	        // Register support staff
	        SupportStaff staff1 = new SupportStaff(1, "John Doe", "johndoe@example.com");
	        SupportStaff staff2 = new SupportStaff(2, "Jane Smith", "janesmith@example.com");

	        // Create tickets
	        Ticket ticket1 = helpDeskSystem.createTicket(user1.getUserId(), "Login issue", "Cannot login to the system.", "High");
	        Ticket ticket2 = helpDeskSystem.createTicket(user2.getUserId(), "Page not loading", "Certain page takes too long to load.", "Medium");

	        // Assign tickets to support staff
	        helpDeskSystem.assignTicketToStaff(ticket1.getTicketId(), staff1.getStaffId());
	        helpDeskSystem.assignTicketToStaff(ticket2.getTicketId(), staff2.getStaffId());

	        // View tickets for users and staff
	        helpDeskSystem.viewTickets(user1.getUserId());
	        helpDeskSystem.viewTicketsForStaff(staff1.getStaffId());

	        // Update ticket status
	        helpDeskSystem.updateTicketStatus(ticket1.getTicketId(), "Resolved");
	    }
	}


