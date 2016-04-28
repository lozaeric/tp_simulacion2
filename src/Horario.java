
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


	public boolean equals (Object obj) {
	   if (this == obj)
		   return true;
	   if (obj == null)
		   return false;
	   if (getClass () != obj.getClass ())
		   return false;
	   Horario other = (Horario) obj;
	   if (dia == null) {
		   if (other.dia != null)
			   return false;
	   }
	   else if (!dia.equals (other.dia))
		   return false;
	   if (turno == null) {
		   if (other.turno != null)
			   return false;
	   }
	   else if (!turno.equals (other.turno))
		   return false;
	   return true;
   }
	
	
}
