package com.pragya.assignment3.handler;

import com.pragya.assignment3.controllers.Action;

import java.util.Scanner;

public class OperationsHandler {

    public void Operations() {

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

            //Using Action class Object(Singleton class) to call methods
            switch (choice) {
                case '1': {
                    System.out.println("Enter the node ID: ");

                    Action.getInstance().getImmediateParents();
                    break;
                }
                case '2': {
                    Action.getInstance().getImmediateChildren();
                    break;
                }
                case '3': {
                    Action.getInstance().getAncestors();
                    break;
                }
                case '4': {
                    Action.getInstance().getDescendants();
                    break;
                }
                case '5': {
                    Action.getInstance().deleteDependency();
                    break;
                }
                case '6': {
                    Action.getInstance().deleteNode();
                    break;
                }
                case '7': {
                    Action.getInstance().addDependency();
                    break;
                }
                case '8': {
                    Action.getInstance().addNode();
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