package com.deustotickets.gui;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.deustotickets.app.App;
import com.deustotickets.client.Resource;
import com.deustotickets.domain.Usuario;
import com.deustotickets.domain.Artista;
import com.deustotickets.domain.Concierto;
import com.deustotickets.domain.Entrada;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 * Class that manages the main window.
 * 
 * @author BSPQ-03
 */
public class MainWindow {
	private static JFrame frmMain;
	private static ImageIcon logo = new ImageIcon("src/main/resources/images/deustotickets_logo.png");
	private static ImageIcon logoPerfil = new ImageIcon("src/main/resources/images/logoPerfil.png");
	private static ImageIcon logoPerfilPeque = new ImageIcon("src/main/resources/images/logoPerfilPeque.png");
	private static ImageIcon inicio = new ImageIcon("src/main/resources/images/inicio.png");
	public static Usuario logged = null;
	private static DefaultListModel<Concierto> conciertosListModel;
	private static JList<Concierto> conciertosList;
	private static JScrollPane conciertosScrollPane;
	private static DefaultListModel<Artista> artistasListModel;
	private static JList<Artista> artistasList;
	private static JScrollPane artistasScrollPane;
	private static DefaultListModel<Artista> artistasFavoritosListModel;
	private static JList<Artista> artistasFavoritosList;
	private static JScrollPane artistasFavoritosScrollPane;
	private static DefaultListModel<Usuario> usuariosListModel;
	private static DefaultListModel<Entrada> entradasPasadasListModel;
	private static DefaultListModel<Entrada> entradasFuturasListModel;
	private static JList<Usuario> usuariosList;
	private static JList<Entrada> entradasPasadasList;
	private static JList<Entrada> entradasFuturasList;	
	private static JScrollPane usuariosScrollPane;
	private static JScrollPane entradasPasadasScrollPane;
	private static JScrollPane entradasFuturasScrollPane;
	private static String fechaActual = DateTimeFormatter.ofPattern("dd-MM-yyyy").format(LocalDateTime.now());
	private static String informeEstadisticas = "Informe Estadísticas DeustoTickets - " + fechaActual + ".txt";
	private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	

//	/**
//	 * @wbp.parser.entryPoint
//	 */
	public Usuario getLogged() {
		return logged;
	}

