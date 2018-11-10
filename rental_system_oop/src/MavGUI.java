import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
//
public class MavGUI extends JFrame
{
	private JDesktopPane theDesktop;
	//using code below will give you a place to put/store the customers and rentals
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	ArrayList<Rental> rentalList = new ArrayList<Rental>();

// mv.getcustomerList to get the customer list
	MavRental mv = new MavRental();
	public MavGUI()
	{
/// title for pop-up window 
		super("Mav Rental System");
		//reads customers and prints the customer list
 		readCustomertxt();
		//System.out.println(customerList);
		//readRental()
		//System.out.println(rentalList);
		theDesktop = new JDesktopPane();
		JMenuBar bar = new JMenuBar();


//creates the Add menu
		JMenu addMenu = new JMenu("Add");
//creates the add cuatomer and add student for the drop down menu
		JMenuItem addCustomer = new JMenuItem("Add Customer");
		JMenuItem addRental = new JMenuItem("Add Rental");


//adds visually both add customer and add rental to the add menu
		addMenu.add(addCustomer);
		addMenu.add(addRental);



//creates the Exit menu
		JMenu exitMenu = new JMenu("Exit");
//creates the calculate charge and close drop down menu
		JMenuItem calcItem = new JMenuItem("Calculate Charges");
		JMenuItem exitItem = new JMenuItem("Close");






//creates and action of closing when; anoymous listeners to do stuff and cant be reused bc its only good for that one item its attached to
//anonymous listener, the action it will perform after pressing close 
		exitItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				writeSerFile();
				System.exit(0);
			}
		});
		calcItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				/*String msg = "";
				for(Customer c:customerList)
				{
					msg += c.printInvoice();
					
				}
				JOptionPane.showMessageDialog(null, msg);
				*/
				//edit so that it calculates 
				System.out.println("Calculation goes here"); 
				//JOptionPane.showMessageDialog(null,"does not exist");
			}
		});
		addCustomer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)

			{
				JInternalFrame frame = new JInternalFrame("Add Customer", true, true, true, true);//min, max, reset, close
				CustomerPanel cp = new CustomerPanel();
				frame.add(cp);
				frame.pack();
				theDesktop.add(frame);
				frame.setVisible(true);
			}
		});
		addRental.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JInternalFrame frame = new JInternalFrame("Add Rental", true, true, true, true);//min, max, reset, close
				RentalPanel rp = new RentalPanel();
				frame.add(rp);
				frame.pack();
				theDesktop.add(frame);
				frame.setVisible(true);
			}

		});






//adds visually both close and calculate charge to the exit menu
		exitMenu.add(calcItem);
		exitMenu.add(exitItem);

//makes both add and exit appear on the bar on the desktop
		bar.add(addMenu);
		bar.add(exitMenu);
		add(theDesktop);
		setJMenuBar(bar);
	}


//commented out this piece of code bc needs editing; will read in command prompt the customers.txt file created when running the WriteCustomers file class

	public void readCustomertxt()
	{
		Scanner input;
		String line;
		String array[];
		
		try
		{
		    
            // read a file named customers.xtx
			input = new Scanner(new File("customers.txt"));
			// for each line
			while(input.hasNext())
			{
				line= input.nextLine();
				array = line.split(",");
				
				if(mv.customerExists(array[0]))
				{
					for(Customer c: mv.getCustomerList())
					{		
						

						if (array[6].equals("Furniture"))
						{
							c.addRental(new FurnitureRental(FurnitureRental.FurnitureType.valueOf(array[7]), Double.parseDouble(array[8]), Integer.parseInt(array[9])));
						}

					
						else
						{
							c.addRental(new ElectronicRental(ElectronicRental.ElectronicType.valueOf(array[7]), Double.parseDouble(array[8]), Integer.parseInt(array[9])));
						}


					}
				}

				else
				{
					
					mv.addCustomer(new Customer(array[0], new Address(array[1],array[2],array[3],array[4]),array[5]));

				

					for(Customer c: mv.getCustomerList())
					{
				
						
						if (array[6].equals("Furniture"))
						{
							c.addRental(new FurnitureRental(FurnitureRental.FurnitureType.valueOf(array[7]), Double.parseDouble(array[8]), Integer.parseInt(array[9])));
						}

					
						else
						{
							
							c.addRental(new ElectronicRental(ElectronicRental.ElectronicType.valueOf(array[7]), Double.parseDouble(array[8]), Integer.parseInt(array[9])));
						}


					}
				}
			}
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}

	}

