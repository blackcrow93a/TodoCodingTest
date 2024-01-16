public class NodeMgmt {

    Node head = null;

    public class Node{
        Node left;
        Node right;
        int value;
        public Node(int data){
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }

    // 1 . 이진 탐색 트리 데이터 생성 및 초기화
    public boolean insertNode(int data){

        // CASE 1 : Node 가 하나도 없을때
        if(this.head == null){
            this.head = new Node(data);
        }else{ // CASE 2 : Node 가 하나 이상 들어가 있을때
            Node findNode = this.head;
            // CASE 2-1 : 현재 Node 의 왼쪽에 Node 가 들어가야할때
            while(true){
                if(data < findNode.value){ // 데이터가 루트 노드에 값보다 작을때
                    if(findNode.left != null){
                        findNode = findNode.left;
                    }else{
                        findNode.left = new Node(data);
                        break;
                    }
                }else{ // CASE 2-2: 현재 Node 의 오른쪽에 Node 가 들어가야할때
                    if(findNode.right !=null){
                        findNode = findNode.right;
                    }else{
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }
        return true;
    }

    // 2. 이진 탐색  트리 데이터 조회
    public Node search(int data){
        if(this.head == null){ // CASE 1 : Node 가 하나도 없을때
            return null;
        }else{ // CASE 2 : Node 가 하나 이상 있을때
            Node findNode = this.head;
            while (findNode !=null){
                if(findNode.value == data){
                    return findNode;
                }else if( data < findNode.value){
                    findNode = findNode.left;
                }else {
                    findNode = findNode.right;
                }
            }
            return null;
        }
    }
    // 3. 이진 탐색 트리 데이터 삭제

    // 3-1. Leaf Node 삭제할때
    // 3-2. Child Node 가 하나인 Node 삭제할때
    // 3-3. Child Node 가 두개인 Node 삭제할때
    // 3-4.

    public boolean deleteNode(int value){

        boolean serached = false;

        Node currParentNode = this.head;
        Node currNode = this.head;

        // 코너 케이스 1 : Node가 하나도 없을떄

        if(this.head == null){
            return false;
        }else {// 코너 케이스 2 : Node가 단지 하나만 있고 , 해당 Node 가 삭제할때 Node 일때

            if(this.head.value == value && this.head.left == null && this.head.right == null){
                this.head = null;
                return true;
            }

            while (currNode !=null){
                if(currNode.value == value){
                    serached = true;
                    break;
                }else if(value < currNode.value){
                    currParentNode = currNode;
                    currNode = currNode.left;
                }else{
                    currParentNode = currNode;
                    currNode = currNode.right;
                }
            }

            if(serached == false){
                return false;
            }else{

                if(currNode.left == null && currNode.right == null){ // CASE 1 : 삭제할 Node 가 Leaf Node 인 경우
                    if(value < currNode.value) {
                        currParentNode.left = null;
                        currNode = null;
                    }else{
                        currParentNode.right = null;
                        currNode = null;
                    }
                     return true;
                }else if(currNode.left !=null && currNode.right ==null){ // CASE 2-1 : 삭제할 Node 가 Child Node 를 한 개 가지고 있을경우 ( 왼쪽에 Child Node 가 있을 경우)

                    if(value < currParentNode.value){
                        currParentNode.left = currNode.left;
                        currNode = null;
                    }else{
                        currParentNode.right = currNode.right;
                        currNode = null;
                    }

                    return true;
                }else if(currNode.left == null && currNode.right !=null){    // CASE 2-2 : 삭제할 Node 가 Child Node 를 한 개 가지고 있을경우 ( 오른쪽에 Child Node 가 있을 경우)

                    if(value < currParentNode.value){
                        currParentNode.left = currNode.right;
                        currNode = null;
                    }else{
                        currParentNode.right = currNode.right;
                        currNode = null;
                    }

                    return true;
                }else { // CASE 3 - 1 : 삭제할 Node 가 Child Node 가 두 개 가지고 있고 , ( 삭제할 Node 가 부모 Node 의 왼쪽에 있을때)

                    if( value > currParentNode.value){

                        Node chageNode = currNode.right;
                        Node chageNodeParentNode = currNode.right;
                        while(chageNode.left !=null){
                            chageNodeParentNode = chageNode;
                            chageNode = chageNode.left;
                        }

                        if(chageNode.right !=null){
                        // CASE 3-1-2  : chageNode 의 오른쪽 Child Node 가 있을떄
                            chageNodeParentNode.left = chageNode.right;

                        }else{
                        // CASE 3-1-1 : chageNode 의 Child Node 가 없을때
                            chageNodeParentNode.left = null;
                        }

                        // currParentNode 의 왼쪽 Child Node 에 , 삭제할 Node 의 왼쪽 자식중,
                        // 가장 작은값을 가진 changeNode 를 연결
                        currParentNode.left = chageNode;

                        // parentNode 의 왼쪽 Child Node 가 현재 , changeNode 이고
                        // changeNode 의 왼쪽 / 오른쪽 Child 를 모두 , 삭제할 currNode 의
                        // 기존 왼쪽 / 오른쪽 Node로 변경

                        chageNode.left = currNode.left;
                        chageNode.right = currNode.right;

                    }else{ // CASE 3 - 2 : 삭제할 Node 가 Child Node 가 두 개 가지고 있고 , ( 삭제할 Node 가 부모 Node 의 오른에 있을때)

                        Node chageNode = currNode.right;
                        Node chageNodeParentNode = currNode.right;
                        while(chageNode.left !=null){
                            chageNodeParentNode = chageNode;
                            chageNode = chageNode.left;
                        }

                        if(chageNode.right !=null){
                            // CASE 3-1-2  : chageNode 의 오른쪽 Child Node 가 있을떄
                            chageNodeParentNode.left = chageNode.right;

                        }else{
                            // CASE 3-1-1 : chageNode 의 Child Node 가 없을때
                            chageNodeParentNode.left = null;
                        }

                        // currParentNode 의 오른쪽 Child Node 에 , 삭제할 Node 의 오른쪽 자식중,
                        // 가장 작은값을 가진 changeNode 를 연결
                        currParentNode.right = chageNode;

                        // parentNode 의 왼쪽 Child Node 가 현재 , changeNode 이고
                        // changeNode 의 왼쪽 / 오른쪽 Child 를 모두 , 삭제할 currNode 의
                        // 기존 왼쪽 / 오른쪽 Node로 변경

                        chageNode.left = currNode.left;
                        chageNode.right = currNode.right;
                    }
                }

            }

            return true;
        }
    }




    public static void main(String[] args) {

        NodeMgmt mgmt = new NodeMgmt();

        mgmt.insertNode(10);
        mgmt.insertNode(12);
        mgmt.insertNode(9);
        mgmt.insertNode(4);

    }


}
