package com.example.java_demo_book.vo;

public class SellBookResponse {
	
	private String name;
	
	private String isbn;
	
	private String author;
	
	private int price;
	
	private int sales;
	
	private int stock;
	
	
	public SellBookResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SellBookResponse(String name, String isbn, String author, int price, int sales, int stock) {
		super();
		this.name = name;
		this.isbn = isbn;
		this.author = author;
		this.price = price;
		this.sales = sales;
		this.stock = stock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
	


}
