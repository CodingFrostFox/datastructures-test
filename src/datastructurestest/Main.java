package datastructurestest;// datastructures - test v1.0

/*
Corresponding to the programming task in my IT course of studies:
Class Buffer:
- Implement a ring buffer in which objects of type string can be stored.
- Implement methods insert(..), print().
- Implement class Entry to manage the objects.
Class Graph:
-Implement the specified methods for creating undirected graphs (using indices and names).
-Goal: Create and query adjacency matrix.
 */

public class Main {
    public static void main(String[] args) {
        //demonstration Buffer:
        System.out.println("Ringbuffer Demonstration:");
        Ringbuffer demoBuffer = new Ringbuffer(3);
        demoBuffer.insert("Monday");
        demoBuffer.insert("Tuesday");

        demoBuffer.print();
        System.out.println();
        demoBuffer.insert("Wednesday");
        demoBuffer.insert("Thursday");
        demoBuffer.print();
        System.out.println();

        //demonstration Graph:
        try{
            System.out.println("IndexGraph Demonstration:");
            Graph demoIndexGraph = new Graph(3);
            System.out.println(demoIndexGraph.getNode(0));
            System.out.println();
            demoIndexGraph.setNodes(new String[]{"Alaska", "Kanada", "Iceland"});
            System.out.println(demoIndexGraph.getNode(0));
            System.out.println(demoIndexGraph.isAdjacent(0,1));
            demoIndexGraph.addEdge(0,1);
            System.out.println(demoIndexGraph.isAdjacent(0,1));
            System.out.println();

            System.out.println("NameGraph Demonstration:");
            Graph demoNameGraph = new Graph(new String[]{"Germany", "France", "Spain"});
            System.out.println(demoNameGraph.getNode(0) + ", " + demoNameGraph.getNode(1)+ ", " + demoNameGraph.getNode(2));
            System.out.println(demoNameGraph.isAdjacent("Germany", "France"));
            demoNameGraph.addEdge("Germany", "France");
            System.out.println(demoNameGraph.isAdjacent("Germany", "France"));
            System.out.println();

        } catch (GraphException e){
            System.out.println("Fehler im Graphen.");
        }


    }
}