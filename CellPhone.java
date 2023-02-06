import java.util.Scanner;

/**
 * Mateo Nieto (40192918) and Syed Ayaan Jilani (40209519)
 * COMP249
 * Assignment 3 Part II
 * 7th October 2022
 */

/**
 * @author Syed Ayaan Jilani (40209519) and Mateo Nieto (40192918)
 *
 */
public class CellPhone{
	
	private long serialNum;
	private String brand;
	private int year;
	private double price;
	
	/**
	 * Parameterized constructor that accepts four values and initializes serialNum, brand, year and price to these passed values.
	 * 
	 * @param srln serial number
	 * @param br brand name
	 * @param yr manufacturing year
	 * @param pr price
	 *
	 */
	public CellPhone (long srln, String br, int yr, double pr)
	{
		this.serialNum = srln;
		this.brand = br;
		this.year = yr;
		this.price = pr;
	}
	
	/**
	 * Parameterized constructor that accepts two parameters and initializes serialNum and the attributes of cellPhone object passed
	 * to the newly created cellPhone object.
	 * 
	 * @param cell cellPhone object to be copied
	 * @param srln serial number
	 *
	 */
	public CellPhone(CellPhone cell, long srln)
	{
		this.serialNum = srln;
		this.brand = cell.brand;
		this.year = cell.year;
		this.price = cell.price;
	}
	
	/**
	 * Method that returns the serialNumber of a CellPhone object
	 * 
	 * @return serialNum serial number of cellPhone
	 *
	 */
	public long getSerialNum ()
	{
		return serialNum;
	}
	
	/**
	 * Method that returns the brand of a CellPhone object
	 * 
	 * @return brand brand of cellPhone
	 *
	 */
	public String getBrand ()
	{
		return brand;
	}
	
	/**
	 * Method that returns the year of manufacturing of a CellPhone object
	 * 
	 * @return year year of manufacturing
	 *
	 */
	public int getYear ()
	{
		return year;
	}
	
	/**
	 * Method that returns the price of a CellPhone object
	 * 
	 * @return price price of cellPhone
	 *
	 */
	public double getPrice ()
	{
		return price;
	}
	
	/**
	 * Method that sets serialNum of cellPhone object to the value passed
	 * 
	 * @param srln serial number
	 *
	 */
	public void setSerialNum (long srln)
	{
		this.serialNum = srln;
	}
	
	/**
	 * Method that sets brand of cellPhone object to the value passed
	 * 
	 * @param br brand
	 *
	 */
	public void setBrand (String br)
	{
		this.brand = br;
	}
	
	/**
	 * Method that sets year of manufacturing of cellPhone object to the value passed
	 * 
	 * @param yr year of manufacturing
	 *
	 */
	public void setYear (int yr )
	{
		this.year = yr;
	}
	
	/**
	 * Method that sets price of cellPhone object to the value passed
	 * 
	 * @param pr price
	 *
	 */
	public void setPrice (double pr)
	{
		this.price = pr;
	}
	
	/**
	 * Method that asks the user for a new serial number and uses to copy constructor to create a copy of the cellPhone
	 * object that invoked the method with the new serial number entered by the user.
	 * 
	 * @param scan scanner object to take input from user
	 * 
	 * @return CellPhone copied cellPhone object
	 */
	public CellPhone clone(Scanner scan)
	{
		long srln = 0;
		System.out.println("\nCopying the following object :-");
		System.out.println(this);
		System.out.print("\nPlease enter the new serial number: ");
	    srln = scan.nextLong();
		return new CellPhone(this, srln);
	}
	
	/**
	 * Displays information of the cellPhone object
	 *
	 */
	public String toString ()
	{
		return "The serial number of this cellphone is: " + this.serialNum + "\nThe brand of this cellphone is: " 
	    + this.brand + "\nThe year of this cellphone is: " + this.year + "\nThe price of this cellphone is: " + this.price + "\n";
	}
	
	/**
	 * Method that takes another cellPhone object as a parameter and compares to see they are same or not
	 * Serial number is not taken into comparision as it is unique attribute
	 * 
	 * @param obj cellPhone object (which is actually passed as Object)
	 *
	 */
	public boolean equals (Object obj)
	
	{
		if (obj == null || obj.getClass() != this.getClass())
		{
		return false;
		}
		else
		{
		   
		   CellPhone cell = (CellPhone)obj;
			
		   return (this.brand == cell.brand && this.year == cell.year && this.serialNum == cell.serialNum && this.brand == cell.brand);
		   
		}
	}
	
}
