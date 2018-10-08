package Pruebas;

import Automatas.AFD;
import Automatas.FuncionDeTransicion;
import estructuras.Lista;

public class PruebaReduccionEj3{
	public static void main(String[] args) {
		Lista<Character> alfabeto = new Lista<Character>(new Character[] {'0', '1'});
		Lista<String> estados = new Lista<String>(("ABCDEFGH").split(""));
		Lista<String> estadosFinales = new Lista<String>(new String[]{"D"});
		String estadoInicial = "A";
		String[][] tabla = {
			{"B","A"},
			{"A","C"},
			{"D","B"},
			{"D","A"},
			{"D","F"},
			{"G","E"},
			{"F","G"},
			{"G","D"},
		};
		FuncionDeTransicion<Character> fdt = new FuncionDeTransicion<Character>(estados, alfabeto, tabla);
		AFD<Character> afd = new AFD<Character>(estadoInicial, estadosFinales, fdt);
		AFD<Character> afdr = afd.reducir();
		System.out.println(afdr.toString());
		System.out.println("Equivalentes: " + afd.esEquivalente(afdr));
	}
}
