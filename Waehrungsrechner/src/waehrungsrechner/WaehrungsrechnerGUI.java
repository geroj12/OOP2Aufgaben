package waehrungsrechner;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WaehrungsrechnerGUI extends JPanel {
	private JLabel titel;
	private JLabel ergebnis;
	private JTextField betrag;

	private JComboBox<Waehrung> von;
	private JComboBox<Waehrung> nach;

	private JButton umrechnen;
	private JButton zuruecksetzen;

	public WaehrungsrechnerGUI() {
		setPreferredSize(new Dimension(400, 300));
		setLayout(new GridLayout(7, 1, 5, 5));

		// Titel
		titel = new JLabel("Währungsrechner");
		add(titel);

		// Betrag eingeben
		betrag = new JTextField();
		betrag.setToolTipText("Betrag eingeben");
		add(betrag);

		// Ausgangswährung auswählen
		von = new JComboBox<>();
		von.addItem(new Euro());
		von.addItem(new Dollar());
		von.setSelectedIndex(0);
		add(von);

		// Zielwährung auswählen
		nach = new JComboBox<>();
		nach.addItem(new Euro());
		nach.addItem(new Dollar());
		nach.setSelectedIndex(1);
		add(nach);

		// Buttons
		umrechnen = new JButton("Umrechnen");
		zuruecksetzen = new JButton("Zurücksetzen");

		add(umrechnen);
		add(zuruecksetzen);

		// Ergebnis
		ergebnis = new JLabel("Ergebnis erscheint hier");
		add(ergebnis);

		// ActionListener
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == umrechnen) {
					berechne();
				}

				if (e.getSource() == zuruecksetzen) {
					betrag.setText("");
					ergebnis.setText("Ergebnis erscheint hier");
				}
			}
		};

		umrechnen.addActionListener(listener);
		zuruecksetzen.addActionListener(listener);

	}

	private void berechne() {

		try {
			double wert = Double.parseDouble(betrag.getText().replace(",", "."));

			Waehrung waehrungVon = (Waehrung) von.getSelectedItem();
			Waehrung waehrungNach = (Waehrung) nach.getSelectedItem();

			if (waehrungVon == null || waehrungNach == null) {
				ergebnis.setText("Bitte Währungen auswählen!");
				return;
			}

			// Umrechnungskurs berechnen
			double wechselkurs = waehrungNach.getKurs() / waehrungVon.getKurs();

			// Umrechnung durchführen
			Umrechnen rechner = new Umrechnen();

			double resultat = rechner.umrechnen(wert, wechselkurs);

			ergebnis.setText(String.format("Ergebnis: %.2f %s", resultat, waehrungNach.getSymbol()));

		} catch (NumberFormatException ex) {
			ergebnis.setText("Bitte einen gültigen Betrag eingeben!");
		}
	}

}