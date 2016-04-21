import java.util.Arrays;


public class Profesor {
	private Materia[] materias;
	private Horario[] horarios;
	private String nombre;
	public static int contadorHorarios = 0;
	
	public Profesor(Materia[] materias, Horario[] horarios, String nombre) {
		this.materias = materias;
		this.horarios = horarios;
		this.nombre = nombre;
		contadorHorarios += horarios.length;
	}
	public Materia[] getMaterias() {
		return materias;
	}
	public Horario[] getHorarios() {
		return horarios;
	}
	public String getNombre() {
		return nombre;
	}
	
	public int getId () {
		int id = 0;
		for (char c : nombre.toCharArray ())
			id += c-96;
		return id;
	}
	public static int getId (String nombre) {
		int id = 0;
		for (char c : nombre.toCharArray ())
			id += c-96;
		return id;
	}
	public String toString () {
	   return "Profesor [nombre=" + nombre + "]";
   }
	
	public static int getContadorH () {
		return contadorHorarios;
	}
}
