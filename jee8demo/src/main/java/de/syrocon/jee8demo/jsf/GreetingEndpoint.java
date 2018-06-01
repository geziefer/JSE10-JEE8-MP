package de.syrocon.jee8demo.jsf;

import java.time.LocalTime;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@ApplicationScoped
@Path("/jsfdemo")
public class GreetingEndpoint {
	@Inject
	@Push(channel = "ticker")
	private PushContext channel;

	@GET
	public void push() {
		String message = "Hello at " + LocalTime.now();
		System.out.println("Send \"" + message + "\"");
		this.channel.send(message);
	}
}
