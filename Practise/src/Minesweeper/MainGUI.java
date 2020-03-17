package Minesweeper;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private int sizeTable;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 100, 900, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMinesweeper = new JLabel("Minesweeper");
		lblMinesweeper.setFont(new Font("Dialog", Font.BOLD, 20));
		lblMinesweeper.setBounds(336, 12, 244, 68);
		contentPane.add(lblMinesweeper);
		
		
		JLabel lblNewLabel = new JLabel("Select the sizeTable:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(55, 140, 170, 45);
		contentPane.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"4x4", "8x8", "12x12"}));
		comboBox.setBounds(350, 140, 170, 45);
		contentPane.add(comboBox);
		
		JButton btnPlay = new JButton("PLAY");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				takeSizeTableFromComboBox();
				dispose();
				setVisible(false);
				TableGUI1 tableGUIobject = new TableGUI1();
				tableGUIobject.setVisible(true);
				tableGUIobject.initialize(sizeTable);
			}
		});
		btnPlay.setBounds(629, 140, 170, 45);
		contentPane.add(btnPlay);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("/home/boss/eclipse-workspace/Practise/image/bomb1.jpg"));
		lblNewLabel_2.setBounds(223, 210, 535, 641);
		contentPane.add(lblNewLabel_2);
		
	}
	
	public void takeSizeTableFromComboBox() { 
		String varName = (String)comboBox.getSelectedItem();
		String letter= varName.substring(0, 1);
		int result = Integer.parseInt(letter);			
		if(result==4) {
			sizeTable =4;
		}else if(result==8){
			sizeTable=8;
		}else {
			sizeTable=12;
		}
	}

}
