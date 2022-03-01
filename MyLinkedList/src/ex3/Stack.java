package ex3;

public class Stack {
	
	int MAX=1000;
	static int datatop = -1;
	static int undotop = -1;
	static int indextop = -1;
	private Object datalist[];
	private Integer undolist[];
	private Integer indexlist[];

	public Stack(){
		this.datalist = new Object[MAX];
		this.undolist = new Integer[MAX];
		this.indexlist = new Integer[MAX];
	}
	
	public boolean dataIsEmpty() {
		return datatop == -1;
	}
	
	public boolean undoIsEmpty() {
		return undotop == -1;
	}
	
	public boolean indexIsEmpty() {
		return indextop == -1;
	}
	
	public void dataPush(Object o) {
		if (datatop == MAX) {
			System.out.println("ERROR");
		}
		else {
			datalist[++datatop] = o;
		}
	}
	
	public void undoPush(int x) {
		if (undotop == MAX) {
			System.out.println("ERROR");
		}
		else {
			undolist[++undotop] = x;
		}
	}
	
	public void indexPush(int x) {
		if (indextop == MAX) {
			System.out.println("ERROR");
		}
		else {
			indexlist[++indextop] = x;
		}
	}
	
	public Object dataPop() {
		if (dataIsEmpty()) {
			return null;
		}
		else {
			datatop -= 1;
			return datalist[datatop+1];
		}
	}
	
	public Integer undoPop() {
		if (undoIsEmpty()) {
			return null;
		}
		else {
			undotop -= 1;
			return undolist[undotop+1];
		}
	}
	
	public Integer indexPop() {
		if (indexIsEmpty()) {
			return null;
		}
		else {
			indextop -= 1;
			return indexlist[indextop+1];
		}
	}
	
	public Object dataTop() {
		if(dataIsEmpty()) {
			return null;
		}
		else {
			return datalist[datatop];
		}
	}
	
	public Integer undoTop() {
		if(undoIsEmpty()) {
			return null;
		}
		else {
			return undolist[undotop];
		}
	}
	
	public Integer indexTop() {
		if(indexIsEmpty()) {
			return null;
		}
		else {
			return indexlist[indextop];
		}
	}
	
	public int dataSize() {
		return datatop;
	}
	
	public int undoSize() {
		return undotop;
	}
	
	public int indexSize() {
		return indextop;
	}
}
