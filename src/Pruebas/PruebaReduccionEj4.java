package Pruebas;

import Automatas.AFD;
import Automatas.FuncionDeTransicion;
import estructuras.Lista;

public class PruebaReduccionEj4{
	public static void main(String[] args) {
		Lista<Character> alfabeto = new Lista<Character>(new Character[] {'0', '1'});
		Lista<String> estados = new Lista<String>(("ABCDEFGHI").split(""));
		Lista<String> estadosFinales = new Lista<String>(new String[]{"C", "F", "I"});
		String estadoInicial = "A";
		String[][] tabla = {
			{"B","E"},
			{"C","F"},
			{"D","H"},
			{"E","H"},
			{"F","I"},
			{"G","B"},
			{"H","B"},
			{"I","C"},
			{"A","E"}
		};
		FuncionDeTransicion<Character> fdt = new FuncionDeTransicion<Character>(estados, alfabeto, tabla);
		AFD<Character> afd = new AFD<Character>(estadoInicial, estadosFinales, fdt);
		AFD<Character> afdr = afd.reducir();
		System.out.println(afdr.toString());
		System.out.println("Equivalentes: " + afd.esEquivalente(afdr));
	}
}
