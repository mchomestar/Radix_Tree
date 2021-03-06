import java.util.Iterator;
import java.io.FileInputStream;
import java.util.Scanner;
/**
 * DigitTree class creates a digit tree
 * and allows users to munipulate 
 * the tree in certain ways
 * <br><br>
 * @author Allen McDermott
 * @since 11/16/14
 */
public class DigitTree implements Iterable {
	

	//variable root is the root of the Digit tree
	node root;

	//size is the size of the Digit tree
	int size;

	//nodeCount is the amount of nodes in the Digit tree
	int nodeCount;

	//String data was origannally going to be used to make a string of all 
	//the variables but then it would be inefficient and would make the 
	//Digit tree arbitrary but i decided not to delete it
	String data;


	/** DigitTree is the constructor for the DigitTree class
	 * it creates a new node for the root and sets size,nodeCount to 0
	 * and data to "" but data isn't used in this class
	**/
	public DigitTree()
	{
		node k = new node("",null);
		root = k;
		size = 0;
		nodeCount = 0;
		data="";
	}


	/**
	 * getRoot returns the root of the digitTree
	 * @return root of the Digit tree
	 * time function 1 - no matter how many elements are in the list it will
	 * take the same amount of time
	 * time complexity O(1)
	 * time function C
	**/
	public node getRoot() {
		return root;
	}


	/**
	 * getSize  returns the size of the Digit tree
	 * @return size of the Digit tree type int
	 * time function 1 - no matter how many elements are in the list it will
	 * take the same amount of time
	 * time complexity O(1)
	 * time function C
	**/
	public int getSize() {
		return size;
	}

	
	/**
	 * clear clears the DigitTree by making a new one and setting all
	 * the variables to 0
	 * time funtion - C
	 * time complexity O(1)
	**/
	public void clear() {
		node k = new node("",null);
		root = k;
		size = 0;
		nodeCount = 0;
		data="";
	}


	/**
 	 * add adds a string to the digit tree
	 * adds calls contains to make sure that it doesn't add a 
	 * string that is already in the tree
	 * also throws DigitFormatException if string contains non numeric values
	 * @param string to be added to tree
	 * @return boolean false if item was not added to the list true if successfull
	 * time complexity O(n) - n being the length of string s
	 * time function - Cn+C
	**/
	public boolean add(String s) throws DigitFormatException {
		try{
			if(contains(s)==true) {
			return false;
			}
		}
		catch(DigitFormatException e) {
			throw new DigitFormatException();
		}
		data+=s+",";
		node k;
		k = root;
		char c;
		int i;
		while(s.length()>0){
			c = s.charAt(0);
			i = Integer.parseInt(c+"");
			if(k.getNext(i)!= null) {
				k = k.getNext(i);
			}
			else {
				k.setNext(c+"",k);
				nodeCount++;
				k = k.getNext(i);
			}
			s = s.substring(1);
		}
		k.setNext("k",k);
		size++;
		return true;
	}


	/**
	 * size returns size of digitTree
	 * @return size of digit tree
	 * time function 1 - no matter how many elements are in the list it will
	 * take the same amount of time
	 * time complexity O(1)
	 * time function - C
	**/
	public int size() {
		return size;
	}


	/**
	 * nodeCount returns the amount of nodes in the digit tree
	 * @return number of nodes in the digit tree
	 * time function 1 - no matter how many elements are in the list it will
	 * take the same amount of time
	 * time complexity O(1)
	 * time function - C
	**/
	public int nodeCount() {
		return nodeCount;
	}


	/**
	 * contains takes in a string and check if it is in the digit tree
	 * contains also throws DigitformatException if the string contains non numeric values
	 * @param s is string that will be checked
	 * @return boolean true if string s is in the tree false if not
	 * time complexity O(n) - n being the length of string s
	 * time function - Cn+C
	**/
	public boolean contains(String s) throws DigitFormatException {
		node k;
		k = root;
		char c;
		int i;
		int iwaq=0;
		c = s.charAt(0);
		while(iwaq<10) {
			if(c == Character.forDigit(iwaq,10)) {
				iwaq=11;
			}
			iwaq++;
		}
		if(iwaq-1<10) {
			throw new DigitFormatException();
		}
		i = Integer.parseInt(c+"");
		if(k.getNext(i)==null) {
			return false;
		}
		while(s.length()>0){
			c = s.charAt(0);
			iwaq=0;
			while(iwaq<10) {
				if(c == Character.forDigit(iwaq,10)) {
					iwaq=11;
				}
				iwaq++;
			}
			if(iwaq-1<10) {
				throw new DigitFormatException();
			}
			i = Integer.parseInt(c+"");
			if(k.getNext(i)!=null) {
				k = k.getNext(i);
			}
			else if(k.getNext(i)==null) {
				return false;
			}
			s = s.substring(1);
		}
		if(k.getNext(10)!=null) {
			return true;
		}
		return false;
		
		
	}	
	

