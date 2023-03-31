package com.deustotickets.gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.deustotickets.client.Resource;
import com.deustotickets.domain.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
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
		panelPantalla.setSize(659, 563);
		frmMain.getContentPane().add(panelPantalla);
		panelPantalla.setBackground(Color.WHITE);
		panelPantalla.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTituloPerfil = new JLabel("PERFIL DEL USUARIO");
		lblTituloPerfil.setFont(new Font("Footlight MT Light", Font.BOLD, 28));
		lblTituloPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		panelPantalla.add(lblTituloPerfil, BorderLayout.NORTH);
		
		JPanel panelDatos = new JPanel();
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
		panelPantalla.add(panelControlPerfil, BorderLayout.SOUTH);
		
		JButton btnCambiarNombre = new JButton("CAMBIAR NOMBRE DE USUARIO");
		btnCambiarNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Insertar código o llamada a función para cambiar la contraseña
			}
		});
		btnCambiarNombre.setFont(new Font("Footlight MT Light", Font.BOLD, 15));
		panelControlPerfil.add(btnCambiarNombre);
		
		JButton btnCambiarContrasena = new JButton("CAMBIAR CONTRASENA");
		btnCambiarContrasena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Insertar código o llamada a función para cambiar la contraseña
			}
		});
		btnCambiarContrasena.setFont(new Font("Footlight MT Light", Font.BOLD, 15));
		panelControlPerfil.add(btnCambiarContrasena);
		
		JButton btnBorrarCuenta = new JButton("BORRAR CUENTA");
		btnBorrarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Insertar código o llamada a función para cambiar la contraseña
			}
		});
		btnBorrarCuenta.setFont(new Font("Footlight MT Light", Font.BOLD, 15));
		panelControlPerfil.add(btnBorrarCuenta);
		
//		JPanel panelPerfil = new JPanel();
//		panelPerfil.setBounds(335, 5, 10, 10);
////		panelPantalla.add(panelPerfil);
//		panelPerfil.setLayout(new GridLayout(10, 2, 0, 0));
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLocation(657, 0);
		panelBotones.setSize(129, 563);
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
}
