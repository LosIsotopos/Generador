package generadores;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GeneradorRegularConGrado {
	private int cantNodos;
	private int grado;
	private List<Nodo> nodos = new LinkedList<Nodo>();
	
	public GeneradorRegularConGrado(int cantNodos, int grado) {
		this.cantNodos = cantNodos;
		this.grado = grado;
		for (int i = 0; i < cantNodos; i++) {
			nodos.add(new Nodo(i));
		}
	}
	
	public void solve() {
		Iterator<Nodo> it = nodos.iterator();
		Nodo aux = null;
		int idNodoAux;
		while(it.hasNext()) {
			aux = it.next();
			while(aux.getCantAristas() != grado) {
				idNodoAux = new Random().nextInt(nodos.size());
				// Evito que la ariasta sea un rulo a sí mismo
				if(idNodoAux != aux.getIdNodo()){
					nodos.get(aux.getIdNodo()).aumentarAristas(idNodoAux);
					nodos.get(idNodoAux).aumentarAristas(aux.getIdNodo());
				}
			}
		}
		
	}
	
	public void mostrarSolucion() {
		for (int i = 0; i < nodos.size(); i++) {
			System.out.println(nodos.get(i).getCantAristas());
		}
	}
}
