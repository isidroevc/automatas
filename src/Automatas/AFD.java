package Automatas;

import Excepciones.EntradaIncorrecta;
import estructuras.Lista;

public class AFD<TipoSimbolo> implements IAFD<TipoSimbolo> {
	private Lista<String> estados;
	private Lista<TipoSimbolo> alfabeto;
	private String estadoInicial;
	private Lista<String> estadosFinales;
	private FuncionDeTransicion<TipoSimbolo> fdt;
	private Palabra<TipoSimbolo> palabraActual, resto;
	private int indiceActual = 0;
	private String estadoActual;
	
	public AFD(String s, Lista<String> F, FuncionDeTransicion<TipoSimbolo> fdt) {
		this.estados = fdt.obtenerEstados();
		if(!validarEstadosFinales(F)) {
			throw new EntradaIncorrecta("F no es subconjunto de K");
		}
		if(!estados.existe(s)) {
			throw new EntradaIncorrecta("El estado inicial no existe entre los estados indicados");
		}
		this.estadosFinales = F;
		this.fdt = fdt;
		this.estadoInicial = s;
		this.alfabeto = fdt.obtenerAlfabeto();
		this.estadoActual = s;
	}
	
	private boolean validarEstadosFinales(Lista<String> f) {	
		for(int i =0, c = f.longitud(); i < c; i++) {
			if(!this.estados.existe(f.obtener(i))) {
				return false;
			}
		}
		return true;
	}
	
	public String obtenerEstadoActual() {
		return this.estadoActual;
	}
	
	public void asignarPalabraActual(Palabra<TipoSimbolo> p) {
		this.palabraActual = p;
		this.indiceActual = 0;
		this.resto = p.subPalabra(0, p.longitud() -1);
	}

	public void asignarEstadoInicial(String s) {
		this.estadoInicial = s;
	}

	public void asignarEstadosFinales(Lista<String> estFinales) {
		// TODO Auto-generated me
		this.estadosFinales = estFinales;
	}

	public void leerSiguiente() {
		this.estadoActual = fdt.obtenerEstado(this.estadoActual, this.palabraActual.simboloEn(indiceActual));
		indiceActual++;
		if(indiceActual >= palabraActual.longitud() ||  this.palabraActual == null) {
			indiceActual++;
			return;
		}
			
		this.resto = palabraActual.subPalabra(indiceActual, palabraActual.longitud() -1);
		
	}

	public String snapShot() {
		if(indiceActual == palabraActual.longitud() -1)
			return "[[ " + this.estadoActual + ",]]";
		return "[[ " + this.estadoActual + ", " + resto.toString() + " ]]";
	}

	public String snapShotChain(Palabra<TipoSimbolo> p) {
		this.palabraActual = p;
		this.resto = p.subPalabra(0, p.longitud() -1);
		this.indiceActual = 0;
		this.estadoActual = this.estadoInicial;
		String s = "";
		while(indiceActual < this.palabraActual.longitud()) {
			if(indiceActual > 0 && indiceActual <= this.palabraActual.longitud()) 
				s += "\n|--m";
			s += this.snapShot();
			leerSiguiente();
		}
		return s;
	}
	
	public boolean acepta(Palabra<TipoSimbolo> p) {
		String estado = this.estadoInicial;
		for(int i =0, c = p.longitud(); i < c; i++) {
			estado = fdt.obtenerEstado(estado, p.simboloEn(i));
		}
		return estadosFinales.existe(estado);
	}
	
	public boolean esEquivalente(AFD<TipoSimbolo> a) {
		return false;
	}
	
	public String[][] procedimientoEquivalencia() {
		return null;
	}
	
	public FuncionDeTransicion<TipoSimbolo>obtenerFdt() {
		return this.fdt;
	}
	
}
