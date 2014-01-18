import java.util.*;

public class Rows{

    private ArrayList<PlayPegs> _row;

    public Rows(){
	ArrayList<PlayPegs> tA = new ArrayList<PlayPegs>();
	for(int x = 0; x < 4; x++){
	    PlayPegs p = new PlayPegs();
	    tA.add(p);
	}
	_row = tA;
    }

    public Rows(String thing){
	if (thing.equals("NULL")){
	    _row = new ArrayList<PlayPegs>();
	}
    }

    public PlayPegs rowRemove(int index){
	return _row.remove(index);
    }

    public int rowSize(){
	return _row.size();
    }

    public boolean equals(Rows r){
	for (int x = 0; x < 4; x++){
	    if (!(r._row.get(x).equals(_row.get(x)))){
		return false;
	    }
	}
	return true;
    }

    public String toString(){
	String tS = "|";
	for(PlayPegs p: _row){
	    tS += (p + "|");
	}
	return tS;
    }

    public void rowAdd(int color){
	PlayPegs tPP = new PlayPegs(color);
	_row.add(tPP);
    }

    public void rowAdd(PlayPegs p){
	_row.add(p);
    }

    public PlayPegs rowGet(int index){
	return _row.get(index);
    }

    public static void main(String[] args){
	//Rows ro = new Rows();
	//Rows or = new Rows();
	//System.out.println(ro.equals(or));
	//implement user terminal input + output
    }

}
