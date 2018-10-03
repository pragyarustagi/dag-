package com.pragya.assignment3.util;

import com.pragya.assignment3.exceptions.MyExceptions;

import java.util.*;

public class Graph {

    private Boolean visited [] ;


      ArrayList<Node> graph [] = new ArrayList[100];
    ArrayList<Node> parentGraph [] = new ArrayList[100];
    Set<Integer> set = new HashSet<Integer>();

      Scanner scanner= new Scanner(System.in);
    private Boolean[] recursionstack;

    public static Graph getInstance()
      {

          return new Graph();
      }
      Graph()
      {

          for(int i=0;i<=90;i++)
          {
              graph[i] =new ArrayList<Node>();

          }
          for(int i=0;i<=90;i++)
          {
              parentGraph[i] =new ArrayList<Node>();

          }
      }




    public void addNode(Integer nodeId ) throws MyExceptions {

        new Node(nodeId);

        System.out.println("choose parent /child  type P or C or F\n");
        String in=scanner.nextLine();
        if ("P".equals(in)) {
            System.out.println("enter parent node id");
            Integer parentId = scanner.nextInt();
            new Node(parentId);

            checkDependency(parentId,nodeId);

        } else if ("C".equals(in)) {

            System.out.println("enter child node id");
            Integer childtId = scanner.nextInt();
            new Node(childtId);

            checkDependency(nodeId, childtId);
        }
      //  print();

    }
    public void addDependency(Integer parentId , Integer childId) throws MyExceptions {
        new Node(parentId);
        new Node(childId);

        checkDependency(parentId,childId);

    }

    public void addEdge(Integer parentId,Integer childId)
    {
        this.graph[parentId].add(Node.hm.get(childId));
     //   System.out.println(graph[parentId].size()+" here\n");
    }

    public void removeEdge(Integer parentId,Integer childId)
    {

        for (int i =0;i< graph[parentId].size();i++) {

            if (graph[parentId].get(i).getId().equals(childId)) {
                graph[parentId].remove(i);
                break;
            }
        }
    }
    public void addEdgeInParentGraph(Integer parentId,Integer childId)
    {
        this.parentGraph[parentId].add(Node.hm.get(childId));
    }

    public void removeEdgeFromParentGraph(Integer parentId,Integer childId)
    {

        for (int i =0;i< this.parentGraph[parentId].size();i++) {

            if (parentGraph[parentId].get(i).equals(Node.hm.get(childId))) {
                parentGraph[parentId].remove(parentGraph[parentId].get(i));
            }
        }
    }



    public void checkDependency(Integer parentId,Integer childId) throws MyExceptions
    {

        addEdge(parentId,childId);
        addEdgeInParentGraph(childId,parentId);
        if(checkCycle())
        {
            removeEdge(parentId,childId);
            removeEdgeFromParentGraph(childId,parentId);
            Node.hm.remove(parentId);
            Node.hm.remove(childId);

            throw new MyExceptions("it makes cycle");
        }


    }

    private boolean checkCycle(){

        visited = new Boolean[100];
        recursionstack = new Boolean[100];

        Arrays.fill(visited,Boolean.FALSE);
        Arrays.fill(recursionstack,Boolean.FALSE);

        for(int i=0;i<50;i++)
        {
            if(visited[i]==false)
            if(checkCycleUtil(i))
                return true;
        }
        return false;

    }

    private boolean checkCycleUtil(Integer nodeId)
    {
        visited[nodeId]=true;
        recursionstack[nodeId]=true;

        for(int i=0;i<graph[nodeId].size();i++)
        {
            if(visited[graph[nodeId].get(i).getId()]==false)
            {
                checkCycleUtil(graph[nodeId].get(i).getId());
            }
            else if(recursionstack[graph[nodeId].get(i).getId()])
                return true;

        }
        recursionstack[nodeId]=false;

        return false;

    }

    public ArrayList<Node> getImmediateParents(Integer nodeId)
    {
        ArrayList<Node> parents = new ArrayList<Node>();
        for(int i=0;i<50;i++)
        {
            for(int j= 0;j<graph[i].size();j++)
            {
                if(graph[i].get(j).getId().equals(nodeId))
                {
                    parents.add(Node.hm.get(i));
                    break;
                }
            }
        }
        return parents;
    }

