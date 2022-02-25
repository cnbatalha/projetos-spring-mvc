package gruoup.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TesteGrouping {
	
	public static void main(String[] args) {
		
		Function<Item, String> funcion = (I) -> I.getTipo();
		
		List<Item> items = abastecerLista();
		
		Map<String, Double> retorno =	items.stream().collect(
										Collectors.groupingBy(t -> t.getTipo(), Collectors.summingDouble( i -> i.getValor())));
		
		System.out.println(retorno);
		
		Map<Object, List<Object>> retorno1 =	items.stream().collect(
				Collectors.groupingBy(
						t -> t.getTipo(),  
						Collectors.mapping( I -> I, Collectors.toList()) 	
						)
			); 

		System.out.println(retorno1);	
		
		Map<Item, Double> retorno2 =	items.stream().collect(
											Collectors.groupingBy(
													t -> t, Collectors.summingDouble( i -> i.getValor()) 	
													)
										);
		
		System.out.println(retorno2);
		
		Map<String, Double> retorno4 =	items.stream().collect(
				Collectors.groupingBy(t -> t.getTipo(), Collectors.summingDouble( i -> i.getValor())));

		System.out.println(retorno4);
		
		Map<Item, Double> retorno5 = retorno4.entrySet().stream()
					.collect(Collectors.toMap( t -> items.stream().filter( i -> i.getTipo().equals(t.getKey())).findFirst().get()
							, t -> t.getValue()));
				
		System.out.println(retorno5);		
		
		Map<Item, Double> retorno6 =	items.stream().collect(
				Collectors.groupingBy(t -> t.getTipo(), Collectors.summingDouble( i -> i.getValor())))
				.entrySet().stream()
				.collect(Collectors.toMap( t -> items.stream().filter( i -> i.getTipo().equals(t.getKey())).findFirst().get()
							, t -> t.getValue()));

		System.out.println(retorno6);
		
		Map<Item, Double> retorno7 = items.stream().collect(Collectors.groupingBy(t -> t.getTipo(), Collectors.summingDouble( i -> i.getValor())))
				.entrySet().stream()
				.collect(Collectors.toMap( t -> items.stream().filter( i -> i.getTipo().equals(t.getKey())).findFirst().get(), t -> t.getValue()));

		System.out.println(retorno7);
		
	}
	
	public static List<Item> abastecerLista() {
		List<Item> lista =  new ArrayList<Item>();
		lista.add(new Item("Prod1", "T1", 10.0));
		lista.add(new Item("Prod2", "T1", 10.0));
		lista.add(new Item("Prod3", "T1", 10.0));
		lista.add(new Item("Prod4", "T2", 10.0));
		lista.add(new Item("Prod4", "T2", 10.0));
		
		return lista;
	}

}
