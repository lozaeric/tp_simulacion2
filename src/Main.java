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
		Horario h[] = new Horario[] {new Horario ("viernes", "mañana"), new Horario ("jueves", "mañana"), new Horario ("jueves", "noche"), new Horario ("miercoles", "noche")};
		Horario h2[] = new Horario[] {new Horario ("martes", "mañana"), new Horario ("miercoles", "noche")};
		Horario h4[] = new Horario[] {new Horario ("viernes", "noche"),new Horario ("martes", "mañana")};
		Materia m[] = new Materia[] {Poblacion.getMateria ("objetos"),Poblacion.getMateria ("control"), Poblacion.getMateria("fisica"), Poblacion.getMateria("algoritmo")};
		Materia m2[] = new Materia[] {Poblacion.getMateria("algoritmo"), Poblacion.getMateria("analisis")};
		Materia m3[] = new Materia[] {Poblacion.getMateria("control"),Poblacion.getMateria("algoritmo"), Poblacion.getMateria("analisis")};
		Materia m4[] = new Materia[] {Poblacion.getMateria("objetos"),Poblacion.getMateria("circuitos"), Poblacion.getMateria("analisis")};
		ArrayList<Profesor> profesores = new ArrayList<Profesor>();
		profesores.add (new Profesor (m,h, "adriana"));
		profesores.add (new Profesor (m2,h, "fagalde"));		
		profesores.add (new Profesor (m3,h, "mayer"));
		profesores.add (new Profesor (m,h4, "dratman"));	
		profesores.add (new Profesor (m2,h2, "ezequiel"));		
		profesores.add (new Profesor (m3,h2, "federico"));
		profesores.add (new Profesor (m4,h4, "graciana"));
		Poblacion.profesores = profesores;
		
		//Configuracion de otros parametros
		Poblacion.max = Profesor.contadorHorarios; 
		Poblacion.f = new Funcion ();
		Poblacion.mutacion = 0.01;
		Poblacion p = new Poblacion ();
		Individuo mejor = p.ejecutar (30); //iteraciones
		
		
		
		System.out.println (mejor);
		
	}
}
