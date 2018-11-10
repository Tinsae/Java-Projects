

//IMPORTANT! Do NOT change any method headers

public class WarehouseServices 
{
	public final static int sortByNAME = 0;
	public final static int sortByCOUNT = 1;
	
	/**
	 * (ADVANCE)
	 * Given an instance of Warehouse w, the method returns an array of Product in w
	 * which are sorted according to below.
	 * if parameter ascending is true
	 *   sorted by name in ascending order if parameter byWhat is 0 (sortByName) 
	 *   sorted by count (number of product count) in ascending order if parameter byWhat is 1 (sortByCOUNT)
	 * else
	 *   sorted by name in descending order if parameter byWhat is 0 (sortByName) 
	 *   sorted by count (number of product count) in descending order if parameter byWhat is 1 (sortByCOUNT)
	 *   
	 * @param w is an instance of a Warehouse
	 * @param byWhat is an integer which its value is either 0 (sortByNAME) or 1 (sortByCOUNT)
	 * @param descending is a boolean. (please see description above)
	 * @return an array of Product sorted according to the above description.
	 * 
	 * HINTS
	 * =====
	 * This method can be very complex to accomplish if you try to do the whole thing at
	 * once. I have separated the testing of this method into 4 tests. Please try to accomplish 
	 * by concentrating on one test at a time, and incrementally add code for the rest of the tests.
	 * You may use any sorting algorithms you have learned in this unit. 
	 * 
	 * testGetSortedProductByNameAscending
	 * testGetSortedProductByNameDescending
	 * testGetSortedProductByCountAscending
	 * testGetSortedProductByCountDescending
	 */
	public static Product[] getSortedProduct(Warehouse w, int byWhat, boolean ascending)
	{
		// write code here
		return null; // may remove
	}
	
	/**
	 * Search Warehouse w for products whose name 
	 * has q as the substring. The comparison for substring 
	 * must be case insensitive.
	 *
	 * @param w is an instance of Warehouse
	 * @param q is a string
	 * @return an array of Product (description above).
	 * 
	 * HINTS
	 * =====
	 * Please look at the documentation for the methods indexOf and toLower 
	 * of the Java String class.
	 */
	public static Product[] listProductByName(Warehouse w, String q)
	{
		// write code here
		return null; // may remove
	}
}
