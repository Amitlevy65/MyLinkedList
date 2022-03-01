package ex3;

public class MyLinkedList {
	 
	private static int counter;
	private Node head;
	private Object data;
	private Stack thestack;
	private boolean undone = false;
	//add fields as you see fits 
	
	
	// Default constructor
	public MyLinkedList() {
		this.head = new Node(this.data);
		this.thestack = new Stack();
		counter = 0;
	}
	
	
 
	// appends the specified element to the end of this list.
	public void add(Object data) {
		if (head == null) {
			head = new Node(data);
		}
		else {
			Node temp = head;
			while(temp.next != null) {
				temp = temp.getNext();
			}
			temp.next = new Node(data);
		}
		incrementCounter();
		if(undone == false) {
			thestack.indexPush(counter-1);				//
			thestack.undoPush(1);						//
			thestack.dataPush(data);					//
		}
	}
 
	private static int getCounter() {
		return counter;
	}
 
	private static void incrementCounter() {
		counter++;
	}
 
	private void decrementCounter() {
		counter--;
	}
 
	// inserts the specified element at the specified position in this list
	public void add(Object data, int index) {

		if (head == null) {
			head = new Node(data);
			incrementCounter();
		}
		else {
			Node temp = new Node(data);
			Node current = head;
			int count = 0;
			
			while(current.next != null) {
				if(count == index) {
					temp.next = current.next;
					current.next = temp;
					incrementCounter();
					if (undone == false) {
						thestack.undoPush(1);						//
						thestack.dataPush(data);					//
						if (index == count) {
							thestack.indexPush(count);
						}
						else {
						thestack.indexPush(counter-1); 				//
						}
					}	
				}
				current = current.next;
				count++;
			}
			
			if (index > count) {
				this.add(data);
			}
		}
	}
	
	
 
	public Object get(int index){
	// returns the element at the specified position in this list.
		Node temp = null;		
		if (head != null && index < counter) {
			temp = head.getNext();
			for(int i = 0 ; i < index ; i++) {
				if (temp.next != null) {
					temp = temp.getNext();
				}
			}
			return temp.getData();
		}
		return temp;
	}
 
	
	// undo last active operation (add/remove).
	public boolean undo() {
		if (thestack.undoIsEmpty() || thestack.dataIsEmpty() || thestack.indexIsEmpty()) {
			return false;
		}
		else {
			undone = true;
			if(thestack.undoTop() == 1) {
				this.remove(thestack.indexPop());
				thestack.undoPop();
				thestack.dataPop();
				undone = false;
				return true;
			}
			if(thestack.undoTop() == 0) {
				this.add(thestack.dataPop(), thestack.indexPop());
				thestack.undoPop();
				undone = false;
				return true;
			}
		}
		return true;
	}
	
	// removes the element at the specified position in this list.
	public boolean remove(int index) {
		Node temp = head;
		if (head == null) {
			return false;
		}
		else {
			
			for( int i = 0 ; i < index ; i++) {
				if (temp.next == null) {
					return false;
				}
				else {
				temp = temp.getNext();
				}
			}
			if (undone == false) {
				thestack.dataPush(temp.next.getData());		//
				thestack.undoPush(0);							//
				thestack.indexPush(index);					//
			}
			temp.next = temp.getNext().getNext();
			decrementCounter();	
			return true;
		}
	}
 

	
	// returns the number of elements in this list.
	public int size() {
		return getCounter();
	}
 
	//String that will be in the following format: [1][2][3][1]
	public String toString() {
		String tostring = "";
		if (head != null) {
			Node temp = head.getNext();
			while(temp != null) {
				tostring += "["+temp.getData().toString()+"]";
				temp = temp.getNext();
			}
		}
		return tostring;
	}
}
