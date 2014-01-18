//Indicator subclass of Pegs
import java.util.*;

public class Indicator extends Pegs{

    private static final String[] USED_COLORS = {"RED","WHITE"};

    public Indicator(String color){
	String tColor = color.toUpperCase();
	for (String x : USED_COLORS){
	    if (x.equals(tColor)){
		_color = tColor;
	    }
	}
	colorSpacing(5);
    }
    
}
