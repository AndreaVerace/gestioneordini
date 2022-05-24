package it.prova.gestioneordini.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ordine")
public class Ordine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nomedestinatario")
	private String nomeDestinatario;
	
	@Column(name = "indirizzoSpedizione")
	private String indirizzoSpedizione;
	
	@Column(name = "dataspedizione")
	private Date dataSpedizione;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ordine")
	private Set<Articolo> articoli;
	
	public Ordine () {
		
	}
	
	
	public Ordine(String nomeDestinatario, String indirizzoSpedizione) {
		this.nomeDestinatario = nomeDestinatario;
		this.indirizzoSpedizione = indirizzoSpedizione;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomeDestinatario() {
		return nomeDestinatario;
	}


	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}


	public String getIndirizzoSpedizione() {
		return indirizzoSpedizione;
	}


	public void setIndirizzoSpedizione(String indirizzoSpedizione) {
		this.indirizzoSpedizione = indirizzoSpedizione;
	}


	public Date getDataSpedizione() {
		return dataSpedizione;
	}


	public void setDataSpedizione(Date dataSpedizione) {
		this.dataSpedizione = dataSpedizione;
	}


	public Set<Articolo> getArticoli() {
		return articoli;
	}


	public void setArticoli(Set<Articolo> articoli) {
		this.articoli = articoli;
	}


	@Override
	public String toString() {
		return "Ordine [id=" + id + ", nomeDestinatario=" + nomeDestinatario + ", indirizzoSpedizione="
				+ indirizzoSpedizione + ", dataSpedizione=" + dataSpedizione + ", articoli=" + articoli + "]";
	}


	
	
	
	
	
	
}
