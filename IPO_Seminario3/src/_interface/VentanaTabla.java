package _interface;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Rectangle;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

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
	private JPopupMenu popupMenu;
	private JMenuItem mntmAadir;

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
		btnAadir.addActionListener(new BtnAadirActionListener());
		btnAadir.setIcon(new ImageIcon(VentanaTabla.class.getResource("/_interface/ic_menu_btn_add.png")));
		toolBar.add(btnAadir);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new BtnEliminarActionListener());
		btnEliminar.setIcon(new ImageIcon(VentanaTabla.class.getResource("/_interface/ic_menu_delete.png")));
		toolBar.add(btnEliminar);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(50, 120));
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		lblFoto = new JLabel("");
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setViewportView(lblFoto);
		
		taFilaSeleccionada = new JTextArea();
		panel.add(taFilaSeleccionada);
		
		scrollPane_1 = new JScrollPane();
		getContentPane().add(scrollPane_1, BorderLayout.CENTER);
		
		miTabla = new JTable();
		miTabla.setRowHeight(30);
		miTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		MiModeloTabla modeloTabla = new MiModeloTabla();
		miTabla.setModel(modeloTabla);
		
		Object[] fila1 = { "Sombra", "Border Collie",
				new ImageIcon(getClass().getClassLoader().getResource("_interface/perros/borderCollie.jpg")), true };
		modeloTabla.anadirFila(fila1);
		Object[] fila2 = { "Bruma", "Pastor Alemán",
				new ImageIcon(getClass().getClassLoader().getResource("_interface/perros/pastorAleman.jpg")), false };
		modeloTabla.anadirFila(fila2);
		Object[] fila3 = { "Ulises", "Labrador",
				new ImageIcon(getClass().getClassLoader().getResource("_interface/perros/labrador.jpg")), true };
		modeloTabla.anadirFila(fila3);
		
//		miTabla.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"Sombra", "Border Collie", null, Boolean.TRUE},
//				{"Bruma", "Pastor Aleman", null, null},
//			},
//			new String[] {
//				"Nombre", "Raza", "Foto", "Vacunado"
//			}
//		) {
//			Class[] columnTypes = new Class[] {
//				String.class, String.class, Object.class, Boolean.class
//			};
//			public Class getColumnClass(int columnIndex) {
//				return columnTypes[columnIndex];
//			}
//		});
		
		miTabla.getColumnModel().getColumn(0).setResizable(false);
		
		popupMenu = new JPopupMenu();
		addPopup(scrollPane_1, popupMenu);
		addPopup(miTabla, popupMenu);
		
		mntmAadir = new JMenuItem("Añadir");
		mntmAadir.addActionListener(new BtnAadirActionListener());
		mntmAadir.setIcon(new ImageIcon(VentanaTabla.class.getResource("/_interface/ic_menu_btn_add.png")));
		popupMenu.add(mntmAadir);
		scrollPane_1.setViewportView(miTabla);

		miTabla.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				if(!lsm.isSelectionEmpty()){
					//int filaseleccionada = lsm.getMinSelectionIndex() + 1;
					//taFilaSeleccionada.setText("Fila "+filaseleccionada+" seleccionada");
					MiModeloTabla modeloTabla = (MiModeloTabla) miTabla.getModel();
					int n = miTabla.getSelectedRow();
					if(n != -1){
						String contenido = "Nombre: "+ modeloTabla.getValueAt(n, 0)+ "\nRaza: "+ modeloTabla.getValueAt(n, 1)+"\n";
						contenido += (Boolean) modeloTabla.getValueAt(n, 3)?"Vacunado":"No Vacunado";
						taFilaSeleccionada.setText(contenido);
						lblFoto.setIcon((ImageIcon) modeloTabla.getValueAt(n, 2));
					}
					
				}
			}
		});
		
		
		TableColumn columnRazas = miTabla.getColumnModel().getColumn(1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Border Collie");
		comboBox.addItem("Galgo");
		comboBox.addItem("Labrador");
		comboBox.addItem("Mestizo");
		comboBox.addItem("Pastor Aleman");
		
		columnRazas.setCellEditor(new DefaultCellEditor(comboBox));
		
		TableColumn columnFotos = miTabla.getColumnModel().getColumn(2);
		columnFotos.setCellEditor(new ColumnaFotoEditor());
		
	}

	private class BtnAadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			MiModeloTabla modeloTabla = (MiModeloTabla) miTabla.getModel();
			Object [] nuevaFila = {"...","...", new ImageIcon(getClass().getClassLoader().getResource("_interface/iconoPerro.jpg")),false};
			modeloTabla.anadirFila(nuevaFila);
			modeloTabla.fireTableDataChanged();
		}
	}
	private class BtnEliminarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			MiModeloTabla modeloTabla = (MiModeloTabla) miTabla.getModel();
			int n = miTabla.getSelectedRow();
			if(n != -1){
				modeloTabla.eliminarFila(n);
			}
			modeloTabla.fireTableDataChanged();
		}
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
