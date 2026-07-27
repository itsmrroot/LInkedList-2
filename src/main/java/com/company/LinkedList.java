package com.company;


public class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void append(Node newNode) {
        Node current = this.head;

        if (current == null) {
            this.head = newNode;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

    }

    public void insert(Node newNode, int index) {

        Node current = this.head;

        if (index == 0) {
            newNode.next = current;
            this.head = newNode;
        } else {
            for (int i = 0; i < index - 1 && current != null; i++) {
                current = current.next;
            }
            if (current != null) {
                newNode.next = current.next;
                current.next = newNode;
            }
        }
    }

    public int delete(int index) {
        Node current = this.head;
        Node previous = null;
        int deletedValue = -1;

        if (index == 0) {
            deletedValue = this.head.data;
            this.head = this.head.next;
            return deletedValue;
        } else {
            for (int i = 0; i < index && current != null; i++) {
                previous = current;
                current = current.next;
            }
            if (current != null) {
                deletedValue = current.data;
                previous.next = current.next;
            }
            return deletedValue;
        }
    }

    public void displayLinkedList() {
        Node current = this.head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }


    public void createLinkedList() {

        Node node1 = new Node(11);
        this.head = node1;

        Node node2 = new Node(18);
        node1.next = node2;

        Node node3 = new Node(24);
        node2.next = node3;
    }

    public int size() {
        int count = 0;
        Node current = this.head;

        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public int search(int value) {
        Node current = this.head;
        int index = 0;

        while (current != null) {
            if (current.data == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public void reverse() {
        Node previous = null;
        Node current = this.head;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        this.head = previous;
    }
}
