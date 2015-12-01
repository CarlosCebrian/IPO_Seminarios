package _interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;

public class Principal{

	private JFrame frame;
	private JPanel pnlFicha;
	private JLabel lblNumExpediente;
	private JTextField txtNumExpediente;
	private JLabel lblCheck;
	private JButton btnCargarFoto;
	private JScrollPane pnlFoto;
	private JLabel lblFoto;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblDni;
	private JLabel lblTelefono;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JFormattedTextField txtDNI;
	private JFormattedTextField txtTelefono;
	private JButton btnCargarComentarios;
	private JScrollPane scrollPane;
	private JTextArea taComentarios;
	private JButton btnGuardar;
	
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 544, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pnlFicha = new JPanel();
		pnlFicha.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), MessagesSeminario2Inter.getString("Principal.pnlFicha.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK)); //$NON-NLS-2$
		frame.getContentPane().add(pnlFicha, BorderLayout.CENTER);
		GridBagLayout gbl_pnlFicha = new GridBagLayout();
		gbl_pnlFicha.columnWidths = new int[]{0, 0, 77, 111, 70, 0, 0, 0};
		gbl_pnlFicha.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlFicha.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_pnlFicha.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		pnlFicha.setLayout(gbl_pnlFicha);
		
		lblNumExpediente = new JLabel(MessagesSeminario2Inter.getString("Principal.lblNumExpediente.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNumExpediente = new GridBagConstraints();
		gbc_lblNumExpediente.anchor = GridBagConstraints.EAST;
		gbc_lblNumExpediente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumExpediente.gridx = 0;
		gbc_lblNumExpediente.gridy = 0;
		pnlFicha.add(lblNumExpediente, gbc_lblNumExpediente);
		
		txtNumExpediente = new JTextField();
		GridBagConstraints gbc_txtNumExpediente = new GridBagConstraints();
		gbc_txtNumExpediente.gridwidth = 2;
		gbc_txtNumExpediente.insets = new Insets(0, 0, 5, 5);
		gbc_txtNumExpediente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumExpediente.gridx = 1;
		gbc_txtNumExpediente.gridy = 0;
		pnlFicha.add(txtNumExpediente, gbc_txtNumExpediente);
		txtNumExpediente.setColumns(10);
		
		lblCheck = new JLabel("");
		GridBagConstraints gbc_lblCheck = new GridBagConstraints();
		gbc_lblCheck.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheck.gridx = 3;
		gbc_lblCheck.gridy = 0;
		pnlFicha.add(lblCheck, gbc_lblCheck);
		
		btnCargarFoto = new JButton(MessagesSeminario2Inter.getString("Principal.btnCargarFoto.text")); //$NON-NLS-1$
		btnCargarFoto.setIcon(new ImageIcon(Principal.class.getResource("/_interface/cargarFoto.png")));
		GridBagConstraints gbc_btnCargarFoto = new GridBagConstraints();
		gbc_btnCargarFoto.gridwidth = 2;
		gbc_btnCargarFoto.insets = new Insets(0, 0, 5, 5);
		gbc_btnCargarFoto.gridx = 0;
		gbc_btnCargarFoto.gridy = 1;
		pnlFicha.add(btnCargarFoto, gbc_btnCargarFoto);
		
		pnlFoto = new JScrollPane();
		pnlFoto.setBorder(new TitledBorder(null, MessagesSeminario2Inter.getString("Principal.pnlFoto.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		GridBagConstraints gbc_pnlFoto = new GridBagConstraints();
		gbc_pnlFoto.gridheight = 4;
		gbc_pnlFoto.gridwidth = 2;
		gbc_pnlFoto.insets = new Insets(0, 0, 5, 5);
		gbc_pnlFoto.fill = GridBagConstraints.BOTH;
		gbc_pnlFoto.gridx = 0;
		gbc_pnlFoto.gridy = 2;
		pnlFicha.add(pnlFoto, gbc_pnlFoto);
		
		lblFoto = new JLabel("");
		pnlFoto.setViewportView(lblFoto);
		
		lblNombre = new JLabel(MessagesSeminario2Inter.getString("Principal.lblNombre.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 2;
		gbc_lblNombre.gridy = 2;
		pnlFicha.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 3;
		gbc_txtNombre.gridy = 2;
		pnlFicha.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		lblApellidos = new JLabel(MessagesSeminario2Inter.getString("Principal.lblApellidos.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.WEST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 2;
		gbc_lblApellidos.gridy = 3;
		pnlFicha.add(lblApellidos, gbc_lblApellidos);
		
		txtApellidos = new JTextField();
		GridBagConstraints gbc_txtApellidos = new GridBagConstraints();
		gbc_txtApellidos.gridwidth = 2;
		gbc_txtApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellidos.gridx = 3;
		gbc_txtApellidos.gridy = 3;
		pnlFicha.add(txtApellidos, gbc_txtApellidos);
		txtApellidos.setColumns(10);
		
		lblDni = new JLabel(MessagesSeminario2Inter.getString("Principal.lblDni.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.WEST;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 2;
		gbc_lblDni.gridy = 4;
		pnlFicha.add(lblDni, gbc_lblDni);
		
		txtDNI = new JFormattedTextField();
		GridBagConstraints gbc_txtDNI = new GridBagConstraints();
		gbc_txtDNI.insets = new Insets(0, 0, 5, 5);
		gbc_txtDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDNI.gridx = 3;
		gbc_txtDNI.gridy = 4;
		pnlFicha.add(txtDNI, gbc_txtDNI);
		
		lblTelefono = new JLabel(MessagesSeminario2Inter.getString("Principal.lblTelefono.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.WEST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 2;
		gbc_lblTelefono.gridy = 5;
		pnlFicha.add(lblTelefono, gbc_lblTelefono);
		
		txtTelefono = new JFormattedTextField();
		GridBagConstraints gbc_txtTelefono = new GridBagConstraints();
		gbc_txtTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefono.gridx = 3;
		gbc_txtTelefono.gridy = 5;
		pnlFicha.add(txtTelefono, gbc_txtTelefono);
		
		btnCargarComentarios = new JButton(MessagesSeminario2Inter.getString("Principal.btnCargarComentarios.text")); //$NON-NLS-1$
		btnCargarComentarios.setIcon(new ImageIcon(Principal.class.getResource("/_interface/cargarComentarios.png")));
		GridBagConstraints gbc_btnCargarComentarios = new GridBagConstraints();
		gbc_btnCargarComentarios.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCargarComentarios.gridwidth = 3;
		gbc_btnCargarComentarios.insets = new Insets(0, 0, 5, 5);
		gbc_btnCargarComentarios.gridx = 0;
		gbc_btnCargarComentarios.gridy = 6;
		pnlFicha.add(btnCargarComentarios, gbc_btnCargarComentarios);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 7;
		pnlFicha.add(scrollPane, gbc_scrollPane);
		
		taComentarios = new JTextArea();
		taComentarios.setBorder(new TitledBorder(null, MessagesSeminario2Inter.getString("Principal.taComentarios.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		scrollPane.setViewportView(taComentarios);
		
		btnGuardar = new JButton(MessagesSeminario2Inter.getString("Principal.btnGuardar.text")); //$NON-NLS-1$
		btnGuardar.setIcon(new ImageIcon(Principal.class.getResource("/_interface/guardar.png")));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridx = 6;
		gbc_btnGuardar.gridy = 8;
		pnlFicha.add(btnGuardar, gbc_btnGuardar);
	}
	
	public JFrame get_frame(){
		return this.frame;
	}

}
