import java.util.Arrays;
import java.util.HashMap;


public class Funcion {
	public static long ejecutar (byte[] adnB) {
		int divisiones = adnB.length/10;
		long fitness = 0;
		HashMap<Integer, Integer> contador = new HashMap<Integer,Integer>(), contadorMaterias = new HashMap<Integer,Integer>();
		Profesor p;
		Materia m;
		
		for (int i=0; i<divisiones; i++) {
			byte[] comision = Arrays.copyOfRange (adnB, 10*i, 10*(i+1));
			

			p = Poblacion.getProfesor (Individuo.binInt (Arrays.copyOfRange (comision, 0 , 5)));
			m = Poblacion.getMateria(Individuo.binInt (Arrays.copyOfRange (comision, 5, 10)));
			
			if (p!=null && m!=null) {
				if (contador.containsKey (Individuo.binInt (Arrays.copyOfRange (comision, 0 , 5))))
					contador.put (Individuo.binInt (Arrays.copyOfRange (comision, 0 , 5)), 1+contador.get (Individuo.binInt (Arrays.copyOfRange (comision, 0 , 5))));
				else
					contador.put (Individuo.binInt (Arrays.copyOfRange (comision, 0 , 5)), 1);			
				if (contadorMaterias.containsKey (Individuo.binInt (Arrays.copyOfRange (comision, 5 , 10))))
					contadorMaterias.put (Individuo.binInt (Arrays.copyOfRange (comision, 5 , 10)), 1+contadorMaterias.get (Individuo.binInt (Arrays.copyOfRange (comision, 5 , 10))));
				else
					contadorMaterias.put (Individuo.binInt (Arrays.copyOfRange (comision, 5 , 10)), 1);						
				for (Materia materia : p.getMaterias ()) {
					if (materia.getNombre ().equals (m.getNombre ())) 
						fitness+=20;
				}
			}
		}
		for (Integer i : contador.keySet ()) {
				if (contador.get (i)<=Poblacion.getProfesor (i).getHorarios ().length/2)
					fitness+=20;
		}		
		fitness+=contadorMaterias.keySet ().size ();
		return fitness;
	}
	
}
