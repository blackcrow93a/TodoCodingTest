import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DfsGraph {

    public ArrayList<String> search(HashMap<String,ArrayList<String>> graph , String startNode ){

        ArrayList<String> visted = new ArrayList<>();
        ArrayList<String> needVisit = new ArrayList<>();

        needVisit.add(startNode);

        while (needVisit.size() > 0){
            String node = needVisit.remove(needVisit.size() - 1);
            if(!visted.contains(node)){
                visted.add(node);
                needVisit.addAll(graph.get(node));
            }

        }

        return visted;
    }



    public static void main(String[] args) {

        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<String>(Arrays.asList("D")));
        graph.put("F", new ArrayList<String>(Arrays.asList("D")));
        graph.put("G", new ArrayList<String>(Arrays.asList("C")));
        graph.put("H", new ArrayList<String>(Arrays.asList("C")));
        graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<String>(Arrays.asList("I")));

        DfsGraph dfsGraph = new DfsGraph();

        System.out.println(dfsGraph.search(graph,"A"));

    }


}
