public class ListNode<E> {
    E data;
    ListNode<E> next;
    boolean isEnd = false;
    public ListNode() {}
    public ListNode(E val) {this.data = val;}
    public ListNode(boolean end){
        this.isEnd = end;
    }
}