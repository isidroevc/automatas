package GUI;

import java.util.Scanner;

import Automatas.AFD;
import Automatas.FuncionDeTransicion;
import estructuras.Lista;

public class Consola {

	private Lista<String> alfa,estadoFinal,conjuntoEst;
	private Scanner teclado;
	private FuncionDeTransicion<String> fdt;
	String alfabeto,conEst,estFin,estIni;
	String arr[],mat[][];
	public AFD leerAFD(){
		teclado= new Scanner(System.in);
		alfa=new Lista<String>();
        estadoFinal=new Lista<String>();
        conjuntoEst=new Lista<String>();
		System.out.println("Escribe los dats separados por coma ");
		System.out.println("Escribe el alfabeto");
		alfabeto=teclado.nextLine();
		System.out.println("Escribe el estado inicial");
		estIni=teclado.nextLine();
		System.out.println("Escribe el conjunto de estados");
		conEst=teclado.nextLine();
		System.out.println("Escribe el estado final");
		estFin=teclado.nextLine();
		arr=alfabeto.split(",");
		for(int i=0;i<arr.length;i++){
			alfa.agregar(arr[i]);
		}
		arr=conEst.split(",");
		for(int i=0;i<arr.length;i++){
			conjuntoEst.agregar(arr[i]);
		}
		arr=estFin.split(",");
		for(int i=0;i<arr.length;i++){
			estadoFinal.agregar(arr[i]);
		}
		mat=new String[conjuntoEst.longitud()+1][alfa.longitud()+1];
		for(int i = 0, c = conjuntoEst.longitud(); i < c; i++) {
			for(int j = 0, l = alfa.longitud(); j < l; j++) {
				System.out.println("Escriba la transicion para (" + conjuntoEst.obtener(i) + ", " + alfa.obtener(j) + ") : ");
				mat[i][j] = teclado.nextLine();
			}
		}

		fdt=new FuncionDeTransicion<String>(conjuntoEst,alfa,mat);
		return new AFD<String>(estIni,estadoFinal,fdt);
	}
	
	
}
