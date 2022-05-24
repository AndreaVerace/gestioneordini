package it.prova.gestioneordini.test;

import java.util.List;

import it.prova.gestioneordini.dao.EntityManagerUtil;
import it.prova.gestioneordini.dao.MyDaoFactory;
import it.prova.gestioneordini.model.Ordine;
import it.prova.gestioneordini.service.ArticoloService;
import it.prova.gestioneordini.service.CategoriaService;
import it.prova.gestioneordini.service.MyServiceFactory;
import it.prova.gestioneordini.service.OrdineService;


public class MyTest {

	public static void main(String[] args) {
		ArticoloService articoloServiceInstance = MyServiceFactory.getArticoloServiceInstance();
		CategoriaService categoriaServiceInstance = MyServiceFactory.getCategoriaServiceInstance();
		OrdineService ordineServiceInstance = MyServiceFactory.getOrdineServiceInstance();
		
		try {
			
			testListOrdine(ordineServiceInstance);
			
			
			
			
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}
	}
	
	
	private static void testListOrdine(OrdineService ordineServiceInstance) throws Exception {
		List<Ordine> result = ordineServiceInstance.list();
		
		System.out.println("Nella tabella ordine sono presenti " + result.size() + " elementi.");
	}

}
