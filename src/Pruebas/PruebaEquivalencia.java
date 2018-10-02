package Pruebas;

import Automatas.AFD;
import Automatas.FuncionDeTransicion;
import Automatas.ProcedimientoEquivalencia;
import estructuras.Lista;

public class PruebaEquivalencia {
	public static void main(String[] args) {
		/*Lista<Character> alfabeto = new Lista<Character>(new Character[] {'0', '1'});
		Lista<String> estados = new Lista<String>(new String[] {"q0", "q1", "q2"});
		String[][] tabla = {{"q1", "q0"}, {"q1", "q2"}, {"q1", "q0"}}; 
		String[][] tabla2 = {{"q0", "q0"}, {"q1", "q2"}, {"q1", "q1"}}; 
		Lista<String> estadosFinales = new Lista<String>(new String[] {"q2"});
		Lista<String> estadosFinales2 = new Lista<String>(new String[] {"q1"});
		FuncionDeTransicion<Character> fdt = new FuncionDeTransicion<Character>(estados, alfabeto, tabla);
		FuncionDeTransicion<Character> fdt2 = new FuncionDeTransicion<Character>(estados, alfabeto, tabla2);
		AFD<Character> automata = new AFD<Character>("q0", estadosFinales, fdt);
		AFD<Character> automata2 = new AFD<Character>("q0", estadosFinales, fdt2);
		ProcedimientoEquivalencia<Character> proc = automata.compararEquivalencia(automata);
		System.out.println("Equivalentes: " + proc.equivalentes());
		String[][] procedimiento = proc.procedimiento();
		for(int i =0, c = procedimiento.length; i < c; i++) {
			for(int j = 0; j < procedimiento[i].length; j++) {
				System.out.print(procedimiento[i][j] + "   ");
			}
			System.out.print("\n");
		}*/
	}
}
