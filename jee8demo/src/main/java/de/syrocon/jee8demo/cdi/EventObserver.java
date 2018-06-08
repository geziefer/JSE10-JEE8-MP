package de.syrocon.jee8demo.cdi;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.ObservesAsync;
import javax.interceptor.Interceptor;

@ApplicationScoped
public class EventObserver {

	public void observe1st(@Observes @Priority(Interceptor.Priority.APPLICATION + 1) GreetEvent e) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
		}
		System.out.println("1st Observer: " + e.getMessage());
	}

	public void observe2nd(@Observes @Priority(Interceptor.Priority.APPLICATION + 2) GreetEvent e) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
		}
		System.out.println("2nd Observer: " + e.getMessage());
	}

	public void observeAsync(@ObservesAsync GreetEvent e) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
		}
		System.out.println("AsyncObserver: " + e.getMessage());
	}

}
