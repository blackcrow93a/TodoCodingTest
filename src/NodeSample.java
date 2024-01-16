public class NodeSample<T> {

    T data;
    NodeSample<T> next = null;

    public NodeSample(T data){
        this.data = data;
    }

    // Node 와 Node 연결하기 : Node 인스턴스 간 연결
}
