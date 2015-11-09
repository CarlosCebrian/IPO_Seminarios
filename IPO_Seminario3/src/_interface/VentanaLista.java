package _interface;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaLista extends JInternalFrame {
	private JButton btnAadirElemento;
	private JScrollPane scrollPane;
	private JLabel lblFilaSeleccionada;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLista frame = new VentanaLista();
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
	public VentanaLista() {
		setTitle("Ejemplo Lista");
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(new Rectangle(50, 50, 200, 500));
		
		btnAadirElemento = new JButton("A\u00F1adir elemento");
		btnAadirElemento.addActionListener(new BtnAadirElementoActionListener());
		getContentPane().add(btnAadirElemento, BorderLayout.NORTH);
		
		lblFilaSeleccionada = new JLabel("Fila seleccionada:");
		getContentPane().add(lblFilaSeleccionada, BorderLayout.SOUTH);
		
		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		list = new JList();
		DefaultListModel modeloLista = new DefaultListModel();
		list.setModel(modeloLista);
		
		modeloLista.addElement("Español");
		modeloLista.addElement("Inglés");
		modeloLista.addElement("Idioma");
		list.addListSelectionListener(new ListListSelectionListener());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		list.setModel(new AbstractListModel() {
//			String[] values = new String[] {"Espa\u00F1ol", "Ingl\u00E9s", "Idioma"};
//			public int getSize() {
//				return values.length;
//			}
//			public Object getElementAt(int index) {
//				return values[index];
//			}
//		});
		list.setCellRenderer(new OtroListCellRenderer());
		scrollPane.setViewportView(list);
		//setBounds(100, 100, 450, 300);
		


	}

	private class ListListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			lblFilaSeleccionada.setText("Fila seleccionada: "+ (String)list.getSelectedValue());
		}
	}
	private class BtnAadirElementoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			DefaultListModel modeloLista = (DefaultListModel) list.getModel();
			
			int index = modeloLista.getSize();
			modeloLista.addElement("Idioma "+(index + 1));
			list.setSelectedIndex(index);
			list.ensureIndexIsVisible(index);
		}
	}
}
