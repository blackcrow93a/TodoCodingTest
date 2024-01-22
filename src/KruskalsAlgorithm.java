import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class KruskalsAlgorithm {

    HashMap<String,String> parent = new HashMap<String,String>();
    HashMap<String,Integer> rank = new HashMap<String,Integer>();

    public ArrayList<Edge> kruskalFunc(ArrayList<String> vetices , ArrayList<Edge> edges){

        ArrayList<Edge> mst = new ArrayList<Edge>();
        Edge currentNode;

        // 1. 초기화
        for(int index = 0 ; index < vetices.size(); index++){
            this.makeSet(vetices.get(index));
        }

        // 2.간선 weight 기반, sorting
        Collections.sort(edges);

        for(int index = 0 ; index < edges.size(); index++){
            currentNode = edges.get(index);
            if(this.find(currentNode.nodeV) != this.find(currentNode.nodeU)) {
              this.union(currentNode.nodeV, currentNode.nodeU);
              mst.add(currentNode);
            }
        }

        return mst;

    }


    public String find(String node){
       // path compression 기법 
       if(this.parent.get(node) != node){
           this.parent.put(node,find(this.parent.get(node)));
       }
       return this.parent.get(node);
    }

    public void union(String nodeV ,String nodeU){

        String root1 = this.find(nodeV);
        String root2 = this.find(nodeU);

        // union-by-rank 기법

        if(this.rank.get(root1) > this.rank.get(root2)){
            this.parent.put(root2,root1);
        }else{
            this.parent.put(root1,root2);
            if(this.rank.get(root1) == this.rank.get(root2)){
               this.rank.put(root2,this.rank.get(root2) + 1);
            }
        }

    }

    public void makeSet(String node){
       parent.put(node,node);
       rank.put(node,0);
    }


    static class Edge implements Comparable<Edge> { // Edge 클래스 및 정렬을 위한 Comparable 인터페이스 의 CompareTo 메서드 구현

        public int weight;
        public String nodeV;
        public String nodeU;

        public Edge(int weight, String nodeV, String nodeU) {
            this.weight = weight;
            this.nodeV = nodeV;
            this.nodeU = nodeU;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "weight=" + weight +
                    ", nodeV='" + nodeV + '\'' +
                    ", nodeU='" + nodeU + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Edge edge) {
            return this.weight - edge.weight;
        }
    }

    public static void main(String[] args) {
        ArrayList<String> vertices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        ArrayList<Edge> edges = new ArrayList<Edge>();
        edges.add(new Edge(7, "A", "B"));
        edges.add(new Edge(5, "A", "D"));
        edges.add(new Edge(7, "B", "A"));
        edges.add(new Edge(8, "B", "C"));
        edges.add(new Edge(9, "B", "D"));
        edges.add(new Edge(7, "B", "E"));
        edges.add(new Edge(8, "C", "B"));
        edges.add(new Edge(5, "C", "E"));
        edges.add(new Edge(5, "D", "A"));
        edges.add(new Edge(9, "D", "B"));

        KruskalsAlgorithm KruskalsAlgorithm = new KruskalsAlgorithm();
        KruskalsAlgorithm.kruskalFunc(vertices,edges);
    }
}