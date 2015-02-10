/**
  Derived from page 582 of J. J. Prichard and F. M. Carrano, 3rd Edition.
*/
import java.util.Queue;
import java.util.LinkedList;

public class SBinaryST
{
	private STreeNode root;

	//default constructor, construct an empty string binary search tree
	public SBinaryST()
	{
		root=null;
	}

	//return true if the tree is empty, false otherwise
	public boolean isEmpty()
	{
		if(root == null) return true;
		else return false;
	}

	//make the tree empty
	public void makeEmpty()
	{
		root = null;
	}

	//return the string at root, throw a TreeException if it is empty
	public String getRootStr()
	{
		if (root == null)
			throw new TreeException("Root is null!");
		else return root.item;
	}

	//insert the string str into the binary search tree (in alphabetical order)
	public void insert(String str)
	{
		insert(root, str);
	}

	//insert the string str into the binary search sub-tree rooted at node(in alphabetical order)
	private STreeNode insert(STreeNode node, String str)
	{

		if(isEmpty())
			root = new STreeNode(str);

		else if (node.item.equals(str)){
			System.out.println(node.item+" "+str);
			throw new TreeException("Duplicate, String not added to Tree");
		}else if(node.item.compareTo(str)>0)
		{
			if(node.left == null)
				node.left = new STreeNode(str);
			else insert(node.left, str);
		}
		else if(node.item.compareTo(str)<0)
		{
			if(node.right == null)
				node.right = new STreeNode(str);
			else insert(node.right, str);
		}
		return node;
	}

	//return a string representation of the shape of the tree, tilted 90 degrees
	public String printTree()
	{
		StringBuilder str = new StringBuilder("The Shape of the Tree is:\n\n");
		printTree(root,0,str);
		return str.toString();
	}

	//StringBuilder object "output" contains the shape of the tree, tilted 90 degrees
	private void printTree(STreeNode node, int indent,StringBuilder output)
	{
		if (node!= null)
		{
			printTree(node.right, indent+2, output);
			for(int i=0; i<(indent*2); i++)
				output.append(" ");
			output.append(node.item);
			output.append("\n");
			printTree(node.left, indent+2, output);
		}
	}

	//return the height of the tree. return 0 if the tree is null
	public int height()
	{
		return height(root);
	}

	//return the height of the tree rooted at node. return 0 is the node is null
	private int height(STreeNode node)
	{
		int lh =0;
		int rh =0;
		if(node == null)
			return 0;
		if(node.left != null)
			lh = height(node.left);
		if(node.right != null)
			rh = height(node.right);
		if(lh>rh) return lh+1;
		else return rh+1;
	}
	//return string representation of the tree, one level at a time
	public String levelOrderStr()
	{
		Queue<STreeNode> q = new LinkedList<STreeNode>();
		q.add(root);

		String str = "{";

		while(!q.isEmpty())
		{
			STreeNode temp = q.remove();
			str += temp.item+",";
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
			q.add(temp.right);
		}
		return str.substring(0,str.length()-1)+"}";
	}
	//return the in-order string representation of the tree rooted
	public String toString()
	{
		return inOrderStr();
	}

	//return the in-order string representation of the tree rooted
	public String inOrderStr()
	{
		String s =inOrder(root);
		return "{"+s.substring(0,s.length()-1)+"}";
	}

	//return the in-order string representation of the sub tree rooted at node
	private String inOrder(STreeNode node)
	{
		if(!isEmpty())
		{
			String str = "";
			if(node.left != null)
				str += inOrder(node.left);
			str+= node.item + ",";
			if(node.right != null)
				str += inOrder(node.right);
			return str;
		}
		return "";
	}

	//return the post-order string representation of the tree
	public String postOrderStr()
	{
		String str = "{";
		if(!isEmpty())
		{
			str += postOrder(root);
			str = str.substring(0,str.length()-1);
		}
		return str + "}";
	}

	//return the post-order string representation of the sub tree rooted at node
	private String postOrder(STreeNode node)
	{
		String str = "";

		if(node.left != null)
			str += postOrder(node.left);
		if(node.right != null)
			str += postOrder(node.right);
		str += node.item +",";
		return str;
	}

	//return the pre-order string representation of the tree
	public String preOrderStr()
	{
		String str = "{";
		if(!isEmpty())
		{
			str += preOrder(root);
			str = str.substring(0,str.length()-1);
		}
		return str + "}";
	}
	//return the pre-order string representation of the sub tree rooted at node
	private String preOrder(STreeNode node)
	{
		String str = "";
		str += node.item +",";
		if(node.left != null)
			str += preOrder(node.left);
		if(node.right != null)
			str += preOrder(node.right);
		return str;
	}

	public static void main(String[] args)
	{
		SBinaryST tree=new SBinaryST();
		tree.insert("d");
		tree.insert("b");
		tree.insert("a");
		tree.insert("c");
		tree.insert("e");
		System.out.println("inorder: "+tree);
		System.out.println("pre: "+tree.preOrderStr());
		System.out.println("post: "+tree.postOrderStr());
		System.out.println("level: "+tree.levelOrderStr());
		System.out.println("height = "+tree.height());
		System.out.println(tree.printTree());
	}
}