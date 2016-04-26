
public class Horario {
	private String turno, dia;

	public Horario(String dia, String turno) {
		super();
		this.turno = turno;
		this.dia = dia;
	}

	public String getTurno() {
		return turno;
	}

	public String getDia() {
		return dia;
	}
	
	public boolean tieneMismoHorario (Horario otro){
		return otro.turno.equals(turno); 
	}
	
	public boolean esDistintoDia (Horario otro){
		return ! otro.dia.equals(dia); 
	}
	
	public String toString () {
		return "dia: "+dia+", turno="+turno;
	}
}
