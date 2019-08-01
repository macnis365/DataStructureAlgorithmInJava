package com.mathematica.ds.hackerrank;

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class ArrayDegree {

    public static void main(String[] args) {

    }

    public static int degreeOfArray(List<Integer> arr) {

        PriorityQueue<Entity> queue = new PriorityQueue<>((x, y) -> y.degree - x.degree);
        TreeMap<Integer, Entity> dictionary = new TreeMap<>();
        int position = 1;
        arr.forEach((element) -> {
            if(dictionary.containsKey(element)){
                Entity entity = dictionary.get(element);
                entity.degree += 1;
                dictionary.put(element, entity);
            }else{
                Entity entity = new Entity();
                entity.num = element;
                entity.degree = 1;
            }
        });
        return 0;
    }
}

class Entity {
    int num;
    int degree;
    int start;
    int end;
}
