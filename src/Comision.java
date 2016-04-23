
public class Comision {
	private Profesor profesor;
	private Materia materia;
	
	
	public Comision (Profesor profesor, Materia materia) {
	   super ();
	   this.profesor = profesor;
	   this.materia = materia;
   }
	
	public Profesor getProfesor () {
		return profesor;
	}
	
	public Materia getMateria () {
		return materia;
	}
	
	public Comision combinar (Comision otro) {
		Materia m; 
		Profesor p;
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
		
		return new Comision (p,m);
	}

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

	public String toString () {
	   return "Comision [profesor=" + profesor + ", materia=" + materia + "]";
   }

	public int getId () {
		return Poblacion.profesores.indexOf (profesor)*100+Poblacion.materias.indexOf (materia);
	}
}