	/**
	 * @wbp.parser.entryPoint
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

		JLabel lblEntradasPasadas = new JLabel("ENTRADAS DE CONCIERTOS PASADOS");
		lblEntradasPasadas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntradasPasadas.setFont(new Font("Footlight MT Light", Font.BOLD, 14));
		lblEntradasPasadas.setBounds(153, 10, 320, 31);
		lblEntradasPasadas.setVisible(false);
		panelDatos.add(lblEntradasPasadas);

		JLabel lblEntradasFuturas = new JLabel("ENTRADAS DE CONCIERTOS FUTUROS");
		lblEntradasFuturas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntradasFuturas.setFont(new Font("Footlight MT Light", Font.BOLD, 14));
		lblEntradasFuturas.setBounds(153, 210, 320, 31);
		lblEntradasFuturas.setVisible(false);
		panelDatos.add(lblEntradasFuturas);

		JLabel lblArtistasFavositos = new JLabel("MIS ARTISTAS FAVORITOS");
		lblArtistasFavositos.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtistasFavositos.setFont(new Font("Footlight MT Light", Font.BOLD, 24));
		lblArtistasFavositos.setBounds(175, 10, 300, 31);
		lblArtistasFavositos.setVisible(false);
		panelDatos.add(lblArtistasFavositos);

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

		JButton btnFavoritos = new JButton("FAVORITOS");
		btnFavoritos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ArrayList<Artista> artistas = App.res.getArtists();
				for (Artista artista : artistas) {
					artistasFavoritosListModel.addElement(artista);
				}

				System.out.println(artistasFavoritosList);
			}
		});

		btnFavoritos.setBounds(576, 56, 70, 20);
		btnFavoritos.setVisible(false);
		panelDatos.add(btnFavoritos);

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
		
		JButton btnComprarEntrada = new JButton("Comprar entrada");
		btnComprarEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ArrayList<Concierto> conciertos = App.res.getConcerts();s
				int idEntradaCon = conciertosList.getSelectedValue().getAforo() - conciertosList.getSelectedValue().getEntradasDisponibles() + 1;
				String idEntrada = Integer.toString(idEntradaCon);
				Entrada nuevaEntrada = new Entrada(idEntrada, conciertosList.getSelectedValue(), conciertosList.getSelectedValue().getAforo()/50, ("Entrada concierto " + conciertosList.getSelectedValue().getArtista()));
				App.res.buyTicket(nuevaEntrada);
				System.out.println(logged.getMisEntradas());
			}
		});
		btnComprarEntrada.setBounds(313, 407, 111, 21);
		btnFavoritos.setVisible(false);
		panelDatos.add(btnComprarEntrada);

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

		// Crear el JScrollPane y la JList de artistas fvaoritos
		artistasFavoritosListModel = new DefaultListModel<Artista>();
		artistasFavoritosList = new JList<>(artistasFavoritosListModel);
		artistasFavoritosScrollPane = new JScrollPane(artistasFavoritosList);
		artistasFavoritosScrollPane.setBounds(80, 45, 501, 150);
		artistasFavoritosScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		artistasFavoritosScrollPane.setViewportView(artistasFavoritosList);

		// Crear el JScrollPane y la JList de usuarios
		usuariosListModel = new DefaultListModel<Usuario>();
		usuariosList = new JList<>(usuariosListModel);
		usuariosScrollPane = new JScrollPane(usuariosList);
		usuariosScrollPane.setBounds(80, 245, 501, 150);
		usuariosScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		usuariosScrollPane.setViewportView(usuariosList);

		// Crear el JScrollPane y la JList de entradas pasadas
		entradasPasadasListModel = new DefaultListModel<Entrada>();
		entradasPasadasList = new JList<>(entradasPasadasListModel);
		entradasPasadasScrollPane = new JScrollPane(entradasPasadasList);
		entradasPasadasScrollPane.setBounds(80, 45, 501, 150);
		entradasPasadasScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		entradasPasadasScrollPane.setViewportView(entradasPasadasList);

		// Crear el JScrollPane y la JList de entradas futuras
		entradasFuturasListModel = new DefaultListModel<Entrada>();
		entradasFuturasList = new JList<>(entradasFuturasListModel);
		entradasFuturasScrollPane = new JScrollPane(entradasFuturasList);
		entradasFuturasScrollPane.setBounds(80, 245, 501, 150);
		entradasFuturasScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		entradasFuturasScrollPane.setViewportView(entradasFuturasList);

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
				App.res.generateReport(informeEstadisticas, App.res.getUsers(), App.res.getConcerts(),
						App.res.getArtists());
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
				lblEntradasFuturas.setVisible(false);
				lblEntradasPasadas.setVisible(false);
				entradasPasadasScrollPane.setVisible(false);
				entradasFuturasScrollPane.setVisible(false);
				// artistasListModel.clear();
				lblArtistasFavositos.setVisible(false);
				lblProximosConciertos.setVisible(true);
				lblArtistas.setVisible(false);
				lblUsuarios.setVisible(false);
				btnFavoritos.setVisible(false);
				btnBuscarConcierto.setVisible(true);
				btnTodosConciertos.setVisible(true);
				btnFavoritos.setVisible(true);
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
				lblEntradasFuturas.setVisible(false);
				lblEntradasPasadas.setVisible(false);
				entradasPasadasScrollPane.setVisible(false);
				entradasFuturasScrollPane.setVisible(false);
				lblArtistasFavositos.setVisible(false);
				lblProximosConciertos.setVisible(false);
				lblArtistas.setVisible(true);
				lblUsuarios.setVisible(true);
				btnFavoritos.setVisible(true);
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

		JButton btnEntradas = new JButton("ENTRADAS");
		btnEntradas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFavoritos.setVisible(false);
				btnBuscarConcierto.setVisible(false);
				btnTodosConciertos.setVisible(false);
				lblProximosConciertos.setVisible(false);
				lblArtistas.setVisible(false);
				lblUsuarios.setVisible(false);
				lblArtistasFavositos.setVisible(false);
				lblEntradasFuturas.setVisible(true);
				lblEntradasPasadas.setVisible(true);
				entradasPasadasScrollPane.setVisible(true);
				entradasFuturasScrollPane.setVisible(true);
				entradasFuturasListModel.clear();
				entradasFuturasListModel.clear();
				usuariosScrollPane.setVisible(false);
				artistasScrollPane.setVisible(false);
				conciertosScrollPane.setVisible(false);
				artistasFavoritosScrollPane.setVisible(false);
				artistasListModel.clear();
				conciertosListModel.clear();
				usuariosListModel.clear();
				panelDatos.add(entradasPasadasScrollPane, BorderLayout.CENTER);
				panelDatos.add(entradasFuturasScrollPane, BorderLayout.CENTER);
				
				ArrayList<Entrada> entradas = logged.getMisEntradas();
				Date fechaHoy = new Date();	//Fecha actual
				for (Entrada entrada: entradas) {
					Date fechaConcierto;
					try {
						fechaConcierto = dateFormat.parse(entrada.getConcierto().getFecha());
						
						if(fechaConcierto.compareTo(fechaHoy) > 0) {	//El concierto es posterior a hoy
							entradasFuturasListModel.addElement(entrada);
						} else if (fechaConcierto.compareTo(fechaHoy) < 0){
							entradasPasadasListModel.addElement(entrada);
						} else {
							System.out.println("¡Hoy tienes un concierto! Aquí tienes la entrada: " + entrada.getNombre());
						}
					} catch (ParseException e1) {
						System.out.println("Error analizando la fecha: " +e1.getMessage());
					}
					
				}
				
				entradasPasadasList.setModel(entradasPasadasListModel);
				entradasFuturasList.setModel(entradasFuturasListModel);
			}
		});
		btnEntradas.setFont(new Font("Footlight MT Light", Font.BOLD, 13));
		panelBotones.add(btnEntradas);

		JButton btnArtistasFavoritos = new JButton("ARTISTAS FAVORITOS");
		btnArtistasFavoritos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				artistasFavoritosListModel.clear();
				artistasFavoritosScrollPane.setVisible(true);
				artistasScrollPane.setVisible(false);
				usuariosScrollPane.setVisible(false);
				conciertosScrollPane.setVisible(false);
				lblEntradasFuturas.setVisible(false);
				lblEntradasPasadas.setVisible(false);
				entradasPasadasScrollPane.setVisible(false);
				entradasFuturasScrollPane.setVisible(false);
				btnFavoritos.setVisible(false);
				lblArtistas.setVisible(false);
				lblProximosConciertos.setVisible(false);
				lblUsuarios.setVisible(false);
				lblArtistasFavositos.setVisible(true);
				panelDatos.add(artistasFavoritosScrollPane, BorderLayout.CENTER);

				ArrayList<Artista> artistas = App.res.getArtists();

				for (Artista artista : artistas) {
					artistasFavoritosListModel.addElement(artista);
				}

				artistasFavoritosList.setModel(artistasFavoritosListModel);
			}
		});
		panelBotones.add(btnArtistasFavoritos);

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
