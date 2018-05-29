package de.syrocon.jee8demo.cdi;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class Greeting {

	public Greeting() {
	};

	public void printMessage(String message) {
		System.out.println(message);
	}

}
