class Heap implements PriorityPQ {
	private Node[] heapArray;	
	private int maxSize;		// size of array
	private int currentSize;	// number of nodes in array
	
	// ------------------------------------------------------------

	// constructor
	public Heap(int mx)	{
		maxSize = mx;
		currentSize = 0;
		heapArray = new Node[maxSize]; // create array
	}

	public boolean isEmpty(){ return currentSize==0; }
	// ------------------------------------------------------------

	public boolean enQueue(int data) {
		System.out.println(" enQueue Node[" + data + "]");
			
		
		if(currentSize==maxSize) return false;

		Node newNode = new Node(data);		// create new node for enQueue
		
		heapArray[currentSize] = newNode;	// append new node to Queue
		
		System.out.println("Total Node in Queue="+(currentSize+1));
		moveNodeUp(currentSize++);			// move child node up
		System.out.println("Next index array for new Node in Queue ="+currentSize);
		displayHeap();
		return true;
	} // end insert()
	// ------------------------------------------------------------

	public void moveNodeUp(int index) {
		int parent = (index-1) / 2;					// formula find parent
		System.out.println();
		
		Node bottom = heapArray[index];				// Store current enQueue Node to tempolary Node
		boolean swap=false;
		while( index > 0 &&	heapArray[parent].data < bottom.data ) {
			System.out.println("compare new Child Node [" + bottom.data + "] with Parent ["+ heapArray[parent].data+"]");
			System.out.println("Swap between Parent ="+ heapArray[parent].data +
							" and Child [" +  bottom.data +"]");
			System.out.println("Store Parent Node at array index ["+ index +"] Child Node " + heapArray[index].data);
			heapArray[index] = heapArray[parent]; 	// move Parent Donw
			index = parent;							// swap index between parent and child
			parent = (parent-1) / 2;				// formula find parent
			System.out.println("new parent index =" + parent + " Node ["+ heapArray[parent].data+"]");
			swap=true;
			System.out.println();
		} // end while
		if (!swap) 	{System.out.println("No Swap (Child value less than Parent)");}
		else 		{System.out.println("End compare node");}
		System.out.println("Store new enQueue Node to Array index["+ parent +"] of Parent Node");
		heapArray[index] = bottom;
		
		System.out.println();
			
		
	} // end moveNodeUp()
	// -------------------------------------------------------------
	
	// delete item with max key
	public Node deQueue() {
		// (assumes non-empty list)

		Node root = heapArray[0];		// save deQueue root node for return and display
		
		System.out.println("deQueue ["+ root.data+"] from root only and rebalance tree");	
			
		heapArray[0] = heapArray[--currentSize];		// copy last Node for replace root Node
														// tempolary
		moveNodeDown(0);
		displayHeap();
		
		return root;	// return current deQueue root Node
	} // end remove()
	// -------------------------------------------------------------

	public void moveNodeDown(int index)	{
		int largerChild;
		Node top = heapArray[index];		// save root (Copy Last node to root Node)
		System.out.println("");
			
		while(index < currentSize/2)		// while node has at
		{									//		least one child,
			int leftChild = 2*index+1;		// find left child node index in array
			int rightChild = leftChild+1;	// find right child node index in array
			System.out.println("left Child Node of index " + index + " =" + leftChild);
			System.out.println("right Child Node of index " + index +" =" + rightChild);
			// find larger child
			System.out.println("find Larger child between left node and right node");
			if(	rightChild < currentSize && // (right Child exists?)
				heapArray[leftChild].data < heapArray[rightChild].data) {
					largerChild = rightChild;
					System.out.println(" leftChild = [" + heapArray[leftChild].data + "]"+
										" rightChild = [" +heapArray[rightChild].data + "]");
				}
			else
				largerChild = leftChild;
			System.out.println("Larger Child = index " + largerChild+ " [" +heapArray[largerChild].data +"]" );
				
			// top >= largerChild?
			System.out.println("compare between top Node and larger child");
			System.out.println("Top Node " + top.data + " >= " +
								heapArray[largerChild].data + " ????");
			
			if(top.data >= heapArray[largerChild].data)
				break;	// break loop
				
			// shift child up
			System.out.println(" if top Node less than bottom Node then move Bottom Node up");
			heapArray[index] = heapArray[largerChild]; // move bottom to up node (parent)
			System.out.println(" New top Node = " + heapArray[index].data);
			index = largerChild;			// move index top node go down 
			if (index < currentSize/2)
				System.out.println(" Next compare index node =" + index + " [" + heapArray[index].data +"] with Left Right Child");
			System.out.println();
			
			
		} // end while
		
		System.out.println(" End Rebalance tree");
		System.out.println(" New bottom node =" + index + " [" + top.data + "]");
		heapArray[index] = top;		// store root node to bottom node
		System.out.println();
			
		
	} // end moveNodeDown()
	// -------------------------------------------------------------
	
	public void displayHeap() {
		System.out.print("heapArray: ");		// array format
		
		for(int m=0; m<currentSize; m++)
			if(heapArray[m] != null)
				System.out.print( "("+heapArray[m].data + ") ");
			else
				System.out.print( "-- ");
			System.out.println();
			
			// heap format
			int nBlanks = 32;
			int itemsPerRow = 1;
			int column = 0;
			int j = 0;			// current item
			String dots = "...............................";
			System.out.println(dots+dots);			// dotted top line
			
			while(currentSize > 0)					// for each heap item
			{
				if(column == 0)						// first item in row?
					for(int k=0; k<nBlanks; k++)	// preceding blanks
						System.out.print(' ');
						
			
				System.out.print(heapArray[j].data);	// display item
				
				if(++j == currentSize)	// done?
					break;
		
				if(++column==itemsPerRow) {			// 	end of row?
					nBlanks /= 2;					//	half the blanks
					itemsPerRow *= 2;				//	twice the items
					column = 0;						//	start over on
					System.out.println();			//	new row
				}	
				else
					for(int k=0; k<nBlanks*2-2; k++) {
						System.out.print(" ");
					}
			} // end for
				System.out.println("\n"+dots+dots); //
		} // end displayHeap()
		
		// -------------------------------------------------------------
} // end class Heap
