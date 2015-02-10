/*
Name: Nathan Burrell
Student #: V00198776
*/
public class Node<T>
{
	public T item;
	public Node next;
	public Node prev;

	// Default constructor. Sets the item to 0, next to null.
	public Node()
	{
		next=null;
		prev=null;
	}

	// Constructor. Assigns the n to item, null to next.
	public Node(T n)
	{
		item=n;
		next=null;
	}

	// Constructor. Assigns the n to item, nextNode to next.
	public Node(T n,Node<T> nextNode )
	{
		item=n;
		next=nextNode;
	}
}