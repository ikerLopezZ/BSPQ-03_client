package com.deustotickets.gui;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.*;

@SuppressWarnings("rawtypes")
public class MainWindow {
	private static JFrame frmMain;
	private static JTextField txtTituloSesion;
	private static JSpinner kmRecorridosSesion;
	private static JTextField txtFechaInicioSesion;
	private static JTextField txtHoraInicioSesion;
	private static JSpinner duracionSesion;
	private static JTextField txtNombreReto;
	private static JTextField txtFechaInicioReto;
	private static JTextField txtFechaFinReto;
	private static JSpinner distanciaReto;
	private static JSpinner tiempoObjetivoReto;
	private static JTextField txtBuscarRetos;
	private static JList listMisSesiones;
	private static JList listGeneralSesionesEnt;
	private static JList listRetosGeneral;
	private static JList listMisRetos;
	public static DefaultListModel<SesionDTO> dlmMisSesiones;
	public static DefaultListModel<SesionDTO> dlmSesionesGeneral;
	public static DefaultListModel<RetoDTO> dlmMisRetos;
	public static DefaultListModel<RetoDTO> dlmRetosGeneral;
	public static DefaultListModel<RetoDTO> dlmRetosFechaFin;
	private static ImageIcon logo = new ImageIcon("images/logo_1.png");

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	@SuppressWarnings({ "unchecked" })
	public static void initialize() {
		frmMain = new JFrame();
		frmMain.setTitle("Strava - Ventana principal");
		frmMain.setBounds(100, 100, 650, 900);
		frmMain.setResizable(false);
		frmMain.setLocationRelativeTo(null);
		frmMain.setIconImage(logo.getImage());
		frmMain.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 634, 839);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tabbedPane.setFocusable(false);
		frmMain.getContentPane().add(tabbedPane);

