import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkstraAlgorizm {

    public HashMap<String,Integer> dijkstracFunc(HashMap<String,ArrayList<Edge>> graph ,String start){

        Edge edgeNode , adjacentNode;
        ArrayList<Edge> nodeList;
        int currentDistance , weight , distance;
        String currentVertex , adjacentVertex;
        HashMap<String,Integer> distances = new HashMap<String,Integer>();

        for(String key : graph.keySet()){
            distances.put(key,Integer.MAX_VALUE);
        }
        distances.put(start,0);

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();
        priorityQueue.add(new Edge(distances.get(start),start));

        while (priorityQueue.size() > 0){

            edgeNode = priorityQueue.poll();
            currentDistance = edgeNode.distance;
            currentVertex = edgeNode.vertex;

            if(distances.get(currentVertex) < currentDistance){
                continue;
            }

            nodeList = graph.get(currentVertex);
            for(int index =  0 ; index < nodeList.size() ; index++){
                adjacentNode = nodeList.get(index);
                adjacentVertex = adjacentNode.vertex;
                weight = adjacentNode.distance;
                distance = currentDistance + weight;

                if(distance < distances.get(adjacentVertex)){
                    distances.put(adjacentVertex,distance);
                    priorityQueue.add(new Edge(distance,adjacentVertex));
                }
            }

        }

        return distances;

    }

    static class Edge implements  Comparable<Edge>{

        public int distance;
        public String vertex;

        public Edge(int distance , String vertex){
            this.distance = distance;
            this.vertex = vertex;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "distance=" + distance +
                    ", vertex='" + vertex + '\'' +
                    '}';
        }
        @Override
        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }
    }


    public static void main(String[] args) {

        HashMap<String , ArrayList<Edge>> graph = new HashMap<String,ArrayList<Edge>>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));

        DijkstraAlgorizm dijkstraAlgorizm = new DijkstraAlgorizm();
        System.out.println(dijkstraAlgorizm.dijkstracFunc(graph,"A"));

    }

}
