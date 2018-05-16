package test;

import comparators.*;
import datastructure.LinkedList;
import model.Pessoa;

public class Test {
	
	public static void main(String[] args) {
		
		LinkedList<Pessoa> lista = populateList();
		
		lista.print();
		
		lista.efficientSort(new SearchByName());
		System.out.println("//////");
		lista.print();
		
		lista.stableSort(new SearchByAge());
		System.out.println("//////");
		lista.print();
	}
	
	public static LinkedList<Pessoa> populateList() {
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
