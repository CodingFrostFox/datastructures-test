package datastructurestest;
//undirected graph
/*
e.g.:
Graph with {Germany, France, Spain} with the edges (Germany - France), (France - Spain).
The corresponding adjacency matrix:

        Germany France  Spain
Germany false   true    false
France  true    false   true
Spain   false   true    false

or as an array:
nodes[3] = {Germany, France, Spain}
{{false, true, false}, {true, false, true}, {false, true, false}}
 */

public class Graph {
    protected boolean[][] adjacencyMatrix;
    protected String[] nodes;

    protected int indexOf(String node) {
        for (int i = 0; i < nodes.length; i++) {
            if (node.equals(nodes[i])) {
                return i;
            }
        }
        return -1;
    }

    public Graph(int nodeNumber) throws GraphException { //creates graph with number of Nodes
        if ( 0 < nodeNumber && nodeNumber < 99){
            nodes = new String[nodeNumber];
            adjacencyMatrix = new boolean[nodeNumber][nodeNumber];
        } else throw new GraphException();

    }

    public Graph(String[] nodes) throws GraphException { //creates graph with Array of nodes
        this(nodes.length);
        System.arraycopy(nodes, 0, this.nodes, 0, nodes.length);
    }

    //METHODS:

    public String getNode(int index) throws GraphException {  //returns specific name of a node
        if (nodes[index] != null) return nodes[index];
        else return "leer";
    }

    public int getNumberOfNodes() {
        return nodes.length;
    }

    public void setNodes(String[] nodes) { //replaces first k elements of array nodes[] ; k = min(nodes.length, this.nodes.length)
        int minimum = Math.min(nodes.length, this.nodes.length);
        System.arraycopy(nodes, 0, this.nodes, 0, minimum);
    }

    public boolean isAdjacent(int index1, int index2) throws GraphException { // true: if index of nodes are neighbours
        if (index1 < nodes.length && index2 < nodes.length){
            return adjacencyMatrix[index1][index2] && adjacencyMatrix[index2][index1];
        } else throw new GraphException();

    }

    public boolean isAdjacent(String node1, String node2) throws GraphException { // true: if name of nodes are neighbours
        int index1 = indexOf(node1);
        int index2 = indexOf(node2);
        if (index1 >= 0 && index2 >= 0){
            return adjacencyMatrix[index1][index2] && adjacencyMatrix[index2][index1];
        } else return false;
    }

    public void addEdge(int index1, int index2) throws GraphException { //by index: new edge from node1 to node2 (vice versa)
        if ((index1 < nodes.length && index2 < nodes.length) && (index1 >= 0 && index2 >= 0)){
            adjacencyMatrix[index1][index2] = true;
            adjacencyMatrix[index2][index1] = true;
        } else throw new GraphException();
    }

    public void addEdge(String node1, String node2) throws GraphException { //by name: new edge from node1 to node2 (vice versa)
        int index1 = indexOf(node1);
        int index2 = indexOf(node2);
        if (index1 >= 0 && index2 >= 0){
            adjacencyMatrix[index1][index2] = true;
            adjacencyMatrix[index2][index1] = true;
        } else System.out.println("Verbindung nicht möglich.");



    }
}