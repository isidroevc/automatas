package Automatas;

import estructuras.Lista;

public class FuncionDeTransicion<TipoSimbolo> {
	public Lista<String> estados;
	public Lista<TipoSimbolo> alfabeto;
	
	private int[][] tabla;
	
	public FuncionDeTransicion(Lista<String> estados, Lista<TipoSimbolo> alfabeto, String[][] tablaS) {
		this.estados = estados;
		this.alfabeto = alfabeto;
		tabla = new int[alfabeto.longitud][];
		for(int i = 0, c = estados.longitud; i < c; i++) {
			tabla[i] = new int[estados.longitud];
			for(int j = 0, k = estados.longitud;  j < k;j++) {
				tabla[i][j] = estados.indice(tablaS[i][j]);
			}
		}
	}
	
	private boolean validarTabla(String[][] tablaS) {
		
	}
}
