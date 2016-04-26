


public class Individuo {
	private Comision comisiones[];

	public Individuo () {
		comisiones = new Comision[Poblacion.max];		
		for (int i=0; i<comisiones.length; i++) 
			comisiones[i] = new Comision(Poblacion.profesores.get((int) (Math.random ()*Poblacion.profesores.size ())), Poblacion.materias.get ((int) (Math.random ()*Poblacion.materias.size ())));
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
		int[] contadorP = new int[Poblacion.profesores.size ()];
		int i=1;
		
		for (Comision c : comisiones) {
			contadorP[Poblacion.profesores.indexOf (c.getProfesor ())]++;
			if (contadorP[Poblacion.profesores.indexOf (c.getProfesor ())]<=c.getProfesor ().getHorarios ().length/2 && c.getProfesor ().esSuMateria (c.getMateria ()))
				sb.append("Comision "+(i++)+'\t'+c.getProfesor ().toString ()+'\t'+c.getMateria ().toString ()+'\n');
			else
				System.out.println ("Comision incoherente, sus datos son obviados"+'\n');
		}
		return sb.toString ();
	}
}
