package com.deustotickets.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class RegWindow {
	public static JFrame frmRegister;
	private static JTextField textFieldNombreApellidos;
	private static JTextField textFieldEmail;
	private static JPasswordField passwordFieldContrasenya;
	private static JTextField textFieldPeso;
	private static JTextField textFieldAltura;
	private static JTextField textFieldFrecCardRep;
	private static JTextField textFieldFrecCardMax;
	private static Border line_1 = BorderFactory.createLineBorder(new Color(194, 194, 194), 2);
	private static Border line_2 = BorderFactory.createLineBorder(new Color(252, 76, 2), 2);
	private static ImageIcon logo_1 = new ImageIcon("images/logo_1.png");
	private static ImageIcon logo_2 = new ImageIcon("images/logo_2.png");
	private static ImageIcon logoGoogle = new ImageIcon("images/logoGoogle.png");
	private static ImageIcon logoFacebook = new ImageIcon("images/logoFacebook.png");

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public static void initialize() {
		frmRegister = new JFrame();
		frmRegister.setTitle("Strava - Registro");
		frmRegister.setBounds(100, 100, 400, 600);
		frmRegister.setResizable(false);
		frmRegister.setLocationRelativeTo(null);
		frmRegister.setIconImage(logo_1.getImage());
		frmRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegister.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		frmRegister.getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 384, 228);
		panel_1.setOpaque(false);
		panel_1.setLayout(null);
		panel.add(panel_1);

		JToggleButton tglbtnGoogle = new JToggleButton("  Registrarse con Google");
		tglbtnGoogle.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tglbtnGoogle.setForeground(new Color(0, 0, 0));
		tglbtnGoogle.setBackground(new Color(223, 223, 232));
		tglbtnGoogle.setFocusPainted(false);
		tglbtnGoogle.setOpaque(false);
		tglbtnGoogle.setContentAreaFilled(false);
		Border empty_1 = new EmptyBorder(0, 17, 0, 0);
		CompoundBorder border = new CompoundBorder(line_1, empty_1);
		tglbtnGoogle.setBorder(border);
		tglbtnGoogle.setBounds(26, 126, 330, 40);
		tglbtnGoogle.setIcon(logoGoogle);
		tglbtnGoogle.setIconTextGap(50);
		tglbtnGoogle.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(tglbtnGoogle);

		JToggleButton tglbtnFacebook = new JToggleButton("Registrarse con Facebook");
		tglbtnFacebook.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tglbtnFacebook.setForeground(new Color(255, 255, 255));
		tglbtnFacebook.setBackground(new Color(66, 103, 178));
		tglbtnFacebook.setFocusPainted(false);
		tglbtnFacebook.setOpaque(true);
		Border empty_2 = new EmptyBorder(0, 20, 0, 0);
		tglbtnFacebook.setBorder(empty_2);
		tglbtnFacebook.setBorderPainted(false);
		tglbtnFacebook.setBounds(26, 177, 330, 40);
		tglbtnFacebook.setIcon(logoFacebook);
		tglbtnFacebook.setIconTextGap(50);
		tglbtnFacebook.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(tglbtnFacebook);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(logo_2);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(140, 11, 104, 104);
		panel_1.add(lblNewLabel);

		tglbtnGoogle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnGoogle.isSelected()) {
					tglbtnGoogle.setOpaque(true);
					tglbtnFacebook.setBackground(new Color(66, 103, 178));
					tglbtnFacebook.setSelected(false);
					passwordFieldContrasenya.setEditable(false);
					passwordFieldContrasenya.setFocusable(false);
				} else {
					tglbtnGoogle.setOpaque(false);
					passwordFieldContrasenya.setEditable(true);
					passwordFieldContrasenya.setFocusable(true);
				}
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 227, 384, 332);
		panel_2.setOpaque(false);
		panel_2.setLayout(null);
		panel.add(panel_2);

		textFieldNombreApellidos = new JTextField();
		textFieldNombreApellidos = Utils.modifyTextField(textFieldNombreApellidos, "Nombre y apellidos");
		textFieldNombreApellidos.setBounds(92, 11, 200, 25);
		panel_2.add(textFieldNombreApellidos);
		textFieldNombreApellidos.setColumns(10);

		textFieldEmail = new JTextField();
		textFieldEmail = Utils.modifyTextField(textFieldEmail, "Email");
		textFieldEmail.setBounds(92, 47, 200, 25);
		panel_2.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		passwordFieldContrasenya = new JPasswordField();
		passwordFieldContrasenya = Utils.modifyPasswordField(passwordFieldContrasenya, "Cntrasenya");
		passwordFieldContrasenya.setBounds(92, 83, 200, 25);
		panel_2.add(passwordFieldContrasenya);

		textFieldPeso = new JTextField();
		textFieldPeso = Utils.modifyTextField(textFieldPeso, "Peso");
		textFieldPeso.setBounds(92, 119, 200, 25);
		panel_2.add(textFieldPeso);
		textFieldPeso.setColumns(10);

		textFieldAltura = new JTextField();
		textFieldAltura = Utils.modifyTextField(textFieldAltura, "Altura");
		textFieldAltura.setBounds(92, 155, 200, 25);
		panel_2.add(textFieldAltura);
		textFieldAltura.setColumns(10);

		textFieldFrecCardRep = new JTextField();
		textFieldFrecCardRep = Utils.modifyTextField(textFieldFrecCardRep, "Frecuencia cardiaca (reposo)");
		textFieldFrecCardRep.setBounds(92, 191, 200, 25);
		panel_2.add(textFieldFrecCardRep);
		textFieldFrecCardRep.setColumns(10);

		textFieldFrecCardMax = new JTextField();
		textFieldFrecCardMax = Utils.modifyTextField(textFieldFrecCardMax, "Frecuencia cardiaca (maxima)");
		textFieldFrecCardMax.setBounds(92, 227, 200, 25);
		panel_2.add(textFieldFrecCardMax);
		textFieldFrecCardMax.setColumns(10);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(92, 263, 200, 40);
		btnRegistrarse.setBackground(new Color(254, 237, 230));
		btnRegistrarse.setFocusPainted(false);
		btnRegistrarse.setOpaque(false);
		btnRegistrarse.setContentAreaFilled(false);
		btnRegistrarse.setBorder(line_1);
		panel_2.add(btnRegistrarse);

		tglbtnFacebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnFacebook.isSelected()) {
					tglbtnFacebook.setBackground(new Color(41, 65, 112));
					tglbtnGoogle.setOpaque(false);
					tglbtnGoogle.setSelected(false);
					passwordFieldContrasenya.setEditable(false);
					passwordFieldContrasenya.setFocusable(false);
				} else {
					tglbtnFacebook.setBackground(new Color(66, 103, 178));
					passwordFieldContrasenya.setEditable(true);
					passwordFieldContrasenya.setFocusable(true);
				}
			}
		});

		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnGoogle.isSelected()) {
					UserDTO ug = new UserDTO();
					ug.setNombreApellidos(textFieldNombreApellidos.getText());
					ug.setEmail(textFieldEmail.getText());
					ug.setPassword("");
					ug.setPeso(Float.parseFloat(textFieldPeso.getText()));
					ug.setAltura(Float.parseFloat(textFieldAltura.getText()));
					ug.setFrecCardRep(Float.parseFloat(textFieldFrecCardRep.getText()));
					ug.setFrecCardMax(Float.parseFloat(textFieldFrecCardMax.getText()));
					ug.setTipo(TipoUsuario.GOOGLE);
					if (MainProgram.registerController.register(ug)) {
						LoginWindow.initialize();
						frmRegister.dispose();
					} else {
						System.out.println("Error while registering new user");
					}
				} else if (tglbtnFacebook.isSelected()) {
					UserDTO uf = new UserDTO();
					uf.setNombreApellidos(textFieldNombreApellidos.getText());
					uf.setEmail(textFieldEmail.getText());
					uf.setPassword("");
					uf.setPeso(Float.parseFloat(textFieldPeso.getText()));
					uf.setAltura(Float.parseFloat(textFieldAltura.getText()));
					uf.setFrecCardRep(Float.parseFloat(textFieldFrecCardRep.getText()));
					uf.setFrecCardMax(Float.parseFloat(textFieldFrecCardMax.getText()));
					uf.setTipo(TipoUsuario.FACEBOOK);
					if (MainProgram.registerController.register(uf)) {
						LoginWindow.initialize();
						frmRegister.dispose();
					} else {
						System.out.println("Error while registering new user");
					}
				} else {
					UserDTO us = new UserDTO();
					us.setNombreApellidos(textFieldNombreApellidos.getText());
					us.setEmail(textFieldEmail.getText());
					us.setPassword(String.valueOf(passwordFieldContrasenya.getPassword()));
					us.setPeso(Float.parseFloat(textFieldPeso.getText()));
					us.setAltura(Float.parseFloat(textFieldAltura.getText()));
					us.setFrecCardRep(Float.parseFloat(textFieldFrecCardRep.getText()));
					us.setFrecCardMax(Float.parseFloat(textFieldFrecCardMax.getText()));
					us.setTipo(TipoUsuario.STRAVA);
					if (MainProgram.registerController.register(us)) {
						LoginWindow.initialize();
						frmRegister.dispose();
					} else {
						System.out.println("Error while registering new user");
					}
				}
			}
		});
		
		btnRegistrarse.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				btnRegistrarse.setBorder(line_2);
				btnRegistrarse.setOpaque(true);
			}

			public void mouseExited(MouseEvent evt) {
				btnRegistrarse.setBorder(line_1);
				btnRegistrarse.setOpaque(false);
			}
		});

		frmRegister.setVisible(true);
	}
}