	/**
	 * delete takes in a string if that string is in the digit tree it will be removed 
	 * delete also throws DigitFormatException if it tries to delete a string with a noon numeric value
	 * @param String s which will be deleted in the tree if its in the tree
	 * @return boolean false if item wasn't deleted, true if it was
	 * time complexity O(n) - n being the length of String s
	 * time function - Cn+C
	**/
	public boolean delete(String s) throws DigitFormatException{
		try {
			if(contains(s)==false) {
			return false;
			}
		}
		catch(DigitFormatException e){}
		String[] qwap = data.split(",");
		for(int ill = 0;ill<qwap.length;ill++) {
			if(qwap[ill]==s) {
				qwap[ill]="";
			}
			data+=qwap[ill]+",";
		}	
		node k;
		node temp;
		k = root;
		char c;
		int i;
		System.out.println("WTF");
		while(s.length()>0){
			c = s.charAt(0);
			i = Integer.parseInt(c+"");
			k=k.getNext(i);
			s = s.substring(1);
		}
		System.out.println(k.getNext(10).getData());
		k.setNode(10);
		System.out.println(k.getParent().getData());
		nodeCount--;
		size--;
		while(k.inList()==false&&k!=root) {
			temp = k;
			k = k.getParent();
			temp = null;
			nodeCount--;
		}
		
		return true;
	}


	/**
	 * sortList is not used in this class because it is ineffeciant and arbitrary
	**/
	public void sortList() {
		String[] go = data.split(",");
		boolean swap = true;
		int j = 0;
	    	while (swap) {
			swap = false;
			j++;
			for (int i = 0; i < go.length - j; i++) {
				if (go[i].compareTo(go[i + 1]) > 0) {
		        	String tmp = go[i];
		        	go[i] = go[i + 1];
		        	go[i + 1] = tmp;
		        	swap = true;
		    		}

			}

   		}
		data="";
		for(int i = 0; i<go.length;i++) {
			data+=go[i]+",";
		}
	}





	/**getListt uses to global variable that are only used for this method 
	 * a is an array of Strings 
	 * its is used to track the index of a when items ar being added to it
	**/
	String[] a;
	int its;

	/**
	 * getListt puts strings in digit tree to an array in
	 * a lexographic listing 
	 * this method uses recursion to traverse threw the tree
	 * @param  node k which is 
	 * @return a  string of the items in the digit tree
	**/ 
	public String getListt(node k,String s) {
		if(k.inList()==false) {
			return "";
		}	
		if(k.getNext(10)!=null) {
			a[its]=s+k.getData();
			its++;			
		}
		if(k.noK()==false) {
			return "";
		}
		s+=k.getData();
		int imp = 0;
		while(imp<10) {
			if(k.getNext(imp)!=null) {
				getListt(k.getNext(imp),s);
			}
			imp++;
		}
		
		return "";
		
	}

	
	/**
	 * printList calls getListt and then outputs the items 
	 * in lexographic order
	 * @return an array of the items in the tree in lexographic order
	**/
	public String[] printList() {
		a = new String[size];
		its = 0;
		getListt(root,"");
		for(int i = 0;i<a.length;i++) {
		}
		return a;
	}

