
public class Comision {
	private Profesor profesor;
	private Materia materia;
	private Horario horarios[];
	
	public Comision (Profesor profesor, Materia materia,Horario h,Horario h2) {
	   super ();
	   this.profesor = profesor;
	   this.materia = materia;
	   this.horarios = new Horario[]{h,h2};
   }
	
	public Profesor getProfesor () {
		return profesor;
	}
	
	public Materia getMateria () {
		return materia;
	}
	
	public Horario getHorario1 () {
		return horarios[0];
	}
	
	public Horario getHorario2 () {
		return horarios[1];
	}
	
	public Comision combinar (Comision otro) {
		Materia m; 
		Profesor p;
		Horario h,h2;
		boolean mutado =  Math.random ()<=Poblacion.mutacion;
		
		if (mutado)
			p = Poblacion.profesores.get((int) (Math.random ()*Poblacion.profesores.size ()));
		else if (otro.profesor.getNombre ().equals (profesor.getNombre ()))
			p = profesor;
		else
			p = Math.random ()>=0.5? profesor:otro.profesor;	
			
		if (otro.materia.getNombre ().equals (materia.getNombre ()) && (!mutado))
			m = materia;
		else
			m = p.getMaterias ()[(int)(Math.random ()*p.getMaterias ().length)];
		
		if (otro.horarios[0].equals (horarios[0]) && (!mutado))
			h = horarios[0];
		else
			h = p.getHorarios ()[(int)(Math.random ()*p.getHorarios ().length)];

		if (otro.horarios[1].equals (horarios[1]) && (!mutado))
			h2 = horarios[1];
		else {
			do {
				h2 = p.getHorarios ()[(int)(Math.random ()*p.getHorarios ().length)];
			} while (p.getHorarios ().length>1 && h2.equals (h));
		}
			
		return new Comision (p,m, h,h2);
	}
/*
	public boolean equals (Object obj) {
	   if (this == obj)
		   return true;
	   if (obj == null)
		   return false;
	   if (getClass () != obj.getClass ())
		   return false;
	   Comision other = (Comision) obj;
	   if (materia == null) {
		   if (other.materia != null)
			   return false;
	   }
	   else if (!materia.getNombre ().equals (other.materia.getNombre ()))
		   return false;
	   if (profesor == null) {
		   if (other.profesor != null)
			   return false;
	   }
	   else if (!profesor.getNombre ().equals (other.profesor.getNombre ()))
		   return false;
	   return true;
   }
*/
	public String toString () {
	   return "Comision [profesor=" + profesor + ", materia=" + materia + "]";
   }

	public int getId () {
		return Poblacion.profesores.indexOf (profesor)*100000+Poblacion.materias.indexOf (materia)*1000+Poblacion.materias.indexOf (horarios[0])*10+Poblacion.materias.indexOf (horarios[1]);
	}
}
