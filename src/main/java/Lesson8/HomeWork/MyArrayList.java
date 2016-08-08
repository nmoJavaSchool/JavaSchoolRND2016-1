package Lesson8.HomeWork;

import java.util.Iterator;

/**
 * Created by user on 06.08.16.
 */
public class MyArrayList<E> implements Iterable<E>{
    public static final int INITIAL_CAPACITY = 16;
    private int size = 0;
    private E[] data = (E[]) new Object[INITIAL_CAPACITY];


    public MyArrayList() {
    }
    public MyArrayList(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]); // Warning: don't use super(objects)!
    }

    public void add(E e) {
        ensureCapacity();
        data[size] = e;

        size++;
    }
    /** Create a new larger array, double the current size + 1 */
    private void ensureCapacity() {
        if (size >= data.length) {
            E[] newData = (E[])(new Object[size * 2 + 1]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator
            implements java.util.Iterator<E> {
        private int current = 0; // Current index
        @Override
        public boolean hasNext() {
            return (current < size);
        }
        @Override
        public E next() {
            return data[current++];
        }
    }

    public int getSize(){
        return size;
    }

    public E get(int index) {
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("Index Out Of Bounds");
        }else
        {
            return data[index];
        }
    }
}
