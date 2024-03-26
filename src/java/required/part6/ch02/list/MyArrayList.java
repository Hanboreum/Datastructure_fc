package java.required.part6.ch02.list;

import java.util.Arrays;

public class MyArrayList<T> implements IList<T>{
    private static  final int DEFAULT_SIZE =  50;
   //어떤 타입이 들어울지 모르기 때문에 T
    private T[]elements;
    private int size; //arr에 데이터가 몇 개 들어있는지
    //초기화
    public MyArrayList(){
        this.size =0;
        this.elements = (T[])new Object[DEFAULT_SIZE];
    }

    @Override
    public void add(T t) { //그냥 더하는 거라 더할 숫자만 넣어준다
        //this.elements[0] = t; 이렇게 하면 계속 0에만 저장됨

        //배열이 꽉차면 늘려주기 *2 하고 기존 배열에 옮겨줌.
        if( this.size == this.elements.length){
            this.elements = Arrays.copyOf(this.elements, this.size *2);
        }
        this.elements[this.size ++] = t;
    }

    @Override
    public void insert(int index, T t) { //정해진 인덱스에 데이터를 넣는다.
        //만약 3번 인덱스에 값을 넣고 싶다.
        //인덱스가 꽉 차 있다면 인덱스를 늘리고
        if( this.size ==this.elements.length){
            this.elements = Arrays.copyOf(this.elements, this.size *2);
        }
        //인덱스 위치에 데이터를 바로 넣어버리면, 기존에 인덱스 위치에 있던 데이터가 지워짐.
        //그렇기에 인덱스 기점으로해서 이 인덱스부터 현재 데이터가 있는 위치의 데이터를 한칸씩 뒤로 밀어주는 작업
        //인덱스에 공간이 있다면 3번위 위치부터 현재 데이터가 있는 시점까지 한 칸 씩 뒤로 밀어준다.
        for (int i=0; i < index; i++){
            this.elements[i + 1] = this.elements[i];
        }
        this.elements[index] = t; //데이터 넣어주기
        this.size++;
    }

    @Override
    public void clear() { //모두 삭제
        this.size = 0;
        this.elements = (T[])new Object[DEFAULT_SIZE];

    }

    @Override
    public boolean delete(T t) { //삭제하고픈 데이터 삭제, 받은 파라미터와 타겟이 일치하는지 확인
        //i는 size를 모두 순환해 지우고 싶은 데이터를 매개변스와 비교
        for (int i=0; i< size; i++){
            if( this.elements[i].equals(t)){
                //지우는 작업이기 때문에 한칸씩 땡겨오기
                for(int j=i; j< this.size - 1; j++){
                    //한칸씩 당겨오기
                    this.elements[j] = this.elements[j +1];
                }
                this.size--;
                return  true;
            }
        }
        //만약 elements의 타겟으로 들어온 i가 i와 같다면
        //삭제하고 , 한칸씩 앞으로 당긴다.
        return false;
    }

    @Override
    public boolean deleteVyIndex(int index) { //위치 기반으로 삭제. 지우고자 하는 데이터의 빈공간이 생긴다 그걸 땡겨줘야
       //인덱스 자체가 잘못 들어올 때
        if( index < 0 || index > this.size -1){
           return false;
       }
        //인덱스 순회.
        for( int i= index; i< this.size -1; i++){
            //i + 1, 뒤에 있는게 한칸씩 당겨진다.
            //이 때 i++의 위치까지 갈 것이기 때문에 i< this.size -1 의 위치까지 간다.
           this.elements[i] = this.elements[i + 1];
       }
        //데이터가 빠졌으니 --
        this.size --;
        return true;
    }

    @Override
    public T get(int index) { //index 접근. 가져온
        //인덱스 에러
        if( index < 0 || index > this.size -1){
            throw new IndexOutOfBoundsException();
        }
        return this.elements[index];
    }

    @Override
    public int indexOf(T t) { //데이터의 유무, 위치 확인
        //0부터 순환
        //elements의 i가 t와 동일 하다면 i를 돌려준다.
        //못찿ㅈ으면 -1
        for (int i=0; i< this.size; i++){
            if( elements[i].equals(t)){
                return i;
            }
        }
        return -1; //return 0시 0벝째에 존재한다는 뜻
    }

    @Override
    public boolean isEmpty() {
        //데이터가 없으면 true 있으면 false
        return this.size == 0;
    }

    @Override
    public boolean contains(T t) { //이 t가 myindex에 존재= t, 없으면 =f
        //elements의 i가 t로 와 동일 = true, 아니라면 false
        //size순환
        for( int i=0; i < this.size; i++){
            if (elements[i].equals(t)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() { //데이터가 얼마나
        return this.size;
    }
}
