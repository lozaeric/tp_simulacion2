

public class Funcion {
	public static double ejecutar (Comision[] adn) {
		double fitness = 0;
		int[] contadorP = new int[Poblacion.profesores.size ()], contadorM = new int[Poblacion.materias.size ()];
		Profesor p;
		Materia m;
		
		for (Comision c : adn) {
			p = c.getProfesor ();
			m = c.getMateria();
			
			if (p!=null) {
				fitness+=5;
				if (contadorP[Poblacion.profesores.indexOf (p)]++==0)
					fitness+=350;
				if (contadorP[Poblacion.profesores.indexOf (p)]<p.getHorarios ().length/2)
					fitness+=500;
				else if (contadorP[Poblacion.profesores.indexOf (p)]==p.getHorarios ().length/2) 
					fitness+=1000;
				if (m!=null) {			
					fitness+=10;
					if (contadorM[Poblacion.materias.indexOf (m)]++==0)
						fitness+=350;			
					if (p.esSuMateria (m)) 
						fitness+=20;
				}
			}
		}
		return fitness;
	}
	
}
