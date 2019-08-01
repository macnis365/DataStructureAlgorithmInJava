package com.mathematica.ds.vanhack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_DocumentManagementSystem {

    public static class Heading {
        protected int weight;
        protected String text;

        public Heading(int weight, String text) {
            this.weight = weight;
            this.text = text;
        }
    }

    public static class Node {
        protected Heading heading;
        protected List<Node> children;

        public Node(Heading heading) {
            this.heading = heading;
            this.children = new ArrayList<>();
        }
    }

    public static Node toOutline(List<Heading> headings) {
        Node root = new Node(new Heading(0, ""));
        Heading rootHeading = headings.get(0);
        root.children.add(new Node(rootHeading));

        Map<Integer, Node> dictionary = new HashMap<>();
        Node currentHeadNode = root.children.get(0);
        int index = 1;
        while (index < headings.size()) {
            Heading currentHeading = headings.get(index);
            Node headNode = dictionary.get(currentHeading.weight - 1);
            if (headNode == null || headNode.heading.weight == currentHeading.weight) {
                dictionary.put(currentHeading.weight - 1, currentHeadNode);
                headNode = currentHeadNode;
            }

            headNode.children.add(new Node(currentHeading));
            int childIndex = currentHeadNode.children.size() - 1;
            if (childIndex >= 0) {
                currentHeadNode = currentHeadNode.children.get(childIndex);
            }
            if (dictionary.containsKey(currentHeading.weight)) {
                dictionary.put(currentHeading.weight, headNode.children.get(headNode.children.size()-1));
            }
            index++;
        }
        return root;
    }
}
