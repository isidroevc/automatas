
package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Automatas.AFD;
import Automatas.FuncionDeTransicion;
import estructuras.Lista;

public class PruebaVista{
private JFrame ventana;
private JPanel panel;
private JTable tabla;
private JLabel etAlf,instruccion,etEsFinal,etEsInicial,etConEst,funTra;
private JTextField textAlf,textEsFinal,textEsInicial,textConEst;
private JButton crearAFD,crearFDT;
private Lista<String> alfabeto,estadoFinal,conjuntoEst;
private String[] alf,efinal,cEstados;
private String estadoInicial;
private DefaultTableModel modelo;
private String[][] matriz;
private FuncionDeTransicion<String> fdt;
	public PruebaVista(){
		ventana= new JFrame();
		panel= new JPanel();
		instruccion= new JLabel("Coloca los datos separados por comas");
		etAlf = new JLabel("Alfabeto ");
		textAlf = new JTextField();
        etEsFinal = new JLabel("Estados Finales");
        textEsFinal= new JTextField();
        etEsInicial = new JLabel("Estados Inicial");
        textEsInicial= new JTextField();
        etConEst = new JLabel("Conjunto de estados");
        textConEst= new JTextField();
        funTra=new JLabel();
        crearFDT = new JButton("CREAR Funcion De Transicion");
        alfabeto=new Lista<String>();
        estadoFinal=new Lista<String>();
        conjuntoEst=new Lista<String>();
        crearAFD=new JButton("Crear Automata");
		atributos();
        armar();
        evento();
        ver();
	}
	public void atributos(){
		panel.setLayout(null);
		ventana.setSize(600,700);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        instruccion.setBounds(150,10,300,30);
        etAlf.setBounds(50,50,100,30);
        textAlf.setBounds(200,50,100,30);
        etEsInicial.setBounds(50,90,100,30);
        textEsInicial.setBounds(200,90,100,30);
        etConEst.setBounds(50,130,150,30);
        textConEst.setBounds(200,130,100,30);
        etEsFinal.setBounds(50,170,100,30);
        textEsFinal.setBounds(200,170,100,30);
        crearFDT.setBounds(300, 170, 250, 30);
        crearAFD.setBounds(50, 520, 150, 30);
        crearAFD.setVisible(false);
	}
	void armar(){
            panel.add(instruccion);
            panel.add(etAlf);
            panel.add(textAlf);
            panel.add(etEsInicial);
            panel.add(textEsInicial);
            panel.add(etConEst);
            panel.add(textConEst);
            panel.add(etEsFinal);
            panel.add(textEsFinal);
            panel.add(crearFDT); 
            panel.add(crearAFD);
            ventana.getContentPane().add(panel);
    }
    void evento(){
        escuEvento evento=new escuEvento();
        crearFDT.addMouseListener(evento);
        crearAFD.addMouseListener(evento);
    }
    void ver(){
        ventana.setVisible(true);
    }
    public class escuEvento extends MouseAdapter{
        @Override 
        public void mousePressed(MouseEvent me){
            if(me.getSource().equals(crearFDT)){
                   alf=textAlf.getText().split(",");
                   for(int i=0;i<alf.length;i++){
                	   alfabeto.agregar(alf[i]);//Agregar datos a la lista alfabeto
                   }
                   efinal=textEsFinal.getText().split(",");
                   for(int i=0;i<efinal.length;i++){
                	   estadoFinal.agregar(efinal[i]);//Agregar datos a la lista estados finales
                   }
                   cEstados=textConEst.getText().split(",");
                   for(int i=0;i<cEstados.length;i++){
                       conjuntoEst.agregar(cEstados[i]);//Agregar datos a la lista conjunto de estados   
                   }
                   estadoInicial=textEsInicial.getText();
                   matriz=new String[cEstados.length+1][alf.length+2];
                   for(int i=0;i<cEstados.length;i++){
                	   for(int j=0;j<alf.length;j++){
                    	   matriz[0][j+1]=alf[j];
                       }   
                	   matriz[i+1][0]=cEstados[i];
                   }
                   modelo = new DefaultTableModel(matriz,alf);
                   
                   tabla=new JTable(modelo);
                
                   tabla.setBounds(50,210,500,300);
                   crearAFD.setVisible(true);
                   panel.add(tabla);
            }if(me.getSource().equals(crearAFD)){
            	construirTabla();
            }
            
        }
    }
    public void construirTabla(){
    	for(int i=0;i<cEstados.length;i++){
     	   for(int j=0;j<alf.length;j++){

         	   matriz[i][j]=(String)tabla.getValueAt(i,j);
         	   
            }   
        }
		fdt=new FuncionDeTransicion<String>(conjuntoEst,alfabeto,matriz);
		//LeerAFD();
		imprimir();
	}
	public AFD LeerAFD(){
		return new AFD(estadoInicial,estadoFinal,fdt);
	}
	void imprimir(){
		for(int i=0;i<cEstados.length;i++){
	     	   for(int j=0;j<=alf.length;j++){

	         	   System.out.print(matriz[i][j]+" ");
	         	   
	            }   
	     	   System.out.print("\n");
	        }
	}
    
    public static void main(String[] a){
		new PruebaVista();
	}
}
