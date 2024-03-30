package javadatastructure.required.part6.ch02.stack;

public class MyStack <T> implements IStack<T>{
    private int size =0;
    private Node head = new Node(null);

    public MyStack(T data){
        this.size = size();
        this.head = new Node(null);
    }

    @Override
    public void push(T data) { //head.next가 가장 최신에 들어온 노드를 가리킴.
       Node node = new Node(data, this.head.next);
       this.head.next = node;
       this.size++;
    }

    @Override
    public T pop() {
        if( this.isEmpty()){
            return null;
        }
        Node curr = this.head.next; //head.next = 가장 최신의 데이터.
       this.head.next = curr.next;
       curr.next = null; //삭제해줄 curr의 연결을 끊는다.
        this.size --; //가장 최신 노드 하나 삭제.
        return curr.data;
    }

    @Override
    public T peek() { //삭제가 아닌 확인
        if( this.isEmpty()){
            return null;
        }
       return this.head.next.data;
    }

    private boolean isEmpty(){
        return this.head.next == null;
    }

    @Override
    public int size() {
        return this.size;
    }
    private class Node{
        T data;
        Node next;
        Node(T data){this.data = data;}

        Node( T data, Node next){
            this.data = data;
            this.next = next;
        }
    }
}
