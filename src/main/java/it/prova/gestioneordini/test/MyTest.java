package it.prova.gestioneordini.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;

import org.hibernate.sql.Delete;

import it.prova.gestioneordini.dao.EntityManagerUtil;
import it.prova.gestioneordini.dao.MyDaoFactory;
import it.prova.gestioneordini.model.Articolo;
import it.prova.gestioneordini.model.Categoria;
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
			
			// testUpdateOrdine(ordineServiceInstance);
			
			// testAggiungiArticoloAOrdine(articoloServiceInstance, ordineServiceInstance);
			
			// testRimuoviArticoloDaOrdine(articoloServiceInstance, ordineServiceInstance);
			
			// testAggiungiArticoloACategoria(articoloServiceInstance, categoriaServiceInstance);
			
			// testAggiungiCategoriaAdArticolo(articoloServiceInstance, categoriaServiceInstance);
			
			// testRimuoviOrdine(ordineServiceInstance);
			
			// testRimuoviCategoria(categoriaServiceInstance);
			
			// testRimuoviArticolo(articoloServiceInstance);
			
			//testVoglioTuttiGliOrdiniDiQuellaCategoria(categoriaServiceInstance, articoloServiceInstance, ordineServiceInstance);
			
			// testVoglioTutteCategorieDiArticoliConDeterminatoOrdine(categoriaServiceInstance, ordineServiceInstance);
			 
			// testVoglioSommaPrezziDiArticoliInQuellaCategoria(categoriaServiceInstance, articoloServiceInstance);
			
			// testVoglioOrdineConSpedizionePiuRecenteDiQuellaCategoria(categoriaServiceInstance, ordineServiceInstance);
			
			// testVoglioCodiciDiCategoriaDiOrdiniFebbraio(categoriaServiceInstance, ordineServiceInstance, articoloServiceInstance);
			
			// testVoglioSommaDiArticoliMarioRossi(ordineServiceInstance, articoloServiceInstance);
			
			testVoglioIndirizziDiOrdiniICuiArticoliHannoNumSerialeCheE(categoriaServiceInstance, ordineServiceInstance, articoloServiceInstance);
			
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
		Articolo articoloDaInserire = new Articolo("lavastoviglie",9,900);
		articoloDaInserire.setDataInserimento(dataDiArticolo);
		
		Set<Articolo> articoli = new HashSet<Articolo>();
		articoli.add(articoloDaInserire);

		Date dataOrdineDaInserire = new SimpleDateFormat("dd-MM-yyyy").parse("01-09-2020");
		Ordine ordineDaInserire = new Ordine("Andrea","Via Torregaveta");
		ordineDaInserire.setDataSpedizione(dataOrdineDaInserire);
		
		articoloDaInserire.setOrdine(ordineDaInserire);
		ordineDaInserire.setArticoli(articoli);
		
		
		ordineServiceInstance.insert(ordineDaInserire);
		articoloServiceInstance.insert(articoloDaInserire);
		
		ordineServiceInstance.aggiungiArticolo(articoloDaInserire, ordineDaInserire);
		
		
		/*
		Ordine ordine = ordineServiceInstance.list().get(2);
		articoloDaInserire.setOrdine(ordine);
		
		articoloDaInserire.setOrdine(ordine);
		
		//ordineServiceInstance.insert(ordine);
		articoloServiceInstance.insert(articoloDaInserire);*/
		
		
		
		
		
		/*System.out.println(articoloServiceInstance.list()
				.get(articoloServiceInstance.list().size() -1)
				.getOrdine());*/
		
	}
	
	private static void testRimuoviArticoloDaOrdine(ArticoloService articoloServiceInstance,OrdineService ordineServiceInstance) throws Exception {
		
		/*Articolo articoloDaDisassociare = articoloServiceInstance.list().get(5);
		Ordine ordineIdDellArticoloDaDisassociare = articoloDaDisassociare.getOrdine();
		
		if(articoloDaDisassociare.getOrdine() != null) {
			ordineIdDellArticoloDaDisassociare = null;
			articoloDaDisassociare.setOrdine(ordineIdDellArticoloDaDisassociare);
			articoloServiceInstance.update(articoloDaDisassociare);
		}
		else 
			throw new Exception("Articolo non presente in nessun ordine.");	*/
		
		Date dataOrdineDaInserire = new SimpleDateFormat("dd-MM-yyyy").parse("01-09-2020");
		Ordine ordineDaInserire = new Ordine("Giovanni","Via Ponzio");
		ordineDaInserire.setDataSpedizione(dataOrdineDaInserire);
		
		
		
		
		
		Date dataDiArticolo = new SimpleDateFormat("dd-MM-yyyy").parse("10-09-2022");
		Articolo articoloDaInserire = new Articolo("lavatrice",9,900);
		articoloDaInserire.setDataInserimento(dataDiArticolo);
		articoloDaInserire.setOrdine(ordineDaInserire);
		
		Set<Articolo> articoli = new HashSet<Articolo>();
		articoli.add(articoloDaInserire);
		
		ordineDaInserire.setArticoli(articoli);
		
		
		ordineServiceInstance.insert(ordineDaInserire);
		articoloServiceInstance.insert(articoloDaInserire);
		
		
		
		
		if(articoloDaInserire != null && ordineDaInserire != null)
			ordineServiceInstance.rimuoviArticolo(articoloDaInserire, ordineDaInserire);
				
	}
	
	
	private static void testAggiungiArticoloACategoria(ArticoloService articoloServiceInstance,CategoriaService categoriaServiceInstance)
			throws Exception {
		
		Categoria categoriaUno = new Categoria("dispositivi elettronici","ANP983");
		categoriaServiceInstance.insert(categoriaUno);
		
		categoriaServiceInstance.aggiungiArticolo(categoriaUno, articoloServiceInstance.list().get(0));
	}
	
	private static void testAggiungiCategoriaAdArticolo(ArticoloService articoloServiceInstance,CategoriaService categoriaServiceInstance)
			throws Exception {
		
		articoloServiceInstance.aggiungiCategoria(categoriaServiceInstance.list().get(0), articoloServiceInstance.list().get(1));
	}
	
	private static void testRimuoviOrdine(OrdineService ordineServiceInstance) throws Exception {
		ordineServiceInstance.delete(ordineServiceInstance.list().get(0));
	}
	
	private static void testRimuoviCategoria(CategoriaService categoriaServiceInstance) throws Exception {
		categoriaServiceInstance.delete(categoriaServiceInstance.list().get(0));
	}
	
	private static void testRimuoviArticolo(ArticoloService articoloServiceInstance) throws Exception {
		articoloServiceInstance.delete(articoloServiceInstance.list().get(2));
	}
	
	private static void testVoglioTuttiGliOrdiniDiQuellaCategoria(CategoriaService categoriaServiceInstance,ArticoloService articoloServiceInstance,OrdineService ordineServiceInstance) 
			throws Exception {
		
		categoriaServiceInstance.aggiungiArticolo(categoriaServiceInstance.list().get(0), articoloServiceInstance.list().get(2));
		
		List<Ordine> result = ordineServiceInstance.voglioTuttiGliOrdiniDiQuellaCategoria(categoriaServiceInstance.list().get(0));
		
		System.out.println(result.get(0).getId());
	}
	
	private static void testVoglioTutteCategorieDiArticoliConDeterminatoOrdine(CategoriaService categoriaServiceInstance,OrdineService ordineServiceInstance) 
			throws Exception {
		
		Ordine ordineInput = ordineServiceInstance.list().get(0);
		
		List<Categoria> result = categoriaServiceInstance.voglioTutteCategorieDiArticoliConDeterminatoOrdine(ordineInput);
		
		System.out.println(result.size());
	}
	
	
	private static void testVoglioSommaPrezziDiArticoliInQuellaCategoria(CategoriaService categoriaServiceInstance,ArticoloService articoloServiceInstance) throws Exception {
		
		Categoria categoriaDaImmettere = categoriaServiceInstance.list().get(0);
		
		long result = articoloServiceInstance.voglioSommaPrezziDiArticoliInQuellaCategoria(categoriaDaImmettere);
		
		System.out.println(result);
	}
	
	private static void testVoglioOrdineConSpedizionePiuRecenteDiQuellaCategoria(CategoriaService categoriaServiceInstance,OrdineService ordineServiceInstance) throws Exception {
		
		Ordine ordineDaRicavare = ordineServiceInstance
				.voglioOrdineConSpedizionePiuRecenteDiQuellaCategoria(categoriaServiceInstance.list().get(0));
		
		System.out.println(ordineDaRicavare.getNomeDestinatario() + " , " + ordineDaRicavare.getDataSpedizione());
	}
	
	private static void testVoglioCodiciDiCategoriaDiOrdiniFebbraio(CategoriaService categoriaServiceInstance,OrdineService ordineServiceInstance,ArticoloService articoloServiceInstance)
		throws Exception {
		
		Date dataOrdineDaInserire = new SimpleDateFormat("dd-MM-yyyy").parse("07-02-2022");
		Ordine ordineDaInserire = new Ordine("ALDO","Via Martini");
		ordineDaInserire.setDataSpedizione(dataOrdineDaInserire);
		
		Date dataDiArticolo = new SimpleDateFormat("dd-MM-yyyy").parse("10-02-2022");
		Articolo articoloDaInserire = new Articolo("il mattino",90,100);
		articoloDaInserire.setDataInserimento(dataDiArticolo);
		articoloDaInserire.setOrdine(ordineDaInserire);
		
		Categoria categoriaDaInserire = new Categoria("carta stampata","LAO639BD");
		
		
		ordineServiceInstance.insert(ordineDaInserire);
		articoloServiceInstance.insert(articoloDaInserire);
		categoriaServiceInstance.insert(categoriaDaInserire);
		
		categoriaServiceInstance.aggiungiArticolo(categoriaDaInserire, articoloDaInserire);
		
		
		
		List<String> result = categoriaServiceInstance.voglioCodiciDiCategoriaDiOrdiniFebbraio();
		
		System.out.println(result.size());
	}
	
	private static void testVoglioSommaDiArticoliMarioRossi(OrdineService ordineServiceInstance,ArticoloService articoloServiceInstance)
			throws Exception {
		Date dataOrdineDaInserire = new SimpleDateFormat("dd-MM-yyyy").parse("07-02-2022");
		Ordine ordineDaInserire = new Ordine("Mario Rossi","Via Pollenatrocchia");
		ordineDaInserire.setDataSpedizione(dataOrdineDaInserire);
		
		Date dataDiArticolo = new SimpleDateFormat("dd-MM-yyyy").parse("10-02-2022");
		Articolo articoloDaInserire = new Articolo("il mattino",90,100);
		articoloDaInserire.setDataInserimento(dataDiArticolo);
		articoloDaInserire.setOrdine(ordineDaInserire);
		
		ordineServiceInstance.insert(ordineDaInserire);
		articoloServiceInstance.insert(articoloDaInserire);
		
		long result = articoloServiceInstance.voglioSommaDiArticoliMarioRossi();
		
		System.out.println(result);
	}
	
	
	private static void testVoglioIndirizziDiOrdiniICuiArticoliHannoNumSerialeCheE(CategoriaService categoriaServiceInstance,OrdineService ordineServiceInstance,ArticoloService articoloServiceInstance)
		throws Exception {
		Date dataOrdineDaInserire = new SimpleDateFormat("dd-MM-yyyy").parse("07-02-2022");
		Ordine ordineDaInserire = new Ordine("Alessandro Magno","Via Del Pino");
		ordineDaInserire.setDataSpedizione(dataOrdineDaInserire);
		
		Date dataDiArticolo = new SimpleDateFormat("dd-MM-yyyy").parse("10-02-2022");
		Articolo articoloDaInserire = new Articolo("nokia 3369",10,50);
		articoloDaInserire.setDataInserimento(dataDiArticolo);
		articoloDaInserire.setOrdine(ordineDaInserire);
		
		Categoria categoriaDaInserire = new Categoria("carta stampata","am90843");
		
		ordineServiceInstance.insert(ordineDaInserire);
		articoloServiceInstance.insert(articoloDaInserire);
		categoriaServiceInstance.insert(categoriaDaInserire);
		
		
		categoriaServiceInstance.aggiungiArticolo(categoriaDaInserire, articoloDaInserire);
		
		String contenuta = "ok";
		
		List<String> result = ordineServiceInstance.voglioIndirizziDiOrdiniICuiArticoliHannoNumSerialeCheE(contenuta);
		
		System.out.println(result.size());
		
		
	}
}
