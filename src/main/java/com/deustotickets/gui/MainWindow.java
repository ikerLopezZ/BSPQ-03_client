package com.deustotickets.gui;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.deustotickets.app.App;
import com.deustotickets.client.Resource;
import com.deustotickets.domain.Usuario;
import com.deustotickets.domain.Artista;
import com.deustotickets.domain.Concierto;
import com.deustotickets.domain.TipoUsuario;

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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	private static DefaultListModel<Artista> artistasListModel;
	private static JList<Artista> artistasList;
	private static JScrollPane artistasScrollPane;
	private static DefaultListModel<Usuario> usuariosListModel;
	private static JList<Usuario> usuariosList;
	private static JScrollPane usuariosScrollPane;
	private static String fechaActual = DateTimeFormatter.ofPattern("dd-MM-yyyy").format(LocalDateTime.now());
	private static String informeEstadisticas = "Informe Estadísticas DeustoTickets - " + fechaActual;

	/**
	 * @wbp.parser.entryPoint
	 * 
	 */
	
	public Usuario getLogged() {
		return logged;
	}
	
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
		lblProximosConciertos.setBounds(175, 10, 279, 31);
		lblProximosConciertos.setVisible(false);
		panelDatos.add(lblProximosConciertos);

		JLabel lblArtistas = new JLabel("ARTISTAS EN DEUSTOTICKETS");
		lblArtistas.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtistas.setFont(new Font("Footlight MT Light", Font.BOLD, 24));
		lblArtistas.setBounds(153, 10, 320, 31);
		lblArtistas.setVisible(false);
		panelDatos.add(lblArtistas);

		JLabel lblUsuarios = new JLabel("USUARIOS EN DEUSTOTICKETS");
		lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarios.setFont(new Font("Footlight MT Light", Font.BOLD, 24));
		lblUsuarios.setBounds(153, 210, 320, 31);
		lblUsuarios.setVisible(false);
		panelDatos.add(lblUsuarios);

		JButton btnBuscarConcierto = new JButton("Buscar concierto");
		btnBuscarConcierto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomArtista = JOptionPane.showInputDialog(btnBuscarConcierto,
						"Nombre del artista o lugar del concierto");
				ArrayList<Concierto> conciertos = App.res.getConcerts();

				conciertosListModel.clear();
				for (Concierto concierto : conciertos) {
					String nom = concierto.getArtista().getNombreApellidos();
					if (nom.equals(nomArtista) || nomArtista.equals(concierto.getLugar())) {

						conciertosListModel.addElement(concierto);
					}

				}
			}
		});
		btnBuscarConcierto.setBounds(175, 407, 128, 21);
		btnBuscarConcierto.setVisible(false);
		panelDatos.add(btnBuscarConcierto);

		JButton btnTodosConciertos = new JButton("Mostrar todos");
		btnTodosConciertos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Concierto> conciertos = App.res.getConcerts();
				conciertosListModel.clear();
				for (Concierto concierto : conciertos) {

					conciertosListModel.addElement(concierto);
				}
			}
		});
		btnTodosConciertos.setBounds(434, 407, 128, 21);
		btnTodosConciertos.setVisible(false);
		panelDatos.add(btnTodosConciertos);

		// Crear el JScrollPane y la JList de conciertos
		conciertosListModel = new DefaultListModel<Concierto>();
		conciertosList = new JList<>(conciertosListModel);
		conciertosScrollPane = new JScrollPane(conciertosList);
		conciertosScrollPane.setBounds(80, 45, 501, 150);
		conciertosScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		conciertosScrollPane.setViewportView(conciertosList);

		// Crear el JScrollPane y la JList de artistas
		artistasListModel = new DefaultListModel<Artista>();
		artistasList = new JList<>(artistasListModel);
		artistasScrollPane = new JScrollPane(artistasList);
		artistasScrollPane.setBounds(80, 45, 501, 150);
		artistasScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		artistasScrollPane.setViewportView(artistasList);

		// Crear el JScrollPane y la JList de usuarios
		usuariosListModel = new DefaultListModel<Usuario>();
		usuariosList = new JList<>(usuariosListModel);
		usuariosScrollPane = new JScrollPane(usuariosList);
		usuariosScrollPane.setBounds(80, 245, 501, 150);
		usuariosScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		usuariosScrollPane.setViewportView(usuariosList);

		JPanel panelControlPerfil = new JPanel();
		panelControlPerfil.setBounds(0, 495, 656, 68);
		panelPantalla.add(panelControlPerfil);
		panelControlPerfil.setLayout(new GridLayout(0, 3, 0, 0));

		JButton btnVerificar = new JButton("VERIFICAR ARTISTA");
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(App.res.getUsers());
				App.res.verifyArtist(artistasList.getSelectedValue().getEmail());
				System.out.println(App.res.getUsers());
			}
		});
		if (logged.getTipo() == TipoUsuario.GESTOR) {
			panelControlPerfil.add(btnVerificar);
		}

		JButton btnBloquearUsuario = new JButton("BLOQUEAR USUARIO");
		btnBloquearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(App.res.getUsers());
				if (usuariosList.getSelectedValue() != null) {
					App.res.banUser(usuariosList.getSelectedValue().getEmail());
				} else if (artistasList.getSelectedValue() != null) {
					App.res.banUser(artistasList.getSelectedValue().getEmail());
				}
				System.out.println(App.res.getUsers());
			}
		});
		if (logged.getTipo() == TipoUsuario.GESTOR) {
			panelControlPerfil.add(btnBloquearUsuario);
		}
		
		JButton btnEstadisticas = new JButton("GENERAR ESTADÍSTICAS");
		btnEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App.res.generateReport(informeEstadisticas, App.res.getUsers(), App.res.getConcerts(), App.res.getArtists());
			}
		});
		if (logged.getTipo() == TipoUsuario.GESTOR) {
			panelControlPerfil.add(btnEstadisticas);
		}
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLocation(655, 70);
		panelBotones.setSize(131, 493);
		frmMain.getContentPane().add(panelBotones);
		panelBotones.setLayout(new GridLayout(4, 1, 0, 0));

		JButton btnConciertos = new JButton("CONCIERTOS");
		btnConciertos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conciertosListModel.clear();
				artistasScrollPane.setVisible(false);
				usuariosScrollPane.setVisible(false);
				conciertosScrollPane.setVisible(true);
				// artistasListModel.clear();
				lblProximosConciertos.setVisible(true);
				lblArtistas.setVisible(false);
				lblUsuarios.setVisible(false);
				btnBuscarConcierto.setVisible(true);
				btnTodosConciertos.setVisible(true);
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
				// conciertosListModel.clear();
				conciertosScrollPane.setVisible(false);
				artistasScrollPane.setVisible(true);
				usuariosScrollPane.setVisible(true);
				artistasListModel.clear();
				usuariosListModel.clear();
				lblProximosConciertos.setVisible(false);
				lblArtistas.setVisible(true);
				lblUsuarios.setVisible(true);
				btnBuscarConcierto.setVisible(false);
				btnTodosConciertos.setVisible(false);
				panelDatos.add(artistasScrollPane, BorderLayout.CENTER);
				panelDatos.add(usuariosScrollPane, BorderLayout.CENTER);
				ArrayList<Artista> artistas = App.res.getArtists();
//				System.out.println(artistas);
				for (Artista artista : artistas) {
					artistasListModel.addElement(artista);
				}

				ArrayList<Usuario> usuarios = App.res.getUsers();
				for (Usuario usuario : usuarios) {
					usuariosListModel.addElement(usuario);
				}

				artistasList.setModel(artistasListModel);
				usuariosList.setModel(usuariosListModel);

			}
		});
		btnArtistas.setFont(new Font("Footlight MT Light", Font.BOLD, 13));
		panelBotones.add(btnArtistas);

		JButton btnNewButton_2 = new JButton("ENTRADAS");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBuscarConcierto.setVisible(false);
				btnTodosConciertos.setVisible(false);
				lblProximosConciertos.setVisible(false);
				lblArtistas.setVisible(false);
				lblUsuarios.setVisible(false);
				usuariosScrollPane.setVisible(false);
				artistasScrollPane.setVisible(false);
				conciertosScrollPane.setVisible(false);
				artistasListModel.clear();
				conciertosListModel.clear();
				usuariosListModel.clear();
			}
		});
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
