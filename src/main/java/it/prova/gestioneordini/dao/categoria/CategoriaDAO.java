package it.prova.gestioneordini.dao.categoria;

import java.util.List;

import it.prova.gestioneordini.dao.IBaseDAO;
import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public interface CategoriaDAO extends IBaseDAO<Categoria> {

	public boolean verificaSeCategoriaHaArticoli(long id) throws Exception;
	
	public List<Categoria> voglioTutteCategorieDiArticoliConDeterminatoOrdine(Ordine ordine) throws Exception;
	
}
