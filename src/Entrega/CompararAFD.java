package Entrega;

import Automatas.AFD;
import Automatas.ProcedimientoEquivalencia;
import GUI.Consola;

public class CompararAFD {
	public static void main(String args[]){
		Consola c= new Consola();
		AFD Q = c.leerAFD();
		AFD Q1= c.leerAFD();
		ProcedimientoEquivalencia pe=Q.compararEquivalencia(Q1);
		String mat[][]=pe.procedimiento();
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[0].length;j++){
				System.out.print(mat[i][j]+"\t");
			}
			System.out.println("");
			
		}
		if(pe.equivalentes()){
			System.out.println("Si son equivalentes");
		}else{
			System.out.println("No son equivalentes");
			
		}
		
	}
}
