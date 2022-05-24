package it.prova.gestioneordini.service;

import java.util.List;

import it.prova.gestioneordini.dao.categoria.CategoriaDAO;
import it.prova.gestioneordini.model.Categoria;

public class CategoriaServiceImpl implements CategoriaService {

	private CategoriaDAO categoriaDAO;
	
	@Override
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
		
	}

	@Override
	public List<Categoria> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria get(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Categoria o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Categoria o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Categoria o) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
