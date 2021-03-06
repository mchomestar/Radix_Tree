import java.util.Scanner;
/**
 * the test class contains menu's
 * and allows users to munipulate 3 different digitTrees 
 * <br><br>
 * @author Allen McDermott
 * @since 11/16/14
 */
public class test {


	/**public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		DigitTree tree = new DigitTree();
		DigitTree tri = new DigitTree();
		DigitTree troo = new DigitTree();
		int j = 1;		
		int k =1;
		men1up(tree,tri,troo);
				
	}**/


	/**
	 * Tree,tri,troo are all DigitTrees that can be used with other methods
	**/
	DigitTree tree;
	DigitTree tri;
	DigitTree troo;

	/** test is a constructor for test it creates 3 new digitTrees
	**/
	public test() {
		tree =  new DigitTree();
		tri =  new DigitTree();
		troo =  new DigitTree();
	}

	//start calls method men1up
	public void start() {
		men1up();
	}
		


	//menu1 displays a menu
	public static void menu1() {
		System.out.println();
		System.out.println("Please select an option: ");
		System.out.println("[1]DigitTree #1");
		System.out.println("[2]DigitTree #2");
		System.out.println("[3]DigitTree #3");
		System.out.println("[4]help");
		System.out.println("[5]exit");
		System.out.println();
	}

	//men1up displays menu1 and asks input from the user that will
	// call another method depending on the inpu
	public void men1up() {
		Scanner key = new Scanner(System.in);
		int k = 1;
		String j;
		while(k>0) {
			menu1();
			j = key.nextLine();
			if(j.equals("1")) {
				men2up(1);
				k=1;
			}
			else if(j.equals("2")) {
				men2up(2);
				k=2;
			}
			else if(j.equals("3")) {
				men3up();
				k=3;
			}
			else if(j.equals("4")){
				help();
				k=4;
			}
			else if(j.equals("5")){
				k=-1;
				System.out.println("Have a nice day! :)");
			}

			else {
				System.out.println("That is not an option (make sure caps are turned off)");
			}
		}
	}


	//menu2 displays a menu
	//@param k is the digit tree the user is in
	public static void menu2(int k) {
		System.out.println();
		System.out.println("You are in digitTree #"+k);
		System.out.println("Select a command:");
		System.out.println("[1]add");
		System.out.println("[2]contains");
		System.out.println("[3]delete");
		System.out.println("[4]size");
		System.out.println("[5]nodeCount");
		System.out.println("[6]toString");
		System.out.println("[7]union");
		System.out.println("[8]intersect");
		System.out.println("[9]subtract");
		System.out.println("[10]clear");
		System.out.println("[11]Iterate");
		System.out.println("[12]DigitTree #3");
		System.out.println("[13]back");
		System.out.println();
	}


	//men2up displays menu2 and asks the user for input which
	//will be used to call different methods
	public void men2up(int i) {
		Scanner key = new Scanner(System.in);
		int k=1;
		String j;
		if(i==1) {
			while(k>0) {
				menu2(i);
				j = key.nextLine();
				if(j.equals("1")) {
					try { 
						addMethod(tree);
					}
					catch(DigitFormatException e)
					{
						System.out.println(e.getMessage());
					}
						
				}
				else if(j.equals("2")) {
					containsMethod(tree);
				}
				else if(j.equals("3")) {
					deleteMethod(tree);
				}
				else if(j.equals("4")) {
					sizeMethod(tree);
				}
				else if(j.equals("5")) {
					nodeCountMethod(tree);
				}
				else if(j.equals("6")) {
					toStringMethod(tree);
				}
				else if(j.equals("7")) {
					unionMethod(tree,tri);
				}
				else if(j.equals("8")) {
					intersectMethod(tree,tri);
				}
				else if(j.equals("9")) {
					subtractMethod(tree,tri,1,2);
				}
				else if(j.equals("10")) {
					clearMethod(tree,1);
				}
				else if(j.equals("11")) {
					iteratorMethod(tree);
				}
				else if(j.equals("12")) {
					men3up();
				}
				else if(j.equals("13")) {
					k=-1;				
				}
				else {
					System.out.println("That is not a valid command (make sure caps lock is off)");
				}
			}
		}
		else if(i==2) {
			while(k>0) {
				menu2(i);
				j = key.nextLine();
				if(j.equals("1")) {
					try { 
						addMethod(tri);
					}
					catch(DigitFormatException e)
					{
						System.out.println(e.getMessage());
					}
					
				}
				else if(j.equals("2")) {
					containsMethod(tri);
				}
				else if(j.equals("3")) {
					deleteMethod(tri);
				}
				else if(j.equals("4")) {
					sizeMethod(tri);
				}
				else if(j.equals("5")) {
					nodeCountMethod(tri);
				}
				else if(j.equals("6")) {
					toStringMethod(tri);
				}
				else if(j.equals("7")) {
					unionMethod(tri,tree);
				}
				else if(j.equals("8")) {
					intersectMethod(tri,tree);
				}
				else if(j.equals("9")) {
					subtractMethod(tri,tree,2,1);
				}
				else if(j.equals("10")) {
					clearMethod(tri,2);
				}
				else if(j.equals("11")) {
					iteratorMethod(tri);
				}
				else if(j.equals("12")) {
					men3up();
				}
				else if(j.equals("13")) {
					k=-1;				
				}
				else {
					System.out.println("That is not a valid command (make sure caps lock is off)");
				}
			}
		}
	}
	

