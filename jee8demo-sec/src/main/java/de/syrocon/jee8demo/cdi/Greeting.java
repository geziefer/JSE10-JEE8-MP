package de.syrocon.jee8demo.cdi;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Greeting {
	public String generate() {
		return "Hello world!";
	}
}
