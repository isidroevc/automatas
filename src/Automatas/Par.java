package Automatas;

public class Par<TipoA, TipoB> {
	TipoA a;
	TipoB b;
	
	public Par(TipoA a, TipoB b) {
		this.a  = a;
		this.b = b;
	}
	public Par() {
	}
	
	@Override
	public String toString() {
		return "(" + a.toString() + ", " + b.toString() + ")";
	}
	
	@Override
	public boolean equals(Object b) {
		Par<TipoA, TipoB> aux = (Par<TipoA, TipoB>)b;
		return aux.a.equals(this.a) && aux.b.equals(this.b);
	}
}
