package com.deustotickets.gui;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.deustotickets.app.App;
import com.deustotickets.client.Resource;
import com.deustotickets.domain.Usuario;
import com.deustotickets.domain.Artista;
import com.deustotickets.domain.Concierto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
	private static ImageIcon logo = new ImageIcon("src/main/resources/deustotickets_logo.png");
	private static ImageIcon logoPerfil = new ImageIcon("src/main/resources/logoPerfil.png");
	private static ImageIcon logoPerfilPeque = new ImageIcon("src/main/resources/logoPerfilPeque.png");
	private static ImageIcon inicio = new ImageIcon("src/main/resources/inicio.png");
	public static Usuario logged = null;
	private static DefaultListModel<Concierto> conciertosListModel;
	private static JList<Concierto> conciertosList;
	private static JScrollPane conciertosScrollPane;

	/**
	 * @wbp.parser.entryPoint
	 * 
	 */
	public static void initialize() {
		frmMain = new JFrame();
		frmMain.getContentPane().setBackground(new Color(255, 255, 255));
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

		JLabel lblTitulo = new JLabel("DEUSTO TICKETS");
		lblTitulo.setBounds(0, 0, 656, 59);
		lblTitulo.setFont(new Font("Footlight MT Light", Font.BOLD, 28));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panelPantalla.add(lblTitulo);

		JPanel panelDatos = new JPanel();
		panelDatos.setBounds(0, 57, 656, 438);
		panelDatos.setBackground(new Color(150, 177, 216));
		panelPantalla.add(panelDatos);
		panelDatos.setLayout(null);

		JLabel lblProximosConciertos = new JLabel("PRÓXIMOS CONCIERTOS");
		lblProximosConciertos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProximosConciertos.setFont(new Font("Footlight MT Light", Font.BOLD, 24));
		lblProximosConciertos.setBounds(200, 10, 279, 31);
		panelDatos.add(lblProximosConciertos);

		// Crear el JScrollPane y la JList de conciertos
		conciertosListModel = new DefaultListModel<Concierto>();
		conciertosList = new JList<>(conciertosListModel);
		conciertosScrollPane = new JScrollPane(conciertosList);
		conciertosScrollPane.setBounds(80, 45, 501, 369);
		conciertosScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		conciertosScrollPane.setViewportView(conciertosList);

		JPanel panelControlPerfil = new JPanel();
		panelControlPerfil.setBounds(0, 495, 686, 68);
		panelPantalla.add(panelControlPerfil);
		panelControlPerfil.setLayout(new GridLayout(2, 2, 0, 0));

		JPanel panelBotones = new JPanel();
		panelBotones.setLocation(655, 70);
		panelBotones.setSize(131, 493);
		frmMain.getContentPane().add(panelBotones);
		panelBotones.setLayout(new GridLayout(4, 1, 0, 0));

		JButton btnConciertos = new JButton("CONCIERTOS");
		btnConciertos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDatos.add(conciertosScrollPane, BorderLayout.CENTER);
				ArrayList<Concierto> conciertos = App.res.getConcerts();
				for (Concierto concierto : conciertos) {
					conciertosListModel.addElement(concierto);
				}

				conciertosList.setModel(conciertosListModel);
			}
		});

		btnConciertos.setFont(new Font("Footlight MT Light", Font.BOLD, 15));
		panelBotones.add(btnConciertos);

		JButton btnArtistas = new JButton("ARTISTAS");
		btnArtistas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Artista> artistas = App.res.getArtists();
				System.out.println(artistas);
				for (Artista arti : (List<Artista>) artistas) {
					System.out.println("Artista bueno bueno: " + arti);
				}
			}
		});
		btnArtistas.setFont(new Font("Footlight MT Light", Font.BOLD, 13));
		panelBotones.add(btnArtistas);

		JButton btnNewButton_2 = new JButton("ENTRADAS");
		btnNewButton_2.setFont(new Font("Footlight MT Light", Font.BOLD, 13));
		panelBotones.add(btnNewButton_2);

		JButton btnPerfilPeque = new JButton("");
		btnPerfilPeque.setBorder(null);
		btnPerfilPeque.setBorderPainted(false);
		btnPerfilPeque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfileWindow pw = new ProfileWindow();
				pw.initialize();
				frmMain.dispose();
			}
		});
		btnPerfilPeque.setIcon(logoPerfilPeque);
		btnPerfilPeque.setBounds(694, 10, 50, 50);
		frmMain.getContentPane().add(btnPerfilPeque);

		frmMain.setVisible(true);
	}
}