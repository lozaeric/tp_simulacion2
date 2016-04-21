
public class Materia {
	private String nombre;
	
	public Materia (String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	public int getId () {
		int id = 0;
		for (char c : nombre.toCharArray ())
			id += c-96;
		return id;
	}
	public static int getId (String nombre) {
		int id = 0;
		for (char c : nombre.toCharArray ())
			id += c-96;
		return id;
	}
	public String toString () {
	   return "Materia [nombre=" + nombre + "]";
   }
	
	
}