//need to add if statment for the sixth array


//writes all the customers after reading the customers in command prompt from readCustomers method above
	public void writeSerFile()
	{
		ObjectOutputStream output;
	
		try
		{
			output = new ObjectOutputStream(new FileOutputStream("customers.ser"));
		//	for(Customer c:customerList)
		//		output.writeObject(b);

		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	



//formatting the pop-up box; needs to be in the MavGUITest

	public static void main(String args[])
	{
		MavGUI m = new MavGUI();
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setLocationRelativeTo(null);
		m.setSize(500,400);
		m.setVisible(true);
	}


//creating a form for the user to fill out 
	class CustomerPanel extends JPanel
	{
		
		private JLabel nameLabel;
		private JLabel streetLabel;
		private JLabel cityLabel;
		private JLabel stateLabel;
		private JLabel zipLabel;
		private JLabel creditCardNumberLabel;
		private JLabel buttonLabel;


		private JTextField nameField;
		private JTextField streetField;
		private JTextField cityField;
		private JTextField stateField;
		private JTextField zipField;
		private JTextField creditCardNumberField;
		private JButton button;
		
		public CustomerPanel()
		{
			setLayout(new GridLayout(7,2));
		
			nameLabel = new JLabel(" Enter name");
			streetLabel = new JLabel(" Enter street");
			cityLabel = new JLabel(" Enter city");
			stateLabel = new JLabel(" Enter state");
			zipLabel = new JLabel(" Enter zip");
			creditCardNumberLabel = new JLabel(" Enter credit card number");
			buttonLabel = new JLabel(" Click When Done");

			nameField = new JTextField(20);
			streetField = new JTextField(20);
			cityField = new JTextField(20);
			stateField = new JTextField(20);
			zipField = new JTextField(20);
			creditCardNumberField = new JTextField(20);
			button = new JButton("SUBMIT");


//anonymous al need editing
/*			button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JOptionPane.showMessageDialog(null,"customer exists");
				}
			});

*/

//need in order to print in command prompt	
			
			MyListener handler = new MyListener();
			button.addActionListener(handler);	
		
			add(nameLabel);
			add(nameField);
			add(streetLabel);
			add(streetField);
			add(cityLabel);
			add(cityField);
			add(stateLabel);
			add(stateField);
			add(zipLabel);
			add(zipField);
			add(creditCardNumberLabel);
			add(creditCardNumberField);
			add(buttonLabel);
			add(button);
		}
//prints in command prompt what user has input; class listener and can be reused unlike the anonymous listener
		class MyListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				if(mv.customerExists(nameField.getText()))
				{
				    
				    
				        JOptionPane.showMessageDialog(null, "customer exists");
				    
				}
				else
				{
				    //customerList.add(new Customer(nameField.getText() + " " + streetField.getText() + " " + cityField.getText() + " " + stateField.getText() + " " + zipField.getText() + " " + creditCardNumberField.getText() + " " )); 
			        customerList.add( new Customer(nameField.getText(), new Address(streetField.getText(), cityField.getText(), stateField.getText(), zipField.getText()), creditCardNumberField.getText()) );
			       //String n, Address a, String cc
			
				}
				System.out.println(nameField.getText() + " " + streetField.getText() + " " + cityField.getText() + " " + stateField.getText() + " " + zipField.getText() + " " + creditCardNumberField.getText() + " " );
				//customerList.add(new Customer(nameField.getText() + " " + streetField.getText() + " " + cityField.getText() + " " + stateField.getText() + " " + zipField.getText() + " " + creditCardNumberField.getText() + " " )); 
				nameField.setText("");
				streetField.setText("");
				cityField.setText("");
				stateField.setText("");
				zipField.setText("");
				creditCardNumberField.setText("");
			
				nameField.requestFocus();

			}

		}

	}
