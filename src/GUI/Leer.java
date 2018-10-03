package GUI;

import Automatas.AFD;
import Automatas.FuncionDeTransicion;
import estructuras.Lista;

public class Leer<TipoSimbolo> {
	private Lista<String> estados;
	private Lista<TipoSimbolo> alfabeto;
	private String estadoInicial;
	private Lista<String> estadosFinales;
	private FuncionDeTransicion<TipoSimbolo> fdt;
	private String[][] tabla;
	public Leer(Lista<String> estados,Lista<TipoSimbolo> alfabeto,String estadoInicial,Lista<String> estadosFinales){
		this.estados=estados;
		this.alfabeto=alfabeto;
		this.estadoInicial=estadoInicial;
		this.estadosFinales= estadosFinales;
		construirTabla();
	}
	public void construirTabla(){
		for(int i =0;i<alfabeto.longitud();i++){
			for(int j=0;j<estados.longitud();j++){
				tabla[0][j+1]=estados.obtener(j);
			}
			tabla[i+1][0]=(String) alfabeto.obtener(i);
		}
		fdt=new FuncionDeTransicion<TipoSimbolo>(estados,alfabeto,tabla);
	}
	public AFD LeerAFD(){
		return new AFD(estadoInicial,estadosFinales,fdt);
	}
}
