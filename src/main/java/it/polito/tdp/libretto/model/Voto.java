package it.polito.tdp.libretto.model;

import java.time.LocalDate;

//deve rappresentare gli oggetti di tipo voto
//-nome corso
//-voto
//data
//solo gli esami superati 

/**
 * Classe Voto contiene le informazioni su un esame
 * 
 * @author sabinoMac13
 *
 */

public class Voto {
	private String corso; //nome del corso, e' un attributo di voto
	private int voto;
	private LocalDate data; //per rappresentare una data in java possiamo usare sia la classe date predisposta, ma ha molti problemi, preferiamo non usarla 
	
	//questo sistema di commenti permette di creare la documentazione e conviene farlo quando ci sono delle funzioni che devono essere richiamate dall'esterno 
	
	/**
	 * Costruisce un nuovo voto
	 *  
	 * @param corso nome del corso superato
	 * @param voto  valore del voto acquisito
	 * @param data data di superamento dell'esame
	 */
	public Voto(String corso, int voto, LocalDate data) {
		super();
		this.corso = corso;
		this.voto = voto;
		this.data = data;
	}

	public String getCorso() {
		return corso;
	}

	public void setCorso(String corso) {
		this.corso = corso;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	//metodo che mi dice come visualizzare il voto quando lo stampo
	@Override
	public String toString() {
		return corso+": " + voto + " (" + data + ")";
	}

	
	//permette all'oggetto di dire qual e il suo criterio di uguaglianza
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corso == null) ? 0 : corso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		if (corso == null) {
			if (other.corso != null)
				return false;
		} else if (!corso.equals(other.corso))
			return false;
		return true; //due oggetti sono considerati uguali se il nome del corso è uguale all'attributo corso dell'altro
	}
	
	
	


	
	
}
