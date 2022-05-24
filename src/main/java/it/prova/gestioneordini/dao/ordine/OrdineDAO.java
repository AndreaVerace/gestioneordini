package it.prova.gestioneordini.dao.ordine;

import it.prova.gestioneordini.dao.IBaseDAO;
import it.prova.gestioneordini.model.Ordine;

public interface OrdineDAO extends IBaseDAO<Ordine> {
	
	public boolean verificaSeOrdineHaArticoli(long id) throws Exception;

}
