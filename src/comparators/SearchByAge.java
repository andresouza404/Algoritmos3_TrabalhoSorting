package comparators;
import java.util.Comparator;

import model.Pessoa;

public class SearchByAge implements Comparator<Pessoa>{

	@Override
	public int compare(Pessoa o1, Pessoa o2) {
		if (o1.getIdade() == o2.getIdade()) {
			return 0;
		}if (o1.getIdade() > o2.getIdade()) {
			return 1;
		}
		return -1;
	}

}
