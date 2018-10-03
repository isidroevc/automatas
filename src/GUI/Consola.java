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
	String arr[],mat[][],arr1[],arr2[];
	public AFD leerAFD(){
		teclado= new Scanner(System.in);
		alfa=new Lista<String>();
        estadoFinal=new Lista<String>();
        conjuntoEst=new Lista<String>();
		System.out.println("Escribe los dats separados por coma ");
		System.out.println("Escribe el alfabeto");
		alfabeto=teclado.nextLine().trim();
		System.out.println("Escribe el estado inicial");
		estIni=teclado.nextLine().trim();
		System.out.println("Escribe el conjunto de estados");
		conEst=teclado.nextLine().trim();
		System.out.println("Escribe el estado final");
		estFin=teclado.nextLine().trim();
		arr=alfabeto.split(",");
		for(int i=0;i<arr.length;i++){
			alfa.agregar(arr[i]);
		}
		arr1=conEst.split(",");
		for(int i=0;i<arr1.length;i++){
			conjuntoEst.agregar(arr1[i]);
		}
		arr2=estFin.split(",");
		for(int i=0;i<arr2.length;i++){
			estadoFinal.agregar(arr2[i]);
		}
		mat=new String[conjuntoEst.longitud()][alfa.longitud()];
		for(int i = 0, c = conjuntoEst.longitud(); i < c; i++) {
			for(int j = 0, l = alfa.longitud(); j < l; j++) {
				System.out.println("Escriba la transicion para (" + conjuntoEst.obtener(i) + ", " + alfa.obtener(j) + ") : ");
				mat[i][j] = teclado.nextLine();
			}
		}
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[0].length;j++){
				System.out.print(mat[i][j]+"\t");
			}
			System.out.println("");
			
		}
		fdt=new FuncionDeTransicion<String>(conjuntoEst,alfa,mat);
		return new AFD<String>(estIni,estadoFinal,fdt);
	}
	
	
}
