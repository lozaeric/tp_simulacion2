
public class Horario {
	private String turno, dia;
	private byte id;
	private static byte _id = 0;

	public Horario(String turno, String dia) {
		super();
		this.turno = turno;
		this.dia = dia;
		_id += 1;
		id = _id;
	}

	public String getTurno() {
		return turno;
	}

	public String getDia() {
		return dia;
	}
	
	public byte getId () {
		return id;
	}
}
