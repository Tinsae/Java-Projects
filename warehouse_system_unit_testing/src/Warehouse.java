import java.util.*;


//IMPORTANT! Do NOT change any method headers

public class Warehouse 
{
	List<Product> productList = new ArrayList<Product>();
	
	/**
	 * Default constructor
	 */
	public Warehouse()
	{}
	
	/**
	 * @param index is an index of Product in productList.
	 * @return an instance of Product in this Warehouse, if the index is valid
	 *         otherwise return null.
	 */
	public Product getProduct(int index)
	{
		// write code here
		return null; // may remove
	}
	
	/**
	 * 1) Add Product p to this Warehouse if Product p does not
	 * exist in this Warehouse. 
	 * 2) Otherwise, the product count in this
	 *    Warehouse is updated (increased) with the product count in p. 
	 * 
	 * @param p is an instance of class Product
	 */
	public void add(Product p)
	{
		// write code here
	}
	
	/**
	 * 
	 * @param p is an instance of class Product
	 * @return an int which is the number of Product p in this Warehouse.
	 *         if Product p does not exist in this Warehouse,
	 *         return 0;
	 */
	public int count(Product p)
	{
		// write code here
		return -1;// may remove
	}
	
	/**
	 * 1) If Product p does not exist in this ware, do nothing
	 * 2) Otherwise, the product count in this
	 *    Warehouse is updated (decreased).
	 *    if after the update, the product count is 0 or less,
	 *    Product p is removed from this Warehouse.
	 *    
	 * 
	 * @param p is an instance of class Product
	 */
	public void remove(Product p)
	{
		// write code here
	}

	/**
	 * 
	 * @return an int which is the number of distinct Products in this Warehouse.
	 */
	public int numberOfProducts()
	{
		// write code here
		return -1;// may remove
	}
}
