import java.util.ArrayList;
import java.util.Collections;

public class Heap {

    /* Max Heap 조건을 구현한 클래스  */
    public ArrayList<Integer> heapArray = null;


    public Heap(Integer data){
        heapArray = new ArrayList<Integer>();
        heapArray.add(null); // 0 번 인덱스 는 제외 , 1번 인덱스 부터 시작
        heapArray.add(data);
    }

    // 힙 데이터 삽입 메서드
    public boolean insert(Integer data){

        Integer inserted_idx , parent_idx;

        if(heapArray == null){
            heapArray = new ArrayList<Integer>();
            heapArray.add(null);
            heapArray.add(data);
            return true;
        }

        this.heapArray.add(data);

        inserted_idx = this.heapArray.size() - 1;

        while (this.moveUp(inserted_idx)){
            parent_idx = inserted_idx / 2;
            Collections.swap(this.heapArray,inserted_idx,parent_idx);
            inserted_idx = parent_idx;
        }
        return true;
    }

    public boolean moveDown(Integer pop_idx){
        Integer left_child_pop_idx , right_child_pop_idx;

        left_child_pop_idx = pop_idx * 2;
        right_child_pop_idx  = pop_idx * 2 + 1;

        // CASE 1 : 왼쪽 자식 노드도 없을때 ( 자식 노드가 하나도 없을때 )
        if(left_child_pop_idx >= this.heapArray.size()){
            return false;
        // CASE 2 : 오른쪽 자식 노드만 없을때
        }else if(right_child_pop_idx >= this.heapArray.size()){
            if(this.heapArray.get(pop_idx) > this.heapArray.get(left_child_pop_idx)){
                return true;
            }else{
                return false;
            }
        }else{ // CASE 3 : 왼쪽 / 오른쪽 자식 노드가 모두 있을떄
            if(this.heapArray.get(left_child_pop_idx) > this.heapArray.get(right_child_pop_idx)){
                if(this.heapArray.get(pop_idx) < this.heapArray.get(left_child_pop_idx)){
                    return true;
                }else{
                    return false;
                }
            }else{
                if(this.heapArray.get(pop_idx) < this.heapArray.get(right_child_pop_idx)){
                    return true;
                }else{
                    return false;
                }
            }

        }

    }

    public Integer pop(){

        Integer returned_data , popped_idx, left_child_poped_idx , right_child_poped_idx;

        if(this.heapArray == null){
            return null;
        }else{

            returned_data = this.heapArray.get(1);
            this.heapArray.set(1,this.heapArray.get(this.heapArray.size() - 1));
            this.heapArray.remove(this.heapArray.size() - 1);
            popped_idx = 1;

            while(this.moveDown(popped_idx)){
                left_child_poped_idx = popped_idx * 2;
                right_child_poped_idx = popped_idx * 2 + 1;

                // CASE 2 : 오른쪽 자식 노드만 없을때
                if(right_child_poped_idx >= this.heapArray.size()){
                    if(this.heapArray.get(popped_idx) < this.heapArray.get(left_child_poped_idx)){
                        Collections.swap(heapArray,popped_idx,left_child_poped_idx);
                        popped_idx = left_child_poped_idx;
                    }
                }else{
                // CASE 3 : 왼쪽 / 오른쪽 자식 노드가 모드 있을때
                    if(this.heapArray.get(left_child_poped_idx) > this.heapArray.get(right_child_poped_idx)){
                        if(this.heapArray.get(popped_idx) < this.heapArray.get(left_child_poped_idx)){
                            Collections.swap(heapArray,popped_idx,left_child_poped_idx);
                            popped_idx = left_child_poped_idx;
                        }
                    }else{
                        if(this.heapArray.get(popped_idx) < this.heapArray.get(right_child_poped_idx)){
                            Collections.swap(heapArray,popped_idx,right_child_poped_idx);
                            popped_idx = right_child_poped_idx;
                        }
                    }
                }
            }

            return returned_data;
        }
    }

    // 힙 데이터 삽입시 스왑 처리 메서드
    public boolean moveUp(Integer inserted_idx){
        if(inserted_idx <= 1){
            return false;
        }

        Integer parent_idx = inserted_idx / 2;
        if(this.heapArray.get(inserted_idx) > this.heapArray.get(parent_idx)){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {

        Heap heapTest = new Heap(15);

        heapTest.insert(10);
        heapTest.insert(8);
        heapTest.insert(5);
        heapTest.insert(4);
        heapTest.insert(20);

        System.out.println(heapTest.heapArray);

        heapTest.pop();

        System.out.println(heapTest.heapArray);

    }

}
