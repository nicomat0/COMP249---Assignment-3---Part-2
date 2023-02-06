import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Mateo Nieto (40192918) and Syed Ayaan Jilani (40209519)
 * COMP249
 * Assignment 3 Part II
 * 7th October 2022
 */

/**
 * @author Syed Ayaan Jilani (40209519) and Mateo Nieto (40192918)
 */
public class CellListUtilization {
	
	/**
	 * This method reads the contents of Cell_Info.txt and copies 
	 * it into the LinkedList. This method makes use of contain to
	 * filter out duplicate entries and addToStart to add in the 
	 * LindedList.
	 * 
	 * @param List1 CellList
	 * @param sc File object
	 * 
	 * @return CellList the LinkedList with all the data
	 */
	public static CellList copyingFromFile(CellList List1,Scanner sc) {
		
		long serialNumber = 0;
		String brand = null;
		double price = 0;
		int year = 0;
		
		while (sc.hasNextLine())
        {
			serialNumber = sc.nextLong();
       	    brand = sc.next();
       	    price = sc.nextDouble();
       	    year = sc.nextInt();
       	 
       	    //testing our contains() method to filter out duplicate entries
       	    if(List1.contains(serialNumber)) 
       	    {
       	    	System.out.println("CellPhone with serial number " + serialNumber + " has been skipped as it already exists.");
       	    }
            else 
            {
            	//testing our addToStart() method
       	        List1.addToStart(new CellPhone (serialNumber, brand, year, price)); 
       	        
            }
        }
        
        sc.close();
        return List1;
		
	}
	
	/**
	 * Tests the special exception case of insertAtIndex
	 * 
	 * @param List1 CellList
	 */
	public static void testExceptionInsert(CellList List1) {
		
		CellPhone p3 = new CellPhone(9956786,"Acer",2012,69.9);
		
		try
		{
			List1.insertAtIndex(p3, 39);
		}
		catch(NoSuchElementException e) {
			System.out.println("\nERROR: Given index is out of range! Program will terminate. \n");
			System.exit(0);
		}
	}
	
	/**
	 * Tests the special exception case of deleteFromIndex
	 * 
	 * @param List1 CellList
	 */
	public static void testExceptionDelete(CellList List1) {
		
		try
		{
			List1.deleteFromIndex(-100);
		}
		catch(NoSuchElementException e) {
			System.out.println("\nERROR: Given index is out of range! Program will terminate. \n");
			System.exit(0);
		}
	}
	
	/**
	 * Tests all the cases of replaceAtIndex
	 * 
	 * @param List1 CellList
	 */
	public static void testReplaceAtIndex(CellList List1) {
		CellPhone p1 = new CellPhone(2927286,"Motorola",2009,23.0);
		List1.replaceAtIndex(p1, 0);
		List1.showListContents();
		List1.replaceAtIndex(p1, -100);
	}
	
	/**
	 * Tests all the cases of deleteFromStart
	 * 
	 * @param List1 CellList (usually has nodes)
	 * @param List2 CellList (usually empty)
	 */
	public static void testDeleteFromStart(CellList List1, CellList List2) {
		if (List1.deleteFromStart()) {
			System.out.println("List 1 :-");
			List1.showListContents();
		}
		if (List2.deleteFromStart()) {
			System.out.println("List 2 :-");
			List2.showListContents();
		}
		else {
			System.out.println("\nCould not delete from start as List2 is empty");
		}
	}
	
	/**
	 * Tests all the cases of inser/delete at index
	 * 
	 * @param List1 CellList
	 */
	public static void testInsertDeleteAtIndex(CellList List1) {
		
		CellPhone p2 = new CellPhone(2956786,"Acer",2022,89.9);
		
		try
		{
			List1.insertAtIndex(p2, 0);
		}
		catch(NoSuchElementException e) {
			System.out.println("ERROR: Given index is out of range! Program will terminate. \n");
			System.exit(0);
		}
		
		List1.showListContents();
		
		try
		{
			List1.deleteFromIndex(0);
		}
		catch(NoSuchElementException e) {
			System.out.println("ERROR: Given index is out of range! Program will terminate. \n");
			System.exit(0);
		}
		
		List1.showListContents();
		
		try
		{
			List1.insertAtIndex(p2, 7);
		}
		catch(NoSuchElementException e) {
			System.out.println("ERROR: Given index is out of range! Program will terminate. \n");
			System.exit(0);
		}
		
		List1.showListContents();
		
		try
		{
			List1.deleteFromIndex(3);
		}
		catch(NoSuchElementException e) {
			System.out.println("ERROR: Given index is out of range! Program will terminate. \n");
			System.exit(0);
		}
		
		List1.showListContents();
		
	}

