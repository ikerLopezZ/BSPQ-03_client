package com.deustotickets.gui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JTextPane;


import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class ResenaWindow extends JFrame{
	
	public static ArrayList<String> listaResena = new ArrayList<String>();
	
	public ResenaWindow() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500, 700);
		JList<String> list = new JList<String>();
		JScrollPane scrollPane = new JScrollPane(list);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		list.setModel(listModel);
		for (String string : listaResena) {
			listModel.addElement(string);
		}
	}

}
