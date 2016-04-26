
import java.util.ArrayList;
import java.util.Arrays;


public class Poblacion {
	private Individuo[] individuos;
	public static int max;
	public static Funcion f;
	public static double mutacion;
	public static ArrayList<Profesor> profesores = new ArrayList<Profesor> ();
	public static ArrayList<Materia> materias = new ArrayList<Materia> ();
	
	public Poblacion () {
		individuos = new Individuo [1000];
		for (int i=0; i<individuos.length; i++) 
			individuos[i] = new Individuo ();
	}
	
	public Individuo ejecutar (int iteraciones) {
		Individuo hijos[];
		int i=0;
		
		do {
			hijos = crearHijos ();
			for (int j=0; j<hijos.length; j++) 
				individuos[individuos.length-j-1] = hijos[j];
			
		} while (i++<iteraciones);
		Arrays.sort (individuos, new Comparador ());
		return individuos[0];
	}
	private Individuo[] crearHijos () {
		Individuo[] padres = padresAptos (), hijos = new Individuo[350];

		for (int i=0; i<700; i+=2) 
			hijos[i/2] = procrear (padres[i], padres[i+1]);
		
		return hijos;
	}
	
	private Individuo[] padresAptos () {
		Individuo i, _elegidos[] = new Individuo[700];
		int m=0;
		
		Arrays.sort (individuos, new Comparador ());
		do {
			i = individuos[(int)(Math.random ()*200)];
			if (m<_elegidos.length && m%2==1 && !_elegidos[m-1].equals (i))
				_elegidos[m++] = i;
			else if (m<_elegidos.length && m%2==0)
				_elegidos[m++] = i;
		} while (m<_elegidos.length);
		
		return _elegidos;
	}
	
	private static Individuo procrear (Individuo i1, Individuo i2) {
		Comision[] adn1 = i1.getAdn (), adn2 = i2.getAdn (), nuevoAdn = new Comision[Poblacion.max];
		Arrays.sort (adn1, new ComparadorComision ());
		Arrays.sort (adn2, new ComparadorComision ());
		for (int i=0; i<adn1.length; i++) 
			nuevoAdn[i] = adn1[i].combinar(adn2[i]);
		
		return new Individuo (nuevoAdn);
	}
	
	public static Materia getMateria (int id) {
		if (materias.size ()>id) 
			return materias.get (id);
		return null;
	}
	
	public static Profesor getProfesor (int id) {
		if (profesores.size ()>id) 
			return profesores.get (id);
		return null;
	}
	public static Materia getMateria (String nombre) {
		for (Materia m : materias) {
			if (m.getNombre ().equalsIgnoreCase (nombre))
				return m;
		}
		return null;
	}
	
	public static Profesor getProfesor (String nombre) {
		for (Profesor p : profesores) {
			if (p.getNombre ().equalsIgnoreCase (nombre))
				return p;
		}
		return null;
	}	
}
