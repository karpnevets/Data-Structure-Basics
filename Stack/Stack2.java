import java.util.ArrayList;

public class Stack2<E> {
    int size = 0;
    ArrayList<E> arr;
    int filled = 0;
    public Stack2(int size) {
        this.size = size;
        arr = new ArrayList<E>(size);
    }
    public boolean empty() {
        return filled == 0 ? true : false;
    }

    public E peek() {
        return arr.get(filled - 1);
    }

    public E pop() {
        filled -= 1;
        return arr.get(filled);
    }

    public void push(E num) {
        filled++;
        arr.add(filled - 1, num);
    }

    public int search(E target) {
        for (int i = filled; i > 0; i--) {
            if (arr.get(i - 1) == target)
                return i;
        }
        return -1;
    }
}
