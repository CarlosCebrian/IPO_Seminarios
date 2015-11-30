package _interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoSeleccionIdioma extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnIngls;
	private JRadioButton rdbtnEspaol;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoSeleccionIdioma dialog = new DialogoSeleccionIdioma();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoSeleccionIdioma() {
		setBounds(100, 100, 447, 179);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblSeleccioneElIdioma = new JLabel("Seleccione el idioma:");
			contentPanel.add(lblSeleccioneElIdioma);
		}
		{
			rdbtnEspaol = new JRadioButton("Espa\u00F1ol");
			rdbtnEspaol
					.setIcon(new ImageIcon(DialogoSeleccionIdioma.class.getResource("/_interface/icono_espania.gif")));
			buttonGroup.add(rdbtnEspaol);
			contentPanel.add(rdbtnEspaol);
		}
		{
			rdbtnIngls = new JRadioButton("Ingl\u00E9s");
			rdbtnIngls.setIcon(new ImageIcon(DialogoSeleccionIdioma.class.getResource("/_interface/icono_uk.jpg")));
			buttonGroup.add(rdbtnIngls);
			contentPanel.add(rdbtnIngls);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new OkButtonActionListener());
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

	private class OkButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (rdbtnIngls.isSelected())
				MessagesSeminario2Inter.setIdioma("inglés");
			Principal ppal = new Principal();
			ppal.get_frame().setVisible(true);
			dispose();
		}
	}
}
