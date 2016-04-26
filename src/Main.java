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
		Horario h2[] = new Horario[] {new Horario ("martes", "mañana"), new Horario ("miercoles", "mañana")};
		Horario h4[] = new Horario[] {new Horario ("viernes", "mañana"), new Horario ("miercoles", "tarde")};
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
		Poblacion.profesores = profesores;
		
		//Configuracion de otros parametros
		Poblacion.max = Profesor.contadorHorarios; 
		Poblacion.f = new Funcion ();
		Poblacion.mutacion = 0.01;
		Poblacion p = new Poblacion ();
		Individuo mejor = p.ejecutar (50); //iteraciones
		
		
		
		System.out.println (mejor);
		
	}
}
