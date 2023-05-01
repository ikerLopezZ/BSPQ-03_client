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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.deustotickets.client.Resource;

/**
 * 
 * @author BSPQ-03
 *
 */
public class ProfileWindow {

	private static JFrame frmProfile;
	private static JTextField textFieldEmail;
	private static JPasswordField passwordFieldContrasenya;
	private static Border line_1 = BorderFactory.createLineBorder(new Color(194, 194, 194), 2);
	private static Border line_2 = BorderFactory.createLineBorder(new Color(227, 30, 36), 2);
	private static ImageIcon logo_1 = new ImageIcon("src/main/resources/logoPerfil.png");
	private static ImageIcon logo_2 = new ImageIcon("src/main/resources/logoPerfil.png");
	private static ImageIcon lapiz = new ImageIcon("src/main/resources/pencil.png");

	/**
	 * @wbp.parser.entryPoint
	 * 
	 */
	public static void initialize() {
		frmProfile = new JFrame();
		frmProfile.setTitle("DeustoTickets - Perfil " + MainWindow.logged.getNombreApellidos());
		frmProfile.setBounds(100, 100, 400, 600);
		frmProfile.setResizable(false);
		frmProfile.setLocationRelativeTo(null);
		frmProfile.setIconImage(logo_1.getImage());
		frmProfile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProfile.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 255, 255));
		frmProfile.getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 384, 214);
		panel_1.setOpaque(false);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(logo_2);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(110, 24, 169, 180);
		panel_1.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 213, 384, 191);
		panel_2.setOpaque(false);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNombreUsuario = new JLabel("USUARIO:");
		lblNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreUsuario.setBounds(40, 61, 117, 13);
		panel_2.add(lblNombreUsuario);

		JLabel lblMail = new JLabel("EMAIL:");
		lblMail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMail.setBounds(40, 89, 117, 13);
		panel_2.add(lblMail);

		JLabel lblContrasenya = new JLabel("CONTRASEÑA:");
		lblContrasenya.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContrasenya.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasenya.setBounds(40, 120, 117, 13);
		panel_2.add(lblContrasenya);

		JLabel lblNombreUsuario_1 = new JLabel("");
		lblNombreUsuario_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreUsuario_1.setText(MainWindow.logged.getNombreApellidos());
		lblNombreUsuario_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreUsuario_1.setBounds(184, 61, 117, 13);
		panel_2.add(lblNombreUsuario_1);

		JLabel lblMail_1 = new JLabel("");
		lblMail_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMail_1.setText(MainWindow.logged.getEmail());
		lblMail_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblMail_1.setBounds(184, 89, 117, 13);
		panel_2.add(lblMail_1);

		JLabel lblContrasenya_1 = new JLabel("");
		lblContrasenya_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasenya_1.setText(MainWindow.logged.getPassword());
		lblContrasenya_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblContrasenya_1.setBounds(184, 120, 117, 13);
		panel_2.add(lblContrasenya_1);

		JButton btnLapiz = new JButton("");
		btnLapiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Nombre de usuario antiguo: " + MainWindow.logged.getNombreApellidos());
				changeUsername();
				System.out.println("Nombre de usuario nuevo: " + MainWindow.logged.getNombreApellidos());
				lblNombreUsuario_1.setText(MainWindow.logged.getNombreApellidos());
			}
		});
		btnLapiz.setIcon(lapiz);
		btnLapiz.setBorderPainted(false);
		btnLapiz.setBounds(263, 43, 56, 31);
		panel_2.add(btnLapiz);

		JButton btnLapiz2 = new JButton("");
		btnLapiz2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Contrasenya antigua: " + MainWindow.logged.getPassword());
				changePassword();
				System.out.println("Contrasenya nueva: " + MainWindow.logged.getPassword());
				lblContrasenya_1.setText(MainWindow.logged.getPassword());
			}
		});
		btnLapiz2.setIcon(lapiz);
		btnLapiz2.setBorderPainted(false);
		btnLapiz2.setBounds(263, 116, 56, 31);
		panel_2.add(btnLapiz2);
		
		JLabel lblDatos = new JLabel("DATOS DE " + MainWindow.logged.getNombreApellidos() + ":");
		lblDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDatos.setBounds(118, 10, 159, 13);
		panel_2.add(lblDatos);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 403, 384, 156);
		panel_3.setOpaque(false);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(85, 106, 200, 40);
		btnVolver.setBackground(new Color(250, 209, 211));
		btnVolver.setFocusPainted(false);
		btnVolver.setOpaque(false);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setBorder(line_1);
		panel_3.add(btnVolver);

		JButton btnBorrarCuenta = new JButton("BORRAR CUENTA");
		btnBorrarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Resource.deleteAccount(MainWindow.logged.getEmail());
				frmProfile.dispose();
				LoginWindow lw = new LoginWindow();
				lw.initialize();
			}
		});
		btnBorrarCuenta.setOpaque(false);
		btnBorrarCuenta.setFocusPainted(false);
		btnBorrarCuenta.setContentAreaFilled(false);
		btnBorrarCuenta.setBorder(line_1);
		btnBorrarCuenta.setBackground(new Color(250, 209, 211));
		btnBorrarCuenta.setBounds(85, 56, 200, 40);
		panel_3.add(btnBorrarCuenta);

		JButton btnCerrarSesion = new JButton("CERRAR SESIÓN");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Resource.closeSession();
				frmProfile.dispose();
				LoginWindow lw = new LoginWindow();
				lw.initialize();
			}
		});
		btnCerrarSesion.setOpaque(false);
		btnCerrarSesion.setFocusPainted(false);
		btnCerrarSesion.setContentAreaFilled(false);
		btnCerrarSesion.setBorder(line_1);
		btnCerrarSesion.setBackground(new Color(250, 209, 211));
		btnCerrarSesion.setBounds(85, 10, 200, 40);
		panel_3.add(btnCerrarSesion);

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow mw = new MainWindow();
				mw.initialize();
				frmProfile.dispose();
			}
		});

		btnVolver.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				btnVolver.setBorder(line_2);
				btnVolver.setOpaque(true);
			}

			public void mouseExited(MouseEvent evt) {
				btnVolver.setBorder(line_1);
				btnVolver.setOpaque(false);
			}
		});

		frmProfile.setVisible(true);
	}

	public static void changeUsername() {
		String newUsername = JOptionPane.showInputDialog("Introduzca el nuevo nombre de usuario:");

		if (newUsername != null) {
			Resource.changeUsername(newUsername, MainWindow.logged.getEmail());
			MainWindow.logged.setNombreApellidos(newUsername);
			JOptionPane.showMessageDialog(null, "Nombre de usuario cambiado con éxito.");
		}
	}

	public static void changePassword() {
		String newPassword = JOptionPane.showInputDialog("Introduzca la nueva contraseña:");

		if (newPassword != null) {
			Resource.changePassword(MainWindow.logged.getEmail(), newPassword);
			MainWindow.logged.setPassword(newPassword);
			JOptionPane.showMessageDialog(null, "Contraseña cambiada con éxito.");
		}
	}
	
}
