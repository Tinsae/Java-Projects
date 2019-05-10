package qu.edu.qa.cmps251.gui;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


import javax.swing.JList;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L; //ignore this line

	private JPanel mContentPane;
	private JList<String> mList;
	private JButton mLoadButton;
	private JButton mSaveButton;
	private DefaultListModel<String> mStringList;
	
	//TODO (a) fix both buttons so that they call saveClicked() and loadClicked() below when clicked
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 520);
		
		setResizable(false);
		
		setTitle("Billboards 100");
		
		mContentPane = new JPanel();
		setContentPane(mContentPane);
		
		setLayout(null);
		
		mList = new JList<String>();
	
		mStringList = new DefaultListModel<>();
		
		mList.setModel(mStringList);
		
		JScrollPane jcp = new JScrollPane(mList);
		jcp.setBounds(10, 10, 380, 400);
		
		mContentPane.add(jcp);

		
		mLoadButton = new JButton("Load file");
		mLoadButton.setBounds(10, 420, 185, 50);
		
		mContentPane.add(mLoadButton);
		
		mSaveButton = new JButton("Save file");
		mSaveButton.setBounds(205, 420, 185, 50);
		
		mContentPane.add(mSaveButton);
		
	}
	
	//TODO (b) Complete this function so that:
	//1. User selects the file to read. File has top 100 in html format. Selection
	//should be from a JFileChooser (use method showOpenDialog())
	//2. After a file is selected, it should call Utils.extractTitlesFromFile()
	//3. Finally, it should call addToList() so that you add the top 100
	//to the JList in the GUI
	private void loadClicked() {
		
	}
	
	//TODO (c) Complete this function so that:
	//1. It checks whether anything was loaded first. If nothing 
	//is loaded, it should display an error message
	//2. If GUI already loaded top 100, then it should call Utils.saveToFile()
	//after firing a JFileChooser to pick the destination file to save to.
	private void saveClicked() {
		
	}
	
	/**
	 * 
	 * Do not modify this function. Pass an ArrayList of things to show in the JList
	 * and it'll show it.
	 * 
	 * @param itemsToAdd Strings to add to the JList
	 */
	private void addToList(ArrayList<String> itemsToAdd) {
		for (String s: itemsToAdd) {
			mStringList.addElement(s);
		}
		mList.invalidate();
	}
	
	//DO NOT DELETE OR MODIFY ANYTHING BELOW
	//You don't need it in the code. You can safely ignore it.
	public JList<String> getJList() {
		return mList;
	}
	
	public JButton getLoadButton() {
		return mLoadButton;
	}
	
	public JButton getSaveButton() {
		return mSaveButton;
	}
	
}
