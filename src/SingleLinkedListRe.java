import sun.plugin2.main.client.DisconnectedExecutionContext;

public class SingleLinkedListRe<T> {

    public Node<T> head = null;

    public class Node<T> {
        T data;
        Node<T> next = null;
        public Node(T data){
            this.data = data;
        }
    }

    public void addNode(T data){
        if(head == null){
            head = new Node<T>(data);
        }else{
             Node<T> node = this.head;
             while (node.next !=null){
                 node = node.next;
             }
             node.next = new Node<T>(data);
        }
    }

    public void printAll(){
        if(head != null){

            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next !=null){
                node = node.next;
                System.out.println(node.data);
            }
            System.out.println("\n");

        }
    }

    public Node<T> search(T data) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == data) {
                    return node;
                } else {
                    node = node.next;
                }
            }
            return null;
        }
    }

    public void addNodeInside(T data, T isData){

        Node<T> searchedNode = this.search(isData);

        if(searchedNode == null){
            this.addNode(data);
        }else{
            Node<T> nextNode = searchedNode.next;
            searchedNode.next = new Node<T>(data);
            searchedNode.next.next = nextNode;
        }

    }

    public Integer delNode(T isData){
        if(this.head == null){
            return 0;
        }else{
            Node<T> node = this.head;

            if(node.data == isData){ // Node 의 head 를 삭제할경우
                this.head = this.head.next;
                return 1;
            }else{
                while (node.next != null){
                    if(node.next.data == isData){
                        node.next = node.next.next;
                        return 1;
                    }
                    node = node.next;
                }
                return 0;
            }
        }
    }

    public static void main(String[] args) {

        SingleLinkedListRe<Integer> singleLinkedListRe = new SingleLinkedListRe<Integer>();

        singleLinkedListRe.addNode(10);
        singleLinkedListRe.addNode(20);
        singleLinkedListRe.addNode(30);

        singleLinkedListRe.printAll();

        singleLinkedListRe.addNodeInside(50,10);

        singleLinkedListRe.printAll();

        singleLinkedListRe.delNode(10);

        singleLinkedListRe.printAll();


    }

}
