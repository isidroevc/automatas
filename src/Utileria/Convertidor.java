package Utileria;

import Automatas.Palabra;
import estructuras.Lista;

public class Convertidor{
	public static Palabra<Character> toPalabra(String s){
		char[] chars = s.toCharArray();
		Lista<Character> l = new Lista<Character>();
		for(char c : chars) {
			l.agregar(c);
		}
		return new Palabra<Character>(l);
	}
}
