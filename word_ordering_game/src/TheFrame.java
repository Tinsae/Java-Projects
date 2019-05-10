import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
// import required classes and interfaces
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

// create a JFrame class
public class TheFrame extends JFrame implements ActionListener {
	public JLabel lblTitle;
	public JLabel lblBody;
	public JPanel pnlWords;
	public JPanel top;
	public JPanel center;
	public JLabel status;

	public JTextField txtWord1;
	public JLabel lblGoesBefore;
	public JTextField txtWord2;

	public JButton btnDone;
	public JButton btnClear;
	private String[][] words;

	public TheFrame(String title) {
		super(title);
		setSize(380, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		lblTitle = new JLabel("Fun with words     ");

		lblTitle.setFont(new Font("Serif", Font.BOLD, 20));

		lblBody = new JLabel("Some body text     ");
		lblBody.setAlignmentX(JLabel.LEFT_ALIGNMENT);

		lblBody.setFont(new Font("Serif", Font.PLAIN, 20));
		pnlWords = new JPanel();
		pnlWords.setLayout(new GridLayout(6, 5));
		pnlWords.setFont(new Font("Serif", Font.PLAIN, 16));
		words = new String[6][5];
		words[0][0] = "dog";
		words[0][1] = "tree";
		words[0][2] = "ball";
		words[0][3] = "cat";
		words[0][4] = "cow";
		words[1][0] = "eat";
		words[1][1] = "dogma";
		words[1][2] = "troglodyte";
		words[1][3] = "cowboy";
		words[1][4] = "ice";
		words[2][0] = "snout";
		words[2][1] = "pig";
		words[2][2] = "man";
		words[2][3] = "woman";
		words[2][4] = "log";
		words[3][0] = "lonely";
		words[3][1] = "desk";
		words[3][2] = "treason";
		words[3][3] = "supercilious";
		words[3][4] = "super";
		words[4][0] = "zeal";
		words[4][1] = "zoo";
		words[4][2] = "my";
		words[4][3] = "do";
		words[4][4] = "scant";
		words[5][0] = "bike";
		words[5][1] = "dirt";
		words[5][2] = "smile";
		words[5][3] = "mom";
		words[5][4] = "nose";

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 5; j++) {
				pnlWords.add(new JLabel(words[i][j]));
			}

		}

		top = new JPanel();
		top.setLayout(new BoxLayout(top, BoxLayout.PAGE_AXIS));
		center = new JPanel();
		center.setLayout(new BorderLayout());
		JPanel threeControls = new JPanel();
		JPanel twoButtons = new JPanel();

		txtWord1 = new JTextField(10);
		txtWord2 = new JTextField(10);
		lblGoesBefore = new JLabel("goes before");
		threeControls.add(txtWord1);
		threeControls.add(lblGoesBefore);
		threeControls.add(txtWord2);
		btnDone = new JButton("Done");
		btnClear = new JButton("Clear");

		twoButtons.add(btnDone);
		twoButtons.add(btnClear);

		center.add(threeControls, BorderLayout.NORTH);
		center.add(twoButtons, BorderLayout.SOUTH);

		status = new JLabel("---");

		top.add(lblTitle);
		top.add(lblBody);
		top.add(pnlWords);

		add(top, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(status, BorderLayout.SOUTH);

		btnDone.addActionListener(this);
		btnClear.addActionListener(this);

	}

	public static void main(String[] args) {
		TheFrame win = new TheFrame("Word Order Game");

		win.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<String> wordList = new ArrayList<String>();

		for(int i=0; i<6 ; i++)
		{
			for(int j=0; j<5 ; j++)
			{
				wordList.add(words[i][j]);
			}
		}
		
		//System.out.println(wordList);
		
		if (e.getSource() == btnClear) {
			// clear text fields
			txtWord1.setText("");
			txtWord2.setText("");

		} else if (e.getSource() == btnDone) {

			//System.out.println("done clicked");
			if (txtWord1.getText().isEmpty() || txtWord2.getText().isEmpty()) {
				status.setText("Enter words in both boxes. Then press done");
			}

			// If neither of the two entered words is in the list, print:
			else if (!wordList.contains(txtWord1.getText()) && !wordList.contains(txtWord2.getText())) {
				status.setText("Neither entry is in the word list.");
			}
			// If the first word is not in the list, print:
			else if (!wordList.contains(txtWord1.getText())) {
				status.setText("First entry not in word list – check spelling.");
			}

			// If both words are from the list but are the same, print:
			else if (wordList.contains(txtWord1.getText()) && wordList.contains(txtWord2.getText())
					&& txtWord1.getText().equals(txtWord2.getText())) {
				status.setText("You entered the same words. Try again.\r\n");
			}

			// If both words are from the list, but are in the wrong order,
			// print:
			// Wrong. Try again.
			else if (wordList.contains(txtWord1.getText()) && wordList.contains(txtWord2.getText())
					&& txtWord1.getText().compareTo(txtWord2.getText()) >= 0) {
				status.setText("Wrong. Try again.");
			} else {
				status.setText("Well done");

			}

		}

	}

}