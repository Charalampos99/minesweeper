package Minesweeper;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ApplicationWindow {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow window = new ApplicationWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ApplicationWindow() {
		initialize();
	}
	
	public void initialize() {
		MainGUI objectMainGUI1 = new MainGUI();
		objectMainGUI1.setVisible(true);
		
	}
}
