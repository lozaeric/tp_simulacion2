import java.util.Arrays;
import java.util.HashMap;




public class Individuo {
	private Comision comisiones[];

	public Individuo () {
		comisiones = new Comision[Poblacion.max];		
		for (int i=0; i<comisiones.length; i++) 
			comisiones[i] = new Comision(Poblacion.profesores.get((int) (Math.random ()*Poblacion.profesores.size ())), Poblacion.materias.get ((int) (Math.random ()*Poblacion.materias.size ())), Poblacion.horarios.get ((int) (Math.random ()*Poblacion.horarios.size ())), Poblacion.horarios.get ((int) (Math.random ()*Poblacion.horarios.size ())));
		//Arrays.sort (comisiones, new ComparadorComision ());
	}
	
	public Individuo (Comision comisiones[]) {
		this.comisiones = comisiones;
   }
	
	public Comision[] getAdn () {
		return comisiones;
	}
	
	public String toString () {
		StringBuilder sb = new StringBuilder ();
		HashMap<Integer, Integer[]> horarios = new HashMap<Integer, Integer[]>();
		int i=1;
		
		for (Comision c : comisiones) {
			if (!horarios.containsKey (Poblacion.profesores.indexOf (c.getProfesor ())))
				horarios.put (Poblacion.profesores.indexOf (c.getProfesor ()), new Integer[0]);		
			
			if (horarios.get (Poblacion.profesores.indexOf (c.getProfesor ())).length<=c.getProfesor ().getHorarios ().length && c.getProfesor ().esSuMateria (c.getMateria ()) && !c.getHorario1 ().equals (c.getHorario2 ()) && c.getProfesor ().esSuHorario (c.getHorario1 ()) && c.getProfesor ().esSuHorario (c.getHorario2 ()) && !esRepetido (horarios.get (Poblacion.profesores.indexOf (c.getProfesor ())), c.getHorario1 (),c.getHorario2 ()))
				sb.append("Comision "+(i++)+'\t'+c.getProfesor ().toString ()+'\t'+c.getMateria ().toString ()+'\t'+c.getHorario1()+'\t'+c.getHorario2()+'\n');
			else {
				System.out.println ("Comision "+(i++)+'\t'+c.getProfesor ().toString ()+'\t'+c.getMateria ().toString ()+'\t'+c.getHorario1()+'\t'+c.getHorario2());
				System.out.println (esRepetido (horarios.get (Poblacion.profesores.indexOf (c.getProfesor ())), c.getHorario1 (),c.getHorario2 ()));
				System.out.println ("Comision incoherente, sus datos son obviados"+'\n');
			}
			
			Integer array[] = horarios.get (Poblacion.profesores.indexOf (c.getProfesor ()));
			Integer nuevo[] = Arrays.copyOf (array, array.length+2);
			nuevo [nuevo.length-1] = Poblacion.horarios.indexOf (c.getHorario1 ());
			nuevo [nuevo.length-2] = Poblacion.horarios.indexOf (c.getHorario2 ());
			horarios.put (Poblacion.profesores.indexOf (c.getProfesor ()), nuevo);	
		}
		return sb.toString ();
	}

	private static boolean esRepetido (Integer[] integers, Horario horario1, Horario horario2) {
	   for (Integer i : integers) {
	   	if (i==Poblacion.horarios.indexOf (horario1)||i==Poblacion.horarios.indexOf (horario2))
	   		return true;
	   }
	   return false;
   }
}
