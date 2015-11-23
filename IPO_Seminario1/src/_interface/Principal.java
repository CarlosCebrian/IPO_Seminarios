package _interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JLabel lblEstado;
	private JLabel lblLogo;
	private JCheckBox chckbxLogo;
	private JLabel lblPassword;

	private final String password = "ipo1";
	private JLabel lblAviso;
	private JButton btnEntrar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/_interface/correo1.jpg")));
		setTitle("Aplicacion de Correo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseMotionListener(new PanelMouseMotionListener());
		panel.setBounds(0, 0, 433, 175);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.addMouseMotionListener(new LblLogoMouseMotionListener());
		lblLogo.addMouseListener(new LblLogoMouseListener());
		lblLogo.setBounds(41, 24, 100, 100);
		panel.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(Principal.class.getResource("/_interface/012.png")));
		
		chckbxLogo = new JCheckBox("Mostrar Logo");
		chckbxLogo.setSelected(true);
		chckbxLogo.addItemListener(new ChckbxLogoItemListener());
		chckbxLogo.setBounds(41, 131, 117, 23);
		panel.add(chckbxLogo);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new BtnEntrarActionListener());
		btnEntrar.setEnabled(false);
		btnEntrar.setBounds(291, 128, 86, 23);
		panel.add(btnEntrar);
		
		JLabel lblUser = new JLabel("Usuario:");
		lblUser.setBounds(189, 24, 92, 14);
		panel.add(lblUser);
		
		lblPassword = new JLabel("Contrase\u00F1a:");
		lblPassword.setEnabled(false);
		lblPassword.setBounds(189, 61, 92, 14);
		panel.add(lblPassword);
		
		txtUser = new JTextField();
		txtUser.addActionListener(new TxtUserActionListener());
		txtUser.setBounds(291, 24, 86, 20);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.addKeyListener(new TxtPassKeyListener());
		txtPass.addActionListener(new TxtPassActionListener());
		txtPass.setEnabled(false);
		txtPass.setBounds(291, 58, 86, 20);
		panel.add(txtPass);
		
		lblAviso = new JLabel("");
		lblAviso.setOpaque(true);
		lblAviso.setBounds(189, 86, 188, 38);
		panel.add(lblAviso);
		
		lblEstado = new JLabel("");
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setBounds(0, 174, 433, 46);
		contentPane.add(lblEstado);
		lblEstado.setOpaque(true);
		lblEstado.setForeground(Color.BLACK);
		lblEstado.setBackground(new Color(255, 255, 153));
	}

	public String getPass() {
		return password;
	}

	private class LblLogoMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			lblLogo.setIcon(new ImageIcon(Principal.class.getResource("/_interface/112.png")));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			lblLogo.setIcon(new ImageIcon(Principal.class.getResource("/_interface/012.png")));
		}
	}
	private class PanelMouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseMoved(MouseEvent arg0) {
			lblEstado.setText("Cursor en panel -- X: " + arg0.getX() + " , Y: "+ arg0.getY());
		}
	}
	private class LblLogoMouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseMoved(MouseEvent e) {
			lblEstado.setText("Cursor en imagen -- X: " + e.getX() + " , Y: "+ e.getY());
		}
	}

	private class TxtUserActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			lblPassword.setEnabled(true);
			txtPass.setEnabled(true);
			txtPass.requestFocus();
		}
	}
	private class TxtPassActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(getPass().equals(String.valueOf(txtPass.getPassword()))){
				lblAviso.setText("CONTRASEÑA CORRECTA");
				lblAviso.setBackground(Color.GREEN);
				btnEntrar.setEnabled(true);
			}
			else{
				lblAviso.setText("CONTRASEÑA INCORRECTA");
				lblAviso.setBackground(Color.RED);
				btnEntrar.setEnabled(false);
			}
		}
	}
	private class ChckbxLogoItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent arg0) {
			lblEstado.setText("Evento de Item: ItemStateChanged. Checkbox " +arg0.getStateChange());
			lblLogo.setVisible(chckbxLogo.isSelected());
		}
	}
	private class BtnEntrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//System.exit(0);
			SecondWindow sw = new SecondWindow();
			sw.setVisible(true);
			dispose();
		}
	}
	private class TxtPassKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent arg0) {
			lblEstado.setText(""+arg0.getKeyChar());
		}
	}
}
