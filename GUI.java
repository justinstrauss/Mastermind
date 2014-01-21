import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GUI extends JFrame implements ActionListener{

    public int turn;
    public JButton[][] button;
    public GridLayout grid;

    public JFrame initializeBoard(){
	turn = 1;
	button = new JButton[10][4];
	grid = new GridLayout(10,4);

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();

	panel.setLayout(grid);
	panel.setSize(500, 1000);
	frame.getContentPane().add(BorderLayout.CENTER, panel);
	frame.setTitle("Mastermind");

	for (int r = 0; r < 10; r++){
	    for (int c = 0; c < 4; c++) {
		button[r][c] = new JButton("Button");
		button[r][c].addActionListener(this);
		button[r][c].setBackground(Color.RED);
		panel.add(button[r][c]);
	    }
	}

	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(600, 1100);
	frame.setVisible(true);
	frame.add(panel);

	return frame;
    }

    public void actionPerformed (ActionEvent action) {
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
