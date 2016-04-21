import java.util.Arrays;


public class Individuo {
	private byte[] adnB;

	public Individuo () {
		adnB = new byte[Poblacion.max];		
		for (int i=0; i<adnB.length; i++) 
			adnB[i] = (byte) (Math.random ()>=0.5? 1:0);
   }
	
	public Individuo (byte[] adnB) {
		this.adnB = adnB;
   }
	
	public byte[] getAdnB () {
		return adnB;
	}
	
	public String toString () {
		StringBuilder sb = new StringBuilder ();
		int idP, idM;
		
		for (int i=0; i<adnB.length/5; i+=2) {
			idP = Individuo.binInt (Arrays.copyOfRange (adnB, 5*i, 5*(i+1)));
			idM = Individuo.binInt (Arrays.copyOfRange (adnB, 5*(i+1), 5*(i+2)));
			if (Poblacion.getProfesor (idP)!=null && Poblacion.getMateria (idM)!=null)
				sb.append(Poblacion.getProfesor (idP)+" "+Poblacion.getMateria (idM)+'\n');
		}
		return sb.toString ();
	}

	
	public static int binInt (byte[] adn) {
		int adnI = 0;
		
		for (int i=0; i<adn.length; i++) 
			adnI += Math.pow (2, adn.length-1-i) * adn[i];
		return adnI;
	}
}
