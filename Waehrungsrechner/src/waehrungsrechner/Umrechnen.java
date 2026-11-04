package waehrungsrechner;

public class Umrechnen implements Umrechenbares {
	 @Override
	    public double umrechnen(double betrag, double wechselkurs) {

	        return betrag * wechselkurs;

	    }
}