		JPanel sesion = new JPanel();
		sesion.setLayout(new GridLayout(3, 2, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Sesiones", scrollPane);
		scrollPane.setViewportView(sesion);

		JPanel registroSesion = new JPanel();
		sesion.add(registroSesion);

		JButton addsesion = new JButton("Crear");
		addsesion.setFocusPainted(false);
		registroSesion.setLayout(new GridLayout(0, 1, 0, 0));

		Label label = new Label("Crear una nueva sesion de entrenamiento");
		registroSesion.add(label);

		JLabel lblNewLabel_1 = new JLabel("Titulo");
		registroSesion.add(lblNewLabel_1);

		txtTituloSesion = new JTextField();
		txtTituloSesion = Utils.modifyTextField(txtTituloSesion, "NuevaSesion");
		registroSesion.add(txtTituloSesion);
		txtTituloSesion.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Deporte");
		registroSesion.add(lblNewLabel_2);

		JComboBox comboDeporteSesion = new JComboBox();
		comboDeporteSesion.addItem(TipoDeporte.CICLISMO);
		comboDeporteSesion.addItem(TipoDeporte.RUNNING);
		comboDeporteSesion.setFocusable(false);
		registroSesion.add(comboDeporteSesion);

		JLabel lblNewLabel_3 = new JLabel("Kilometros recorridos");
		registroSesion.add(lblNewLabel_3);

		kmRecorridosSesion = new JSpinner();
		kmRecorridosSesion = Utils.modifySpinner(kmRecorridosSesion);
		registroSesion.add(kmRecorridosSesion);

		JLabel lblNewLabel_4 = new JLabel("Fecha de inicio");
		registroSesion.add(lblNewLabel_4);

		txtFechaInicioSesion = new JTextField();
		txtFechaInicioSesion = Utils.modifyTextField(txtFechaInicioSesion, "dd/mm/aaaa");
		registroSesion.add(txtFechaInicioSesion);
		txtFechaInicioSesion.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Hora de inicio");
		registroSesion.add(lblNewLabel_5);

		txtHoraInicioSesion = new JTextField();
		txtHoraInicioSesion = Utils.modifyTextField(txtHoraInicioSesion, "hh:mm");
		registroSesion.add(txtHoraInicioSesion);
		txtHoraInicioSesion.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Duracion en minutos");
		registroSesion.add(lblNewLabel_6);

		duracionSesion = new JSpinner();
		duracionSesion = Utils.modifySpinner(duracionSesion);
		registroSesion.add(duracionSesion);
		registroSesion.add(addsesion);

		JPanel listaSesionesEnt = new JPanel();
		sesion.add(listaSesionesEnt);
		listaSesionesEnt.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Mis sesiones de entrenamiento");
		listaSesionesEnt.add(lblNewLabel, BorderLayout.NORTH);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		listaSesionesEnt.add(scrollPane_1, BorderLayout.CENTER);
		
		listMisSesiones = new JList();
		scrollPane_1.setViewportView(listMisSesiones);

		JPanel sesionesGeneral = new JPanel();
		sesion.add(sesionesGeneral);
		sesionesGeneral.setLayout(new BorderLayout(0, 0));

		JLabel lblSesionesGeneral = new JLabel("Lista general de sesiones de entrenamiento");
		sesionesGeneral.add(lblSesionesGeneral, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		sesionesGeneral.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		sesionesGeneral.add(scrollPane_2, BorderLayout.CENTER);
		
		listGeneralSesionesEnt = new JList();
		scrollPane_2.setViewportView(listGeneralSesionesEnt);

		JPanel retos = new JPanel();
		retos.setLayout(new GridLayout(3, 1, 0, 0));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		tabbedPane.addTab("Retos", scrollPane_3);
		scrollPane_3.setViewportView(retos);

		JPanel nuevoReto = new JPanel();
		retos.add(nuevoReto);
		nuevoReto.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblCrearReto = new JLabel("Crear un nuevo reto");
		nuevoReto.add(lblCrearReto);

		JLabel lblNewLabel_10 = new JLabel("Nombre");
		nuevoReto.add(lblNewLabel_10);

		txtNombreReto = new JTextField();
		txtNombreReto = Utils.modifyTextField(txtNombreReto, "NuevoReto");
		nuevoReto.add(txtNombreReto);
		txtNombreReto.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("Fecha de inicio");
		nuevoReto.add(lblNewLabel_11);

		txtFechaInicioReto = new JTextField();
		txtFechaInicioReto = Utils.modifyTextField(txtFechaInicioReto, "dd/mm/aaaa");
		nuevoReto.add(txtFechaInicioReto);
		txtFechaInicioReto.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("Fecha de fin");
		nuevoReto.add(lblNewLabel_12);

		txtFechaFinReto = new JTextField();
		txtFechaFinReto = Utils.modifyTextField(txtFechaFinReto, "dd/mm/aaaa");
		nuevoReto.add(txtFechaFinReto);
		txtFechaFinReto.setColumns(10);

		JLabel lblNewLabel_13 = new JLabel("Distancia");
		nuevoReto.add(lblNewLabel_13);

		distanciaReto = new JSpinner();
		distanciaReto = Utils.modifySpinner(distanciaReto);
		nuevoReto.add(distanciaReto);

		JLabel lblNewLabel_14 = new JLabel("Tiempo objetivo");
		nuevoReto.add(lblNewLabel_14);

		tiempoObjetivoReto = new JSpinner();
		tiempoObjetivoReto = Utils.modifySpinner(tiempoObjetivoReto);
		nuevoReto.add(tiempoObjetivoReto);

		JLabel lblNewLabel_15 = new JLabel("Deporte");
		nuevoReto.add(lblNewLabel_15);

		JComboBox comboDeporteReto = new JComboBox();
		comboDeporteReto.addItem(TipoDeporte.CICLISMO);
		comboDeporteReto.addItem(TipoDeporte.RUNNING);
		comboDeporteReto.setFocusable(false);
		nuevoReto.add(comboDeporteReto);

		JButton btnCrearReto = new JButton("Crear");
		btnCrearReto.setFocusPainted(false);
		nuevoReto.add(btnCrearReto);

		JPanel misRetos = new JPanel();
		retos.add(misRetos);
		misRetos.setLayout(new BorderLayout(0, 0));

		JLabel lblapuntarseReto = new JLabel("Mis retos");
		misRetos.add(lblapuntarseReto, BorderLayout.NORTH);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		misRetos.add(scrollPane_4, BorderLayout.CENTER);
		
		listMisRetos = new JList();
		scrollPane_4.setViewportView(listMisRetos);

		JPanel retosGeneral = new JPanel();
		retos.add(retosGeneral);
		retosGeneral.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		retosGeneral.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_7 = new JLabel("Lista general de retos");
		panel.add(lblNewLabel_7, BorderLayout.NORTH);

		txtBuscarRetos = new JTextField();
		txtBuscarRetos = Utils.modifyTextField(txtBuscarRetos, "dd/mm/aaaa");
		panel.add(txtBuscarRetos, BorderLayout.CENTER);
		txtBuscarRetos.setColumns(10);

		JButton btnBuscarRetos = new JButton("Buscar");
		btnBuscarRetos.setFocusPainted(false);
		panel.add(btnBuscarRetos, BorderLayout.EAST);
		
		JButton btnApuntarse = new JButton("Apuntarse");
		btnApuntarse.setFocusPainted(false);
		panel.add(btnApuntarse, BorderLayout.SOUTH);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		retosGeneral.add(scrollPane_5, BorderLayout.CENTER);
		
		listRetosGeneral = new JList();
		scrollPane_5.setViewportView(listRetosGeneral);

		JMenuBar menuBar = new JMenuBar();
		frmMain.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Usuario");
		menuBar.add(mnNewMenu);

		addsesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SesionDTO s = new SesionDTO();
				s.setTitulo(txtTituloSesion.getText());
				s.setDeporte((TipoDeporte) comboDeporteSesion.getSelectedItem());
				s.setDistancia(Double.valueOf(kmRecorridosSesion.getValue().toString()));
				s.setFechaHora(txtFechaInicioSesion.getText() + " " + txtHoraInicioSesion.getText());
				s.setDuracion((Integer) duracionSesion.getValue());
				MainProgram.mainController.crearSesion(MainProgram.loginController.getToken(), s);
				List<SesionDTO> sesiones = MainProgram.mainController.obtenerSesiones();
				List<SesionDTO> sesionesUsuario = MainProgram.mainController.obtenerSesionesUsuario(MainProgram.loginController.getToken());
				dlmMisSesiones = new DefaultListModel<SesionDTO>();
				dlmSesionesGeneral = new DefaultListModel<SesionDTO>();

				for (SesionDTO sesion : sesiones) {
					System.out.println(sesion.toString());
					dlmSesionesGeneral.addElement(sesion);
				}

				for (SesionDTO sesion : sesionesUsuario) {
					System.out.println(sesion.toString());
					dlmMisSesiones.addElement(sesion);
				}

				listMisSesiones.setModel(dlmMisSesiones);
				listGeneralSesionesEnt.setModel(dlmSesionesGeneral);
			}
		});

