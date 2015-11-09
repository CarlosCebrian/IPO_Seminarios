package _interface;

import java.awt.*;

import javax.swing.*;

public class MiListCellRenderer extends DefaultListCellRenderer {

	protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
	
	ImageIcon iconoEspanol;
	ImageIcon iconoIngles;
	ImageIcon iconoIdioma;
	
	public MiListCellRenderer(){
		iconoEspanol = new ImageIcon(MiListCellRenderer.class.getResource("banderaEsp.gif"));
		iconoIngles = new ImageIcon(MiListCellRenderer.class.getResource("banderaIng.gif"));
		iconoIdioma = new ImageIcon(MiListCellRenderer.class.getResource("idioma.gif"));
	}
	
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean hasFocus){
		
		JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, hasFocus);
		
		if(list.getModel().getElementAt(index) == "Español"){
			renderer.setIcon(iconoEspanol);
		}
		else if(list.getModel().getElementAt(index) == "Inglés"){
			renderer.setIcon(iconoIngles);
		}
		else{
			renderer.setIcon(iconoIdioma);
		}
		
		return renderer;
	}
}
