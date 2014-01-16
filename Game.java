//game play file
import java.util.*;
import java.io.*;

public class Game{

    private Rows _masterRow;
    private ArrayList<Rows> _board;
    private int _counter;

    private InputStreamReader isr;
    private BufferedReader in;

    public Game(){
	_masterRow = new Rows();
	_counter = 0;
	isr = new InputStreamReader(System.in);
	in = new BufferedReader( isr );
    }

    public int rightSpots(Rows r){
	int tInt = 0;
	for (int x = 0; x < 4; x++){
	    if (_masterRow.rowGet(x).equals(r.rowGet(x))){
		tInt ++;
	    }
	}
	return tInt;
    }

    public void newGame(){
	Rows newRow = new Rows("NULL");
	boolean won = false;
	System.out.println("New Game");
	while (!(won) && (_counter < 10)){
	    newRow = new Rows("NULL");
	    System.out.println(_masterRow);
		for (int x = 0; x < 4; x++){
		    String s = "Choose the  color of peg " + x;
		    //red-0 blue-1 green-2 yellow-3 purple-4 black-5
		    System.out.println(s);
		    try{
			newRow.rowAdd(Integer.parseInt( in.readLine()));
		    }
		    catch ( IOException e ){}
		}
	    System.out.println(newRow);
	    if (newRow.equals(_masterRow)){
		System.out.println("You win!\n" + _masterRow + " is " + newRow);
		won = true;
	    }
	    else{
		System.out.println("Sorry. " + newRow + " is not the master row\nTry again");
		_counter ++;
	    }
	}
	System.out.println("Game over. You lost.");
	    
    }

    public static void main(String[] args){
	Game gTerm = new Game();
	gTerm.newGame();
	/*
	Rows testRow = Game._masterRow;
	System.out.println(_masterRow.rightSpots(testRow));
	Rows testRow = new Rows();
	System.out.println(_masterRow.rightSpots(testRow))*/
    }
}
		 
