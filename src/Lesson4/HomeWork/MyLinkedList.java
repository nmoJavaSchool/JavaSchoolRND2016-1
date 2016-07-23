package Lesson4.HomeWork;

/**
 * Created by user on 23.07.16.
 */
public class MyLinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    int size = 0;

    public void add(E value){
        Node<E> node = new Node<E>(value);
        node.next = head;
        head = node;
        size++;
        if (tail == null) {
            tail = head;
        }
    }

    public void add(int index, E value) throws IndexOutOfBoundsException{
        if(index == 0){
            Node<E> newNode = new Node<E>(value);
            tail.next = newNode;
            tail = newNode;
            size++;
        }
        else if(index < size){
            Node<E> current = head;
            for (int i = 1; i < index; i++)
                current = current.next;
            Node<E> temp = current.next;
            current.next = new Node<E>(value);
            (current.next).next = temp;
            size++;

        }else if(index == size){
            Node<E> newNode = new Node<E>(value);
            newNode.next = head;
            head = newNode;
            size++;
        }else{
            throw new IndexOutOfBoundsException("Index: "+ index + ", Size: " + size);
        }
    }

    public E get(int index) throws IndexOutOfBoundsException{
        if(index<size && index>=0){
            Node<E> current = head;
            for (int i = size-1; i >(size-1)-(size-1-index) ; i--) {
                current = current.next;
            }
            return current.value;

        }else{
            throw new IndexOutOfBoundsException("Index: "+ index + ", Size: " + size);
        }
    }
    public E remove(int index) throws IndexOutOfBoundsException{
        //TODO доделать
        if(index<size && index>=0){
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
        String result = "]";
        Node<E> tempNode = head;
        int counter = 0;
        while(tempNode!=null){

            if(counter>0 ) {
                result = tempNode.value + ", " + result;
            }else {
                result = tempNode.value + result;
            }

            tempNode = tempNode.next;
            ++counter;

        }
        result ="[" + result;

        return result;
    }
}
