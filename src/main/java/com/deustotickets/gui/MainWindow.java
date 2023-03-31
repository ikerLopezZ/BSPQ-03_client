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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 10, 101, 22);
		frmMain.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cuenta");
		mnNewMenu.setBounds(121, 8, 91, 24);
		frmMain.getContentPane().add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cerrar Sesion");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Resource.closeSession();
				frmMain.dispose();
				LoginWindow lw = new LoginWindow();
				lw.initialize();
				
				
			}
		});

		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cambiar contraseña");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Cambiar usuario");
		mnNewMenu.add(mntmNewMenuItem_2);
		menuBar.add(mnNewMenu);
		
		frmMain.setVisible(true);
	}
}