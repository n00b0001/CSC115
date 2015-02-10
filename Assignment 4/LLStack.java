/*
Name: Nathan Burrell
Student #: V00198776
*/

public class LLStack<T> implements Stack<T>
{
	private Node<T> head;
	private Node<T> tail;
	private int size;

	public LLStack()
	{
		head = null;
		tail = null;
		size = 0;
	}

	public int size()
	{
		return size;
	}

	public boolean empty()
	{
		if(size == 0)
			return true;
		return false;
	}

	public void push(T element)
	{
		Node<T> n = new Node<T>(element);
		if(tail==null)
		{
			head = n;
		}else{
			tail.next = n;
			n.prev = tail;
		}
		tail = n;
		size++;
	}

	public T pop() throws StackEmptyException
	{
		Node<T> storage = tail;
		if(empty())
		{
			throw new StackEmptyException("Invalid expression.");
		}
		size--;
		if(tail.prev==null)
		{
			head = null;
			tail = null;
			return storage.item;
		}
		tail.prev.next = null;
		tail = tail.prev;
		return storage.item;
	}

	public T peek() throws StackEmptyException
	{
		if(empty())
		{
			throw new StackEmptyException("Peek failed");
		}else{
			return tail.item;
		}
	}

	public void makeEmpty()
	{
		head = null;
		tail = null;
		size = 0;
	}

	public String toString()
	{
		String list = "";
		Node<T> p = head;
		for(int i=0;i<size();i++)
		{
			list += p.item;
			if(p.next!=null)
			{
				list += ",";
			}
			p=p.next;
		}
		list += "";
		return list;
	}
}