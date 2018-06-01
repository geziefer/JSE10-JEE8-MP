package de.syrocon.jee8demo.rest;

import java.time.LocalDate;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.SseEventSource;

import de.syrocon.jee8demo.jpa.Book;

@ApplicationScoped
@Path("/restdemo")
public class SseClient {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Book register() {
		WebTarget target = ClientBuilder.newClient().target("http://localhost:8080/jee8demo/rest/sse");
		try (SseEventSource sseEventSource = SseEventSource.target(target).build()) {

			sseEventSource.register(System.out::println);
			sseEventSource.open();

			Thread.sleep(1500);
			
			Book book = new Book("1234567890", "Test book", LocalDate.now());
			return book;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}
}
