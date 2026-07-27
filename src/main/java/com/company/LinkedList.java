package com.company;

public class LinkedList {
    Node head;

    public LinkedList(){
        this.head=null;
    }

    public void append(Node newNode){
        Node current=this.head;

        if(current==null){
            this.head=newNode;
        }else{
            while(current.next!=null){
                current=current.next;
            }
            current.next=newNode;
        }

    }




}
