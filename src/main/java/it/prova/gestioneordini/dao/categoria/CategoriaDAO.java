package it.prova.gestioneordini.dao.categoria;

import it.prova.gestioneordini.dao.IBaseDAO;
import it.prova.gestioneordini.model.Categoria;

public interface CategoriaDAO extends IBaseDAO<Categoria> {

	public boolean verificaSeCategoriaHaArticoli(long id) throws Exception;
	
}
