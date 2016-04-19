
public class Materia {
	private String nombre;
	private byte id;
	private static byte _id = 0;
	
	public Materia (String nombre) {
		this.nombre = nombre;
		horario = new Horario[2];
		_id += 1;
		id = _id;
	}

	public String getNombre() {
		return nombre;
	}
	
	public byte getId () {
		retur id;
	}
}
