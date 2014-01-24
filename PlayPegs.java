//PlayPegs subclass of Pegs
import java.util.*;

public class PlayPegs extends Pegs{

    private static final String[] USED_COLORS = {"RED","BLUE","GREEN","YELLOW","PURPLE","BLACK"};

    public PlayPegs(){
        _color = USED_COLORS[(int)(6 * Math.random())];
        colorSpacing(6);
    }
    
    public PlayPegs(int color){
        _color = USED_COLORS[color];
        colorSpacing(6);
        //robustify
    }

    public boolean equals(PlayPegs p){
        return (p._color.equals(_color));
    }

    /*    public static void main(String[] args){
        PlayPegs p = new PlayPegs();
        System.out.println(p);
        System.out.println(p._color.length());
        }*/

}
