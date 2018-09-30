package Pruebas;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class Vista {
private JFrame ventana;
private JPanel panel;
private JTable tabla;
private JScrollPane scroll;
private String [] nombreColumna={
		"q","q'","Estados"
};
private String[][] informacion;
	public Vista(){
		informacion= new String[5][3];
		ventana= new JFrame();
		panel= new JPanel();
		tabla = new JTable(informacion,nombreColumna);
		scroll=new JScrollPane(tabla);
		atributos();
        armar();
        ver();
	}
	public void atributos(){
		ventana.setSize(500,300);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        tabla.setForeground(Color.black);
        tabla.setBackground(Color.white);
	}
	void armar(){
        ventana.add(scroll);
    }
    void ver(){
        ventana.setVisible(true);
    }
	
	
}
