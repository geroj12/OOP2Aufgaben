package mypanel;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingTester {

	public static void main(String[] args) {

		JFrame myFrame = new JFrame("My first window (Markus WS26)");

		// first JFrame
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// add first JPanel
		JPanel firstPanel = new MyPanel();
		myFrame.getContentPane().add( firstPanel);
		myFrame.setVisible(true);
		myFrame.pack();

	}

}

