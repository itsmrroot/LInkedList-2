package com.company;

public class LinkedList {
    Node head;

    public LinkedList(){
        this.head=null;
    }

    public void append(int data){

        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
        }
        while (head.next!=null){
            head=head.next;

        }
        head.next=newNode;
    }



}
