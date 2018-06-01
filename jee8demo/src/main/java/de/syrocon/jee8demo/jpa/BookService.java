package de.syrocon.jee8demo.jpa;

import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@ApplicationScoped
@Path("/jpademo")
public class BookService {
	@PersistenceContext
	EntityManager em;

	@GET
	public void query() {
		Stream<Book> books = em.createQuery("SELECT b FROM Book b", Book.class).getResultStream();
		books.map(b -> b.getName() + "/" + b.getPublished()).forEach(System.out::println);

	}
}
