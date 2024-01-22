import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PrimAlgorizthm {

    public ArrayList<Edge> primFunc(String startNode , ArrayList<Edge> edges){
        Edge currentEdge , poppedEdge , adjacentEdgeNode ;
        ArrayList<Edge> currentEdgeList , candidateEdgeList , adjacentEdgeNodes;
        ArrayList<String> connectedNodes = new ArrayList<String>();
        ArrayList<Edge> mst = new ArrayList<Edge>();
        HashMap<String,ArrayList<Edge>> adjacentEdges = new HashMap<String,ArrayList<Edge>>();


        for(int index = 0 ; index < edges.size() ; index++){
            currentEdge = edges.get(index);
            if(!adjacentEdges.containsKey(currentEdge.node1)){
                adjacentEdges.put(currentEdge.node1,new ArrayList<Edge>());
            }

            if(!adjacentEdges.containsKey(currentEdge.node2)){
                adjacentEdges.put(currentEdge.node2,new ArrayList<Edge>());
            }
        }

        for(int index = 0 ; index < edges.size(); index++){
            currentEdge = edges.get(index);
            currentEdgeList = adjacentEdges.get(currentEdge.node1);
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node1, currentEdge.node2));
            currentEdgeList = adjacentEdges.get(currentEdge.node2);
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node2, currentEdge.node1));
        }

        connectedNodes.add(startNode);
        candidateEdgeList = adjacentEdges.getOrDefault(startNode , new ArrayList<>());
        PriorityQueue<Edge>  priorityQueue= new PriorityQueue<Edge>();

        for(int index = 0 ; index < candidateEdgeList.size(); index++){
            priorityQueue.add(candidateEdgeList.get(index));
        }

        while(priorityQueue.size() > 0) {
            poppedEdge = priorityQueue.poll();
            if(!connectedNodes.contains(poppedEdge.node2)){
               // 해당 edge 를 mst 추가
                connectedNodes.add(poppedEdge.node2);
                mst.add(new Edge(poppedEdge.weight, poppedEdge.node1, poppedEdge.node2));

                adjacentEdgeNodes = adjacentEdges.getOrDefault(poppedEdge.node2,new ArrayList<Edge>());

                for(int index = 0 ; index < adjacentEdgeNodes.size(); index++){
                    adjacentEdgeNode = adjacentEdgeNodes.get(index);
                    if(!connectedNodes.contains(adjacentEdgeNode.node2)){
                        priorityQueue.add(adjacentEdgeNode);
                    }
                }

            }
        }

        return mst;
    }



    static class  Edge implements Comparable<Edge> {
        public int weight;
        public String node1;
        public String node2;

        public Edge(int weight, String node1, String node2) {
            this.weight = weight;
            this.node1 = node1;
            this.node2 = node2;
        }

        // System.out.println() 으로 객체 자체 출력시, 다음 메서드를 호출하여, 원하는 attribute등을 출력할 수 있음
        public String toString() {
            return "(" + this.weight + ", " + this.node1 + ", " + this.node2 + ")";
        }

        @Override
        public int compareTo(Edge edge)
        {
            return this.weight - edge.weight;
        }
    }

    public static void main(String[] args) {

        ArrayList<Edge> myedges = new ArrayList<Edge>();
        myedges.add(new Edge(7, "A", "B"));
        myedges.add(new Edge(5, "A", "D"));
        myedges.add(new Edge(8, "B", "C"));
        myedges.add(new Edge(9, "B", "D"));
        myedges.add(new Edge(7, "D", "E"));
        myedges.add(new Edge(5, "C", "E"));
        myedges.add(new Edge(7, "B", "E"));
        myedges.add(new Edge(6, "D", "F"));
        myedges.add(new Edge(8, "E", "F"));
        myedges.add(new Edge(9, "E", "G"));
        myedges.add(new Edge(11, "F", "G"));

        PrimAlgorizthm pObject = new PrimAlgorizthm();

        System.out.println(pObject.primFunc("A",myedges));

    }




}
