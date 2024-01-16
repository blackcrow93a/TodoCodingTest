import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Edge implements Comparable<Edge>{

    public int distance;
    public String vertex;
    private int value;

    public Edge(int distance , String vertex){
        this.distance = distance;
        this.vertex = vertex;
    }

    @Override
    public String toString() {
        return"distance=" + distance +", vertex='" + vertex + '\'';
    }

    @Override
    public int compareTo(Edge o) {
        return this.distance - o.distance;
    }
}
