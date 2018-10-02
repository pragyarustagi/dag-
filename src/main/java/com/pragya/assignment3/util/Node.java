package com.pragya.assignment3.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {

    public static Map< Integer,Node> hm =
            new HashMap< Integer, Node>();


    private Integer id;
    //private String name;

    private final List<Node> children = new ArrayList<Node>();
   // private final Node parent;

    public Node(Integer id ) {
        this.id = id;
      //  this.name = name;
        //this.parent = parent;
        hm.put(id,this);

    }

    public final Integer getId() {
        return id;
    }

    public final void setId(Integer id) {
        this.id = id;
    }

//    public final String getName() {
//        return name;
//    }
//
//    public final void setName() {
//        this.name = name;
//    }

//    public Node (Node parent) {
//        this.parent = parent;
//    }

    public List<Node> getChildren() {
        return children;
    }

//    public Node getParent() {
//        return parent;
//    }

}

