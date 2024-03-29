public class Queue<E> {
    int size = 0;
    ListNode<E> front = new ListNode<>(true);
    ListNode<E> rear = new ListNode<>(true);

    public Queue(){}

    public void insertion(E add){
        ListNode<E> addition = new ListNode<>(add);
        addition.next = front;
        front = addition;
        size++;
        setup();
    }
    private void setup(){
        if (rear.isEnd){
            while(!front.isEnd){
                ListNode<E> temp = front.next;
                front.next = rear;
                rear = front;
                front = temp;
            }
            ListNode<E> temp = rear.next;
            rear.next = front;
            front = rear;
            rear = temp;
        }
    }

    public E poll(){
        if (front.isEnd && rear.isEnd)
            return null;
        setup();
        ListNode<E> res = rear;
        rear = rear.next;
        size--;
        return res.data;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0 ? true : false;
    }
    public E peek(){
        return rear.data;
    }
    public boolean contains(E target){
        return indexOf(target) == -1 ? false : true;
    }
    public int indexOf(E target){
        ListNode<E> temp = rear;
        int index = 0;
        while (!rear.isEnd){
            if (rear.data == target){
                rear = temp;
                return index;
            }
            rear = rear.next;
            index++;
        }
        rear = temp;
        temp = front;
        while (!front.isEnd){
            if (front.data == target){
                front = temp;
                return index;
            }
            front = front.next;
            index++;
        }
        front = temp;
        return -1;
    }
}