	/**
	 * Tests the very "DEADLY" find method.
	 * 
	 * @param List1 CellList
	 * @param userInput scanner obj to take input from user
	 */
	public static void testFind(CellList List1, Scanner userInput) {
		
		System.out.print("\nEnter one serial number: ");
		long srln1 = userInput.nextLong();
		System.out.print("Enter a second serial number: ");
		long srln2 = userInput.nextLong();
		System.out.print("Enter a last serial number: ");
		long srln3 = userInput.nextLong();
		
		System.out.println(List1.find(srln1));
		System.out.println(List1.find(srln2));
		System.out.println(List1.find(srln3)); //returns a node so we see random gibberish in output

		/* This method is very dangerous as nothing is stopping
		 * the user from doing -:
		 * 
		 * List1.find(srln1).getCell().setPrice(-1000)
		 * List1.find(srln1).getCell().setBrand("I am a very bad brand");
		 * List1.find(srln1).getCell().setYear(1);
		 */
	}
	
	/**
	 * Tests the copy constructors as well as equals method of CellList
	 * 
	 * @param List1 CellList (will be copied)
	 * @param List2 CellList (will be copied to)
	 * @param userInput scanner obj to take input from user
	 * 
	 * @return CellList copied cellList object
	 */
	public static CellList testEqualAndCopy(CellList List1,CellList List2, Scanner userInput) {
		System.out.println();
		System.out.println(List1.equals(List2));
		System.out.println(List1.equals(null));
		List2 = new CellList(List1, userInput);
		System.out.println("\nTesting equality after performing deep copy : " + List1.equals(List2));
		return List2;
	}
	
	/**
	 * Tests the methods of CellPhone class
	 * @param userInput scanner obj to take input from user
	 */
	public static void testCellPhoneMethods(Scanner userInput) {
		CellPhone p = new CellPhone(3890909,"Sony",2009, 366.7);
		CellPhone phone = p.clone(userInput);
		
		System.out.println("\nThe brand is " + phone.getBrand());
		System.out.println("The price is " +phone.getPrice());
		System.out.println("The serial number is " + phone.getSerialNum());
		System.out.println("The year is " +phone.getYear());
		
		phone.setBrand("Lenovo");
		phone.setPrice(10);
		phone.setSerialNum(9999999);
		phone.setYear(2001);
		
		System.out.println("\n"+ p);
		System.out.println("\n"+ phone);
		System.out.println(p.equals(phone));
		System.out.println(p.equals(null));
	}
	
	/**
	 * @param args array of sequence of characters(Strings)
	 */
	public static void main(String[] args) {
		
		System.out.println("WELOCME TO CELL UTILIZATION\n");
		
		CellList List1 = new CellList();
		CellList List2 = new CellList();

		Scanner userInput = new Scanner(System.in);
		Scanner sc = null;
	
		try{
			sc = new Scanner(new FileInputStream("Cell_Info.txt"));
			List1 = copyingFromFile(List1,sc);
		}catch(FileNotFoundException e){ 
			System.out.println("File not found. Program will terminate immediately");
			System.exit(0);
		}
        
        List1.showListContents(); //testing our showListContents() method
        
        System.out.println("\nCHOOSE THE FOLLOWING METHODS TO TEST");
        System.out.println("1. FIND METHOD ");
        System.out.println("2. CELL PHONE CLASS METHODS ");
        System.out.println("3. ALL CASES OF INSERT/DELETE ");
        System.out.println("4. ALL CASES OF REPLACE ");
        System.out.println("5. DELETE FROM START ");
        System.out.println("6. EQUALS METHOD AND COPY CONSTRUCTOR OF CELLLIST ");
        System.out.println("7. EXCEPTION CASE OF INSERT ");
        System.out.println("8. EXCEPTION CASE OF DELETE ");
        System.out.println("ENTER ANY OTHER NUMBER TO EXIT THE PROGRAM ");
		
		while(true) {
			
			System.out.print("\nEnter you choice : ");
			int c = userInput.nextInt();
			
			if (c==1) {
				testFind(List1,userInput);
			}
			else if (c==2) {
				testCellPhoneMethods(userInput);
			}
			else if(c==3) {
				testInsertDeleteAtIndex(List1);
			}
			else if(c==4) {
				testReplaceAtIndex(List1);
			}
			else if(c==5) {
				 testDeleteFromStart(List1,List2);
			}
			else if(c==6) {
				testEqualAndCopy(List1,List2,userInput).showListContents();
			}
			else if(c==7) {
				testExceptionInsert(List1);
			}
			else if(c==8) {
				testExceptionDelete(List1);
			}
			else {
				System.out.println("\nTHANKYOU FOR USING CELL LIST UTLIZATION");
				userInput.close();
				break;
			}
		}
		
	}

}