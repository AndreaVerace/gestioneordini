package it.prova.gestioneordini.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.prova.gestioneordini.dao.EntityManagerUtil;
import it.prova.gestioneordini.dao.MyDaoFactory;
import it.prova.gestioneordini.model.Articolo;
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
			
			// testListOrdine(ordineServiceInstance);
			
			// testInsertOrdine(ordineServiceInstance);
			
			//testUpdateOrdine(ordineServiceInstance);
			
			testAggiungiArticoloAOrdine(articoloServiceInstance, ordineServiceInstance);
			
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
	
	private static void testInsertOrdine(OrdineService ordineServiceInstance) throws Exception {
		
		Date dataOrdineDaInserire = new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2020");
		Ordine ordineDaInserire = new Ordine("Andrea","Via Torregaveta");
		ordineDaInserire.setDataSpedizione(dataOrdineDaInserire);
		
		ordineServiceInstance.insert(ordineDaInserire);
		
		System.out.println(ordineServiceInstance.list().get(0).getNomeDestinatario());
	}

	private static void testUpdateOrdine(OrdineService ordineServiceInstance) throws Exception {
	
		Date dataOrdineDaInserire = new SimpleDateFormat("dd-MM-yyyy").parse("31-08-2021");
		
		Ordine ordineDaInserire = ordineServiceInstance.list().get(0);
		
		ordineDaInserire.setNomeDestinatario("Giacomo");
		ordineDaInserire.setIndirizzoSpedizione("Via Poggi");
		ordineDaInserire.setDataSpedizione(dataOrdineDaInserire);
		
		
		ordineServiceInstance.update(ordineDaInserire);
		
		System.out.println(ordineServiceInstance.list().get(0).getNomeDestinatario());
	}	
	
	
	private static void testAggiungiArticoloAOrdine(ArticoloService articoloServiceInstance,OrdineService ordineServiceInstance) throws Exception {
		
		Date dataDiArticolo = new SimpleDateFormat("dd-MM-yyyy").parse("21-06-2022");
		Articolo articoloDaInserire = new Articolo("pc huawei",2,600);
		articoloDaInserire.setDataInserimento(dataDiArticolo);
		articoloDaInserire.setOrdine(ordineServiceInstance.list().get(0));
		
		
		articoloServiceInstance.insert(articoloDaInserire);
		
		
		
		//System.out.println(ordineServiceInstance.list().get(0).getArticoli());
		
	}
}
