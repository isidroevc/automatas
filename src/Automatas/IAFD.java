package Automatas;

import estructuras.Lista;

public interface IAFD<TipoDatos> {
	public void agregarAlfabeto(Lista<Object> alf);
	public void asignarrEstadosFinales(Lista<String> estFinales);
	public void asignarConjuntoEstados(Lista<String> est);
	public void transiciones(FuncionDeTransicion ftd);
}