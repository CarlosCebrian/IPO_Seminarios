package _interface;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JFrame;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class EditorGrafico {

	int modo = -1;
	private final int SOLEADO = 1;
	private final int NUBLADO = 2;
	private final int RECTANGULO = 3;
	private final int TEXTO = 4;

	private int x, y;

	private Toolkit toolkit;
	private Image imagSoleado;
	private Image imagNublado;
	private Image imagRectangulo;
	private Image imagTexto;
	private Image imagCursorSoleado;
	private Image imagCursorNublado;
	private Cursor cursorSoleado;
	private Cursor cursorNublado;
	private Cursor cursorRectangulo;
	private Cursor cursorTexto;

	private JFrame frame;
	private JToolBar tbBarraDibujo;
	private JButton btnCargarMapa;
	private JButton btnSoleado;
	private JButton btnNublado;
	private JButton btnRectangulo;
	private JButton btnAnotacion;
	private JScrollPane scrollPane;

	private MiAreaDibujo miareadibujo;
	private ImageIcon imagen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorGrafico window = new EditorGrafico();
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
	public EditorGrafico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		toolkit = Toolkit.getDefaultToolkit();
		imagSoleado = toolkit.getImage(getClass().getClassLoader().getResource("_interface/soleado.png"));
		imagNublado = toolkit.getImage(getClass().getClassLoader().getResource("_interface/nubesYClaros.png"));
		imagRectangulo = toolkit.getImage(getClass().getClassLoader().getResource("_interface/rectangulo.png"));
		imagTexto = toolkit.getImage(getClass().getClassLoader().getResource("_interface/aniadirAnotacion.png"));
		imagCursorSoleado = toolkit.getImage(getClass().getClassLoader().getResource("_interface/cursorSoleado.png"));
		imagCursorNublado = toolkit
				.getImage(getClass().getClassLoader().getResource("_interface/cursorNubesYClaros.png"));

		cursorRectangulo = toolkit.createCustomCursor(imagRectangulo, new Point(0, 0), "CURSOR_RECTANGULO");
		cursorTexto = toolkit.createCustomCursor(imagTexto, new Point(0, 0), "CURSOR_TEXTO");
		cursorSoleado = toolkit.createCustomCursor(imagCursorSoleado, new Point(0, 0), "CURSOR_SOL");
		cursorNublado = toolkit.createCustomCursor(imagCursorNublado, new Point(0, 0), "CURSOR_NUBLADO");

		frame = new JFrame();
		frame.setBounds(new Rectangle(0, 0, 700, 700));
		// frame.setBounds(100, 100, 771, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tbBarraDibujo = new JToolBar();
		frame.getContentPane().add(tbBarraDibujo, BorderLayout.NORTH);

		btnCargarMapa = new JButton("");
		btnCargarMapa.addActionListener(new BtnCargarMapaActionListener());
		btnCargarMapa.setIcon(new ImageIcon(EditorGrafico.class.getResource("/_interface/cargarMapa.png")));
		tbBarraDibujo.add(btnCargarMapa);

		btnSoleado = new JButton("");
		btnSoleado.addActionListener(new BtnDibujoActionListener());
		btnSoleado.setIcon(new ImageIcon(EditorGrafico.class.getResource("/_interface/soleado.png")));
		tbBarraDibujo.add(btnSoleado);

		btnNublado = new JButton("");
		btnNublado.addActionListener(new BtnDibujoActionListener());
		btnNublado.setIcon(new ImageIcon(EditorGrafico.class.getResource("/_interface/nubesYClaros.png")));
		tbBarraDibujo.add(btnNublado);

		btnRectangulo = new JButton("");
		btnRectangulo.addActionListener(new BtnDibujoActionListener());
		btnRectangulo.setIcon(new ImageIcon(EditorGrafico.class.getResource("/_interface/rectangulo.png")));
		tbBarraDibujo.add(btnRectangulo);

		btnAnotacion = new JButton("");
		btnAnotacion.addActionListener(new BtnDibujoActionListener());
		btnAnotacion.setIcon(new ImageIcon(EditorGrafico.class.getResource("/_interface/aniadirAnotacion.png")));
		tbBarraDibujo.add(btnAnotacion);

		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		miareadibujo = new MiAreaDibujo();
		miareadibujo.addMouseMotionListener(new MiareadibujoMouseMotionListener());
		miareadibujo.addMouseListener(new MiareadibujoMouseListener());
		miareadibujo.setIcon(null);
		scrollPane.setViewportView(miareadibujo);
	}

	private class BtnCargarMapaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser fcAbrir = new JFileChooser();
			int valorDevuelto = fcAbrir.showOpenDialog(frame);
			if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
				File file = fcAbrir.getSelectedFile();
				imagen = new ImageIcon(file.getAbsolutePath());
				miareadibujo.setIcon(imagen);
			}
		}
	}

	private class BtnDibujoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] path = ((JButton) e.getSource()).getIcon().toString().split("/");
			switch (path[path.length - 1]) {
			case "aniadirAnotacion.png":
				modo = TEXTO;
				frame.setCursor(cursorTexto);
				break;
			case "nubesYClaros.png":
				modo = NUBLADO;
				frame.setCursor(cursorNublado);
				break;
			case "soleado.png":
				modo = SOLEADO;
				frame.setCursor(cursorSoleado);
				break;
			case "rectangulo.png":
				modo = RECTANGULO;
				frame.setCursor(cursorRectangulo);
				break;
			}
		}
	}

	private class MiareadibujoMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent arg0) {
			x = arg0.getX();
			y = arg0.getY();
			if (imagen != null) {
				switch (modo) {
				case SOLEADO:
					miareadibujo.addObjetoGrafico(new ImagenGrafico(x, y, imagSoleado));
					miareadibujo.repaint();
					break;
				case NUBLADO:
					miareadibujo.addObjetoGrafico(new ImagenGrafico(x, y, imagNublado));
					miareadibujo.repaint();
					break;
				case RECTANGULO:
					miareadibujo.addObjetoGrafico(new RectanguloGrafico(x, y, x, y, Color.RED));
					break;
				case TEXTO:
				}
			}
		}
	}

	private class MiareadibujoMouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseDragged(MouseEvent arg0) {
			if (modo == RECTANGULO && imagen != null) {
				((RectanguloGrafico) miareadibujo.getUltimoObjetoGrafico()).setX1(arg0.getX());
				((RectanguloGrafico) miareadibujo.getUltimoObjetoGrafico()).setY1(arg0.getY());
				miareadibujo.repaint();
			}
		}
	}
}
