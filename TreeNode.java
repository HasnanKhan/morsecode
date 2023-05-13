//@author: Hasnan Khan
public class TreeNode<T> extends Object {
	TreeNode<T> left;
	TreeNode<T> right;
	T data;
	public TreeNode() {
		left = null;
		right = null;
		data = null;
	}
	public TreeNode(T dataNode) {
		left = null;
		right = null;
		data = dataNode;
	}
	public TreeNode(TreeNode<T> node) {
		left = node.left;
		right = node.right;
		data = node.data;
	}
	public T getData() {
		return data;
	}
}
