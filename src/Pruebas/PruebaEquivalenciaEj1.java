package Pruebas;

import Automatas.AFD;
import Automatas.FuncionDeTransicion;
import estructuras.Lista;

public class PruebaEquivalenciaEj1 {
	public static void main(String[] args) {
		Lista<Character> alfabeto = new Lista<Character>(new Character[] {'a', 'b'});
		Lista<String> estados = new Lista<String>(("ABCDEFGHIJ").split(""));
		Lista<String> estadosFinales = new Lista<String>(new String[]{"D", "E", "G"});
		String estadoInicial = "A";
		String[][] tabla = {
			{"B","C"},
			{"D","E"},
			{"A","B"},
			{"C","F"},
			{"G","H"},
			{"H","B"},
			{"I","I"},
			{"J","F"},
			{"H","J"},
			{"G","E"}
		};
		FuncionDeTransicion<Character> fdt = new FuncionDeTransicion<Character>(estados, alfabeto, tabla);
		AFD<Character> afd = new AFD<Character>(estadoInicial, estadosFinales, fdt);
		AFD<Character> afdr = afd.reducir();
		System.out.println(afdr.toString());
		System.out.println("Equivalentes: " + afd.esEquivalente(afdr));
	}
}
