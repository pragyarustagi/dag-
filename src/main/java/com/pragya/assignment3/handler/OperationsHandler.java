package com.pragya.assignment3.handler;

import com.pragya.assignment3.controllers.Action;
import com.pragya.assignment3.exceptions.MyExceptions;

import java.util.Scanner;

public class OperationsHandler {

    public void Operations() throws MyExceptions {

        Scanner scan = new Scanner(System.in);
        char choice;

        while (true) {
            System.out.println("Dependency Graph Operations ");
            System.out.println("\n1. Get the immediate parents of a node ");
            System.out.println("2. Get the immediate children of a node");
            System.out.println("3. Get the ancestors of a node");
            System.out.println("4. Get the descendants of a node");
            System.out.println("5. Delete dependency from tree");
            System.out.println("6. Delete a node form tree");
            System.out.println("7. Add a new dependency to a tree");
            System.out.println("8. Add a new node to tree");

            //User Input his/her Choice
            System.out.println("Choose any one Operation: ");
            choice = scan.next().charAt(0);
            Action A=Action.getInstance();

            //Using Action class Object(Singleton class) to call methods
            switch (choice) {
                case '1': {
                    System.out.println("Enter the node ID: ");

                    A.getImmediateParents();
                    break;
                }
                case '2': {
                    A.getImmediateChildren();
                    break;
                }
                case '3': {
                    A.getAncestors();
                    break;
                }
                case '4': {
                    A.getDescendants();
                    break;
                }
                case '5': {
                    A.deleteDependency();
                    break;
                }
                case '6': {
                    A.deleteNode();
                    break;
                }
                case '7': {
                    A.addDependency();
                    break;
                }
                case '8': {
                    A.addNode();
                    break;
                }
                case '9':{
                    A.print();
                    break;


                }
                default: {
                    System.out.println("Inappropriate Operation Chosen");
                    break;
                }
            }
        }

    }
}