import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkstraPath {

    public HashMap<String,Integer> dijkstaFunc(HashMap<String, ArrayList<Edge>> graph , String start){
        Edge nodeEdge ,adjacentEdge;
        int currentDistance , adjacentDistance , distance;
        String currentNode , adjacentNode;
        ArrayList<Edge> nodeList;

        HashMap<String,Integer> distances = new HashMap<String,Integer>();

        for(String key : graph.keySet()){
            distances.put(key,Integer.MAX_VALUE); // 초기화
        }

        distances.put(start,0); // 찾는위치 시작

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();
        priorityQueue.add(new Edge(distances.get(start),start));

        while ( priorityQueue.size() > 0) {
            nodeEdge = priorityQueue.poll();
            currentDistance = nodeEdge.distance;
            currentNode = nodeEdge.vertex;

            if(distances.get(currentNode) < currentDistance){
                continue;
            }

            nodeList = graph.get(currentNode);
            for(int index = 0; index < nodeList.size(); index++){
                adjacentEdge = nodeList.get(index);
                adjacentDistance = adjacentEdge.distance;
                adjacentNode = adjacentEdge.vertex;
                distance = currentDistance + adjacentDistance;

                if(distance < distances.get(adjacentNode)){
                    distances.put(adjacentNode,distance);
                    priorityQueue.add(new Edge(distance,adjacentNode));
                }

            }

        }

        return distances;
    }

    public static void main(String[] args) {

        HashMap<String, ArrayList<Edge>> graph = new HashMap<String,ArrayList<Edge>>();

        graph.put("A",new ArrayList<Edge>(Arrays.asList(new Edge(8,"B"),new Edge(1,"C"),new Edge(2,"D"))));
        graph.put("B",new ArrayList<Edge>());
        graph.put("C",new ArrayList<Edge>(Arrays.asList(new Edge(5,"B"),new Edge(2,"D"))));
        graph.put("D",new ArrayList<Edge>(Arrays.asList(new Edge(3,"E"),new Edge(5,"F"))));
        graph.put("E",new ArrayList<Edge>(Arrays.asList(new Edge(1,"F"))));
        graph.put("F",new ArrayList<Edge>(Arrays.asList(new Edge(5,"A"))));

        DijkstraPath dijkstraPath = new DijkstraPath();

        System.out.println(dijkstraPath.dijkstaFunc(graph,"A"));
        // graph.keySet() -> 모든키를 가져옴

    }

}
