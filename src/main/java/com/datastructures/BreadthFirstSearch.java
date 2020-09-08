package com.datastructures;

import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearch {
    int value;
    boolean visited;
    List<BreadthFirstSearch> array;

    public BreadthFirstSearch(int value) {
        this.value = value;
        this.visited = false;
        array = new LinkedList<BreadthFirstSearch>();
    }

    public static void run(BreadthFirstSearch node) {
        if (node.visited) {
            return;
        }

        System.out.println(node.value);
        node.array.forEach(n -> {
            run(n);
        });
    }

    public static void main(String[] args) {
        BreadthFirstSearch n1 = new BreadthFirstSearch(1);
        BreadthFirstSearch n2 = new BreadthFirstSearch(2);
        BreadthFirstSearch n3 = new BreadthFirstSearch(3);
        BreadthFirstSearch n4 = new BreadthFirstSearch(4);
        BreadthFirstSearch n5 = new BreadthFirstSearch(5);
        BreadthFirstSearch n6 = new BreadthFirstSearch(6);
        BreadthFirstSearch n7 = new BreadthFirstSearch(7);
        BreadthFirstSearch n8 = new BreadthFirstSearch(8);

        n1.array.add(n2);
        n1.array.add(n5);

        n2.array.add(n4);
        n2.array.add(n3);

        n5.array.add(n6);
        n5.array.add(n7);

        n7.array.add(n8);
        run(n1);




    }



}
