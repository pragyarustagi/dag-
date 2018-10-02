package com.pragya.assignment3.controllers;

import com.pragya.assignment3.exceptions.MyExceptions;
import com.pragya.assignment3.util.Graph;
import com.pragya.assignment3.util.Node;

import java.util.Scanner;

public class Action {

    Scanner sc = new Scanner(System.in);
    Integer nodeId;
    static  Graph G= Graph.getInstance();

    public static Action getInstance() {
        return new Action();
    }

    public void getImmediateParents() {
        System.out.println("enter nodeid : ");
        Integer nodeId=sc.nextInt();
        G.getImmediateParents(nodeId);

    }

    public void getImmediateChildren() {
        System.out.println("enter nodeid : ");
        Integer nodeId=sc.nextInt();
        G.getImmediateChildren(nodeId);
    }

    public void getAncestors() {
        System.out.println("enter nodeid : ");
        Integer nodeId=sc.nextInt();
        G.getAncestors(nodeId);
    }

    public void getDescendants() {
        System.out.println("enter nodeid : ");
        Integer nodeId=sc.nextInt();
        G.getDescendants(nodeId);

    }

    public void deleteDependency() {
        System.out.println("enter parentnodeid : ");
        Integer parentnodeId=sc.nextInt();
        System.out.println("enter childnodeid : ");
        Integer childnodeId=sc.nextInt();
        G.deleteDependency(parentnodeId,childnodeId);
    }

    public void deleteNode() {
        System.out.println("enter nodeid : ");
        Integer nodeId=sc.nextInt();
        G.deleteNode(nodeId);

    }

    public void addDependency() throws MyExceptions {
        System.out.println("enter parentnodeid : ");
        Integer parentnodeId=sc.nextInt();
        System.out.println("enter childnodeid : ");
        Integer childnodeId=sc.nextInt();
        G.addDependency(parentnodeId,childnodeId);
    }

    public void addNode() throws MyExceptions {
        System.out.println("Enter the nodeId you want to add: ");

        Integer nodeId=sc.nextInt();


        G.addNode(nodeId);


    }

    public void print() {
        G.print();

    }
}
