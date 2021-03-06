/**
 * The node class has an array of nodes
 * this class is used to create a Digit tree
 * <br><br>
 * @author Allen McDermott
 * @since 11/16/14
 */
public class node
{
	//Data type String
	String data;

	//Parent Node
	node parent;

	//Pointer(s)
	node[] nodeList = new node[11];
	

	//contructor for a node
	public node(String s,node p)
	{
		data = s+"";
		parent = p;
	}



	/**@param sets the next node == input**/
	public void setNext(String s,node elder)
	{
		if(s=="k") {
			node k = new node(s,elder);
			nodeList[10] = k;
		}
		else {
			int index = Integer.parseInt(s);
			node k = new node(s,elder);
			nodeList[index] = k;
		}
	}

	//@param int index the index of the no that will be set
	public void setNode(int index) {
		nodeList[index] = null;
	}

	//inList will see if the each index in nodeList is null
	//@return false if every index is null true if not
	public boolean inList() {
		int j = 0;
		for(int i = 0; i<nodeList.length;i++) {
			if(nodeList[i]!=null){
				j++;
			}
		}
		if(j>0) {
			return true;
		}
		else {
			return false;
		}
	}

	//noK() will see if each index is null except index 10
	//@return false if all index's (we don't care about index #10) are null true if not
	public boolean noK() {
		int j = 0;
		for(int i = 0; i<nodeList.length-1;i++) {
			if(nodeList[i]!=null){
				j++;
			}
		}
		if(j>0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**@return the next InNode**/
	public node getNext(int k)
	{
		return nodeList[k];
	}
	
	
	/**@return data of the node**/
	public String getData()
	{
		return data;
	}

	/**@return parent node**/
	public node getParent()
	{
		return parent;
	}
	
}
	
