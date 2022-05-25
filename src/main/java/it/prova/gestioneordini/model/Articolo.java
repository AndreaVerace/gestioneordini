package it.prova.gestioneordini.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "articolo")
public class Articolo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	@Column(name = "numeroseriale")
	private int numeroSeriale;
	
	@Column(name = "prezzosingolo")
	private int prezzoSingolo;
	
	@Column(name = "datainserimento")
	private Date dataInserimento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ordine_id")
	private Ordine ordine;
	
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinTable(name = "articolo_categoria", joinColumns = @JoinColumn(name = "articolo_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "categoria_id", referencedColumnName = "ID"))
	private Set<Categoria> categorie = new HashSet<Categoria>();
	
	public Articolo () {
		
	}
	
	
	public Articolo (String descrizione,int numeroSeriale,int prezzoSingolo) {
		this.descrizione = descrizione;
		this.numeroSeriale = numeroSeriale;
		this.prezzoSingolo = prezzoSingolo;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public int getNumeroSeriale() {
		return numeroSeriale;
	}


	public void setNumeroSeriale(int numeroSeriale) {
		this.numeroSeriale = numeroSeriale;
	}


	public int getPrezzoSingolo() {
		return prezzoSingolo;
	}


	public void setPrezzoSingolo(int prezzoSingolo) {
		this.prezzoSingolo = prezzoSingolo;
	}


	public Date getDataInserimento() {
		return dataInserimento;
	}


	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public Ordine getOrdine() {
		return ordine;
	}


	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}


	public Set<Categoria> getCategorie() {
		return categorie;
	}


	public void setCategorie(Set<Categoria> categorie) {
		this.categorie = categorie;
	}


	@Override
	public String toString() {
		return "Articolo [id=" + id + ", descrizione=" + descrizione + ", numeroSeriale=" + numeroSeriale
				+ ", prezzoSingolo=" + prezzoSingolo + ", dataInserimento=" + dataInserimento + ", ordine=" + ordine
				+ ", categorie=" + categorie + "]";
	}


	
	
	
	
	
	
}
