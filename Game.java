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
        _counter = 1;
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

    public int rightColors(Rows r){
        int tInt = 0;
        Rows tMast = new Rows("NULL");
        for(int x = 0; x < 4; x++){
            tMast.rowAdd(_masterRow.rowGet(x));
        }
        for(int x = 0; x < 4; x++){
            for(int y = 0; y < tMast.rowSize(); y++){
                if (tMast.rowGet(y).equals(r.rowGet(x))){
                    tMast.rowRemove(y);
                    tInt++;
                    break;
                }
            }
        }
        return tInt;
    }

    public void newGame(){
        Rows newRow = new Rows("NULL");
        boolean won = false;
        int rightS = 0;
        int rightC = 0;
        System.out.println("New Game");
        String s = "Key:\n";
        s += "  RED    - 0\n";
        s += "  BLUE   - 1\n";
        s += "  GREEN  - 2\n";
        s += "  YELLOW - 3\n";
        s += "  PURPLE - 4\n";
        s += "  BLACK  - 5";
        System.out.println(s);
        while (!(won) && (_counter <= 10)){
            newRow = new Rows("NULL");
            //System.out.println(_masterRow);
            
            System.out.println("Turn " + _counter);
            for (int x = 0; x < 4; x++){
                s = "Choose the  color of peg " + x;
                System.out.println(s);
                try{
                    int tInt = Integer.parseInt( in.readLine());
                    if (tInt < 6 && tInt > -1)
                        newRow.rowAdd(tInt);
                    else{
                        System.out.println("Number out of range. Please make a selection from the key.");
                        x--;
                    }
                }
                catch ( IOException e ){
                    System.out.println("Input not an integer. Please make a selection from the key.");
                    x--;
                }
                catch ( NumberFormatException e ){
                    System.out.println("Input not an integer. Please make a selection from the key.");
                    x--;
                }
            }
            System.out.println(newRow);
            if (newRow.equals(_masterRow)){
                System.out.println("You win!\n" + _masterRow + " is " + newRow);
                won = true;
            }
            else if (_counter == 10){_counter++;}
            else{
                rightS = rightSpots(newRow);
                rightC = rightColors(newRow) - rightS;
                System.out.println("Sorry. " + newRow + " is not the master row");
                if (rightS == 1)
                    System.out.println("There is 1 peg with the right color and position");
                else
                    System.out.println("There are " + rightS + " pegs with the right color and position");
                if (rightC == 1)
                    System.out.println("There is 1 peg with only the right color");
                else
                    System.out.println("There are " + rightC + " pegs with only the right color");
                _counter ++;
                System.out.println("Try again");
            }
        }
        if(_counter == 11){
            System.out.println("\n\nGame over. You lost.");
            System.out.println("The master list was " + _masterRow);
        }
    }

    public static void main(String[] args){
        Game gTerm = new Game();
        gTerm.newGame();
    }
}
