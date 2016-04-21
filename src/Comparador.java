import java.util.Comparator;


public class Comparador implements Comparator <Individuo> {
	public int compare (Individuo o1, Individuo o2) {
		if (Poblacion.f.ejecutar (o1.getAdnB ())==Poblacion.f.ejecutar (o2.getAdnB ()))
			return 0;
	   return Poblacion.f.ejecutar (o1.getAdnB ())<Poblacion.f.ejecutar (o2.getAdnB ())? 1:-1;
   }
}
