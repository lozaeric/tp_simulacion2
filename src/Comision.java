
public class Comision {
	private Profesor profesor;
	private Materia materia;
	private Horario[] horarios;
	private byte id;
	private static byte _id = 0;
	
	public Comision (Profesor profesor, Materia materia, Horario[] horarios) {
	   super ();
	   this.profesor = profesor;
	   this.materia = materia;
	   this.horarios = horarios;
		_id += 1;
		id = _id;
   }
	
	public Profesor getProfesor () {
		return profesor;
	}
	public Materia getMateria () {
		return materia;
	}
	public Horario[] getHorarios () {
		return horarios;
	}
	
	public byte getId () {
		return id;
	}
}
