package com.deustotickets.gui;

import javax.swing.UIManager;


public class Test {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		try { 
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
	    } catch(Exception ignored) {
	    }
		LoginWindow win = new LoginWindow();
		win.initialize();
	}
}
