import java.util.Comparator;


public class ComparadorComision implements Comparator <Comision> {
	public int compare (Comision o1, Comision o2) {
		if (o1.getId ()==o2.getId ())
			return 0;
	   return o1.getId ()>o2.getId ()? 1:-1;
   }
}
