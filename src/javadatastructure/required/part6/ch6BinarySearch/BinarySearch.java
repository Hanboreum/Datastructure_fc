package javadatastructure.required.part6.ch6BinarySearch;

import java.util.Scanner;

public class BinarySearch {
    public int serach(int arr[], int target){
        //1. 데이터의 중간 인덱스 값을 찾는다
        //2. 중간 인덱스 위치를 기준으로 arr를 절반으로 나눈다
        //3.나눠진 절반의 리스트에서 target값을 찾는다.

        int l = 0; //left
        int r = arr.length -1; //right

        int m; //중간 인덱스 값 저장
        //l 과 r의 위치로 종료 조건을 잡을 수 있다
        while( l <= r){//l이 r보다 작을 때까지, l이 r보다 커진다 = 모든 array의 데이터를 다 봤다.
            m = l + ( r - l / 2); //중간 인덱스 값을 찾기

            if(arr[m] == target){
                return m;
            }
            if(arr[m] < target){ // arr의 m이 target보다  작다. target이 크다
                //m기준으로 오른 쪽만 보면 된다.
                l = m +1;
            } else{ //target이 더 작은 경우
                //m기준으로 array의 왼쪽을 보면 된다.
                r = m - 1;
            }
        }
        return -1;
    }
}
