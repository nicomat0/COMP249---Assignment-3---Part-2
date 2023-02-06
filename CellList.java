import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Mateo Nieto (40192918) and Syed Ayaan Jilani (40209519)
 * COMP249
 * Assignment 3 Part II
 * 7th October 2022
 */

/**
 * @author Syed Ayaan Jilani (40209519) and Mateo Nieto (40192918)
 */
public class CellList {
	
        class CellNode {
		
		private CellPhone cell;
		private CellNode next;
		
		/**
		 * Default constructor that initialises cell and next to null
		 */
		public CellNode ()
		{
			cell = null;
			next = null;
		}
		
		/**
		 * Parameterized constructor that takes in cellPhone object and pointer to the next node
		 * 
		 * @param cell cellPhone object
		 * @param node pointer to next node
		 * 
		 */
		public CellNode (CellPhone cell, CellNode node)
		{
			this.cell = cell;
			this.next = node;
		}
		
		/**
		 * Copy constructor that copies the course and the pointer to next node
		 * 
		 * @param cn cellNode to be copied
		 * @param scan scanner object to take input from user
		 */
		public CellNode (CellNode cn, Scanner scan)
		
		{
	        cell = cn.cell.clone(scan);
	        next = cn.next;
		}
		
		/**
		 * Clone method that returns copy of the cellNode
		 * 
		 * @param scan scanner object to take input from user
		 * @returns the new copied cellNode
		 */
		public CellNode clone (Scanner scan)
		{
			return new CellNode(this, scan);
		}
		
		/**
		 * Method that sets cell to the cellPhone object passed
		 * 
		 * @param c cellPhone object
		 */
		public void setCell (CellPhone c)
		{
			cell = c;
		}
		
		/**
		 * Method that sets the pointer to the next node to the node passed
		 * 
		 * @param nx cellNode
		 */
		public void setNext (CellNode nx)
		{
			next = nx;
		}
		
		/**
		 * Method that returns the cellPhone object of the node
		 * 
		 * @param c cellPhone object
		 */
		public CellPhone getCell ()
		{
			return cell;
		}
		
		/**
		 * Method that returns the pointer to the next node
		 * 
		 * @param next pointer to the next cellNode
		 */
		public CellNode getNext ()
		{
			return next;
		}

	}
	
	private CellNode head;
	private int size;
	
	/**
	 * Default constructor that initializes head to null and size to 0
	 */
	public CellList ()
	{
		head = null;
		size = 0;
	}
	
	/**
	 * Copy constructor that takes a CellList object and creates its copy
	 * @param scan scanner object to take input from user
	 * @param cll the linked-list to be copied
	 */
	public CellList (CellList cll, Scanner scan)
	{
		
		if (cll.head == null)
		{
			head = null;
		}
		else
		{
			head = null;
			
			CellNode n1,n2,n3;
			
			n1 = cll.head;
			n2 = n3 = null;
			
			while (n1 != null)
			{
				if (head == null)
				{
					n2 = new CellNode (n1, scan);
					head = n2;
				}
				
				else
				{
					n3 = new CellNode (n1, scan);
					n2.next = n3;
					n2 = n3;
				}
				n1 = n1.next;
			}
			
			n2 = n3 = null;
		}
		size = cll.size;
		
	}
	
	/**
	 * Method that adds takes a cellPhone objects, creates its node
	 * and adds it to the start of the cellList.
	 * 
	 * @param cell cellPhone object
	 */
	public void addToStart (CellPhone cell)
	{
		head = new CellNode (cell, head);
		size++;
	}
	
	/**
	 * Method that inserts the cellPhone object passed at the index passed
	 * 
	 * @param cell cellPhone object
	 * @param index index to be added to
	 */
	public void insertAtIndex (CellPhone cell, int index) throws NoSuchElementException
	{
		
		if (index > size - 1 || index < 0)
		{
			throw new NoSuchElementException();
		}
			
		System.out.println("\nInserting Cellphone object at index # " + index + ".\n");

		if (index == 0)
		{
			addToStart(cell);
		}
		else
		{
			CellNode t = head;
			for(int i = 0; i < index-1; i++)
				t=t.next;
			t.next = new CellNode(cell, t.next);
			size++;
		}

	}
	
	/**
	 * Method that deletes the cellPhone object at the index passed
	 * 
	 * @param index index to be deleted at
	 */
	public void deleteFromIndex(int index) throws NoSuchElementException
	{

		if (index > size - 1 || index < 0)
		{
			throw new NoSuchElementException();
		}
			
		System.out.println("\nDeleting Cellphone object at index # " + index + ".\n");
		
		if (index == 0)
		{
			if (!deleteFromStart()) {
				System.out.println("/nCould not delete object as list is empty");
			}
		}
		
		else	
		{
			CellNode t = head;
			for(int i = 0; i< index-1; i++)
			{
				t = t.next;
			}
			t.next = t.next.next;
			size--;
		}
	}