		btnCrearReto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RetoDTO r = new RetoDTO();
				r.setNombre(txtNombreReto.getText());
				r.setFechaI(txtFechaInicioReto.getText());
				r.setFechaF(txtFechaFinReto.getText());
				r.setDistancia(Double.valueOf(distanciaReto.getValue().toString()));
				r.setDeporte((TipoDeporte) comboDeporteReto.getSelectedItem());
				r.setTiempoObjetivo((Integer) tiempoObjetivoReto.getValue());
				MainProgram.mainController.crearReto(MainProgram.loginController.getToken(), r);
				List<RetoDTO> retos = MainProgram.mainController.obtenerRetos();
				List<RetoDTO> retosUsuario = MainProgram.mainController.obtenerRetosUsuario(MainProgram.loginController.getToken());
				dlmMisRetos = new DefaultListModel<RetoDTO>();
				dlmRetosGeneral = new DefaultListModel<RetoDTO>();

				for (RetoDTO reto : retos) {
					System.out.println(reto.toString());
					dlmRetosGeneral.addElement(reto);
				}

				for (RetoDTO reto : retosUsuario) {
					System.out.println(reto.toString());
					dlmMisRetos.addElement(reto);
				}	
				listRetosGeneral.setModel(dlmRetosGeneral);
				listMisRetos.setModel(dlmMisRetos);
			}
		});

		btnBuscarRetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtBuscarRetos.getText().equals("dd/mm/aaaa") || txtBuscarRetos.getText().equals("")) {
					List<RetoDTO> retos = MainProgram.mainController.obtenerRetos();
					dlmMisRetos = new DefaultListModel<RetoDTO>();

					for (RetoDTO reto : retos) {
						System.out.println(reto.toString());
						dlmMisRetos.addElement(reto);
					}
					listRetosGeneral.setModel(dlmMisRetos);				
				} else {
					List<RetoDTO> retos = MainProgram.mainController.obtenerRetosActivosFecha(txtBuscarRetos.getText());
					dlmRetosFechaFin = new DefaultListModel<RetoDTO>();
					for (RetoDTO reto : retos) {
						System.out.println(reto.toString());
						dlmRetosFechaFin.addElement(reto);
					}
					listRetosGeneral.setModel(dlmRetosFechaFin);
				}
			}
		});
		
		
		btnApuntarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainProgram.mainController.aceptarReto(MainProgram.loginController.getToken(), (RetoDTO) listRetosGeneral.getSelectedValue());
				dlmMisRetos.addElement((RetoDTO) listRetosGeneral.getSelectedValue());
				listMisRetos.setModel(dlmMisRetos);
			}
		});

		JMenuItem mntmLogout = new JMenuItem("Cerrar sesion");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainProgram.loginController.logout();
				LoginWindow.initialize();
				frmMain.dispose();
			}
		});
		
		mnNewMenu.add(mntmLogout);
		loadWindow();
		frmMain.setVisible(true);
	}
	
	@SuppressWarnings("unchecked")
	public static void loadWindow() {
		List<SesionDTO> sesiones = MainProgram.mainController.obtenerSesiones();
		List<SesionDTO> sesionesUsuario = MainProgram.mainController.obtenerSesionesUsuario(MainProgram.loginController.getToken());
		dlmMisSesiones = new DefaultListModel<SesionDTO>();
		dlmSesionesGeneral = new DefaultListModel<SesionDTO>();

		for (SesionDTO sesion : sesiones) {
			System.out.println(sesion.toString());
			dlmSesionesGeneral.addElement(sesion);
		}

		for (SesionDTO sesion : sesionesUsuario) {
			System.out.println(sesion.toString());
			dlmMisSesiones.addElement(sesion);
		}
		
		listMisSesiones.setModel(dlmMisSesiones);
		listGeneralSesionesEnt.setModel(dlmSesionesGeneral);
		
		List<RetoDTO> retos = MainProgram.mainController.obtenerRetos();
		List<RetoDTO> retosUsuario = MainProgram.mainController.obtenerRetosUsuario(MainProgram.loginController.getToken());
		dlmMisRetos = new DefaultListModel<RetoDTO>();
		dlmRetosGeneral = new DefaultListModel<RetoDTO>();

		for (RetoDTO reto : retos) {
			System.out.println(reto.toString());
			dlmRetosGeneral.addElement(reto);
		}

		for (RetoDTO reto : retosUsuario) {
			System.out.println(reto.toString());
			dlmMisRetos.addElement(reto);
		}
		
		listRetosGeneral.setModel(dlmRetosGeneral);
		listMisRetos.setModel(dlmMisRetos);
	}
}