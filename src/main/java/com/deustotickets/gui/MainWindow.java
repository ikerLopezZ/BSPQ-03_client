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
//		    	conciertosListModel = new DefaultListModel<Concierto>();
		        ArrayList<Concierto> conciertos = App.res.getConcerts();
		        System.out.println(conciertos);
//		        int contador = 0;
//		        System.out.println(contador); 
		        for(Concierto c : conciertos) {
		        	System.out.println(c.getClass());
//		        	contador ++;
		        }
//		        System.out.println(contador);
//		        conciertosListModel.clear();
//		        for (Concierto concierto : conciertos) {
//		            conciertosListModel.addElement(concierto);
//		            System.out.println(concierto.toString());
//		        }
//		        JList<Concierto> conciertosList = new JList<>(conciertosListModel);
//		        panelDatos.add(new JScrollPane(conciertosList));
//		    	System.out.println(App.res.getConcerts());
		        System.out.println(conciertos);
//		    	ArrayList<Concierto> conciertos = new ArrayList<>();
//		    	conciertos = App.res.getConcerts();
//		    	for(Concierto con : conciertos) {
//		    		conciertosListModel.addElement(con);
//		    		System.out.println(con);
//		    	}
//		    	panelDatos.add(new JScrollPane(conciertos));
		    	
//		    	ArrayList<Concierto> conciertos = App.res.getConcerts();
//		        JTextArea textArea = new JTextArea(10, 30);
//		        textArea.setBounds(0, 57, 600, 400);
//		        textArea.setBackground(Color.yellow);
//		        textArea.append(conciertos.toString());
//		        for (Concierto concierto : conciertos) {
//		            textArea.append(concierto.toString() + "\n");
//		        }
		        
//		        panelDatos.removeAll(); // Limpiamos el panel
//		        panelDatos.add(textArea); // Añadimos el JTextArea al panel
//		        panelDatos.revalidate(); // Redibujamos el panel
//		        panelDatos.repaint();
		    }
		});
		btnConciertos.setFont(new Font("Footlight MT Light", Font.BOLD, 15));
		panelBotones.add(btnConciertos);

		JButton btnArtistas = new JButton("ARTISTAS");
		btnArtistas.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       ArrayList<Artista> artistas = App.res.getArtists();
		       System.out.println(artistas);
		       for(Artista arti : (List<Artista>) artistas) {
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