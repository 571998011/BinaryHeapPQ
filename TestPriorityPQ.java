// HeapApp.java
// demonstrates heaps
// to run this program: C>java HeapApp
import java.io.*;			// for I/O
import java.lang.Integer;	// for parseInt()

////////////////////////////////////////////////////////////////
public class TestPriorityPQ {
	public static void main(String[] args) throws IOException	{
		int value;
		PriorityPQ theHeap = new Heap(31); // make a Heap; max size 31
		boolean success;
				
		// until [Ctrl]-[C]
		while(true) {
			putText("Enter first letter of ");
			putText("[s]how, [e]nQueue, [d]eQueue ,");
			putText("Ctrl+c to Exit:==>");
			int choice = getChar();
			
			switch(choice) {
				
				case 's': theHeap.displayHeap();	break;		// show
				case 'e':
						// enQueue
						putText("Enter value to enQueue: ");
						value = getInt();
						success = theHeap.enQueue(value);
						
						if( !success )
							putText("Can't insert; heap is full" + '\n');
						break;
				case 'd':
						// deQueue
						if( !theHeap.isEmpty() )
							theHeap.deQueue();
						else
							putText("Can't deQueue; heap is empty" +	'\n');
						break;
				default:
						putText("Invalid entry\n");
			} // end switch
		} //while (choice == 'x');// end while
	} // end main()
	// ------------------------------------------------------------
	
	public static void putText(String s) {
		System.out.print(s);
		System.out.flush();
	}
	//-------------------------------------------------------------
	
	public static String getString() throws IOException	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		if (s.equals("")) s="x";
		return s;
	}
	//-------------------------------------------------------------
	public static char getChar() throws IOException	{
		String s = getString();
		return s.charAt(0);
	}
	//-------------------------------------------------------------
	public static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}
	//-------------------------------------------------------------
} // end class HeapApp
		
