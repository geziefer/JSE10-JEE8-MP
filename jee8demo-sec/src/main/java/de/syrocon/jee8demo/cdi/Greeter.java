package de.syrocon.jee8demo.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class Greeter {
	@Inject
	Greeting greeting;

	public void greet() {
		System.out.println(greeting.generate());
	}

}
