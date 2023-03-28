package com.deustotickets.gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainWindow {
	private static JFrame frmMain;
	private static ImageIcon logo = new ImageIcon("images/deustotickets_logo.png");

	/**
	 * Initialize the contents of the frame.
	 */
	public static void initialize() {
		frmMain = new JFrame();
		frmMain.setTitle("DeustoTickets - Ventana principal");
		frmMain.setBounds(100, 100, 1600, 1200);
		frmMain.setResizable(false);
		frmMain.setLocationRelativeTo(null);
		frmMain.setIconImage(logo.getImage());
		frmMain.getContentPane().setLayout(null);
		
		frmMain.setVisible(true);
	}

}
