import java.util.PriorityQueue;

public class PriorityQueueOragnize {

    public static void main(String[] args) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);

        queue.add(13);
        queue.add(3);
        queue.add(18);
        queue.add(7);
        queue.add(11);

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }

    }


}
