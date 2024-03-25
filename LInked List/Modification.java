import java.util.Stack;

public class Modification {
    public static ListNode addition(ListNode head, ListNode addon, int index){
        if (index < 1) return null;
        else if (index == 1) {
            addon.next = head;
            return addon;
        }
        ListNode temp = head;
        while (temp.next != null && index - 1 > 1){
            temp = temp.next;
        }
        ListNode save = temp.next;
        temp.next = addon;
        addon.next = save;
        return head;
    }
    public static ListNode subtraction(ListNode head, ListNode target){
        if (head == null) return null;
        ListNode start = head;
        while (start != null && start.val == target.val) start = start.next;
        ListNode temp = start;
        while (temp != null && temp.next != null){
            if (temp.next.val == target.val) {
                ListNode temp2 = temp.next;
                while (temp2 != null && temp2.val == target.val) temp2 = temp2.next;
                temp.next = temp2;
            }
            temp = temp.next;
        }
        return start;
    }

    public static ListNode reverse(ListNode head){
        if (head == null) return null;
        ListNode temp = head;
        int count = 1;
        while (temp.next != null){
            temp = temp.next;
            count++;
        }
        ListNode res = temp;
        temp = head;
        ListNode[] helper = new ListNode[count - 1];
        for (int i = 0; i < count - 1; i++) {
            helper[i] = temp;
            temp = temp.next;
        }
        for (int i = 0; i < helper.length; i++) {
            res.next = helper[helper.length - i - 1];
            res = res.next;
        }
        res.next = null;
        return temp;
    }

    public static ListNode reverse2 (ListNode head){
        if (head == null) return null;
        ListNode temp = head;
        Stack<ListNode> st = new Stack<>();
        while (temp.next != null){
            st.push(temp);
            temp = temp.next;
        }
        ListNode res = temp;
        while (st.size() > 0){
            res.next = st.pop();
            res = res.next;
        }
        res.next = null;
        return temp;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2; l2.next = l3; l3.next = l4;
        ListNode test = reverse2(l1);
        if (test == null){
            System.out.println("Invalid addition point");
        } else {
            while (test != null){
                System.out.println(test.val);
                test = test.next;
            }
        }
    }
}
