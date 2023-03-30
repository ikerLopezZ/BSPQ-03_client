package com.deustotickets.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author BSPQ-03
 *
 */
public class Utils {
	/**
	 * Personaliza y añade los escuchadores correspondientes al {@link JTextField} recibido como argumento.
	 * @param field {@link JTextField} a personalizar.
	 * @param textoPorDefecto {@link String} por defecto para el campo.
	 * @return {@link JTextField} personalizado.
	 */
	public static JTextField modifyTextField(JTextField field, String textoPorDefecto) {
		Border line = BorderFactory.createLineBorder(new Color(194, 194, 194), 2);
		Border empty = new EmptyBorder(0, 5, 0, 0);
		CompoundBorder border = new CompoundBorder(line, empty);
		field.setBorder(border);
		field.setForeground(Color.GRAY);
		field.setText(textoPorDefecto);

		field.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Border line = BorderFactory.createLineBorder(new Color(227, 30, 36), 2);
				Border empty = new EmptyBorder(0, 5, 0, 0);
				CompoundBorder border = new CompoundBorder(line, empty);
				field.setBorder(border);
				field.setForeground(Color.BLACK);
				if (field.getText().equals(textoPorDefecto)) {
					field.setText("");
				}
				super.focusGained(e);
			}

			@Override
			public void focusLost(FocusEvent e) {
				Border line = BorderFactory.createLineBorder(new Color(194, 194, 194), 2);
				Border empty = new EmptyBorder(0, 5, 0, 0);
				CompoundBorder border = new CompoundBorder(line, empty);
				field.setBorder(border);
				field.setForeground(Color.GRAY);
				if (field.getText().length() == 0) {
					field.setText(textoPorDefecto);
				}
				super.focusLost(e);
			}
		});

		field.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				field.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			}

		});
		return field;
	}
	
	/**
	 * Personaliza y añade los escuchadores correspondientes al {@link JPasswordField} recibido como argumento.
	 * @param field {@link JPasswordField} a personalizar.
	 * @param textoPorDefecto {@link String} por defecto para el campo.
	 * @return {@link JPasswordField} personalizado.
	 */
	public static JPasswordField modifyPasswordField(JPasswordField field, String textoPorDefecto) {
		Border line = BorderFactory.createLineBorder(new Color(194, 194, 194), 2);
		Border empty = new EmptyBorder(0, 5, 0, 0);
		CompoundBorder border = new CompoundBorder(line, empty);
		field.setBorder(border);
		field.setForeground(Color.GRAY);
		char passwordChar = field.getEchoChar();
		field.setEchoChar((char) 0);
		field.setText(textoPorDefecto);

		field.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Border line = BorderFactory.createLineBorder(new Color(227, 30, 36), 2);
				Border empty = new EmptyBorder(0, 5, 0, 0);
				CompoundBorder border = new CompoundBorder(line, empty);
				field.setBorder(border);
				field.setForeground(Color.BLACK);
				if (String.valueOf(field.getPassword()).equals(textoPorDefecto)) {
					field.setEchoChar(passwordChar);
					field.setText("");
				} else {
					field.setEchoChar(passwordChar);
				}
				super.focusGained(e);
			}

			@Override
			public void focusLost(FocusEvent e) {
				Border line = BorderFactory.createLineBorder(new Color(194, 194, 194), 2);
				Border empty = new EmptyBorder(0, 5, 0, 0);
				CompoundBorder border = new CompoundBorder(line, empty);
				field.setBorder(border);
				field.setForeground(Color.GRAY);
				if (String.valueOf(field.getPassword()).length() == 0) {
					field.setEchoChar((char) 0);
					field.setText(textoPorDefecto);
				} else {
					field.setEchoChar(passwordChar);
				}
				super.focusLost(e);
			}
		});
		return field;
	}
	
	/**
	 * Personaliza y añade los escuchadores correspondientes al {@link JSpinner} recibido como asrgumento.
	 * @param field {@link JSpinner} a personalizar.
	 * @return {@link JSpinner} personalizado.
	 */
	public static JSpinner modifySpinner(JSpinner field) {
		Border line = BorderFactory.createLineBorder(new Color(194, 194, 194), 2);
		Border empty = new EmptyBorder(0, 5, 0, 0);
		CompoundBorder border = new CompoundBorder(line, empty);
		field.setBorder(border);
		field.setForeground(Color.GRAY);

		((JSpinner.DefaultEditor) field.getEditor()).getTextField().addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Border line = BorderFactory.createLineBorder(new Color(227, 30, 36), 2);
				Border empty = new EmptyBorder(0, 5, 0, 0);
				CompoundBorder border = new CompoundBorder(line, empty);
				field.setBorder(border);
				field.setForeground(Color.BLACK);
				super.focusGained(e);
			}

			@Override
			public void focusLost(FocusEvent e) {
				Border line = BorderFactory.createLineBorder(new Color(194, 194, 194), 2);
				Border empty = new EmptyBorder(0, 5, 0, 0);
				CompoundBorder border = new CompoundBorder(line, empty);
				field.setBorder(border);
				field.setForeground(Color.GRAY);
				super.focusLost(e);
			}
		});
		return field;
	}
}