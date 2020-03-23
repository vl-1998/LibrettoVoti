package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {
	Libretto lib; //creo un nuovo libretto
	
	
	//e' abbastanza limitativo lavorarci, perche' mi permette di lavorare solo con altri metodi statici
	//ogni volta che si ha un main conviene creare un'istanza della classe stessa
	private void run() {
		this.lib = new Libretto(); //creo un libretto vuoto
		
		//1. Inserire alcuni voti //6. il libretto dovrebbe evitare di inserire un voto già presente, non inserira mai voti in conflitto 
		Voto v1= new Voto("Tecniche di programmazione", 30, LocalDate.of(2020, 06, 15));
		Voto v2= new Voto ("Analisi II", 28, LocalDate.of(2020, 06, 20));
		
		lib.add(v1);
		lib.add(v2); 
		if ( lib.add(new Voto ("Economia", 24, LocalDate.of(2020, 02, 14))) ==false) {
			System.out.println("Errore nell'inserimento di Economia");
		}
		System.out.println(this.lib); 

		//2. stampa tutti i voti pari a un certo numero
		System.out.println (this.lib.stampaVotiUguali(28));
		System.out.println(this.lib.estraiVotiUguali(28));
		
		//3. cerca un esame superato conoscendo il nome del corso
		String nomeCorso = "Analisi II";
		//int voto = lib.cercaNomeCorso(nomeCorso); //mi restituira 28
		//a quetso punto conviene restituire un oggetto voto, 
		//in modo che se in futuro io volessi cercare secondo una data non dovrei avere un altro metodo
		Voto votoAnalisi = lib.cercaNomeCorso(nomeCorso); 
		System.out.println("Il voto di"+nomeCorso+" e' "+votoAnalisi.getVoto());
		
		Voto votoMancante = lib.cercaNomeCorso("Fisica I"); 
		System.out.println("Il voto di Fisica I e' "+votoMancante);
		
		//4. verificare se esiste gia un voto
		//5. verificare se c'è un conflitto con libretto 
		Voto economia2 = new Voto ("Economia", 24, LocalDate.now());
		Voto economia3 = new Voto ("Economia",21, LocalDate.now());
		System.out.println("Economia con 24 e' duplicato: "+lib.isDuplicato(economia2)+"/conflitto:"+lib.isConflitto(economia2));
		System.out.println("Economia con 24 e' duplicato: "+lib.isDuplicato(economia3)+"/conflitto:"+lib.isConflitto(economia3));

	}

	public static void main(String[] args) { //tutto il lavoro che devo fare e' nel run, non si lavora dentro il main
		TestLibretto test= new TestLibretto();
		test.run();

	}
	
	
}
