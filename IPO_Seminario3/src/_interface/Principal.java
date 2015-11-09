package _interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;

public class Principal {

	private JFrame frame;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(new Rectangle(0, 0, 700, 700));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		desktopPane = new JDesktopPane();
		desktopPane.setOpaque(false);
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		VentanaLista v1 = new VentanaLista();
		desktopPane.add(v1);
		v1.setVisible(true);
		
		VentanaTabla v2 = new VentanaTabla();
		desktopPane.add(v2);
		v2.setVisible(true);
	}

}
