package waehrungsrechner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Waehrungsrechner {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {

			JFrame myFrame = new JFrame("Währungsrechner");

			myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel panel = new WaehrungsrechnerGUI();

			myFrame.getContentPane().add(panel);

			myFrame.pack();
			myFrame.setLocationRelativeTo(null);
			myFrame.setVisible(true);
		});

	}

}
