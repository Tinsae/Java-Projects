//IMPORTANT! Do NOT change any method headers
// Students do not edit this file.

public class Product
{
	private String name;
	private int count;
	
	public Product(String name)
	{
		setName(name);
		setCount(0);
	}
	
	public Product(String name, int count)
	{
		setName(name);
		setCount(count);
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
	public int getCount() 
	{
		return this.count;
	}

	public void setCount(int count) 
	{
		this.count = Math.abs(count);
	}
	
	public String toString() 
	{
		return "product(\"" + name + 
				      "\"," + count + ")"; 
	}
}