    public ArrayList<Node> getImmediateChildren(Integer nodeId)
    {
        ArrayList<Node> children = new ArrayList<Node>();
        for(int i=0;i<graph[nodeId].size();i++)
        {
            children.add(graph[nodeId].get(i));
        }
        return children;
    }
    public ArrayList<Node> getDescendants(Integer nodeId)
    {
        ArrayList<Node> descendants = new ArrayList<Node>();
        visited = new Boolean[100];
        Arrays.fill(visited,Boolean.FALSE);
        dfs(nodeId,descendants);
        return descendants;
    }
    public ArrayList<Node> getAncestors(Integer nodeId)
    {
        ArrayList<Node> ancestors = new ArrayList<Node>();
        visited = new Boolean[100];
        Arrays.fill(visited,Boolean.FALSE);
        dfsOnParentGraph(nodeId,ancestors);
        return ancestors;
    }

    public void dfs(Integer nodeId,ArrayList<Node> descendants)
    {
        visited[nodeId]=true;

        for(int i=0;i<graph[nodeId].size();i++)
        {
            if(visited[graph[nodeId].get(i).getId()]==false)
            {
                descendants.add(graph[nodeId].get(i));
                dfs(graph[nodeId].get(i).getId(),descendants);
            }
        }

    }
    public void dfsOnParentGraph(Integer nodeId,ArrayList<Node> ancestors)
    {
        visited[nodeId]=true;

        for(int i=0;i<parentGraph[nodeId].size();i++)
        {
            if(visited[parentGraph[nodeId].get(i).getId()]==false)
            {
                ancestors.add(parentGraph[nodeId].get(i));
                dfsOnParentGraph(parentGraph[nodeId].get(i).getId(),ancestors);
            }
        }

    }

    public void deleteNode(Integer nodeId)
    {
        set.clear();
        set.add(nodeId);
        deleteNodeUtil(nodeId);
    }

    public void deleteNodeUtil(Integer nodeId)
    {
//        System.out.println(nodeId);
//
//
//        Iterator<Integer> it = set.iterator();
//        while(it.hasNext()){
//            System.out.print(it.next()+" ");
//        }
//        System.out.println("------------------\n");
        for(int  i =0;i<parentGraph[nodeId].size();i++)
        {

            removeEdge(parentGraph[nodeId].get(i).getId(),nodeId);
           // System.out.println(parentGraph[nodeId].get(i).getId()+" ");
        }
        parentGraph[nodeId].clear();

        ArrayList<Integer> temp= new ArrayList<Integer>();

        for(int i=0;i<graph[nodeId].size();i++)
        {
            temp.add(graph[nodeId].get(i).getId());
          //  set.add(graph[nodeId].get(i).getId());
        }
        List<Integer> toBeDelete =new ArrayList<Integer>();

        for(int i=0;i<temp.size();i++)
        {
            if(parentGraph[temp.get(i)].size()==1)
            {
                if(!set.contains(temp.get(i))) {
                    set.add(temp.get(i));

                    //   deleteNodeUtil(temp.get(i));

                    toBeDelete.add(temp.get(i));
                }
            }
            else {
                boolean flag = true;
                for (int j = 0; j < parentGraph[temp.get(i)].size(); j++) {
                    if (!set.contains(parentGraph[temp.get(i)].get(j).getId())) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                {
                    if(!set.contains(temp.get(i))) {


                        set.add(temp.get(i));
                        toBeDelete.add(temp.get(i));
                    }

                    //deleteNodeUtil(temp.get(i));
                }

            }

            removeEdge(nodeId,temp.get(i));
        }
        for(int i=0;i<toBeDelete.size();i++)
        {
            deleteNodeUtil(temp.get(i));
            //8removeEdge(nodeId,temp.get(i));
        }
    }

    public void deleteDependency(Integer parentId ,Integer childId)
    {
        removeEdge(parentId,childId);
        if(parentGraph[childId].size()==1) {
            deleteNode(childId);
        }
        else
        {
            removeEdgeFromParentGraph(childId,parentId);
        }
    }
    public void print()
    {
        visited = new Boolean[100];
        Arrays.fill(visited,Boolean.FALSE);
        //printUtil(1);


        for(int i=0;i<9;i++)
        {
            System.out.println(i+"-->");
            for(int j=0;j<graph[i].size();j++)
            {
                System.out.println(graph[i].get(j).getId()+" ");
            }
            System.out.println("\n");

        }
//        for(int i=0;i<9;i++)
//        {
//            System.out.println(i+"-->");
//            for(int j=0;j<parentGraph[i].size();j++)
//            {
//                System.out.println(parentGraph[i].get(j).getId()+" ");
//            }
//            System.out.println("\n");
//
//        }

    }


//    void printUtil(Integer nodeId)
//    {
//        visited[nodeId]=true;
//
//        System.out.println(nodeId+": -->");
//        for(int i=0;i<graph[nodeId].size();i++)
//        {
//            if(visited[graph[nodeId].get(i).getId()]==false)
//                printUtil(graph[nodeId].get(i).getId());
//
//        }
//    }


}
