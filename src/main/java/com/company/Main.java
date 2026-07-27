package com.company;


public class Main {
   public static void main(String[] args) {

       LinkedList l1 = new LinkedList();
       Node newNode1 = new Node(22);
       Node newNode2 = new Node(43);
       Node newNode3 = new Node(5);
       l1.createLinkedList();

       l1.append(newNode1);
       l1.insert(newNode2, 0);
       l1.insert(newNode3, 2);
       l1.delete(2);
       l1.displayLinkedList();




    }
}
