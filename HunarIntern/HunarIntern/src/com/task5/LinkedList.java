package com.task5;

//Define the Node class
class Node {
 int data;
 Node next;

 // Constructor to create a new node
 public Node(int data) {
     this.data = data;
     this.next = null;
 }
}

//Define the LinkedList class
class LinkedList {
 Node head;

 // Method to add an element to the list
 public void add(int data) {
     Node newNode = new Node(data);
     if (head == null) {
         head = newNode;
     } else {
         Node temp = head;
         while (temp.next != null) {
             temp = temp.next;
         }
         temp.next = newNode;
     }
 }

 // Method to display the list
 public void display() {
     Node temp = head;
     while (temp != null) {
         System.out.print(temp.data + " -> ");
         temp = temp.next;
     }
     System.out.println("null");
 }

 // Method to delete the last occurrence of a specified item
 public void deleteLastOccurrence(int item) {
     Node temp = head;
     Node lastOccurrencePrev = null;
     Node lastOccurrence = null;
     Node prev = null;

     // Traverse the list to find the last occurrence of the item
     while (temp != null) {
         if (temp.data == item) {
             lastOccurrencePrev = prev;
             lastOccurrence = temp;
         }
         prev = temp;
         temp = temp.next;
     }

     // If the item was found
     if (lastOccurrence != null) {
         // If the last occurrence is the head node
         if (lastOccurrence == head) {
             head = head.next;
         } else {
             lastOccurrencePrev.next = lastOccurrence.next;
         }
     } else {
         System.out.println("Item not found in the list.");
     }
 }

 // Main method to test the program
 public static void main(String[] args) {
     LinkedList list = new LinkedList();

     // Add some elements to the list
     list.add(1);
     list.add(2);
     list.add(3);
     list.add(4);
     list.add(2);  // Last occurrence of 2
     list.add(5);

     // Display the original list
     System.out.println("Original list:");
     list.display();

     // Delete the last occurrence of 2
     list.deleteLastOccurrence(2);
     System.out.println("List after deleting the last occurrence of 7:");
     list.display();

     // Test deleting an element that is not in the list
     list.deleteLastOccurrence(7);
 }
}
