package waehrungsrechner;

public class Waehrung {
	protected String name;
    protected String symbol;
    protected double kurs;

    public Waehrung(String name, String symbol, double kurs) {
        this.name = name;
        this.symbol = symbol;
        this.kurs = kurs;
    }

    public double getKurs() {
        return kurs;
    }

    public String getSymbol() {
        return symbol;
    }
    
    @Override
    public String toString() {
        return name + " (" + symbol + ")";
    }
}
