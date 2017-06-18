package generadores;

public class Main {

	public static void main(String[] args) {
		GeneradorRegularConGrado gnReg = new GeneradorRegularConGrado(4, 2);
		gnReg.solve();
		gnReg.mostrarSolucion();
	}

}
