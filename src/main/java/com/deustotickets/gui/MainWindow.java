package com.deustotickets.gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

import com.deustotickets.client.Resource;
import com.deustotickets.domain.Usuario;
import javax.swing.JScrollPane;
import javax.swing.text.View;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author BSPQ-03
 *
 */
public class MainWindow {
	private static JFrame frmMain;
	private static ImageIcon logo = new ImageIcon("images/deustotickets_logo.png");
	public static Usuario logged = null;
	/**
	 * @wbp.parser.entryPoint
	 * 
	 */
	public static void initialize() {
		frmMain = new JFrame();
		frmMain.setTitle("DeustoTickets - Ventana principal");
		frmMain.setBounds(100, 100, 1600, 1200);
		frmMain.setResizable(false);
		frmMain.setLocationRelativeTo(null);
		frmMain.setIconImage(logo.getImage());
		frmMain.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 61, 625, 549);
		frmMain.getContentPane().add(panel);
		
		JMenu mnNewMenu = new JMenu("Cuenta");
		panel.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cerrar Sesion");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cambiar contraseña");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Cambiar usuario");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 10, 101, 22);
		frmMain.getContentPane().add(menuBar);
		
		menuBar.add(mnNewMenu);

		
		frmMain.setVisible(true);
	}
}