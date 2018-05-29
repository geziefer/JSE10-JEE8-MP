package de.syrocon.jee8demo.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import de.syrocon.jee8demo.cdi.Greeting;

@Path("/greeting")
public class GreetingService {
	@Inject
	Greeting greeting;

	@GET
	public void greet() {
		greeting.printMessage("Huhu!");
	}
}
