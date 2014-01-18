//Pegs superclass

public class Pegs{

    protected String _color;

    public Pegs(){
	_color = "NONE";
    }

    public Pegs(String color){
	_color = color.toUpperCase();
    }

    public String getColor(){
	return _color;
    }

    public void setColor(String color){
	_color = color.toUpperCase();
    }

    public boolean equals(Pegs p){
	return _color == p._color;
    }

    public String toString(){
	return _color;
    }

    public void colorSpacing(int length){
	String tS = "";
	for(int x = 0; x < (length - _color.length()); x++){
	    tS += " ";
	}
	setColor(_color + tS);
    }

}

