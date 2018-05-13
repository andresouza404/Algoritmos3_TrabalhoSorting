package comparators;
import java.util.Comparator;

import model.Pessoa;

public class SearchByName implements Comparator<Pessoa>{

	@Override
	public int compare(Pessoa o1, Pessoa o2) {
		if (o1.getNome().equals(o2.getNome())) {
			return 0;
		}if (o1.getNome().compareToIgnoreCase(o2.getNome()) > 0) {
			return 1;
		}
		return -1;
		
		
	}
}
