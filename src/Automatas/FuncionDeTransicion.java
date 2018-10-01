package Automatas;

import Excepciones.ElementoNoEncontrado;
import Excepciones.NoEsUnaFuncion;
import estructuras.Lista;

public class FuncionDeTransicion<TipoSimbolo> {
	private Lista<String> estados;
	private Lista<TipoSimbolo> alfabeto;
	
	private String[][] tabla;
	
	public FuncionDeTransicion(Lista<String> estados, Lista<TipoSimbolo> alfabeto, String[][] tablaS) {
		this.estados = estados;
		this.alfabeto = alfabeto;
		
		if(!validarTablaS(tablaS)) {
			throw new NoEsUnaFuncion("La Funcion de Transicion es inválida");
		}
		this.tabla = tablaS;
	}
	
	private boolean validarTablaS(String[][] tablaS) {
		int c = estados.longitud(), k = alfabeto.longitud();
		if(tablaS.length != estados.longitud()) {
			return false;
		}
		// Recorrer la tabla en busca de elementos nulos o inexistentes en la lista de estados.
		for(int i = 0; i < c; i++) {
			if(tablaS[i].length != alfabeto.longitud()) {
				return false;
			}
			for(int j = 0; j < k; j++) {
				if(estados.indice(tablaS[i][j]) == -1) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	
	public void asignarTabla(String[][] tablaS) {
		if(!validarTablaS(tablaS)) {
			throw new NoEsUnaFuncion("La Función de transicion es inválida");
		}
		this.tabla = tablaS;
	}
	
	
	public String obtenerEstado(String estado, TipoSimbolo s) {
		int indiceEstado = estados.indice(estado), indiceSimbolo = alfabeto.indice(s);
		if(indiceEstado == -1 )
			throw new ElementoNoEncontrado("Se ha proporcionado un estado inexistente en el conjunto de estados");
		if(indiceSimbolo == -1)
			throw new ElementoNoEncontrado("Se ha proporcionado un simbolo inexistente en el alfabeto");
		
		return tabla[indiceEstado][indiceSimbolo];
	}
	
	public Lista<String> obtenerEstados() {
		return this.estados;
	}
	
	public Lista<TipoSimbolo> obtenerAlfabeto() {
		return this.alfabeto;
	}
	
}
