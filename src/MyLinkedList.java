import java.awt.*;

public class MyLinkedList {

   private Node first;
   private Node last;
   private int size = 0 ;

    public int getSize() {
        return size;
    }

    public MyLinkedList() {
        last = new Node(null, first, null);
        first = new Node(null,null,last);
   }

    public void pushFirst(int data) {
        Node next = first;
        next.setData(data);
        first = new Node(null,null,next);
        next.setPrev(first);
        size++;
    }

    public void pushLast(int data) {
        Node prev = last;
        prev.setData(data);
        last = new Node(null,prev,null);
        prev.setNext(last);
        size++;
    }

    public void pushIndex(int index, int data) {
        Node currNode = first;
        for (int i = 0; i <= index-1; i++) {
            currNode = currNode.getNext();
        }
        Node added = new Node(data,currNode,currNode.getNext());
        currNode.getNext().setPrev(added);
        currNode.setNext(added);

        System.out.println("Element : " + added.getData() + " added");
    }

    public void removeFirst() {
       System.out.println("Element : " + first.getNext().getData() + " deleted");
       first = first.getNext();
       size--;
    }

    public void removeLast() {
       System.out.println("Element : " + last.getPrev().getData() + " deleted");
       last = last.getPrev();
       size--;
    }

    public void remove(int index) {
        Node currNode = first;
        for (int i = 0; i <= index; i++) {
            currNode = currNode.getNext();
        }
        currNode.getPrev().setNext(currNode.getNext());
        currNode.getNext().setPrev(currNode.getPrev());
        System.out.println("Element : " + currNode.getData() + " deleted");
        currNode = null;
    }

    public int get(int index) {
        Node currNode = first;
        for (int i = 0; i <= index; i++) {
            currNode = currNode.getNext();
        }
        return currNode.getData();
    }

    public void print() {
       Node currNode = first.getNext();
       while (currNode != last) {
           System.out.println(currNode.getData());
           currNode = currNode.getNext();
       }
    }
}