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
	
	public String[][] obtenerTabla() {
		return this.tabla.clone();
	}
	
	
	public String obtenerEstado(String estado, TipoSimbolo s) {
		int indiceEstado = estados.indice(estado), indiceSimbolo = alfabeto.indice(s);
		if(indiceEstado == -1 )
			throw new ElementoNoEncontrado("Se ha proporcionado un estado inexistente en el conjunto de estados, estado");
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
	
	public FuncionDeTransicion<TipoSimbolo> copiar() {
		return new FuncionDeTransicion<TipoSimbolo>(estados.copiar(), alfabeto.copiar(), this.tabla.clone());
	}
	
	
	public FuncionDeTransicion<TipoSimbolo> quitarEstado(String estado, String equivalente) {
		Lista<String> nuevosEstados = this.estados.copiar();
		int indiceEstado = estados.indice(estado);
		nuevosEstados.quitar(indiceEstado);
		int a = nuevosEstados.longitud(), b = this.alfabeto.longitud(), ic = 0, aa = estados.longitud();
		String[][] nuevaTabla = new String[a][b];
		
		for(int i = 0; i < aa; i++ ){
			if(i == indiceEstado)
				continue;
			for(int j = 0; j < b; j++) {
				
				if(estado.equals(this.tabla[i][j])) {
					nuevaTabla[ic][j] = equivalente;
					continue;
				}
				nuevaTabla[ic][j] = this.tabla[i][j];
			}
			ic++;
		}
		for(int i = 0; i < nuevaTabla.length; i++) {
			for(int j = 0; j < nuevaTabla[i].length; j++) {
				System.out.print(nuevaTabla[i][j]);
			}
			System.out.println("");
		}
		return new FuncionDeTransicion<TipoSimbolo>(nuevosEstados, alfabeto.copiar(), nuevaTabla);
	}
	
	@Override
	public String toString() {
		String result = "{ ";
		String estado;
		TipoSimbolo s;
		int ic = 0;
		for(int i = 0, c = this.estados.longitud(); i < c; i ++) {
			for(int j = 0, l = this.alfabeto.longitud(); j < l; j++) {
				estado = this.estados.obtener(i);
				s = this.alfabeto.obtener(j);
				result += "(" + estado +", " + s + ")-> " + this.obtenerEstado(estado, s);
				if(ic < c*l) {
					result += ", ";
				}
				ic++;
			}
		}
		result += "}";
		return result;
	}
	
}
