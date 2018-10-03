package Pruebas;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

public class Vista {
private JFrame ventana;
private JPanel panel;
private JTable tabla;
private JScrollPane scroll;
private String [] nombreColumna={"q","q'","Estados"};
private JLabel etAlf;
private JTextField textAlf;
private String[][] informacion;
	public Vista(){
		informacion= new String[5][3];
		ventana= new JFrame();
		panel= new JPanel();
		etAlf = new JLabel("Alfabeto");
		textAlf = new JTextField();
		atributos();
        armar();
        ver();
	}
	public void atributos(){
		panel.setLayout(null);
		ventana.setSize(1000,700);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        etAlf.setBounds(50,50,100,30);
        textAlf.setBounds(150,50,100,30);
	}
	void armar(){
		panel.add(etAlf);
		panel.add(textAlf);
		ventana.getContentPane().add(panel);
    }
    void ver(){
        ventana.setVisible(true);
    }
	
    public static void main(String[] a){
		new Vista();
	}
}
