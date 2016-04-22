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
	
	public boolean esSuMateria (Materia materia) {
		for (Materia m : materias) {
			if (m.equals(materia))
				return true;
		}
		return false;
	}
	
	public String toString () {
	   return "Profesor [nombre=" + nombre + ", materias = "+Arrays.toString(materias)+"]";
   }
	
	public static int getContadorH () {
		return contadorHorarios;
	}
}
