package it.prova.gestioneordini.exception;

public class CustomException extends Exception{

private String message;
	
	public CustomException(String message) {
		super(message);
	}
	
}
