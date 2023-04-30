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

import com.deustotickets.client.Resource;
import com.deustotickets.domain.TipoUsuario;
import com.deustotickets.domain.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;

/**
 * 
 * @author BSPQ-03
 *
 */
public class RegWindow {
	public static JFrame frmRegister;
	private static JTextField textFieldNombreApellidos;
	private static JTextField textFieldEmail;
	private static JPasswordField passwordFieldContrasenya;
	private static Border line_1 = BorderFactory.createLineBorder(new Color(194, 194, 194), 2);
	private static Border line_2 = BorderFactory.createLineBorder(new Color(227, 30, 36), 2);
	private static ImageIcon logo_1 = new ImageIcon("src/main/resources/deustotickets_logo.png");
	private static ImageIcon logo_2 = new ImageIcon("src/main/resources/deustotickets_logo_2.png");
	private static ImageIcon logoGoogle = new ImageIcon("src/main/resources/logoGoogle.png");
	private static ImageIcon logoFacebook = new ImageIcon("src/main/resources/logoFacebook.png");
	
	/**
	 *
	 */
	public static void initialize() {
		frmRegister = new JFrame();
		frmRegister.setTitle("DeustoTickets - Registro");
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
//					passwordFieldContrasenya.setEditable(false);
//					passwordFieldContrasenya.setFocusable(false);
				} else {
					tglbtnGoogle.setOpaque(false);
//					passwordFieldContrasenya.setEditable(true);
//					passwordFieldContrasenya.setFocusable(true);
				}
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 227, 384, 332);
		panel_2.setOpaque(false);
		panel_2.setLayout(null);
		panel.add(panel_2);

//		textFieldNombreApellidos = new JTextField("Nombre y apellidos");
		textFieldNombreApellidos = new JTextField();
		textFieldNombreApellidos = Utils.modifyTextField(textFieldNombreApellidos, "Nombre y apellidos");
		textFieldNombreApellidos.setBounds(92, 11, 200, 25);
		panel_2.add(textFieldNombreApellidos);
		textFieldNombreApellidos.setColumns(10);

//		textFieldEmail = new JTextField("Email");
		textFieldEmail = new JTextField();
		textFieldEmail = Utils.modifyTextField(textFieldEmail, "Email");
		textFieldEmail.setBounds(92, 47, 200, 25);
		panel_2.add(textFieldEmail);
		textFieldEmail.setColumns(10);

//		passwordFieldContrasenya = new JPasswordField("Contrasenya");
		passwordFieldContrasenya = new JPasswordField();
		passwordFieldContrasenya = Utils.modifyPasswordField(passwordFieldContrasenya, "Contrasenya");
		passwordFieldContrasenya.setBounds(92, 83, 200, 25);
		panel_2.add(passwordFieldContrasenya);
		
		JCheckBox chckbxEresUnArtista = new JCheckBox("Eres artista?");
		chckbxEresUnArtista.setBackground(new Color(255, 255, 255));
		chckbxEresUnArtista.setBounds(92, 119, 85, 25);
		chckbxEresUnArtista.setFocusable(false);
		panel_2.add(chckbxEresUnArtista);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(92, 155, 200, 40);
		btnRegistrarse.setBackground(new Color(250, 209, 211));
		btnRegistrarse.setFocusPainted(false);
		btnRegistrarse.setOpaque(false);
		btnRegistrarse.setContentAreaFilled(false);
		btnRegistrarse.setBorder(line_1);
		panel_2.add(btnRegistrarse);
		
		JLabel lblYaTienesUna = new JLabel("Ya tienes una cuenta?");
		lblYaTienesUna.setHorizontalAlignment(SwingConstants.CENTER);
		lblYaTienesUna.setBounds(130, 236, 124, 14);
		panel_2.add(lblYaTienesUna);
		
		JButton btnIniciarSesion = new JButton("Iniciar sesion");
		btnIniciarSesion.setBounds(92, 261, 200, 40);
		btnIniciarSesion.setBackground(new Color(250, 209, 211));
		btnIniciarSesion.setFocusPainted(false);
		btnIniciarSesion.setOpaque(false);
		btnIniciarSesion.setContentAreaFilled(false);
		panel_2.add(btnIniciarSesion);

		tglbtnFacebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnFacebook.isSelected()) {
					tglbtnFacebook.setBackground(new Color(41, 65, 112));
					tglbtnGoogle.setOpaque(false);
					tglbtnGoogle.setSelected(false);
//					passwordFieldContrasenya.setEditable(false);
//					passwordFieldContrasenya.setFocusable(false);
				} else {
					tglbtnFacebook.setBackground(new Color(66, 103, 178));
//					passwordFieldContrasenya.setEditable(true);
//					passwordFieldContrasenya.setFocusable(true);
				}
			}
		});

		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglbtnGoogle.isSelected()) {
					
				} else if (tglbtnFacebook.isSelected()) {
				
				} else if (chckbxEresUnArtista.isSelected()) {
					Usuario a = new Usuario();
					a.setNombreApellidos(textFieldNombreApellidos.getText());
					a.setEmail(textFieldEmail.getText());
					a.setPassword(String.valueOf(passwordFieldContrasenya.getPassword()));
					a.setTipo(TipoUsuario.ARTISTA);
					if (Resource.registerUser(a.getNombreApellidos(), a.getEmail(), a.getPassword(), a.getTipo())) {
						LoginWindow.initialize();
						frmRegister.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Usuario ya registrado", "Error", JOptionPane.ERROR_MESSAGE);
						System.out.println("Error while registering new user");
					}					
				} else {
					Usuario u = new Usuario();
					u.setNombreApellidos(textFieldNombreApellidos.getText());
					u.setEmail(textFieldEmail.getText());
					u.setPassword(String.valueOf(passwordFieldContrasenya.getPassword()));
					u.setTipo(TipoUsuario.CLIENTE);
					if (Resource.registerUser(u.getNombreApellidos(), u.getEmail(), u.getPassword(), u.getTipo())) {
						LoginWindow.initialize();
						frmRegister.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Usuario ya registrado", "Error", JOptionPane.ERROR_MESSAGE);
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
		
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginWindow.initialize();
				frmRegister.dispose();
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

		frmRegister.setVisible(true);
	}
}