package com.example.java_demo_book.vo;

public class BuyBookResponse {

	/*
	 * ‰ñ™B‹‹Á”ïÒ“I‘Ğ‘u
	 */
	private String name;
	
	private String isbn;
	
	private String author;
	
	private int price;
	
	
	public BuyBookResponse() {
		super();
		// TODO Auto-generated constructor stub
	}





	public BuyBookResponse(String name, String isbn, String author, int price) {
		super();
		this.name = name;
		this.isbn = isbn;
		this.author = author;
		this.price = price;
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
	
	
	
}
