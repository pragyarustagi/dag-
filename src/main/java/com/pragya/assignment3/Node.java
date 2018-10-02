package com.pragya.assignment3;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private Integer id;
    private String name;

    private final List<Node> children = new ArrayList<Node>();
    private final Node parent;

    public Node(Integer id, String name, Node parent) {
        this.id = id;
        this.name = name;
        this.parent = parent;
    }

    public final Integer getId() {
        return id;
    }

    public final void setId(Integer id) {
        this.id = id;
    }

    public final String getName() {
        return name;
    }

    public final void setName() {
        this.name = name;
    }

    public Node (Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public Node getParent() {
        return parent;
    }

}

