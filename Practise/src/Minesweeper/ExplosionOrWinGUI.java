package Minesweeper;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ExplosionOrWinGUI extends JFrame {

	private static JPanel contentPane;
	
	private int flagWinOrLoose;
	
	
	public ExplosionOrWinGUI(int flagWinOrLoose) {
		this.flagWinOrLoose = flagWinOrLoose;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 100, 900, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		selectPicture();
		setRestartButton();
		setEndButton();
		
	}
	
	public void selectPicture() {
		String pictureDestination;
		int xStartPicture;
		if(flagWinOrLoose == 0) {
			pictureDestination = "/home/boss/git/minesweeper/Practise/image/explotion.png";
			xStartPicture =5;
		}else {
			pictureDestination = "/home/boss/git/minesweeper/Practise/image/winBomb.jpg";
			xStartPicture = 155;
		}
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(pictureDestination));
		lblNewLabel_1.setBounds(xStartPicture, 23, 839, 509);
		contentPane.add(lblNewLabel_1);
	}
	
	public void setRestartButton() {
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
	}
	
	public void setEndButton() {
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
