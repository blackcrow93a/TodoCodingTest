import java.util.Arrays;
import java.util.Comparator;

public class NodeTestSample implements Comparable<NodeTestSample> {

    public Integer distance;
    public String vertex;

    public NodeTestSample(Integer distance,String vertex){
        this.distance = distance;
        this.vertex = vertex;
    }

    @Override
    public int compareTo(NodeTestSample o) {
        return o.distance - this.distance; // 내림 차순 또는 올림차순 설정가능
        // [1] 내림 차순 시 compareTo 의 매개변수에서 기존 변수를 빼는 형태
        // [2] 오름 차순 시 에는 기존 변수에서 매개변수 의 변수를 뺴는 형태
    }

    public static void main(String[] args) {

        NodeTestSample nodeTestSample1 = new NodeTestSample(10,"A");
        NodeTestSample nodeTestSample2 = new NodeTestSample(9,"A");
        NodeTestSample nodeTestSample3 = new NodeTestSample(3,"A");

       NodeTestSample[] nodeTestSamples = new NodeTestSample[]{nodeTestSample1,nodeTestSample2,nodeTestSample3};

       Arrays.sort(nodeTestSamples, new Comparator<NodeTestSample>() {
           @Override
           public int compare(NodeTestSample o1, NodeTestSample o2) {
               return o2.distance - o1.distance;
           }
       });
       System.out.println(nodeTestSamples);

       for( int index = 0 ; index < nodeTestSamples.length; index++){
           System.out.println(nodeTestSamples[index].distance);
       }

    }
}
