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
	 * @return true se ha inseritoil voto, false se non l'ha inserito perche era in conflitto o duplicato 
	 */
	public boolean add(Voto v) {
		//verifica di conflitto o duplicato 
		if (this.isConflitto(v) || this.isDuplicato(v)) {
			//non inserire il voto, non ho nulla da fare pero, o ho un'eccezione
			return false; //segnalo al chiamante che non ha avuto successo 
		}
		else {
			//inserisci il voto perche non è in cnflitto o duplicato
			this.voti.add(v);
			return true; //l'operazione ha avuto successo 
		}
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

	
	//decidere come gestire la ricerca di un voto che non esiste
	/**
	 * Dato il nome di un corso ricerca se quell esame esiste nel libretto e in caso affermativo restituisce
	 * l'oggetto voto corrispondente
	 * 
	 * Se l'esame non esiste restituisce null
	 * 
	 * @param nomeCorso parametro da cercare 
	 * @return il {@link Voto} corrispondente o null se non esiste.
	 */
	public Voto cercaNomeCorso(String nomeCorso) {
		/*for (Voto v: this.voti) {
			if (nomeCorso.equals(v.getCorso())) {
				return v;
			}
		}
		return null;*/
		
		//quando cerca nella collection se esiste un voto, per confrontare due oggetti il criterio a priori non si puo dire, in generale
		//Java non sa il criterio di uguaglianza di due oggetti, quindi si fida del fatto che ciascuno oggetto sappia dire qual e il suo criterio di
		//uguaglianza. Se noi in Voto specificassimo un criterio di uguaglianza (con un metodo Equals).
		//this.voti.indexOf(voto_cercato);
		
		int pos = this.voti.indexOf(new Voto(nomeCorso, 0, null)); //intero che mi da la posizione di questo elemento (equals andara a vedere solo il nome, quindi non è un problema i campi vuoti)
		if (pos != -1) { //ritorna -1 se non trova l'elemento
			return this.voti.get(pos);
		}else {
			return null;
		}
	}
	
	/**
	 * Return true se il corso specificato da v esiste nel libretto con la stessa valutazione.
	 * Se non esiste o la valutazione è diversa ritorna false.
	 * @param v voto da cercare
	 * @return l'esistenza di un duplicato 
	 */
	public boolean isDuplicato (Voto v) {
		Voto esiste = this.cercaNomeCorso(v.getCorso()); //se null non è di sicuro un duplicato 
		if (esiste == null) {
			return false; //se non l'ho trovato non è duplicato
		}
		
		/*if (esiste.getVoto()== v.getVoto()) {
			return true; //se esiste e hanno lo stesso voto è un duplicato
		}
		else
			return false; //se esiste e non hanno l stesso voto non è un duplicato*/
		
		return (esiste.getVoto()==v.getVoto()); //riassume l'if sopra (ritorna il valore di verita di questa espressione
	}
	
	/** 
	 * Determina se esiste un voto con lo stesso nome corso, ma valutazione diversa.
	 * @param v
	 * @return
	 */
	public boolean isConflitto (Voto v) {
		//prima cerco se esiste
		Voto esiste = this.cercaNomeCorso(v.getCorso()); //se null non è di sicuro un duplicato 
		if (esiste == null) {
			return false; //se non l'ho trovato non è duplicato
		}
		
		//poi restituisco l'opposto
		return (esiste.getVoto()!=v.getVoto()); 

	}

	
}
