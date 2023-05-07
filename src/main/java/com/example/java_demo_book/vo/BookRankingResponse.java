package com.example.java_demo_book.vo;

public class BookRankingResponse {
	
	private String name;

	private String isbn;

	private String author;

	private int price;
	
	
	

	public BookRankingResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	public BookRankingResponse(String name, String isbn, String author, int price) {
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
