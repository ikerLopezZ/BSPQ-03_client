package com.deustotickets.gui;

import javax.swing.UIManager;


public class GUITest {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		try { 
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
	    } catch(Exception ignored) {
	    }
//		LoginWindow win = new LoginWindow();
		MainWindow win = new MainWindow();
		win.initialize();
	}
}
