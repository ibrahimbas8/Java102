package com.company;

public class MyList<T> {
    private int capacity;
    private T[] list;
    private int iterator = 0;

    //constructor
    public MyList() {
        setCapacity(10);
        this.list = (T[])new Object[capacity];
    }

    //constructor2
    public MyList(int capacity) {
        this.capacity = capacity;
        this.list = (T[])new Object[capacity];
    }

    //size
    public int size() {
        return this.iterator;
    }

    //add data
    public void add(T data){
        if (size() == getCapacity()){
            this.capacity = capacity*2;
            setCapacity(this.capacity);
            T[] temp =  (T[])new Object[getCapacity()];
            copyArray(this.list ,temp);
            this.list = (T[])new Object[capacity];
            copyArray(temp,this.list);
        }
        this.list[iterator] = data;
        this.iterator++;
    }

    //list copy
    public void copyArray(T[] list, T[] copy){
        for (int i=0; i< list.length; i++){
             copy[i] = list[i];
        }
    }

    //return value in index
    public T get(int index){
        return  this.list[index];
    }

    //remove data list
    public void remove(int index){
        if (index<this.iterator && index>=0){
            for (int i = index; i < this.iterator - 1; i++) {
                this.list[i] = this.list[i + 1];
            }
            this.iterator--;
        }
        else System.out.println("Null");
    }

    //assigning a new value to the index
    public void set(int index, T data){
        if (index<this.capacity && index>=0){
            this.list[index] = data;
        }
        else System.out.println("Null");
    }

    //list tosring
    public String toString(){
        String str = "[";
        for (int i = 0 ; i < this.iterator; i++) {
            str += this.list[i];
            if (i != this.iterator - 1) {
                str += ", ";
            }
        }
        str += "]";
        return str;
    }

    //Returns the index of the searched value
    public int indexOf(T data){
        for (int i=0; i<this.iterator; i++){
            if (this.list[i] == data){
                return i;
            }
        }
            return -1;
    }

    //Returns the last index of the searched value
    public int lastIndexOf(T data){
        for (int i=this.iterator; i>=0; i--){
            if (this.list[i] == data){
                return i;
            }
        }
            return -1;
    }

    //does it return empty
    public boolean isEmpty(){
        if (this.iterator > 0){
            return true;
        }else{
            return false;
        }
    }

    //create to array
    public T[] toArray(){
        T[] array =(T[])new Object[this.iterator];
        for(int i = 0; i < this.iterator; i++) {
            array[i] = this.list[i];
        }
        return array;
    }

    //clear the list
    public void clear(){
        this.list = (T[])new Object[capacity];
        this.iterator = 0;
    }

    //create to subarray
    public T[] sublist(int start,int finish){
        T[] newSubList =(T[])new Object[finish-start];
        int subIterator = 0;
        for(int i = start; i < finish; i++) {
            newSubList[subIterator] = this.list[i];
            subIterator++;
        }
        return newSubList;
    }

    //Is the value in the list?
    public boolean contains(T data){
        for (int i=0; i<this.iterator; i++){
            if (this.list[i] == data){
                return true;
            }
        }
        return false;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
