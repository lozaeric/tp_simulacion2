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
		for (int i=0; i<adnB.length/5; i+=2) 
			sb.append(Poblacion.getProfesor (Individuo.binInt (Arrays.copyOfRange (adnB, 5*i, 5*(i+1))))+" "+Poblacion.getMateria (Individuo.binInt (Arrays.copyOfRange (adnB, 5*(i+1), 5*(i+2))))+'\n');
		return sb.toString ();
	}

	
	public static int binInt (byte[] adn) {
		int adnI = 0;
		
		for (int i=0; i<adn.length; i++) 
			adnI += Math.pow (2, adn.length-1-i) * adn[i];
		return adnI;
	}
}
