package Minesweeper;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class TableGUI extends JFrame {
	private int size;
	private int[][] table;
	private JPanel contentPane;
	private int count=0;
	private int count0=0;
	private int count1=0;
	private int xLabel=0;
	private int yLabel=150;
	private String element;
	private int valueOfBombs;
	private int countWin;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableGUI frame = new TableGUI();
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
	public TableGUI() {
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
		JButton[][] buttons =new JButton[size][size];
		int y=150;
		for(int ii = 0; ii<size ; ii++) {
			int x=0;
			if(size==4) {
				x=320;
			}else if(size==8) {
				x=280;
			}else {
				x=200;
			}
			for(int jj=0;jj<size ;jj++) {
				buttons[ii][jj]=new JButton("");
				buttons[ii][jj].setBounds(x, y, 50, 50);
				contentPane.add(buttons[ii][jj]);
				x=x+50;	
			}
			y=y+50;
		}   
		
		//newwwwwwwwwwwwwwwwwwwwwwwwwwwww
	//	JButton[][] buttons =new JButton[size][size];
		
		for(count0=0;count0<size;count0++) {
			if(size==4) {
				xLabel=320;
			}else if(size==8) {
				xLabel=280;
			}else {
				xLabel=200;
			}
			for(count1=0; count1<size ; count1++) {
				buttons[count0][count1].addActionListener(new ActionListener() {
					int x1=count0;
					int y1=count1;
					int xLabel1=xLabel;
					int yLabel1=yLabel;
					
					public void actionPerformed(ActionEvent e) {
						countWin++;
						System.out.println("-----" +x1);
						System.out.println("-------"+y1);
						//RemoveTheButton
						contentPane.remove(buttons[x1][y1]);
						contentPane.revalidate();
						contentPane.repaint();
						element=Integer.toString(table[x1][y1]);
						if(table[x1][y1]!=-1) {
							//CreateFrame
							JLabel lblNewLabel = new JLabel(element);
							lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
							lblNewLabel.setFont(new Font("Dialog", Font.BOLD,20));
							lblNewLabel.setBounds(xLabel1, yLabel1, 50, 50);
							contentPane.add(lblNewLabel); 
							if(countWin==(size*size-valueOfBombs)) {
								try {
									TimeUnit.SECONDS.sleep(1);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								System.out.print("you are the winner");
							}
							
							
						}else {
							getContentPane().removeAll();
							getContentPane().repaint();
							JLabel lblNewLabel_1 = new JLabel("New label");
							lblNewLabel_1.setIcon(new ImageIcon("/home/boss/eclipse-workspace/Practise/image/explotion.png"));
							lblNewLabel_1.setBounds(5, 23, 839, 509);
							contentPane.add(lblNewLabel_1);
							
							JButton btnNewButton = new JButton("RESTART");
							btnNewButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									try {
										MainGUI mainGUI = new MainGUI();
										mainGUI.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
									System.out.println("All is good");
									dispose();
								}
							});
							btnNewButton.setBounds(120, 600, 200, 50);
							contentPane.add(btnNewButton);
							
							JButton btnNewButton_1 = new JButton("END GAME");
							btnNewButton_1.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									System.exit(0);	
								}
							});
							btnNewButton_1.setBounds(517, 600, 200, 50);
							contentPane.add(btnNewButton_1);
						}
						
							
					}
				});
				xLabel=xLabel+50;
			}
			yLabel=yLabel+50;
			System.out.println(yLabel + "------------yLabel");
		}
	}
}
