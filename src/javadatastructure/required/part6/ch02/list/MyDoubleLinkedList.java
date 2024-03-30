package javadatastructure.required.part6.ch02.list;

import org.w3c.dom.Node;

public class MyDoubleLinkedList<T> implements IList<T> {

    private Node head;
    private Node tail;
    private int size;

    public MyDoubleLinkedList() {
        this.size = 0;
        this.head = new Node(null);
        this.tail = new Node(null);
        //헤드의 넥스트는 테일이 되고, 테일의 넥스트는 헤드가 된다.
        this.head.next = this.tail;
        this.tail.prev = this.head;
        // size()
        // clear()
        // add()
    }

    @Override
    public void add(T t) {
        //마지막 노드는 테일의 프리브, 그렇기에 테일의 이전 노드인 노드가 prev
        Node last = this.tail.prev;
        //데이터 넣어줄 노드 생성.데이터 t, last,노드의 마지막은 테일을 가리키고 있음
        Node node = new Node(t,last, this.tail);
        //마지막의 다음은 새로 생성해줄 노드
        last.next= node;
        //테일도 연결해둠.
        this.tail.prev = node;
        this.size ++;
        // 그 다음 get(index)
    }

    @Override
    public void insert(int index, T t) { //인덱스 기준으로 데이터 삽입
        //삽입하는 데이터의 시점이 중요. 이전 노드와 현재 노드의 연결을 이어주는 것이 중요
        if( index > this.size || index <0){
            throw new IndexOutOfBoundsException();
        }
        //종료시, curr node는 우리가 데이터를 삽입할 위치를 가리킴.

        Node prev = null;
        Node curr = null; //데이터를 삽입하고자 하는 인덱스의 위치
        //인덱스 찾아가는 변수
        int i=0;
        // /2 는 헤드에서 가까움
        if(index< this. size /2){
            prev = this.head;
            curr = this.head.next;
            //++ 하면서 인덱스의 위치까지 current node를 이동시킴
            while (i ++ < index){
                prev = prev.next;
                curr = curr.next;
            }

        }else{ //tail부터 찾아들어감
            curr = this.tail;
            prev = this.tail.prev;

            //tail 부터 시작하기 떄문에 -1이 아니라, this.size - index를 뺸 값으로 조회
            while( i ++ < (this.size - index)){ //this size의 index로 접근
                curr = curr.prev;
                prev = prev.prev;  //이전으로 돌아가기 curr = curr.prev
            }
        }
        //new node는 curr위치가 나옴. t,prev를 자신의 이전 노드로, curr를 자신의 다음 노드로 가짐.
        Node newNode = new Node(t, prev, curr);
        curr.prev = newNode;
        prev.next = newNode;
        this.size ++ ; // insert를 했기 때문에

        // 그 다음 delete by index
    }

    @Override
    public void clear() {
        this.size = 0;
        this.head.next = this. tail;
        this.tail.prev = this.head;
    }

    @Override
    public boolean delete(T t) {

        return false;
    }

    @Override
    public boolean deleteVyIndex(int index) { //인덱스 기반 접근 방법은, 절반나눠서 어디서부터 할지 정해야
        Node prev = null;
        Node curr = null;
        Node next = null;
        int i=0;
        // 인덱스가 절반?
        if( index < this.size / 2){
            prev = this.head;
            curr = this.head.next;
            while( i++ < index){
                prev = prev.next;
                curr = curr.next;
            }
            //while 종료되면, curr node에 지워야하는 index의 위치가 들어있음
            //curr기준으로 앞에있는 노드와 뒤에있는 노드를 연결시켜줘야함.
            prev.next = curr.next;
            curr.next.prev = prev;
            curr.next = null;
            prev.next = null;
        }else{
            //tail에서부터 역으로
            curr = this.tail.prev;
            next = this.tail;
            //curr의 tail prev, 실제 데이터가 있는 곳에서 시작하기 때문에 -1을 해준다.
            while( i++ < ( this.size - index -1)){
                next = next.prev;
                curr = curr.prev;
            }
            //지우고자 하는 노드의 다음 노드.
            next.prev = curr.prev;
            //원래 curr을 가리키고 있었음
            curr.prev.next = next;
            curr.next = null;
            curr.prev = null;
        }
        //헤드가 가까우면
        //++ 로 인덱스 조회하면서,
        this.size --;
        return true;
    }

    @Override
    public T get(int index) { //get으로 인덱스 접근을 해 가져오는
        if( index >= this.size || index <0){
            throw  new IndexOutOfBoundsException();
        }
        int i =0; //이걸로 인덱스 찾기
        //노드는 curr로 초기회
        Node curr = null;
        //헤드부터 찾아간다.
        //헤드 or 테일 .더 가까운 경우를 찾는다
        //인덱스가 현사이즈의 절반보다 작으면, ==인덱스가 헤드에서 더 가까우면
        if( index < this.size /2 ){
            //헤드 넥스트로 들어감
            curr = this.head.next;
            while(i++ < index) {
                curr = curr.next;
                }
            }else{ //index 가 tail에 가까우면
                curr = this.tail.prev;
                //역으로 찾아가기 때문에 -1 해야 원하는 인데스 값을 찾아갈 수 있음
                while(i ++ < (this.size - index -1)){
                    curr = curr.prev; //앞노드로 역으로 들어감
                }
            }
            return curr.data;
        }
        // 그 다음 insert(index)


    @Override
    public int indexOf(T t) {

        return -1;
    }

    @Override
    public boolean isEmpty() {
        return this.head.next == this.tail;
    }

    @Override
    public boolean contains(T t) {
        Node curr = this.head.next;
        while( curr !=null){
            if( curr.data != null &curr.data.equals(t)){
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

    private class Node {
        T data;
        Node prev;
        Node next;

        Node ( T data){
            this.data = data;
        }
        Node(T data, Node prev, Node next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}
