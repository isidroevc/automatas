package Pruebas;

import Utileria.Convertidor;
import Automatas.AFD;
import Automatas.FuncionDeTransicion;
import Automatas.Palabra;
import estructuras.Lista;

public class PruebaAutomata {
	public static void main(String[] args) {
		Lista<Character> alfabeto = new Lista<Character>(new Character[] {'0', '1'});
		Lista<String> estados = new Lista<String>(new String[] {"q0", "q1", "q2"});
		String[][] tabla = {{"q1", "q0"}, {"q1", "q2"}, {"q1", "q0"}}; 
		Lista<String> estadosFinales = new Lista<String>(new String[] {"q2"});
		FuncionDeTransicion<Character> fdt = new FuncionDeTransicion<Character>(estados, alfabeto, tabla);
		AFD<Character> automata = new AFD<Character>("q0", estadosFinales, fdt);
		System.out.println("q0, 0 -> " + fdt.obtenerEstado("q0", '0'));
		System.out.println("q0, 1 -> " + fdt.obtenerEstado("q0", '1'));
		
		System.out.println("q1, 0 -> " + fdt.obtenerEstado("q1", '0'));
		System.out.println("q1, 1 -> " + fdt.obtenerEstado("q1", '1'));
		
		System.out.println("q2, 0 -> " + fdt.obtenerEstado("q2", '0'));
		System.out.println("q2, 1 -> " + fdt.obtenerEstado("q2", '1'));
		
		Palabra<Character> palabra = Convertidor.toPalabra("001");
		System.out.println(automata.snapShotChain(palabra));
	}
}