	//addMethod adds an item to either tree or tri depending on the param
	//throws DigitFormatException if the user inputs a non numeric value	
	public static void addMethod(DigitTree t) throws DigitFormatException {
		Scanner key = new Scanner(System.in);
		String s;
		System.out.println("Input digit String to be added:");
		s = key.nextLine();
		int iwaq;
		for(int i = 0; i<s.length();i++) {
			iwaq=0;
			while(iwaq <10) {
				if(s.charAt(i)==Character.forDigit(iwaq,10)) {
					iwaq=11;
				}
				iwaq++;
			}
			if(iwaq-1<10) {
				System.out.println(s.charAt(i)+"REEE");
				throw new DigitFormatException();
			}
			
		}
		System.out.println(s+" was added to DigitTree "+t.add(s));
	}

	//deleteMethod deletes an item from tree or tri depending on the param
	// @param t is a digitTree that an item will be deleted from
	public static void deleteMethod(DigitTree t) {
		Scanner key = new Scanner(System.in);
		String s;
		System.out.println("Input digit String to be deleted:");
		s = key.nextLine();
		try {
			System.out.println(s+" was deleted from DigitTree "+t.delete(s));
		}
		catch(DigitFormatException e){System.out.println("false");}
	}

	//contains method searches threw a tree to see if it contains a value
	//@param tree that will be searched threw
	public static void containsMethod(DigitTree t) {
		Scanner key = new Scanner(System.in);
		String s;
		System.out.println("Input digit String to see if its contained in tree:");
		s = key.nextLine();
		try {
			System.out.println("DigitTree contains "+s+" "+t.contains(s));
			}
		catch(DigitFormatException e) { System.out.println("false");

		}
	}

	//sizeMethod returns the size of a digitTree
	//@param t is the digit tree that we will get the size from
	public static void sizeMethod(DigitTree t) {
		System.out.println("The size of your DigitTree is "+t.size());
	}


	//nodeCount returns the amount of nodes in a digit Tree
	//@param digit tree to find amount of nodes from
	public static void nodeCountMethod(DigitTree t) {
		System.out.println("The node count for this DigitTree is "+t.nodeCount());
	}


	//toStringMethod makes a digitree to a string
	//@param digitTree to make into a string 
	public static void toStringMethod(DigitTree t) {
		System.out.println(t.toString());
	}

	//unionMethod makes the union of to digitTrees
	//@param t digitTree to make into a union
	//@param ot DigitTree to make into a union
	public void unionMethod(DigitTree t, DigitTree ot) {
		troo = t.union(ot);
		System.out.println("DigitTree #3 is now the union of DigitTrees #1, and #2");
	}

	//intersect intersects two digitTrees
	//@param digitTree to intersect
	//@param digitTree to inteersect
	public void intersectMethod(DigitTree t, DigitTree ot) {
		troo = t.intersect(ot);
		System.out.println("DigitTree #3 is now the intersect of DigitTree #1, and #2");
	}

	//subtractMethod subtracts one tree from another
	//@param digitTree to be subtracted by
	//@param digit tree thta will be doing the subtracting
	//@param int toor # declaring what tree it is
	//@param taar # declaring what tree it is
	public void subtractMethod(DigitTree t, DigitTree ot,int toor, int taar) {
		troo = t.subtract(ot);
		System.out.println("DigitTree #3 is now DigitTree #"+toor+" subtracted by DigitTree #"+taar);
	}

	//clearMethod clears a digitTree
	//@param digitTree to clear
	public void clearMethod(DigitTree t,int itts) {
		t.clear();
		System.out.println("Digit tree #"+itts+" was cleared");
	}

	public void iteratorMethod(DigitTree t) {
		t.iterator();
	}
		
	// menu3 displays a menu
	public static void menu3() {
		System.out.println();
		System.out.println("You are in digitTree #3!");
		System.out.println("Select a command;");
		System.out.println("[1]contains");
		System.out.println("[2]size");
		System.out.println("[3]nodeCount");
		System.out.println("[4]toString");
		System.out.println("[5]clear");
		System.out.println("[6]Iterate");
		System.out.println("[7]back");
		System.out.println();
	}

	//men3up displays menu3 and asks user for input
	public void men3up() {
		Scanner key = new Scanner(System.in);
		int k=1;
		String j;
		while(k>0) {
			menu3();
			j = key.nextLine();
			if(j.equals("1")) {
				containsMethod(troo);
			}
			else if(j.equals("2")) {
				sizeMethod(troo);
			}
			else if(j.equals("3")) {
				nodeCountMethod(troo);
			}
			else if(j.equals("4")) {
				toStringMethod(troo);
			}
			else if(j.equals("5")) {
					clearMethod(troo,3);
				}
			else if(j.equals("6")) {
					iteratorMethod(troo);
				}
			else if(j.equals("7")) {
				k=-1;
			}
			else {
				System.out.println("That is not a command (make sure that caps lock is off)");
			}
		}
	}

	//help deisplays a message for the interactions of digit tree #3
	public static void help() {
		System.out.println("For digitTree #3 you can only look at it (you can't directly add,delete,ect), it represents the last method you called from union, intersect, and delete in either tree #1 or tree #2. Therefor you can only create it by going in to DigitTree #1 or #2, and using the union, intersect, and subtract methods which will then use tree #2 (if you are currently in tree #1), or tree #1 (if you are currently in tree #2) to create tree #3 which may change depend on the last time you have used those three methonds.");
		System.out.println("Press any key to go back:");
		System.out.println();
		Scanner key = new Scanner(System.in);
		key.nextLine();
		
	}

	

}
