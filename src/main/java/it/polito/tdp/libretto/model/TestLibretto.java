package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {
	Libretto lib; //creo un nuovo libretto
	
	
	//e' abbastanza limitativo lavorarci, perche' mi permette di lavorare solo con altri metodi statici
	//ogni volta che si ha un main conviene creare un'istanza della classe stessa
	private void run() {
		this.lib = new Libretto(); //creo un libretto vuoto
		Voto v1= new Voto("Tecniche di programmazione", 30, LocalDate.of(2020, 06, 15));
		Voto v2= new Voto ("Analisi II", 28, LocalDate.of(2020, 06, 20));
		
		lib.add(v1);
		lib.add(v2);
		lib.add(new Voto ("Economia", 24, LocalDate.of(2020, 02, 14)));
		
		System.out.println(this.lib); 
		System.out.println (this.lib.stampaVotiUguali(28));
		System.out.println(this.lib.estraiVotiUguali(28));
	}

	public static void main(String[] args) { //tutto il lavoro che devo fare e' nel run, non si lavora dentro il main
		TestLibretto test= new TestLibretto();
		test.run();

	}
	
	
}
