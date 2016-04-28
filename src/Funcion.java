import java.util.Arrays;
import java.util.HashMap;



public class Funcion {
	public static double ejecutar (Comision[] adn) {
		double fitness = 0;
		int[] contadorP = new int[Poblacion.profesores.size ()], contadorM = new int[Poblacion.materias.size ()];
		HashMap<Integer, Integer[]> horarios = new HashMap<Integer, Integer[]>();
		Profesor p;
		Materia m;
		Horario h1,h2;
		
		for (Comision c : adn) {
			p = c.getProfesor ();
			m = c.getMateria();
			h1 = c.getHorario1 ();
			h2 = c.getHorario2();
			
				//verifica si hay horarios que se superponen
				if (!horarios.containsKey (Poblacion.profesores.indexOf (p))) {
					horarios.put (Poblacion.profesores.indexOf (p), new Integer[] {Poblacion.horarios.indexOf (h1),Poblacion.horarios.indexOf (h2)});		
				}
				else {
					Integer array[] = horarios.get (Poblacion.profesores.indexOf (p));
					Integer nuevo[] = Arrays.copyOf (array, array.length+2);
					nuevo [nuevo.length-1] = Poblacion.horarios.indexOf (h1);
					nuevo [nuevo.length-2] = Poblacion.horarios.indexOf (h2);
					for (Integer i : array) {
						if (i!=nuevo [nuevo.length-1]&&i!=nuevo [nuevo.length-2])
							fitness+=100;
					}
					horarios.put (Poblacion.profesores.indexOf (p), nuevo);		
				}
				//contadores de profesores y materias
				if (contadorP[Poblacion.profesores.indexOf (p)]++==0)
					fitness+=350;
				if (contadorM[Poblacion.materias.indexOf (m)]++==0)
					fitness+=350;	
				//evita que cada profesor tenga mas horarios de los que puede
				if (contadorP[Poblacion.profesores.indexOf (p)]<p.getHorarios ().length/2)
					fitness+=500;
				else if (contadorP[Poblacion.profesores.indexOf (p)]==p.getHorarios ().length/2) 
					fitness+=1000;		
				//pequeñas mejoras
				if (p.esSuMateria (m)) 
					fitness+=25;
				if (h1.esDistintoDia(h2))
					fitness+=200;
				if (h1.tieneMismoHorario(h2))
					fitness+=100;
		}
		
		
		return fitness;
	}
	
}
