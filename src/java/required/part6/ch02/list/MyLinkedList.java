package java.required.part6.ch02.list;
//ch02-04 linkedlist2
import org.w3c.dom.Node;

public class MyLinkedList<T> implements IList<T>{
    //몇개의 사이즈가 있는지
    private int size ;
    private  Node head;

    public MyLinkedList(){
        this.size = 0;
        this.head =new Node(null); //dummy node
    }

    //가장 끝에 데이터를 넣어줌. 헤드부터 테일까지 타고 들어가 넣어주기
    @Override
    public void add(T t) {
        //널이 아닐때까지, curr = curr.next가 널이라는 것은. 그 다음이 없다는 것.
        //다음 데이터가 없을 때 까지 들어가기
        //노드 생성하고/ 새로운 데이터 넣어주기/ ++ 해주기
        Node curr = this.head;
        while( curr.next != null){
            curr = curr.next;
        }
        Node node = new Node(t);
        curr.next =node;
        this.size++;
    }

    @Override
    public void insert(int index, T t) { //index위치 받고, 원하는 데이터인 t 넣기
       //더 큰 인덱스 || 음수가 들어올ㅇ시
        if( index > this.size || index <0){
            throw new IndexOutOfBoundsException();
        }

        //데이터를 다 미뤄주는게 아니라 포인터를 다룬다
        //이전노드 prev
        // 현재노드 curr = prev.next
        //인덱스의 위치까지 하나씩 옮겨가면서
        //prev = prev.next , curr = curr.next 한칸씩 이동
        //i가 index의 위치까지 간다면 node 생성, t, curr 매개변수
        //새로 만들어진 node는 중가네 들어가는 것이기 때문에 node의 next는 curr을 가리키게 된다.
        Node prev = this.head;
        Node curr = prev.next;

        int i=0;
        //헤드브터 해서 인덱스까지 한칸씩 한칸씩 옮겨온다.
        while(i ++ < index){
            prev = prev.next;
            curr = curr.next;
        }
        //prev -> new node -> curr
        //new node에 우리가 원하는 데이터 삽입.
        Node node = new Node(t, curr);
        prev.next = node;
        this.size++;
    }

    @Override
    public void clear() { //모두 비워짐
        this.size =0;
        //헤드 다음에 null. 노드 연결이 끊어짐
        this.head.next =null;

    }

    @Override
    public boolean delete(T t) {
        //data T의 위치를 지워주는 작업. 이전노드가 필요하기 때문에 prev 사용
        Node prev = this.head;
        Node curr = prev.next;
        //curr이 null이 아닐때까지 = 끝까지
        while(curr != null){
            //받은 파라매터t와 동일하다면
            //currnode는 지워야할것
           if( curr.data.equals(t)){
               //이전 노드는 curr을 가리키고 있었을 것.
               prev.next = curr.next;
               //지우고자 하는 curr은 아무것도 가리키지 않게
               curr.next = null;
               //삭제햤으니까 --
               this.size --;
               return true;
           }
           prev = prev.next;
           curr = curr.next;
        }
        //한칸씩 타고 들어가기
        //curr는 지워야할 노드.
        return false;
    }

    @Override
    public boolean deleteVyIndex(int index) { //인덱스를 통해 찾아감 + delete 연산
       //세팅된 인덱스보다 더 큰 인덱스가 들어온다면, 음수가 들어온다면
        if(index >= this.size || index <0 ){
            throw new IndexOutOfBoundsException();
        }
        //preve 는 head , curr = prev next
        Node prev = this.head;
        Node curr = prev.next;
        int i=0;
        // index가 index보다 작을 때까지
        while( i++ < index){
            prev = prev.next;
            curr = curr.next;
        }
        prev.next = curr.next;
        curr.next = null;
        this.size --;
        return  true;
        //orev와 curr가 타고 들어가게
    }

    @Override
    public T get(int index) { //데이터 가져옴 인덱스 기번
       //잘못들어온 인덱스 처리
        if( index <= this.size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        //++ 하면서 노드 찾기
        //head는 더미 데이터니까 head next 부터
        Node curr = this.head.next;
        int i=0;
        while(i ++ < index){
            curr = curr.next;
        }
        return curr.data;
    }

    @Override
    public int indexOf(T t) { //t의 위치 노드 인덱스
        Node curr = this.head.next;
        int index =0;
        while( curr != null){ //null이 아닐때까지, 끝까지.
            //currnode의 데이터와 일치하게 된다면 인덱스 반환
            if(t.equals(curr.data)){
                return index;
            }
            curr = curr.next;
           //노드 한 칸 옮길때마다 index 도 같이.
            index ++;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return this.head.next == null;
    }

    @Override
    public boolean contains(T t) {
        Node curr = this.head.next;
        while( curr != null){
            if(t.equals(curr.data)){
                //t가 curr node의 데이터와 동일 하다면 리던
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    private class Node{
        //데이터를 담을 것
        T data;
        //다음 노드 가리키는.
        Node next;
        Node(T data){
            this.data = data;
        }
        Node(T data, Node next){
            this.data = data;
            this.next = next;
        }
    }
}
