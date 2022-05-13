package com.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return val == node.val;
    }

    @Override
    public int hashCode() {
        return val;
    }*/
}


public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        System.out.println(queue.peek().val);
        Map<Integer, Node> newOriginalNodes = new HashMap<>();
        Map<Integer, Set<Integer>> valueToNode = new HashMap<>();
        while (!queue.isEmpty()) {
            Node nodeAux = queue.poll();
            if (!valueToNode.containsKey(nodeAux.val)) {
                newOriginalNodes.put(nodeAux.val, new Node(nodeAux.val));
                valueToNode.put(nodeAux.val, new HashSet<>());
            }
            for (Node n : nodeAux.neighbors) {
                Node newNode = new Node(n.val);
                if (!valueToNode.get(nodeAux.val).contains(n.val)) {

                    valueToNode.get(nodeAux.val).add(n.val);
                    System.out.println(n.val);
                    queue.add(n);
                }
            }
        }
        valueToNode.forEach((nodeValue, neighboors) -> {
            Node currentNode = newOriginalNodes.get(nodeValue);
            for (int n : neighboors) {
                Node neighboorNode = newOriginalNodes.get(n);
                currentNode.neighbors.add(neighboorNode);
            }
        });

        return newOriginalNodes.get(node.val);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
       /* Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);*/

        CloneGraph cg = new CloneGraph();
        cg.cloneGraph(node1);
    }

}
