package com.task4;
import java.util.*;
public class HelpDeskSystem {
	
	    private Map<Integer, User> users = new HashMap<>();
	    private Map<Integer, Ticket> tickets = new HashMap<>();
	    private Map<Integer, SupportStaff> supportStaff = new HashMap<>();
	    private int ticketIdCounter = 1;
	    private int userIdCounter = 1;
	    private int staffIdCounter = 1;

	    // Register a new user
	    public User registerUser(String username, String password, String email, String role) {
	        User newUser = new User(userIdCounter++, username, password, email, role);
	        users.put(newUser.getUserId(), newUser);
	        return newUser;
	    }

	    // Create a new ticket
	    public Ticket createTicket(int userId, String title, String description, String priority) {
	        Ticket newTicket = new Ticket(ticketIdCounter++, userId, title, description, "Open", priority);
	        tickets.put(newTicket.getTicketId(), newTicket);
	        return newTicket;
	    }

	    // Assign a ticket to support staff
	    public void assignTicketToStaff(int ticketId, int staffId) {
	        Ticket ticket = tickets.get(ticketId);
	        if (ticket != null) {
	            ticket.assignTo(staffId);
	            System.out.println("Ticket assigned to Staff ID: " + staffId);
	        }
	    }

	    // View all tickets
	    public void viewTickets(int userId) {
	        System.out.println("Tickets for User ID: " + userId);
	        for (Ticket ticket : tickets.values()) {
	            if (ticket.getTicketId() == userId) {
	                System.out.println(ticket);
	            }
	        }
	    }

	    // View all tickets assigned to support staff
	    public void viewTicketsForStaff(int staffId) {
	        System.out.println("Tickets for Support Staff ID: " + staffId);
	        for (Ticket ticket : tickets.values()) {
	            if (ticket.getAssignedTo() == staffId) {  // Use the getter to access assignedTo
	                System.out.println(ticket);
	            }
	        }
	    }


	    // Update ticket status
	    public void updateTicketStatus(int ticketId, String newStatus) {
	        Ticket ticket = tickets.get(ticketId);
	        if (ticket != null) {
	            ticket.updateStatus(newStatus);
	            System.out.println("Ticket Status Updated to: " + newStatus);
	        }
	    }
	}

