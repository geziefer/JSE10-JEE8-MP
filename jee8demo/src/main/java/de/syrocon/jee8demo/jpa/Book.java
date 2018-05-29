package de.syrocon.jee8demo.jpa;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "findAll", query = "SELECT b FROM Book b")
@NamedQuery(name = "findByISBN", query = "SELECT b FROM Book b WHERE b.isbn = :isbn")
public class Book {

}
