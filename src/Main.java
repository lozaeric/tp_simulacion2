import java.util.ArrayList;

public class Main {
	public static void main (String[] args) {
		//Materias que deben darse
		ArrayList<Materia> materias = new ArrayList<Materia>();
		materias.add (new Materia("algoritmo"));
		materias.add (new Materia("fisica"));
		materias.add (new Materia("analisis"));
		materias.add (new Materia("circuitos"));
		materias.add (new Materia("control"));
		materias.add (new Materia("objetos"));		
		Poblacion.materias = materias;
		
		//Profesores disponibles
		Horario h[] = new Horario[] {new Horario ("viernes", "mañana"), new Horario ("jueves", "mañana"), new Horario ("jueves", "tarde"), new Horario ("jueves", "mañana")};
		Horario h2[] = new Horario[] {new Horario ("martes", "mañana"), new Horario ("miercoles", "tarde"), new Horario ("miercoles", "mañana"), new Horario ("jueves", "tarde"), new Horario ("jueves", "mañana")};
		Horario h4[] = new Horario[] {new Horario ("viernes", "mañana"), new Horario ("jueves", "mañana")};
		Materia m[] = new Materia[] {Poblacion.getMateria ("control"), Poblacion.getMateria("fisica"), Poblacion.getMateria("algoritmo")};
		Materia m2[] = new Materia[] {Poblacion.getMateria("algoritmo"), Poblacion.getMateria("analisis")};
		Materia m3[] = new Materia[] {Poblacion.getMateria("objetos"),Poblacion.getMateria("algoritmo"), Poblacion.getMateria("analisis")};
		Materia m4[] = new Materia[] {Poblacion.getMateria("circuitos"),Poblacion.getMateria("algoritmo"), Poblacion.getMateria("analisis")};
		ArrayList<Profesor> profesores = new ArrayList<Profesor>();
		profesores.add (new Profesor (m,h, "a"));
		profesores.add (new Profesor (m2,h2, "b"));		
		profesores.add (new Profesor (m3,h2, "c"));
		profesores.add (new Profesor (m4,h4, "d"));	
		profesores.add (new Profesor (m2,h2, "e"));		
		profesores.add (new Profesor (m3,h2, "f"));
		profesores.add (new Profesor (m4,h4, "g"));			
		profesores.add (new Profesor (m2,h2, "h"));		
		profesores.add (new Profesor (m3,h2, "i"));
		profesores.add (new Profesor (m4,h4, "j"));	
		profesores.add (new Profesor (m2,h2, "l"));		
		profesores.add (new Profesor (m3,h2, "m"));
		profesores.add (new Profesor (m4,h4, "n"));	
		profesores.add (new Profesor (m2,h2, "b2"));		
		profesores.add (new Profesor (m3,h2, "c2"));
		profesores.add (new Profesor (m4,h4, "d2"));	
		profesores.add (new Profesor (m2,h2, "e2"));		
		profesores.add (new Profesor (m3,h2, "f2"));
		profesores.add (new Profesor (m4,h4, "g2"));			
		profesores.add (new Profesor (m2,h2, "h2"));		
		profesores.add (new Profesor (m3,h2, "i2"));
		profesores.add (new Profesor (m4,h4, "j2"));	
		profesores.add (new Profesor (m2,h2, "l2"));		
		profesores.add (new Profesor (m3,h2, "m2"));
		profesores.add (new Profesor (m4,h4, "n2"));	
		profesores.add (new Profesor (m2,h2, "b3"));		
		profesores.add (new Profesor (m3,h2, "c3"));
		profesores.add (new Profesor (m4,h4, "d3"));	
		profesores.add (new Profesor (m2,h2, "e3"));		
		profesores.add (new Profesor (m3,h2, "f3"));
		profesores.add (new Profesor (m4,h4, "g3"));			
		profesores.add (new Profesor (m2,h2, "h3"));		
		profesores.add (new Profesor (m3,h2, "i3"));
		profesores.add (new Profesor (m4,h4, "j3"));	
		profesores.add (new Profesor (m2,h2, "l3"));		
		profesores.add (new Profesor (m3,h2, "m3"));
		profesores.add (new Profesor (m4,h4, "n3"));	
		Poblacion.profesores = profesores;
		
		//Configuracion de otros parametros
		Poblacion.max = Profesor.contadorHorarios; 
		Poblacion.f = new Funcion ();
		Poblacion.mutacion = 0.005;
		Poblacion p = new Poblacion ();
		Individuo mejor = p.ejecutar (50); //iteraciones
		
		
		
		System.out.println (mejor);
		
	}
}
