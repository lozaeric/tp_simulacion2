
public class Materia {
	private String nombre;
	private Horario horario[];
	//private Profesor profesor;
	
	public Materia (String nombre) {
		this.nombre = nombre;
		horario = new Horario[2];
	}

	public Horario[] getHorario() {
		return horario;
	}

	public void setHorario(Horario[] horario) {
		this.horario = horario;
	}
/*
	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
*/
	public String getNombre() {
		return nombre;
	}
}
