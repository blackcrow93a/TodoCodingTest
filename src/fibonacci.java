public class fibonacci {

    public int fibonacci(int n){
        if(n <=1){
            return n;
        }
        return this.fibonacci(n-1) + this.fibonacci(n-2);
    }

    public int dnynamicFibonacci(int data){
        Integer[] cache = new Integer[data +1];
        cache[0] = 0;
        cache[1] = 1;
        for(int index = 2; index < data +1 ; index++){
            cache[index] = cache[index-1] + cache[index-2];
        }
        return cache[data];
    }

    public static void main(String[] args) {

        fibonacci fibonacci = new fibonacci();

        int result = fibonacci.fibonacci(3);

        System.out.println(result);

        int dynamicResult = fibonacci.dnynamicFibonacci(10);

        System.out.println(dynamicResult);

    }


}
