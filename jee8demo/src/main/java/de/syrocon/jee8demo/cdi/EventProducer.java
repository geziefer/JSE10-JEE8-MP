package de.syrocon.jee8demo.cdi;

import java.time.LocalTime;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@ApplicationScoped
@Path("/cdidemo")
public class EventProducer {
	@Inject
	Event<GreetEvent> eventSource;

	@GET
	public void fireEvents() {
		System.out.println("Fired 1st event");
		eventSource.fire(new GreetEvent("Hello at " + LocalTime.now()));
		System.out.println("Fired 2nd event");
		eventSource.fire(new GreetEvent("Hello at " + LocalTime.now()));
		System.out.println("Fired 3rd event");
		eventSource.fire(new GreetEvent("Hello at " + LocalTime.now()));

		System.out.println("Fired 1st async event");
		eventSource.fireAsync(new GreetEvent("Hello at " + LocalTime.now()));
		System.out.println("Fired 2nd async event");
		eventSource.fireAsync(new GreetEvent("Hello at " + LocalTime.now()));
		System.out.println("Fired 3rd async event");
		eventSource.fireAsync(new GreetEvent("Hello at " + LocalTime.now()));
	}
}
