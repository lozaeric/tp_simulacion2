
public class Profesor {
	private String[] materias;
	private Horario[] horarios;
	private String nombre;
	private byte id;
	private static byte _id = 0;
	
	public Profesor(String[] materias, Horario[] horarios, String nombre) {
		this.materias = materias;
		this.horarios = horarios;
		this.nombre = nombre;
		_id += 1;
		id = _id;
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
	
	public byte getId () {
		return id;
	}
}
