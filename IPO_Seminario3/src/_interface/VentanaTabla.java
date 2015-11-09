package _interface;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTable;

public class VentanaTabla extends JInternalFrame {
	private JToolBar toolBar;
	private JButton btnAadir;
	private JButton btnEliminar;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTextArea taFilaSeleccionada;
	private JLabel lblFoto;
	private JScrollPane scrollPane_1;
	private JTable miTabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaTabla frame = new VentanaTabla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaTabla() {
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setFrameIcon(new ImageIcon(VentanaTabla.class.getResource("/_interface/iconoFrame.jpg")));
		setTitle("Ejemplo Tabla");
		setBounds(new Rectangle(200, 200, 400, 400));
		//setBounds(100, 100, 450, 300);
		
		toolBar = new JToolBar();
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		btnAadir = new JButton("A\u00F1adir");
		btnAadir.setIcon(new ImageIcon(VentanaTabla.class.getResource("/_interface/ic_menu_btn_add.png")));
		toolBar.add(btnAadir);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(VentanaTabla.class.getResource("/_interface/ic_menu_delete.png")));
		toolBar.add(btnEliminar);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(50, 120));
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		lblFoto = new JLabel("");
		scrollPane.setViewportView(lblFoto);
		
		taFilaSeleccionada = new JTextArea();
		panel.add(taFilaSeleccionada);
		
		scrollPane_1 = new JScrollPane();
		getContentPane().add(scrollPane_1, BorderLayout.CENTER);
		
		miTabla = new JTable();
		scrollPane_1.setViewportView(miTabla);

	}

}
