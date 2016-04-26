

public class Funcion {
	public static double ejecutar (Comision[] adn) {
		double fitness = 0;
		int[] contadorP = new int[Poblacion.profesores.size ()], contadorM = new int[Poblacion.materias.size ()];
		Profesor p;
		Materia m;
		Horario h1,h2;
		
		for (Comision c : adn) {
			p = c.getProfesor ();
			m = c.getMateria();
			h1 = c.getHorario1 ();
			h2 = c.getHorario2();
			

				if (contadorP[Poblacion.profesores.indexOf (p)]++==0)
					fitness+=350;
				if (contadorP[Poblacion.profesores.indexOf (p)]<p.getHorarios ().length/2)
					fitness+=500;
				else if (contadorP[Poblacion.profesores.indexOf (p)]==p.getHorarios ().length/2) 
					fitness+=1000;
				if (contadorM[Poblacion.materias.indexOf (m)]++==0)
					fitness+=350;			
				if (p.esSuMateria (m)) 
					fitness+=20;
				if (h1.esDistintoDia(h2))
					fitness+=30;
				if (h1.tieneMismoHorario(h2))
					fitness+=10;
		}
		
		
		return fitness;
	}
	
}