	/**
	 * Method that deletes the first node on the list
	 * 
	 * @return boolean deleted(true) or not(false)
	 */
	public boolean deleteFromStart()
	{
		
		if (head != null)
		{
			head = head.getNext();
			size--;
			return true;
		}
		else
		{
			return false;
		}
		
	}

	/**
	 * Method that replaces the cellPhone object at the index passed to the 
	 * cellPhone object passed as the parameter
	 * 
	 * @param cell cellPhone object
	 * @param index index to be replaced at
	 */
	public void replaceAtIndex(CellPhone cell, int index)
	{
	
		if (index > size - 1 || index < 0)
		{
			System.out.println("ERROR: Given index is out of range! Will simply return. \n");
			return;
		}
		
		System.out.println("\nReplcaing node at index # " + index + ".\n" );
		
		if(index == 0)
		{
			head = new CellNode(cell, head.next);
		}
		else
		{
			CellNode t = head;
			for(int i = 0; i < index-1; i++)
			{
				t = t.next;
			}
			t.next = new CellNode(cell,t.next.next);
		}
	}

	/**
	 * Method that find and returns the cellNode containing the cellPhone which
	 * has the serial number passed as parameter. 
	 * 
	 * This method is very very DEADLY as it can lead to a privacy leak. The method
	 * returns a pointer to the node which the user can use to manipulate the value
	 * of the node as well as the next incoming nodes. One suggestion to avoid privacy
	 * leak could be to corrupt/destroy the list while returning the node so that the 
	 * user cannot manipulate the values of the nodes.
	 * 
	 * @param serialNumber the Serial Number to find
	 * 
	 * @return CellNode the node containing the cellPhone object
	 */
	public CellNode find(long serialNumber)
	{
		CellNode temp = head;
		int NbrOfIterations = 0;
		while( temp != null )
		{
			if (temp.getCell().getSerialNum() == serialNumber)
			{
				System.out.print("\nThe cellPhone object was found and its corresponding node returned.\n"
						+ "The number of iterations was " + NbrOfIterations + "\n");
				return temp;
                
			}
			temp = temp.getNext();	
			NbrOfIterations++;
		
		}
		System.out.print("\nThe cellPhone object was not found and null value was returned.\n"
				+ "The number of iterations was " + NbrOfIterations + "\n");
		return null;
		
	}

	/**
	 * Method that tells if an cellNode containing cellPhone object with 
	 * the serial number passed exist or no. The contains method could 
	 * have simply taken advantage of the find() method but the find 
	 * also displays the number everytime we use it. We will use contains
	 * frequently in CellListUtilization to see if duplicate records exist 
	 * while copying data from Cell_Info.txt and initliaizing it into our
	 * CellList. This can lead to messy output where number of iterations 
	 * will get printed everytime we try to verify existance of duplicate 
	 * record in the CellList. This is why contains() does not simply use
	 * find() to make the output more user-friendly.
	 * 
	 * @param serialNbr serial number
	 * 
	 * @return boolean exists(true) or not(false)
	 */
	public boolean contains(long serialNbr)
	{
		CellNode temp = head;
		while( temp != null )
		{
			if (temp.getCell().getSerialNum() == serialNbr)
			{
				return true;
                
			}
			temp = temp.getNext();	
		
		}
		return false;
	}

	/**
	 * Method that displays the contents of the cellList
	 */
	public void showListContents()
	{
		int count = 1;
		CellNode temp = head;
		
		if (temp == null) 
		{
			System.out.println("There is nothing to display; list is empty!" );
		}
		else {
			System.out.println("\nThe size of the list is " + this.size + ". Here are the contents of the list:" );
			System.out.println("==============================================================");
		}
		
		while(temp != null)
		{
			
			System.out.print("[" + temp.getCell().getSerialNum() + ": " + 
		    temp.getCell().getBrand() + " " + temp.getCell().getPrice() + 
		    " " + temp.getCell().getYear() + "]"+ "--->");
			
			temp = temp.getNext();		// Move to the next node
			
			if (count==3) {
				System.out.println();
				count = 1;
			}else {
				count++;
			}
		}
		System.out.print("X\n");
			
	}

	/**
	 * Method that checks if contents of two cellLists are equal or not
	 * @return boolean equal(true) or not(false)
	 */
	public boolean equals (Object obj)
	{
		
		if (obj == null || obj.getClass() != this.getClass() || this.size != ((CellList)obj).size)
		{
			return false;
		}
		
		CellNode List1 = this.head;
		CellNode List2 = ((CellList)obj).head;
		
		while (List1 != null && List2 != null)
		{
			if (List1.cell.getBrand() != List2.cell.getBrand())
			{
				return false;
			}
			else if (List1.cell.getPrice() != List2.cell.getPrice())
			{
				return false;
			}
			else if (List1.cell.getYear() != List2.cell.getYear())
			{
				return false;
			}
			List1 = List1.getNext();
			List2 = List2.getNext();
		}
		
		return true;
	}
	
}
