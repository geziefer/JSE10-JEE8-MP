package de.syrocon.jee8demo.cdi;

public class GreetEvent {
	private String message;

	public GreetEvent(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
