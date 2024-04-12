package javadatastructure.required.ch4queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        //logic
        Queue <Integer> queue = new LinkedList<>();

        //생성한 q에 입력받은 n을 차례대로 넣어줌
        for (int i=0; i< N; i++){
            queue.add(i+1); // +1 안하면, 4 입력시 0 ~ 3까지 입력됨
        }

        int count =1;
        while(queue.size()!=1 ){
            int q = queue.poll();  //카드를 한장씩 뺀다.
            if(count % 2 ==0){
                queue.offer(q); //카드가 짝수일 시 큐에 q를 다시 넣어준다.
            }//홀수일시 버린다
            System.out.println(count + " ->" + queue); //n번째 count 실행에 queue의 상태를 출력해주는 역할
            count++;
        }// 카드가 한 장 남은 상태서 while문 종료.
        System.out.println(queue.peek()); // 카드 출력
    }
}
