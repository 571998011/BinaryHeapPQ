class Node
{
	public int data;						// data item (key)
	public Node(int data) { this.data = data; } 	// constructor
	
	@Override
	public String toString() {
		return Integer.toString(this.data);
	}
} // end class Node

