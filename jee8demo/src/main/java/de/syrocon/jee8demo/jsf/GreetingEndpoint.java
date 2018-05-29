package de.syrocon.jee8demo.jsf;

import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;

public class GreetingEndpoint {
	@Inject
	@Push(channel = "ticker")
	private PushContext channel;

	public void notify(String message) {
		this.channel.send(message);
	}
}
