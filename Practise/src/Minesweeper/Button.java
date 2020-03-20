package Minesweeper;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Button {
	private int sizeTable;
	private int xPosition;
	private int yPosition;
	private int elementButton;
	private int widthButton = 50 ;
	private int heightButton = 50;
	private JButton button;
	private JPanel contentPane;
	private int countBomb ;
	private static int countWin =0;
	private TableGUI frame;
	
	public Button(int sizeTable,int xPosition ,
		int yPosition ,JPanel contentPane,
		int elementButton, TableGUI frame){
		this.sizeTable=sizeTable;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.contentPane=contentPane;
		this.elementButton = elementButton;	
		countBomb = sizeTable*sizeTable/3 -1;
		this.frame= frame;
		createButton();	
	}
	
	public void createButton() {
		button = new JButton("");
		button.setBounds(xPosition, yPosition, widthButton, heightButton);
		contentPane.add(button);
		listener();
	}
	
	public void listener() {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeButton();
				if(checkIfExistBomb()) {
					createNewGuiExplosion();
					countWin=0;
				}else {
					countWin++;
					System.out.println(countWin +"          dsfsfa");
					if(countWin==(sizeTable*sizeTable-countBomb)) {
						ExplosionOrWinGUI explosionGUIobject = new ExplosionOrWinGUI(1);
						explosionGUIobject.setVisible(true);
						frame.dispose1();
						countWin = 0;
						System.out.println("You are winner");
						System.out.println(countWin + "  " + (sizeTable*sizeTable-countBomb));
					}else{
						replaceButtonWithLabel();
					}
					
				}
						
			}
		});
	}
	public void removeButton() {
		contentPane.remove(button);
		contentPane.revalidate();
		contentPane.repaint();
	}
	
	public boolean checkIfExistBomb() {
		if(elementButton ==-1) 
			return true;
		return false;
	}
	public void createNewGuiExplosion(){
		ExplosionOrWinGUI explosionGUIobject = new ExplosionOrWinGUI(0);
		explosionGUIobject.setVisible(true);
		frame.dispose1();
		
	}
	
	public void replaceButtonWithLabel() {
		String elementButton1 =Integer.toString(elementButton);
		JLabel lblNewLabel = new JLabel(elementButton1);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD,20));
		lblNewLabel.setBounds(xPosition, yPosition, 50, 50);
		contentPane.add(lblNewLabel);
	}
	
	
}
