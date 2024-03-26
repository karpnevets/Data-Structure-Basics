public class Stack<E> {
    int size = 0;
    ListNode<E> top = null;
    public Stack(){}
    public boolean empty() {
        return size == 0 ? true : false;
    }
    public E peek() {
        return top.data;
    }
    public E pop(){
        E res = top.data;
        top = top.next;
        return res;
    }
    public void push(E obj) {
        ListNode<E> insertion = new ListNode<E>(obj);
        insertion.next = top;
        top = insertion;
    }
    public int search(E target){
        ListNode temp = top;
        int index = 0;
        while (temp != null) {
            if (temp.data == target)
                return index;
            temp = temp.next;
            index++;
        }
        return -1;
    }
}