	/**
	 * Iterator returns and iterator which will iterate threw the digit tree
	 * time complexity O(n) - n being the number of nodes
	 * time function - Cn+C
	**/
	public Iterator iterator() {
		Iterator t = null; 
		System.out.println();
		a = new String[size];
		its = 0;
		getListt(root,"");
		for(int i = 0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		return t;	
	}


	/**
	 * stringRec uses recursion to make a single string that represents all the items
	 * in the digit tree
	 * @param node k starts out as the root but is used for all the other nodes in the tree
	 * @param s string that will represent all the items in the tree
	 * @return string representing all the items in the tree
	**/	 
	public String stringRec(node k, String s) {
		if(k==null) {
			return "";
		}
		if(k.noK()==false) {
			return "";
		}
		
		int ip = 0;
		int imp = 0;
		while(imp<10) {
			if(k.getNext(imp)!=null) {
				if(ip!=1) {
					s+="("+k.getNext(imp).getData()+" ";
					s = s+stringRec(k.getNext(imp),"");
					ip++;
				}
				else {
					s+= k.getNext(imp).getData()+" ";
					s = s+stringRec(k.getNext(imp),"");		
				}
			}
			imp++;
		}
		s= s+")";
		return s;
	}



	/**
	 * this method simply calls stringRec and returns the string created by 
	 * stringRec
	 * @return string representing all the items in the tree
	 * time complexity O(n) - n being the number of nodes
	 * time function - Cn+C
	**/
	public String toString() {
		return stringRec(root,"");
	}
	


	/**
	 * intersectRec uses to global variables only used by this method
	 * uni is an array strings
	 * kills is used to track the index's of uni
	**/
	String[] uni;
	int kills;

	/**
	 * intersectRec takes two digitTrees and puts all the items that are only in one of the 
	 * trees and puts them into an array
	 * this method uses recursion
	 * @param k node of one of the digit trees
	 * @param n node of the other digit tree
	 * @param s is the item that is used to travers the tree
	 * @return string of the traversal threw the tree
	**/
	public String intersectRec(node k,node n, String s) {
		if(k==null||n==null) {
			return "";
		}

		if(k.getNext(10)!=null&&n.getNext(10)!=null) {
			uni[kills]=s+k.getData();
			kills++;
			
		}

		if(k.noK()==false||n.noK()==false) {
			return "";
		}
		
		int ip = 0;
		int imp = 0;
		s+=k.getData();
		while(imp<10) {
			if(k.getNext(imp)!=null&&n.getNext(imp)!=null) {
				
				intersectRec(k.getNext(imp),n.getNext(imp),s);
			}
			imp++;
		}
		
		return "";
	}


	/**
	 * intersect takes in a digit tree and makes one that this and others don't
	 * have in common
	 * @param other is a digit tree that will be compared to the current digit tree
	 * @return an intersection digit tree between others and the current digit tree
	 * time complexity O(n+|nodeCount for other|) - n being the number of nodes
	 * time function - (Cn+C)+C|nodeCount for other|+C
	**/
	public DigitTree intersect(DigitTree other) {
		if(other.getSize()>size) {
			uni = new String[other.getSize()];
		}
		else {
			uni = new String[size];
		}
		kills=0;
		DigitTree temp = new DigitTree();
		intersectRec(root,other.getRoot(),"");
		for(int i=0;i<uni.length;i++) {
			if(uni[i]!=null) {
				try{
					temp.add(uni[i]);
				}
				catch(DigitFormatException e){}
			}
		}
		return temp;
	}


	/**
	 * union adds both items from others and the current tree
	 * and makes a new one with both those items
	 * @param other is a digit tree that will be added to make a new one
	 * @return digit tree containing items from both others and the current tree
	 * time complexity O(n+|nodeCount for other|) - n being the number of nodes
	 * time function - (Cn+C)+C|nodeCount for other|+C
	**/ 
	public DigitTree union(DigitTree other) {
		String[] kool = other.printList();
		String[] caal = printList();
		DigitTree temp = new DigitTree();
		for(int it =0; it<kool.length;it++) {
			try{
				temp.add(kool[it]);
			}
			catch(DigitFormatException e){
				System.out.println("error in union");}
		}
		for(int it =0; it<caal.length;it++) {
			try{
				temp.add(caal[it]);
			}
			catch(DigitFormatException e){System.out.println("error in union2");}
		}
		return temp;
	}


	/**
	 * sub and brains are global variables only used by subRec
	 * sub is an array of Strings 
	 * brains is an int that tacks the index's of sub
	**/
	String[] sub;
	int brains;

	/**
	 * subRec is a recursive method that subtracts one digit tree from another
	 * @param node k first tree
	 * @param node n tree that will be deleted from k
	 * @param s is the string that tracks the items
	 * @return string of items
	**/
	public String subRec(node k,node n, String s) {
		if(k==null) {
			return "";
		}
		if(n!=null) {
			if(k.getNext(10)!=null&&n.getNext(10)==null) {
				sub[brains]=s+k.getData();
				brains++;
			}
		}
		else{
			if(k.getNext(10)!=null) {
				sub[brains]=s+k.getData();
				brains++;
			}
		}

		if(k.noK()==false) {
			return "";
		}
		
		int ip = 0;
		int imp = 0;
		s+=k.getData();
		while(imp<10) {
			if(k.getNext(imp)!=null) {
				if(n!=null) {
					subRec(k.getNext(imp),n.getNext(imp),s);
				}
				else {
					subRec(k.getNext(imp),n,s);
				}
			}
			imp++;
		}
		
		return "";
	}


	/**
	 * subtarct uses subRec to get items into an array and add them to
	 * a new digit tree
	 * @param digit tree to delete from current tree
	 * @return digit tree that has been subtracted
	 * time complexity O(n+|nodeCount for other|) - n being the number of nodes
	 * time function - (Cn+C)+C|nodeCount for other|+C
	**/
	public DigitTree subtract(DigitTree other) {
		DigitTree temp = new DigitTree();
		sub = new String[size];
		subRec(root,other.getRoot(),"");
		for(int its = 0;its<sub.length;its++) {
			if(sub[its]!=null) {
				try{
					temp.add(sub[its]);
				}
				catch(DigitFormatException e){}
			}
		}
		return temp;
	}
		
		
		

				
				 
}
