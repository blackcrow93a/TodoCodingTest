import com.sun.deploy.appcontext.AppContext;

import java.util.ArrayList;

public class MyStack<T> {

    public ArrayList<T> arrayList = new ArrayList<T>();

    public void push(T item){
        arrayList.add(item);
    }

    public T pop(){
        return arrayList.remove(arrayList.size() - 1);
    }

    public boolean isEmpty(){
        return arrayList.isEmpty();
    }

    public static void main(String[] args) {

        MyStack myStack = new MyStack();

        myStack.push(1);
        System.out.println(myStack.pop());
        myStack.push(2);
        myStack.push(3);

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

    }



}
