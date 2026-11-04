package waehrungsrechner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WaehrungsrechnerGUI extends Application {

    @Override
    public void start(Stage stage) {

        // Überschrift
        Label titel = new Label("Währungsrechner");

        // Eingabefeld
        TextField betrag = new TextField();
        betrag.setPromptText("Betrag eingeben");

        // Währungen auswählen
        ComboBox<Waehrung> von = new ComboBox<>();

        von.getItems().addAll(
            new Euro(),
            new Dollar()
        );

        von.setValue(von.getItems().get(0));

        ComboBox<Waehrung> nach = new ComboBox<>();

        nach.getItems().addAll(
            new Euro(),
            new Dollar()
        );

        nach.setValue(nach.getItems().get(1));

        // Buttons
        Button umrechnen = new Button("Umrechnen");
        Button zuruecksetzen = new Button("Zurücksetzen");

        // Ergebnisanzeige
        Label ergebnis = new Label("Ergebnis erscheint hier");

        // Umrechnungsobjekt erstellen
        Umrechnen rechner = new Umrechnen();

        // Button: Umrechnen
        umrechnen.setOnAction(e -> {

            try {

                // Betrag auslesen
                double wert = Double.parseDouble(
                    betrag.getText().replace(",", ".")
                );

                // Ausgewählte Währungen auslesen
                Waehrung waehrungVon = von.getValue();
                Waehrung waehrungNach = nach.getValue();

                // Wechselkurs berechnen
                double wechselkurs =
                    waehrungNach.getKurs() / waehrungVon.getKurs();

                // Umrechnung durchführen
                double result = rechner.umrechnen(
                    wert, wechselkurs
                );

                // Ergebnis anzeigen
                ergebnis.setText(
                    String.format(
                        "Ergebnis: %.2f %s",
                        result,
                        waehrungNach.getSymbol()
                    )
                );

            } catch (NumberFormatException ex) {

                ergebnis.setText(
                    "Bitte einen gültigen Betrag eingeben!"
                );

            }
        });

        // Button: Zurücksetzen
        zuruecksetzen.setOnAction(e -> {

            betrag.clear();

            von.setValue(von.getItems().get(0));
            nach.setValue(nach.getItems().get(1));

            ergebnis.setText("Ergebnis erscheint hier");

        });

        // Layout
        VBox layout = new VBox(15);

        layout.getChildren().addAll(
            titel,
            betrag,
            von,
            nach,
            umrechnen,
            zuruecksetzen,
            ergebnis
        );

        // Fenster
        Scene scene = new Scene(layout, 400, 350);

        stage.setTitle("Währungsrechner");
        stage.setScene(scene);
        stage.show();
    }

    public static void startProgramm(String[] args) {
        launch(args);
    }
}