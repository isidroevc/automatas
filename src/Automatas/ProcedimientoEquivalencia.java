package Automatas;

import estructuras.Lista;

public class ProcedimientoEquivalencia<TipoSimbolo> {
	private Lista<Lista<Par<String, String>>> tabla;
	private Lista<TipoSimbolo> alfabeto;
	private FuncionDeTransicion<TipoSimbolo> fdtA, fdtB;
	private Lista<String> estadosFinalesA, estadosFinalesB;
	private AFD<TipoSimbolo> a, b;
	private boolean equivalentes;
	private String causa;
	public ProcedimientoEquivalencia(AFD<TipoSimbolo> a, AFD<TipoSimbolo> b) {
		fdtA = a.obtenerFdt();
		fdtB = b.obtenerFdt();
		estadosFinalesA = a.obtenerEstadosFinales();
		estadosFinalesB = b.obtenerEstadosFinales();
		alfabeto = fdtA.obtenerAlfabeto();
		this.a = a;
		this.b =b;
		resolver();
	}
	
	private void resolver() {
		// agregar primera linea con los estaos iniciales
		String p = a.obtenerEstadoInicial(), q = b.obtenerEstadoInicial();
		Lista<Par<String, String>> renglon = new Lista<Par<String, String>>();
		Lista<Par<String, String>> paresNuevos = new Lista<Par<String, String>>();
		Lista<Par<String, String>> paresProcesados = new Lista<Par<String, String>>();
		Par<String, String> parActual, parAux;
		this.tabla = new Lista<Lista<Par<String, String>>>();
		paresNuevos.agregar(new Par<String, String>(p, q));
		
		while(paresNuevos.longitud() > 0) {
			parActual = paresNuevos.obtener(paresNuevos.longitud() - 1);
			paresNuevos.quitar(paresNuevos.longitud() - 1);
			renglon.agregar(parActual);
			if(!sonCompatibles(parActual.a,parActual.b)) {
				this.causa = "Par de estados " +  parActual.toString() + " incompatibles";
				this.equivalentes = false;
				for(int i = 0, c = alfabeto.longitud(); i < c; i++) {
					renglon.agregar(null);//Rellenar el reesto con null
				}
				tabla.agregar(renglon);
				return;
			}
			for(int i = 0, c = alfabeto.longitud(); i < c; i++) {
				TipoSimbolo simboloActual = alfabeto.obtener(i);
				parAux = new Par<String, String>();
				parAux.a = fdtA.obtenerEstado(parActual.a, simboloActual);
				parAux.b = fdtB.obtenerEstado(parActual.b, simboloActual);
				if(!paresNuevos.existe(parAux) && !paresProcesados.existe(parAux))
					paresNuevos.agregar(parAux);
				renglon.agregar(parAux);
			}
			paresProcesados.agregar(parActual);
			tabla.agregar(renglon);
			renglon = new Lista<Par<String, String>>();
		}
		this.equivalentes = true;
	}
	
	private boolean sonCompatibles(String p, String q) {
		return (estadosFinalesA.existe(p) && estadosFinalesB.existe(q)) || (!estadosFinalesA.existe(p) && !estadosFinalesB.existe(q));
	}
	
	public String[][] procedimiento() {
		int c = this.tabla.longitud() + 1 , d = this.alfabeto.longitud() + 1;
		String resultado[][] = new String[c][d];
		String[] encabezado =  new String [d];
		encabezado[0] = "q q'";
		for(int i = 0; i < alfabeto.longitud(); i++) {
			encabezado[i + 1] = alfabeto.obtener(i).toString();
		}
		//agregar encabezado.
		resultado[0] = encabezado;
		for(int i = 1;  i < c - 1; i++) {
			for(int j = 0; j < d; j++ ) {;
				Par<String, String> parAux = tabla.obtener(i).obtener(j);
				if(parAux == null)
					resultado[i][j] = "";
				else 
					resultado[i][j] = parAux.toString();
			}
		}
		return resultado;
	}
	
	public Lista<Lista<Par<String, String>>> tabla() {
		return this.tabla;
	}
	
	public boolean equivalentes() {
		return this.equivalentes;
	}
	
	public String causa() {
		return causa;
	}
}
