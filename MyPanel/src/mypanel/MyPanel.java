package mypanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyPanel extends JPanel {
	
	JLabel label;
	JButton myButton;
	JTextField input;
	
	public MyPanel() {
		setPreferredSize( new Dimension(400,300));
		
		// add first button
		myButton = new JButton("Click Me");
		add( myButton);
		
		// add first input field
		input = new JTextField(10);
		add( input);
		
		// add first label
		label = new JLabel("Some Text.");
		add(label);
		
		// make the button change the text
		ActionListener lTest = new MyListener();
		ActionListener l = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// first test on sysout
				System.out.print("The button-listener is performed. ");
				
				if (e.getSource() == myButton) {
					System.out.println("it was the button");
					label.setText("Changed Text.");
				} else {
					System.out.println("it was something else");
					label.setText(input.getText());
				}
			}
		};
		
		myButton.addActionListener(l);
		input.addActionListener(l);
		
		myButton.addActionListener(lTest); // for regular inner class
	}

	private class MyListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("This is a test");

		}		
	}

}
