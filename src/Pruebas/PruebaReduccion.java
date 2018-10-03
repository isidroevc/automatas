package Pruebas;

import Automatas.AFD;
import GUI.Consola;

public class PruebaReduccion {
	public static void main(String[] args) {
		Consola c = new Consola();
		AFD<String> afd = c.leerAFD();
		System.out.println(afd.toString());
		System.out.println("=============================================================");
		System.out.println(afd.reducir().toString());
	}
}
