package com.deustotickets.gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import com.deustotickets.client.Resource;

//import es.deusto.ingenieria.sd.strava.client.MainProgram;
//import es.deusto.ingenieria.sd.strava.client.gui.LoginWindow;
//import es.deusto.ingenieria.sd.strava.client.gui.MainWindow;
//import es.deusto.ingenieria.sd.strava.server.data.domain.TipoUsuario;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPasswordField;
import java.awt.BorderLayout;

/**
 * 
 * @author BSPQ-03
 *
 */
public class LoginWindow {
	private static JFrame frmLogin;
	private static JTextField textFieldEmail;
	private static JPasswordField passwordFieldContrasenya;
	private static Border line_1 = BorderFactory.createLineBorder(new Color(194, 194, 194), 2);
	private static Border line_2 = BorderFactory.createLineBorder(new Color(227, 30, 36), 2);
	private static ImageIcon logo_1 = new ImageIcon("images/deustotickets_logo.png");
	private static ImageIcon logo_2 = new ImageIcon("images/deustotickets_logo_1.png");
	private static ImageIcon logoGoogle = new ImageIcon("images/logoGoogle.png");
	private static ImageIcon logoFacebook = new ImageIcon("images/logoFacebook.png");
	
	/**
	 * 
	 */
	public static void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("DeustoTickets - Inicio de sesion");
		frmLogin.setBounds(100, 100, 400, 600);
		frmLogin.setResizable(false);
		frmLogin.setLocationRelativeTo(null);
		frmLogin.setIconImage(logo_1.getImage());
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 255, 255));
		frmLogin.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 384, 152);
		panel_1.setOpaque(false);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(logo_2);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(127, 11, 130, 130);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 152, 384, 115);
		panel_2.setOpaque(false);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JToggleButton tglbtnGoogle = new JToggleButton("  Iniciar sesion con Google");
		tglbtnGoogle.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tglbtnGoogle.setForeground(new Color(0, 0, 0));
		tglbtnGoogle.setBackground(new Color(223,223,232));
		tglbtnGoogle.setFocusPainted(false);
		tglbtnGoogle.setOpaque(false);
		tglbtnGoogle.setContentAreaFilled(false);
		Border empty_1 = new EmptyBorder(0, 15, 0, 0);
		CompoundBorder border_1 = new CompoundBorder(line_1, empty_1);
		tglbtnGoogle.setBorder(border_1);
		tglbtnGoogle.setBounds(27, 11, 330, 40);
		tglbtnGoogle.setIcon(logoGoogle);
		tglbtnGoogle.setIconTextGap(50);
		tglbtnGoogle.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(tglbtnGoogle);
		
		JToggleButton tglbtnFacebook = new JToggleButton("Iniciar sesion con Facebook");
		tglbtnFacebook.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tglbtnFacebook.setForeground(new Color(255, 255, 255));
		tglbtnFacebook.setBackground(new Color(66, 103, 178));
		tglbtnFacebook.setFocusPainted(false);
		tglbtnFacebook.setOpaque(true);
		Border empty_2 = new EmptyBorder(0, 18, 0, 0);
		tglbtnFacebook.setBorder(empty_2);
		tglbtnFacebook.setBorderPainted(false);
		tglbtnFacebook.setBounds(27, 62, 330, 40);
		tglbtnFacebook.setIcon(logoFacebook);
		tglbtnFacebook.setIconTextGap(50);
		tglbtnFacebook.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(tglbtnFacebook);
		
		tglbtnFacebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnFacebook.isSelected()) {
					tglbtnFacebook.setBackground(new Color(41, 65, 112));
					tglbtnGoogle.setOpaque(false);
					tglbtnGoogle.setSelected(false);
				} else {
					tglbtnFacebook.setBackground(new Color(66, 103, 178));
				}
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 267, 384, 292);
		panel_3.setOpaque(false);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
//		textFieldEmail = new JTextField("Email");
		textFieldEmail = new JTextField();
		textFieldEmail = Utils.modifyTextField(textFieldEmail, "Email");
		textFieldEmail.setBounds(92, 24, 200, 25);
		panel_3.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
//		passwordFieldContrasenya = new JPasswordField("Contrasenya");
		passwordFieldContrasenya = new JPasswordField();
		passwordFieldContrasenya = Utils.modifyPasswordField(passwordFieldContrasenya, "Contrasenya");
		passwordFieldContrasenya.setBounds(92, 60, 200, 25);
		panel_3.add(passwordFieldContrasenya);
		
		JLabel lblOlvidar = new JLabel("Has olvidado tu contrasenya?");
		lblOlvidar.setHorizontalAlignment(SwingConstants.CENTER);
		lblOlvidar.setBounds(148, 96, 144, 14);
		panel_3.add(lblOlvidar);
		
		JButton btnIniciarSesion = new JButton("Iniciar sesion");
		btnIniciarSesion.setBounds(92, 120, 200, 40);
		btnIniciarSesion.setBackground(new Color(250, 209, 211));
		btnIniciarSesion.setFocusPainted(false);
		btnIniciarSesion.setOpaque(false);
		btnIniciarSesion.setContentAreaFilled(false);
		btnIniciarSesion.setBorder(line_1);
		panel_3.add(btnIniciarSesion);
		
		JLabel lblAun = new JLabel("Aun no estas registrado?");
		lblAun.setHorizontalAlignment(SwingConstants.CENTER);
		lblAun.setBounds(130, 196, 124, 14);
		panel_3.add(lblAun);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(91, 221, 200, 40);
		btnRegistrarse.setBackground(new Color(250, 209, 211));
		btnRegistrarse.setFocusPainted(false);
		btnRegistrarse.setOpaque(false);
		btnRegistrarse.setContentAreaFilled(false);
		btnRegistrarse.setBorder(line_1);
		panel_3.add(btnRegistrarse);
		
		tglbtnGoogle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnGoogle.isSelected()) {
					tglbtnGoogle.setOpaque(true);
					tglbtnFacebook.setBackground(new Color(66, 103, 178));
					tglbtnFacebook.setSelected(false);
				} else {
					tglbtnGoogle.setOpaque(false);
				}
			}
		});
		
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegWindow rw = new RegWindow();
				rw.initialize();
				frmLogin.dispose();
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
		
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnGoogle.isSelected()) {

				} else if(tglbtnFacebook.isSelected())  {

				} else {
					try {
						if(Resource.loginUser(textFieldEmail.getText(), String.valueOf(passwordFieldContrasenya.getPassword()))) {
							MainWindow mwin = new MainWindow();
							mwin.initialize();
						} else {
							LoginWindow lwin = new LoginWindow();
							lwin.initialize();
						}
						frmLogin.dispose();
					} catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Error al iniciar sesión", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		btnIniciarSesion.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				btnIniciarSesion.setBorder(line_2);
				btnIniciarSesion.setOpaque(true);
			}

			public void mouseExited(MouseEvent evt) {
				btnIniciarSesion.setBorder(line_1);
				btnIniciarSesion.setOpaque(false);
			}
		});
		
		frmLogin.setVisible(true);
	}
}