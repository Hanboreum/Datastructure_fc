package javadatastructure.required.part6.ch02.stack;

import java.util.Scanner;
import java.util.Stack;

public class BOJ9012 {

    public static void foo(String s){
        Stack<Character> stack = new Stack<>();

        int i=0;
        while (i< s.length()){
            char c = s.charAt(i);

            if( c =='('){
                stack.push(c);
            }else{ //')'
                if(stack.size() <1){
                    System.out.println("NO");
                    return;
                }
                stack.pop();
            }
            i++;
        }
        if( stack.size() > 0){ //짝이 안맞음.
            System.out.println("YES");
        }else { //sizs ==0
            System.out.println("NO");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for( int i=0; i < T; i++){
            String s = sc.nextLine();
            foo(sc.next());
        }
    }
}
