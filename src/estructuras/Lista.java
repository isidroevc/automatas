package estructuras;

import Excepciones.ElementoNoEncontrado;

public class Lista<TipoDato> implements ILista<TipoDato>{
	private  Nodo<TipoDato> inicio;
	private  Nodo<TipoDato> fin;
	private  int longitud = 0;
	//Constructors
	
	public Lista() {

	}
	
	public Lista(TipoDato[] arr) {
		for(int i = 0, c = arr.length; i < c; i++) {
			this.agregar(arr[i]);
		}
	}
	
	public Lista(long longitud) {
		for(long i = 0, c = longitud; i < c; i++) {
			this.agregar(null);
		}
	}

	public void agregar(TipoDato d) {
		if(this.inicio == null) {
			this.inicio = new Nodo<TipoDato>(d);
			this.fin = this.inicio;
		} else {
			this.fin.next = new Nodo<TipoDato>(d);
			this.fin = this.fin.next;
		}
		longitud++;
	}
	
	public int indice(TipoDato d) {
		Nodo<TipoDato> cursor = this.inicio;
		int i = 0;
		while(cursor != null) {
			if(cursor.dato.equals(d)) {
				return i;
			}
			cursor = cursor.next;
			i++;
		}
		return -1;
	}

	public void quitar(int index) {
		if(index > this.longitud - 1 || index < 0)
			throw new IndexOutOfBoundsException("Index out of bounds");
		Nodo<TipoDato> n = this.inicio;
		int i = 0;
		if(index == 0) {
			this.inicio = this.inicio.next;
			longitud--;
			return;
		}
		while(n != null) {
			if(i == index -1)
				break;
			n = n.next;
			i++;
		}
		if(i < index - 1)
			throw new ElementoNoEncontrado("Not found");
		n.next = n.next.next;
		longitud--;
	}

	public void agregarEn(int index, TipoDato d) {
		if(index > this.longitud - 1 || index < 0)
			throw new ElementoNoEncontrado("Not found");
		Nodo<TipoDato> n = new Nodo<TipoDato>(d);
		Nodo<TipoDato> cursor = this.inicio;
		int i = 0;
		if(index == 0) {
			n.next = this.inicio;
			this.inicio = n;
			longitud++;
			return;
		}
		while(cursor != null) {
			if(i == index -1)
				break;
			cursor = cursor.next;
			i++;
		}
		if(i < index - 1)
			throw new ElementoNoEncontrado("Not found");
		n.next = cursor.next;
		cursor.next = n;
		longitud++;
	}

	public TipoDato obtener(int index) {
		if(index > this.longitud - 1 || index < 0)
			throw new ElementoNoEncontrado("Not found");
		Nodo<TipoDato> n = this.inicio;
		int i = 0;
		if(index == 0) {
			return this.inicio.dato;
		}
		while(n != null) {
			if(i == index)
				return n.dato;
			n = n.next;
			i++;
		}
		throw new ElementoNoEncontrado("Not found");
	}

	public void asignar(int index, TipoDato d) {
		if(index > this.longitud - 1 || index < 0)
			throw new ElementoNoEncontrado("Not found");
		Nodo<TipoDato> n = this.inicio;
		int i = 0;
		if(index == 0) {
			this.inicio = this.inicio.next;
			return;
		}
		while(n != null) {
			if(i == index)
				break;
			n = n.next;
			i++;
		}
		if(i < index)
			throw new ElementoNoEncontrado("Not found");
		n.next.dato = d;
	}

	public boolean existe(TipoDato d) {
		Nodo<TipoDato> cursor = this.inicio;
		while(cursor != null) {
			if(cursor.dato.equals(d)) {
				return true;
			}
			cursor = cursor.next;
		}
		return false;
	}
	
	@Override
	public String toString() {
		String result = "[";
		for(int i = 0, c = this.longitud; i < c; i++) {
			result += this.obtener(i).toString() + ((i < c -1 ) ? ", " : "");
		}
		return result + "]";
	}
	
	public int longitud() {
		return this.longitud;
	}
	
}
