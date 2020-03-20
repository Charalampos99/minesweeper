package Minesweeper;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TableGUI extends JFrame {
	private int size;
	private int[][] table;
	private int count=0;
	private int count0=0;
	private int count1=0;
	private int xLabel=0;
	private int yLabel=150;
	private String element;
	private int valueOfBombs;
	private int countWin;
	private JPanel contentPane;
	private Button[][] buttons;
	
	public TableGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 100, 900, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMinesweeper = new JLabel("The game started:", SwingConstants.LEFT);
		lblMinesweeper.setFont(new Font("Dialog", Font.BOLD, 20));
		lblMinesweeper.setBounds(70, 12, 244, 68);
		contentPane.add(lblMinesweeper);	
	}
	
	public void initialize(int size) {
		this.size=size;
		TableElements tableObject = new TableElements(size);
		table=tableObject.getFinalTableWithoutZeros();
		valueOfBombs=tableObject.getValueofBombs();
		createTableButtons();
		
		JLabel lblTotalBomb = new JLabel("The table has " + valueOfBombs + " Bombs ", SwingConstants.LEFT);
		lblTotalBomb.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTotalBomb.setBounds(70, 40, 500, 100);
		contentPane.add(lblTotalBomb);
		
	}
	
	public void createTableButtons() {
		Button[][] buttons =new Button[size][size];
		int y=150;
		for(int i = 0; i<size ; i++) {
			int x= getStartX();
			for(int j=0;j<size ;j++) {
				buttons[i][j]=new Button(size,x,y,contentPane,table[i][j] ,this);
				x=x+50;
			}
			y=y+50;
		}   
	}
	
	public int getStartX(){
		int x;
		if(size==4)
			return x=320;
		if(size==8) 
			return x=280;
		return x=200;
	}
	
	public void dispose1() {
		setVisible(false);
		dispose();
	}
}
