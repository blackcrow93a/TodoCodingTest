import java.util.ArrayList;

public class MyStack2<T> {

    private ArrayList<T> stack = new ArrayList<>();

    public void push(T item){ stack.add(item);}

    public T pop(){
        if(stack.isEmpty()){
            return null;
        }

        return stack.remove(stack.size() - 1);
    }

    public Boolean isEmpty(){
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        MyStack2 stack2 = new MyStack2();

        stack2.push(1);
        System.out.println(stack2.pop());
        stack2.push(2);
        stack2.push(3);

        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
    }

}
