package Entrega;

import estructuras.Lista;
import Automatas.AFD;
import Automatas.FuncionDeTransicion;
import Automatas.ProcedimientoEquivalencia;
import Utileria.Convertidor;

public class EntregaEquivalencia {
	public static void main(String[] args) {
		Lista<Character> alfabeto = new Lista<Character>(new Character[] {'a', 'b'});
		Lista<String> estados1 = new Lista<String>(new String[] {"q0", "q1", "q2"});
		Lista<String> estadosFinales1 = new Lista<String>(new String[] {"q0", "q2"});
		String[][] transiciones1 = {{"q2", "q1"}, {"q1", "q1"}, {"q0", "q1"}};
		FuncionDeTransicion<Character> fdt1 = new FuncionDeTransicion<Character> (estados1, alfabeto, transiciones1);
		
		Lista<String> estados2 = new Lista<String>(new String[] {"q0", "r1"});
		Lista<String> estadosFinales2 = new Lista<String>(new String[] {"q0"});
		String[][] transiciones2 = {{"q0", "r1"}, {"r1", "r1"}};
		
		FuncionDeTransicion<Character> fdt2 = new FuncionDeTransicion<Character> (estados2, alfabeto, transiciones2);
		
		AFD<Character> automata1 = new AFD<Character>("q0", estadosFinales1, fdt1);
		AFD<Character> automata2 = new AFD<Character>("q0", estadosFinales2, fdt2);
		
		ProcedimientoEquivalencia<Character> proc = automata1.compararEquivalencia(automata2);
		
		System.out.println(proc.equivalentes());
		
	}
}
