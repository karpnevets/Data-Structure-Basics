public class Traversal {
    public static int[] list_val(ListNode head) {
        if (head == null) return null;
        int count = 1;
        ListNode temp = head;
        while (temp.next != null){
            temp = temp.next;
            count++;
        }
        temp = head;
        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            res[i] = temp.val;
            temp = temp.next;
        }
        return res;
    }
    public static int find_target(ListNode head, ListNode target){
        if (head == null) return -1;
        int index = 1;
        boolean none = true;
        ListNode temp = head;
        while(temp != null){
            if (temp.val == target.val) {
                none = false;
                break;
            }
            temp = temp.next; index++;
        }
        if (none) return -1;
        else return index;
    }
    public static int find_target(ListNode head, int target){
        if (head == null) return -1;
        int index = 1;
        boolean none = true;
        ListNode temp = head;
        while(temp != null){
            if (temp.val == target) {
                none = false;
                break;
            }
            temp = temp.next; index++;
        }
        if (none) return -1;
        else return index;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2; l2.next = l3; l3.next = l4;
        System.out.println(find_target(l1, 4));
    }
}
