//@author: Hasnan Khan
import java.util.ArrayList;

public class MorseCodeTree extends Object implements LinkedConverterTreeInterface<String> {

	TreeNode<String> root  = new TreeNode<String>();
	//call builds the tree
	public MorseCodeTree() {
		buildTree();
	}
	public LinkedConverterTreeInterface<String> insert(String code, String result) {
		addNode(root, code, result);
		return this;
	}

	
	public String fetch(String code) {
		return fetchNode(root,code);
	}

	//throw exception
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	//throw exception
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	//creates the tree
	public void buildTree() {
		//root
		setRoot(new TreeNode<String>(""));
		//level 1
		insert(".","e");
		insert("-","t");
		//level 2
		insert("..","i");
		insert(".-","a");
		insert("-.","n");
		insert("--","m");
		//level 3
		insert("...","s");
		insert("..-","u");
		insert(".-.","r");
		insert(".--","w");
		insert("-..","d");
		insert("-.-","k");
		insert("--.","g");
		insert("---","o");
		//level 4
		insert("....","h");
		insert("...-","v");
		insert("..-.","f");
		insert(".-..","l");
		insert(".--.","p");
		insert(".---","j");
		insert("-...","b");
		insert("-..-","x");
		insert("-.-.","c");
		insert("-.--","y");
		insert("--..","z");
		insert("--.-","q");
	}


	public ArrayList<String> toArrayList() {
		ArrayList<String> l = new ArrayList<String>();
		LNRoutputTraversal(root,l);
		return l;
	}
	//returns the root
	public TreeNode<String> getRoot(){
		return root;
	}
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}
	public void addNode(TreeNode<String> root, String code, String letter) {
		if(code.length() == 1) {
			if(code.equals(".")) {
				root.left = new TreeNode<String>(letter);
			}
			if(code.equals("-")) {
				root.right = new TreeNode<String>(letter);
			}
		}else {
			if(code.charAt(0) == '.') {
				addNode(root.left, code.substring(1),letter);
			}
			if(code.charAt(0) == '-') {
				addNode(root.right, code.substring(1),letter);
			}
		}
	}
	public String fetchNode(TreeNode<String> root, String code) {
		if(code.length() == 1) {
			if(code.equals("-")) {
				return root.right.getData();
			}
			if(code.equals(".")) {
				return root.left.getData();
			}
		}else {
			if(code.charAt(0)=='-') {
				return fetchNode(root.right,code.substring(1));
			}
			if(code.charAt(0)=='.') {
				return fetchNode(root.left,code.substring(1));
			}
		}
		return null;
		
	}

	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root == null) {
			return;
		}
		LNRoutputTraversal(root.left,list);
		list.add(root.getData());
		LNRoutputTraversal(root.right,list);
	}

}
