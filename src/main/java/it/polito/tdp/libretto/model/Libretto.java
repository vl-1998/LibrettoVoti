package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.List; //attenta sempre java.util.list non awt

/**
 * Classe che memorizza e gestisce un insieme di voti superati
 * @author sabinoMac13
 *
 */

public class Libretto {

	private List <Voto> voti=new ArrayList <>(); //potrei omettere <Voto> dopo perche Java lo capisce da solo 

	/*
	/**
	 * Crea un libretto vuoto nuovo
	 
	//costruttore a cui chiediamo di non inizializzare il campo voti, perche nasce vuoto e non devo passargli dall'esterno la lista
	public Libretto() {
		this.voti= new ArrayList <Voto>();
		//il costruttore ha senso di esistere solo se deve fare altro otre all'inizializzazione dei dati quindi non usiamo il costruttore
	}
	*/
	
	
	//metodo add per aggiungere esami (meglio questo, meno dipendenza, meno lavoro) 
	//USIAMO SEMPRE OGGETTI, MAI DATI SPARSI

	//il metodo add delega l'aggiunta all'array list
	/**
	 * Aggiunge un nuovo voto al libretto
	 * 
	 * @param v Voto da aggiungere
	 */
	public void add(Voto v) {
		this.voti.add(v);
	}
	
	/*
	//anche questo metodo e' valido, ma se in futuro dovessimo aggiungere dei dati in voto dovrei modificar tutti i metodi add
	public void add(String corso, int voto, LocalDate data) {
		
	}*/
	
	//definire un metodo che mi dica come il libretto debba essere stampato	
	public String toString() {
		String s = "";
		for (Voto v: this.voti) {
			s += v.toString()+"\n";
		}
		return s;
	}
	
	//2 Modi per stampare i voti pari a 25
		//- creare un simil metodo to string che stampa solo i voti pari a un certo voto
		/**
		 * Dato un libretto restituisce una stringa nella quale ci sono solo i voti passati come parametro
		 * @param voto valore specificato
		 * @return formattato per visualizzare il sotto libretto
		 */
	public String stampaVotiUguali (int voto) {
		String s = "";
		for (Voto v: this.voti) {
			if (v.getVoto()==voto) {
			s += v.toString()+"\n";
			}
		}
		return s;
	}
		
		//-si puo cercare un metodo piu furbo, perche ho gia un metodo che stampa i voti
		//creo un nuovo libretto partendo da quello attuale che stampa tutti i voti pari a tot voto, che poi magari butto, pero posso usarlo perche
		//e' un oggetto libretto vero e proprio 
	/**
	 * Genera un nuovo libretto a partire da quello esistente che conterra esclusivamente i voti con votazione
	 * pari a quella specificata	
	 * @param voto valutazione specificata
	 * @return nuov Libreto "ridotto"
	 */
	public Libretto estraiVotiUguali (int voto) {
		Libretto nuovo = new Libretto();
		for (Voto v: this.voti) {
			if(v.getVoto()==voto) {
				nuovo.add(v);
			}
		}
		return nuovo;
	}

	
}
