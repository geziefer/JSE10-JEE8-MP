package de.syrocon.jee8demo.jpa;

import java.time.LocalDate;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b")
@NamedQuery(name = "Book.findByISBN", query = "SELECT b FROM Book b WHERE b.isbn = :isbn")
public class Book {
	@Id
	private String isbn;

	private String name;

	@JsonbDateFormat("dd.MM.yyyy")
	private LocalDate published;

	public Book() {

	}

	public Book(String isbn, String name, LocalDate published) {
		this.isbn = isbn;
		this.name = name;
		this.published = published;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getPublished() {
		return published;
	}

	public void setPublished(LocalDate published) {
		this.published = published;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", name=" + name + ", published=" + published + "]";
	}
}