//		class SubmitButtonListener implements ActionListener
//		{
//		    public void actionPerformed(ActionEvent e) 
//		    {
//		      	if(!mv.customerExists(array[0]))
//		      	{
//		      	    mv.addCustomer(new Customer(array[0], new Address(array[1],array[2],array[3],array[4]),array[5]));
//
//		      	}
//		      	else
//		      	{
//		      	    	JOptionPane.showMessageDialog(null,"customer already exits");
//		      	}
//				
//			}
//		}

	class RentalPanel extends JPanel
	{
		
		
		private JLabel custNameLabel;
		private JLabel numOfDaysLabel;
		private JLabel priPerDayLabel;
		private JLabel buttonLabel;


		private JTextField custNameField;
		private JComboBox<String> typeBox;
		private JTextField numOfDaysField;
		private JTextField priPerDayField;
		private JButton submitButton;
		
		private JCheckBox furnBox;
		private JCheckBox elecBox;
		
		private JComboBox<String> ftypeBox;
		String ftypes[] = {"SELECT ONE","BED","COUCH","CHAIR"};
		private JComboBox<String> etypeBox;
		String etypes[] = {"SELECT ONE","COMPUTER","TV"};

		ButtonGroup group;

		public RentalPanel()
		{
			setLayout(new GridLayout(6,2));
		
			custNameLabel = new JLabel(" Enter customer name");
			numOfDaysLabel = new JLabel(" Enter number of days");
			priPerDayLabel = new JLabel(" Enter price per day");
			buttonLabel = new JLabel(" Click When Done");

			custNameField = new JTextField(20);
			numOfDaysField = new JTextField(20);
			priPerDayField = new JTextField(20);
			submitButton = new JButton("SUBMIT");

			group = new ButtonGroup();
			furnBox = new JCheckBox("Furniture");
			elecBox = new JCheckBox("Electronic");
			
			group.add(furnBox);
			group.add(elecBox);

			ftypeBox = new JComboBox<String>(ftypes);
			etypeBox = new JComboBox<String>(etypes);

			furnBox.addActionListener(new ActionListener ()
			{
				public void actionPerformed(ActionEvent e)
				{	
					ftypeBox.setEnabled(true);
					etypeBox.setEnabled(false);
				}
	
			});
			elecBox.addActionListener(new ActionListener()
			{	
				public void actionPerformed(ActionEvent e)
				{	
					ftypeBox.setEnabled(false);
					etypeBox.setEnabled(true);
				}
			});


//anonymous al need editing
/*			submitButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JOptionPane.showMessageDialog(null,"customer does not exist");
				}
			});*/
//need in order to print in command prompt		
			MyListener handler = new MyListener();
			submitButton.addActionListener(handler);
			//SumbitButton handler =  new MyListener();
			
		
			
			add(custNameLabel);
			add(custNameField);
			add(furnBox);
			add(elecBox);
			add(numOfDaysLabel);
			add(numOfDaysField);
			add(priPerDayLabel);
			add(priPerDayField);
			add(ftypeBox);
			add(etypeBox);
			add(buttonLabel);
			add(submitButton);
		}


			
		/*class SubmitButtonListener implements ActionListener
		{
		    public void actionPerformed(ActionEvent e) 
		    {
		      	if(!mv.customerExists(array[0]))
		      	{
		      	    mv.addCustomer(new Customer(array[0], new Address(array[1],array[2],array[3],array[4]),array[5]));

		      	}
		      	else
		      	{
		      	    	JOptionPane.showMessageDialog(null,"customer already exits");
		      	}
				
		      }
		}*/

//prints in command prompt what the user has input
		class MyListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println(custNameField.getText() + " " + numOfDaysField.getText() + " " + priPerDayField.getText() + " " );
			

				if(furnBox.isSelected())
				{
					System.out.println(furnBox.getText());
					System.out.println(ftypes[ftypeBox.getSelectedIndex()]);
				}
				else 
				{
					System.out.println(elecBox.getText());
					System.out.println(etypes[etypeBox.getSelectedIndex()]);
				}
				
				custNameField.setText("");
				numOfDaysField.setText("");
				priPerDayField.setText("");
				group.clearSelection();
				ftypeBox.setSelectedIndex(0);
				etypeBox.setSelectedIndex(0);
				custNameField.requestFocus();

			}
		}


	}




}