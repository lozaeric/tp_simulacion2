
public class Profesor {
	private String[] materias;
	private Horario[] horarios;
	private String nombre;
	
	public Profesor(String[] materias, Horario[] horarios, String nombre) {
		this.materias = materias;
		this.horarios = horarios;
		this.nombre = nombre;
	}
	public String[] getMaterias() {
		return materias;
	}
	public Horario[] getHorarios() {
		return horarios;
	}
	public String getNombre() {
		return nombre;
	}
}
