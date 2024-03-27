import java.util.*;

public class BinaryTree<T> {
    B_TreeNode<T> root;
    int level = 0;
    int size = 0;

    BinaryTree(){}
    BinaryTree(B_TreeNode<T> root){
        this.root = root;
        size++;
    }
    public int getSize(){
        return size;
    }
    public List<B_TreeNode<T>> DFS(){
        return inorderIterative();
    }

    public List<List<B_TreeNode<T>>> BFS(){
        B_TreeNode<T> root = this.root;
        List<List<B_TreeNode<T>>> res = new ArrayList<>();
        bfsHelper(root, res, 0);
        return res;
    }
    private void bfsHelper(B_TreeNode<T> root, List<List<B_TreeNode<T>>> res, int level){
        if(root == null) return;
        if (res.size() == level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root);
        if (root.left != null) bfsHelper(root.left, res, level + 1);
        if (root.right != null) bfsHelper(root.right, res, level + 1);
    }

    public List<List<B_TreeNode<T>>> BFS_Queue(){
        List<List<B_TreeNode<T>>> res = new ArrayList<>();
        Queue<B_TreeNode<T>> q = new LinkedList<>();
        q.add(this.root);
        while(!q.isEmpty()){
            int size = q.size();
            List<B_TreeNode<T>> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                B_TreeNode<T> cur = q.poll();
                tmp.add(cur);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            res.add(tmp);
        }
        return res;
    }
    public void inorderTraversal (B_TreeNode<T> root){
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }
    public List<B_TreeNode<T>> inorderIterative(){
        List<B_TreeNode<T>> res = new ArrayList<>();
        Stack<B_TreeNode<T>> st = new Stack<>();
        B_TreeNode<T> cur = this.root;
        while(cur != null || !st.empty()){
            while(cur != null){
                st.push(cur);
                cur= cur.left;
            }
            cur = st.pop();
            res.add(cur);
            cur = cur.right;
        }
        return res;
    }
    public void preorderTraversal (B_TreeNode<T> root){
        if (root == null) return;
        System.out.print(root.data + " ");
        inorderTraversal(root.left);
        inorderTraversal(root.right);
    }
    public void postorderTraversal (B_TreeNode<T> root){
        if (root == null) return;
        inorderTraversal(root.left);
        inorderTraversal(root.right);
        System.out.print(root.data + " ");
    }
    public static void main(String[] args) {
        B_TreeNode<Integer> n4 = new B_TreeNode<>(4);
        B_TreeNode<Integer> n2 = new B_TreeNode<>(2);
        B_TreeNode<Integer> n1 = new B_TreeNode<>(1);
        B_TreeNode<Integer> n3 = new B_TreeNode<>(3);
        B_TreeNode<Integer> n6 = new B_TreeNode<>(6);
        B_TreeNode<Integer> n5 = new B_TreeNode<>(5);
        B_TreeNode<Integer> n7 = new B_TreeNode<>(7);
        n4.left = n2; n4.right = n6; n2.left = n1; n2.right = n3; n6.left = n5; n6.right = n7;
        BinaryTree<Integer> a = new BinaryTree<>(n4);
        a.inorderTraversal(n4);
        System.out.println("**************");
        List<B_TreeNode<Integer>> ioI = a.inorderIterative();
        for (B_TreeNode<Integer> i:ioI) {
            System.out.print(i.data + " ");
        }
        System.out.println("**************");
        List<List<B_TreeNode<Integer>>> bfs = a.BFS();
        for (List<B_TreeNode<Integer>> i:bfs) {
            for (B_TreeNode<Integer> t:i) {
                System.out.print(t.data + " ");
            }
        }
        System.out.println("**************");
        List<List<B_TreeNode<Integer>>> bfsQ =a.BFS_Queue();
        for (List<B_TreeNode<Integer>> i:bfsQ) {
            for (B_TreeNode<Integer> t:i) {
                System.out.print(t.data + " ");
            }
        }
    }
}
