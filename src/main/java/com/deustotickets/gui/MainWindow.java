package com.deustotickets.gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.deustotickets.client.Resource;
import com.deustotickets.domain.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 * 
 * @author BSPQ-03
 *
 */
public class MainWindow {
	private static JFrame frmMain;
	private static ImageIcon logo = new ImageIcon("images/deustotickets_logo.png");
	private static ImageIcon logoPerfil = new ImageIcon("images/logoPerfil.png");
	private static ImageIcon inicio = new ImageIcon("images/inicio.png");
	public static Usuario logged = null;

	/**
	 * @wbp.parser.entryPoint
	 * 
	 */
	public static void initialize() {
		frmMain = new JFrame();
		frmMain.setTitle("DeustoTickets - Ventana principal");
		frmMain.setBounds(100, 100, 800, 600);
		frmMain.setResizable(false);
		frmMain.setLocationRelativeTo(null);
		frmMain.setIconImage(logo.getImage());
		frmMain.getContentPane().setLayout(null);

		JPanel panelPantalla = new JPanel();
		panelPantalla.setLocation(0, 0);
		panelPantalla.setSize(656, 563);
		frmMain.getContentPane().add(panelPantalla);
		panelPantalla.setBackground(Color.WHITE);
		panelPantalla.setLayout(null);

		JLabel lblTituloPerfil = new JLabel("PERFIL DEL USUARIO");
		lblTituloPerfil.setBounds(0, 0, 686, 27);
		lblTituloPerfil.setFont(new Font("Footlight MT Light", Font.BOLD, 28));
		lblTituloPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		panelPantalla.add(lblTituloPerfil);

		JPanel panelDatos = new JPanel();
		panelDatos.setBounds(0, 27, 686, 468);
		panelDatos.setBackground(new Color(150, 177, 216));
		panelPantalla.add(panelDatos);
		panelDatos.setLayout(null);

		JLabel lblNombreUsuario = new JLabel("NOMBRE:");
		lblNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombreUsuario.setForeground(new Color(255, 255, 255));
		lblNombreUsuario.setBackground(new Color(183, 183, 183));
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreUsuario.setBounds(89, 160, 199, 60);
		panelDatos.add(lblNombreUsuario);

//		Resource.loginUser(textFieldEmail.getText());

		JLabel lblNom = new JLabel(logged.getNombreApellidos());
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNom.setForeground(new Color(255, 255, 255));
		lblNom.setBounds(324, 181, 289, 20);
		panelDatos.add(lblNom);

		JLabel lblMail = new JLabel("CORREO ELECTRÓNICO:");
		lblMail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMail.setForeground(new Color(255, 255, 255));
		lblMail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMail.setBounds(57, 210, 231, 60);
		panelDatos.add(lblMail);

		JLabel lblCorreo = new JLabel(logged.getEmail());
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCorreo.setForeground(new Color(255, 255, 255));
		lblCorreo.setBounds(323, 233, 290, 20);
		panelDatos.add(lblCorreo);

		JLabel lblConstrasena = new JLabel("CONTRASENA:");
		lblConstrasena.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConstrasena.setForeground(new Color(255, 255, 255));
		lblConstrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConstrasena.setBounds(132, 269, 156, 60);
		panelDatos.add(lblConstrasena);

		JLabel lblContra = new JLabel(logged.getPassword());
		lblContra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContra.setForeground(new Color(255, 255, 255));
		lblContra.setBounds(324, 290, 289, 20);
		panelDatos.add(lblContra);

		JLabel lblDatos = new JLabel("DATOS DEL USUARIO:");
		lblDatos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDatos.setForeground(Color.WHITE);
		lblDatos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDatos.setBackground(new Color(183, 183, 183));
		lblDatos.setBounds(204, 90, 199, 60);
		panelDatos.add(lblDatos);

		JPanel panelControlPerfil = new JPanel();
		panelControlPerfil.setBounds(0, 495, 686, 68);
		panelPantalla.add(panelControlPerfil);

		JButton btnCambiarNombre = new JButton("CAMBIAR NOMBRE DE USUARIO");
		btnCambiarNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Nombre de usuario antiguo: " + logged.getNombreApellidos());
				changeUsername();
				System.out.println("Nombre de usuario nuevo: " + logged.getNombreApellidos());
				lblNom.setText(logged.getNombreApellidos());
			}
		});
		panelControlPerfil.setLayout(new GridLayout(2, 2, 0, 0));
		btnCambiarNombre.setFont(new Font("Footlight MT Light", Font.BOLD, 12));
		panelControlPerfil.add(btnCambiarNombre);

		JButton btnCambiarContrasena = new JButton("CAMBIAR CONTRASENA");
		btnCambiarContrasena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Contrasenya antigua: " + logged.getPassword());
				changePassword();
				System.out.println("Contrasenya nueva: " + logged.getPassword());
				lblContra.setText(logged.getPassword());
			}
		});
		btnCambiarContrasena.setFont(new Font("Footlight MT Light", Font.BOLD, 12));
		panelControlPerfil.add(btnCambiarContrasena);

		JButton btnBorrarCuenta = new JButton("BORRAR CUENTA");
		btnBorrarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Resource.erase(logged.getEmail());
				frmMain.dispose();
				LoginWindow lw = new LoginWindow();
				lw.initialize();
			}
		});
		
		btnBorrarCuenta.setFont(new Font("Footlight MT Light", Font.BOLD, 12));
		panelControlPerfil.add(btnBorrarCuenta);
		
		JButton btnCerrarSesion = new JButton("CERRAR SESIÓN");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Resource.closeSession();
				frmMain.dispose();
				LoginWindow lw = new LoginWindow();
				lw.initialize();
			}
		});
		panelControlPerfil.add(btnCerrarSesion);
		btnCerrarSesion.setFont(new Font("Footlight MT Light", Font.BOLD, 12));

		JPanel panelBotones = new JPanel();
		panelBotones.setLocation(655, 0);
		panelBotones.setSize(131, 563);
		frmMain.getContentPane().add(panelBotones);
		panelBotones.setLayout(new GridLayout(4, 1, 0, 0));

		JButton btnPerfil = new JButton("");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnPerfil.setIcon(logoPerfil);
		panelBotones.add(btnPerfil);

		JButton btnConciertos = new JButton("CONCIERTOS");
		btnConciertos.setFont(new Font("Footlight MT Light", Font.BOLD, 15));
		panelBotones.add(btnConciertos);

		JButton btnArtistas = new JButton("ARTISTAS");
		btnArtistas.setFont(new Font("Footlight MT Light", Font.BOLD, 13));
		panelBotones.add(btnArtistas);

		JButton btnNewButton_2 = new JButton("ENTRADAS");
		btnNewButton_2.setFont(new Font("Footlight MT Light", Font.BOLD, 13));
		panelBotones.add(btnNewButton_2);

		frmMain.setVisible(true);
	}

	public static void changeUsername() {
		String newUsername = JOptionPane.showInputDialog("Introduzca el nuevo nombre de usuario:");

		if (newUsername != null) {
			Resource.changeUsername(newUsername,logged.getEmail());
			logged.setNombreApellidos(newUsername);
			JOptionPane.showMessageDialog(null, "Nombre de usuario cambiado con éxito.");
		}
	}

	public static void changePassword() {
		String newPassword = JOptionPane.showInputDialog("Introduzca la nueva contraseña:");

		if (newPassword != null) {
			Resource.changePassword(logged.getEmail(), newPassword);
			logged.setPassword(newPassword);
			JOptionPane.showMessageDialog(null, "Contraseña cambiada con éxito.");
		}
	}
}