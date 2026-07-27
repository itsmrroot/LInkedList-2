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
    public void insert(Node newNode, int index){

        Node current=this.head;

        if(index==0){
            newNode.next=current;
            this.head=newNode;
        }
        else{
            for(int i = 0 ; i < index -1  && current !=null; i++){
                current=current.next;
            }
            if(current!=null){
                newNode.next=current.next;
                current.next=newNode;
            }
        }
    }





}
