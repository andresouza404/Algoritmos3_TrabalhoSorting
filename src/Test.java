
public class Test {
	
	public static void main(String[] args) {
		
		LinkedList<Pessoa> lista = pop();
		
		lista.print();
		
		lista.stableSort(lista.getHead(), new SearchByName());
		System.out.println("//////");
		lista.print();
		
		lista.stableSort(lista.getHead(), new SearchByAge());
		System.out.println("//////");
		lista.print();
	}
	
	public static LinkedList<Pessoa> pop() {
		String nome[] = { "Bianca", "Luis", "Sofia", "Eduarda", "Roberto", "Mariana", "Felipe", "Barbara", "Thiago",
				"Ana" };
		int idade[] = { 83, 83, 66, 33, 24, 24, 33, 48, 64, 37, 32 };
		LinkedList<Pessoa> list = new LinkedList<Pessoa>();
		for (int x = 0; x < nome.length; x++) {
			Pessoa a = new Pessoa(nome[x], idade[x]);
			if (x == 0) {
				list.addFirst(a);
			} else {
				list.append(a);
			}
		}
		return list;
	}
}
