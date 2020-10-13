package com.certification;

interface Collection {
    String read();
    void modify();
}

class NewCollection implements Collection {

    Collection collection;

    public NewCollection(Collection c){
        this.collection = c;
    }

    @Override
    public String read() {

        return this.collection.read();
    }

    @Override
    public void modify() {

    }
}
/**
 * any problem IN oop can be solbed with indirection
 * indirection: access with another way
 */
//public class Q1 {
//    private Collection myCollection;
//
//    public Q1(Collection myCollection) {
//        this.myCollection = myCollection;
//    }
//
//    public Collection getMyCollection() {
//
//        return new NewCollection(myCollection);
//    }
//} 

