package Lesson4.HomeWork;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by user on 23.07.16.
 */

public class MyLinkedList<E> implements Iterable<E>{
    private Node<E> head = null;
    private Node<E> tail = null;
    int size = 0;

    public void add(E value){
        Node<E> node = new Node<E>(value);
        node.next = null;

        if(tail!=null){
            tail.next = node;
        }
        tail = node;
        size++;

        if (head == null) {
            head = tail;
        }
    }

    public void add(int index, E value) throws IndexOutOfBoundsException{
        if(index == 0){
            Node<E> newNode = new Node<E>(value);
            newNode.next = head;
            head = newNode;
            size++;
        }
        else if(index <= size-1){
            Node<E> current = head;
            for (int i = 1; i < index; i++)
                current = current.next;
            Node<E> temp = current.next;
            current.next = new Node<E>(value);
            (current.next).next = temp;
            size++;

        }else if(index == size){
            Node<E> newNode = new Node<E>(value);
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
            size++;
        }else{
            throw new IndexOutOfBoundsException("Index: "+ index + ", Size: " + size);
        }
    }

    public boolean addAll(Collection<? extends  E> value){
        try {
            for (E e : value) {
                add(e);
            }
        }catch (Exception ex){
            return false;
        }
        return true;
    }

    public boolean copy(Collection<? extends  E> value){
        try {
            head = tail = null;
            for (E e : value) {
                add(e);
            }
        }catch (Exception ex){
            return false;
        }
        return true;
    }

    public E get(int index) throws IndexOutOfBoundsException{
        if(index<size && index>=0){
            Node<E> current = head;
            for (int i = 0; i <index ; i++) {
                current = current.next;
            }
            return current.value;

        }else{
            throw new IndexOutOfBoundsException("Index: "+ index + ", Size: " + size);
        }
    }

    public E remove(int index) throws IndexOutOfBoundsException{
        if(index == 0){
            E value = head.value;
            head = head.next;
            --size;
            return value;

        }else if(index == size-1 ){
            Node<E> second = head;
            while(second.next!=tail){
                second = second.next;
            }
            E value = tail.value;
            second.next = null;
            tail = second;
            --size;
            return value;

        }else if(index<size){
            Node<E> second = head;
            Node<E> first = second;
            for (int i = size-1; i >(size-1)-(size-1-index) ; i--) {
                first = second;
                second = second.next;
            }
            first.next = second.next;
            --size;
            return second.value;

        }else{
            throw new IndexOutOfBoundsException("Index: "+ index + ", Size: " + size);
        }
    }

    @Override
    public String toString() {
        String result = "[";
        Node<E> tempNode = head;
        int counter = 0;
        while(tempNode!=null){
            if(tempNode.next!=null)
                result += tempNode.value + ", ";
            else
                result += tempNode.value;

            tempNode = tempNode.next;
            ++counter;
        }
        result +="]";

        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator<E> implements Iterator<E>{
        private Node<E> current = (Node<E>) head;

        @Override
        public boolean hasNext() {
            return (current!=null)?true:false;
        }

        @Override
        public E next() {
            E value = current.value;
            current = current.next;
            return value;
        }
    }

    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value) {
            this.value = value;
        }
    }

}
