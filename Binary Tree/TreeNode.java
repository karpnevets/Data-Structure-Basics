import java.util.ArrayList;
import java.util.List;

public class TreeNode<T>{
    T data;
    List<TreeNode<T>> children = new ArrayList<>();
    public TreeNode() {}
    public TreeNode(T val) {this.data = val;}
}
