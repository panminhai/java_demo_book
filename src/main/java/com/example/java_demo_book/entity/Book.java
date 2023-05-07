package com.example.java_demo_book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@Column(name = "isbn")
	private String isbn;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "author")
	private String author;

	@Column(name = "price")
	private int price;
	
	@Column(name = "stock")
	private int stock;
	
	@Column(name = "sales")
	private int sales;
	
	@Column(name = "category")
	private String category;

	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Book(String isbn, String name, String author, int price, int stock, int sales, String category) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.author = author;
		this.price = price;
		this.stock = stock;
		this.sales = sales;
		this.category = category;
	}



	public Book(String isbn, String name, String author, int price, int stock) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.author = author;
		this.price = price;
		this.stock = stock;
	}

	public Book(int stock) {
		super();
		this.stock = stock;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	




}
