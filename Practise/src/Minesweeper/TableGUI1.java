package Minesweeper;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TableGUI1 extends JFrame {
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableGUI1 frame = new TableGUI1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TableGUI1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 100, 900, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	public void initialize(int size) {
		this.size=size;
		Table1 tableObject = new Table1(size);
		table=tableObject.getFinalTableWithoutZeros();
		valueOfBombs=tableObject.getValueofBombs();
		createTableButtons();
		
	}
	
	public void createTableButtons() {
		Button[][] buttons =new Button[size][size];
		int y=150;
		for(int i = 0; i<size ; i++) {
			int x=0;
			if(size==4) {
				x=320;
			}else if(size==8) {
				x=280;
			}else {
				x=200;
			}
			for(int j=0;j<size ;j++) {
				buttons[i][j]=new Button(size,x,y,
						contentPane,table[i][j]);
				x=x+50;
			}
			y=y+50;
		}   
	}
}
