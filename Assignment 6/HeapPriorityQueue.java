/*
 * HeapPriorityQueue.java
 *
 * CSC 115: Assignment 6 sample code.
 *
 */

public class HeapPriorityQueue implements PriorityQueue
{
	protected final static int DEFAULT_SIZE = 10000;

	/* This array is where you will store the elements in the heap */
	protected Comparable storage[];

	/* Keep track of the current number of elements in the heap */
	protected int currentSize;

	/* Default Constructor */
	public HeapPriorityQueue ()
	{
		this(DEFAULT_SIZE);
	}

	/* Constructor for a Heap with max size size*/
	public HeapPriorityQueue(int size)
	{
		storage = new Comparable[size + 1];
		currentSize = 0;
	}

	public int size ()
	{
		return currentSize;
	}

	public boolean isEmpty ()
	{
		return size() == 0;
	}

	public Comparable removeMin () throws HeapEmptyException
	{
		try
		{
			Comparable returnVal = storage[1];
			swapElement(1, currentSize);
			storage[currentSize--] = null;
			bubbleDown();
			return returnVal;
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				throw new HeapEmptyException();
			}
	}

	public void insert ( Comparable k  ) throws HeapFullException
	{
		try
		{
			storage[++currentSize] = k;
			bubbleUp();
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			throw new HeapFullException();
		}
	}

	/*
	 * A new value has just been added to the bottom of the heap
	 * "bubble up" until it is in the correct position
	 */
	private void bubbleUp ()
	{
		int i = size();
		while(i >= 2)
		{
			if (parent(i) == -1)
				return;
			if (storage[i].compareTo(storage[parent(i)]) < 0)
			{
				swapElement(i, parent(i));
				i = parent(i);
			}
			else return;
		}
	}

	/*
	 * Because of a removeMin operation, a value from the bottom
	 * of the heap has been moved to the root.
	 *
	 * "bubble down" until it is in the right position
	 */
	private void bubbleDown()
	{
		for(int i=1;;)
		{
			if(hasLeft(i))
			{
				if(hasRight(i))
				{
					if (storage[i].compareTo(storage[leftChild(i)]) >= 0 || storage[i].compareTo(storage[rightChild(i)]) >= 0)
					{
						if (storage[leftChild(i)].compareTo(storage[rightChild(i)]) <= 0)
						{
							swapElement(i, leftChild(i));
							i = leftChild(i);
						}
						else if(storage[leftChild(i)].compareTo(storage[rightChild(i)]) >= 0)
						{
							swapElement(i, rightChild(i));
							i = rightChild(i);
						}
						else return;
					}
					else return;
				}
				else {
					if(storage[leftChild(i)].compareTo(storage[i]) <= 0)
					{
						swapElement(i, leftChild(i));
						i = leftChild(i);
					}
					else return;
				}
			}
			else return;
		}
	}

	/*
	 * Swap the element at position p1 in the array with the element at
	 * position p2
	 */
	private void swapElement ( int p1, int p2 )
	{
		Comparable temp = storage[p1];
		storage[p1] = storage[p2];
		storage[p2] = temp;
	}

	/*
	 * Return the index of the parent of the node at pos
	 */
	private int parent ( int pos )
	{
		if(pos%2 == 1)
			return (pos-1)/2;
		else if(pos%2 == 0)
			return pos/2;
		else return -1;
	}

	/*
	 * Return the index of the left child of the node at pos
	 */
	private int leftChild ( int pos )
	{
		if(2*pos <= storage.length && storage[2*pos] != null)
			return 2*pos;
		else return -1;
	}

	/*
	 * Return the index of the right child of the node at pos
	 */
	private int rightChild ( int pos )
	{
		if(2*pos+1 <= storage.length && storage[2*pos+1] != null)
			return 2*pos+1;
		else return -1;
	}

	/*
	 * Given the current number of elements in the heap, does the
	 * node at pos have a left child?
	 *
	 * Note that all internal nodes have at least a left child.
	 *
	 */
	private boolean hasLeft ( int pos )
	{
		return (pos*2 <= currentSize);
	}

	/*
	 * Given the current number of elements in the heap, does the
	 * node at pos have a right child?
	 */
	private boolean hasRight ( int pos )
	{
		return (pos*2 + 1 <= currentSize);
	}
}
