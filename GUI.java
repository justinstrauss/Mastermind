import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class GUI extends JFrame implements ActionListener{

    private int turn;
    private GridLayout grid;
    private GridLayout grid1;
    private JTable pegs;
    private JTable indicators;
    private Color[] colors = {Color.red, Color.blue, Color.green, Color.yellow, Color.MAGENTA, Color.darkGray};
    private ArrayList<String> colorsS = new ArrayList<String>();
    private ArrayList<String> colorsN = new ArrayList<String>();
    private JButton[][] tempName;
    private Color selectedColor;
    private int selectedColumn;
    //private Color[][] board = new Color[10][4];
    //private Color[][] indicators = new Color[20][2];

    public JFrame initializeBoard(){
        turn = 1;
        tempName = new JButton[2][6];
        grid = new GridLayout(2,6);
        grid1 = new GridLayout(1,1);
        selectedColor = Color.PINK;
        selectedColumn = -1;
        String[] colorsA = {"RED", "BLUE", "GREEN", "YELLOW", "MAGENTA", "DARK_GRAY"};
        String[] colorsNA = {"1", "2", "3", "4"};
        for(String s:colorsA){
            colorsS.add(s);
        }
        for(String h:colorsNA){
            colorsN.add(h);
        }
        
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(1,3));
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        pegs = new JTable(10,4);
        indicators = new JTable(10,4);
        panel2.add(pegs);
        panel3.add(indicators);
        frame.add(panel2);
        frame.add(panel3);

        panel.setLayout(grid);
        panel2.setLayout(grid1);
        panel3.setLayout(grid1);

        panel.setSize(500, 1000);
        frame.getContentPane().add(panel, BorderLayout.PAGE_END);
        frame.getContentPane().add(panel2, BorderLayout.LINE_START);
        frame.getContentPane().add(panel3, BorderLayout.LINE_END);
        frame.setTitle("Mastermind");        

        tempName[0][0] = new JButton("CLEAR");
        tempName[0][0].addActionListener(this);
        tempName[0][0].setBackground(Color.WHITE);
        tempName[0][0].setActionCommand("CLEAR");
        panel.add(tempName[0][0]);
        
        for (int y = 1; y < 5; y++){
            tempName[0][y] = new JButton("" + y);
            tempName[0][y].addActionListener(this);
            tempName[0][y].setBackground(Color.PINK);
            tempName[0][y].setActionCommand("" + y);
            panel.add(tempName[0][y]);
        }

        tempName[0][5] = new JButton("SUBMIT");
        tempName[0][5].addActionListener(this);
        tempName[0][5].setBackground(Color.WHITE);
        tempName[0][5].setActionCommand("SUBMIT");
        panel.add(tempName[0][5]);

        for (int x = 0; x < 6; x++){
            tempName[1][x] = new JButton("color");
            tempName[1][x].addActionListener(this);
            tempName[1][x].setBackground(colors[x]);
            tempName[1][x].setActionCommand(colorsS.get(x));
            panel.add(tempName[1][x]);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 1100);
        frame.setVisible(true);
        frame.add(panel);

        return frame;
    }

    public void actionPerformed (ActionEvent e) {
        //getSource action listener: if in tempName[1][?], set selectedColor, if in tempName[0][1-4], set selectedRo
        if(colorsS.contains(e.getActionCommand())){
            selectedColor = colors[colorsS.indexOf(e.getActionCommand())];     
        }
        else if(colorsN.contains(e.getActionCommand())){
            Integer i = new Integer(e.getActionCommand());
            selectedColumn = i.intValue();
        }
        if(selectedColumn != -1 && !(selectedColor.equals(Color.PINK))){
            tempName[0][selectedColumn].setBackground(selectedColor);
            selectedColumn = -1;
            selectedColor = Color.PINK;
        }
        if("CLEAR".equals(e.getActionCommand())){
            for (int x = 1; x < 5; x++){
                tempName[0][x].setBackground(Color.PINK);
            }
            selectedColumn = -1;
            selectedColor = Color.PINK;
        }
        
    }

    public static void main(String[] args) {
        GUI newgame = new GUI();
        JFrame box = new JFrame();
        JOptionPane.showMessageDialog(box, "This is the Mastermind board game.[Instructions here] Click OK to continue.");
                //int x = Integer.parseInt(JOptionPane.showInputDialog("Please input the board size."));
                //int[][] board=new int [x][x];
        newgame.initializeBoard();
    }
}
