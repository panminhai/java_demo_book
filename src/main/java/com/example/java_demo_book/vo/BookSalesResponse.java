package com.example.java_demo_book.vo;

public class BookSalesResponse {
	
	
	private String name;
	
	private String isbn;
	
	private String author;
	
	private int price;
	
	private int buyNum;
	
	private int sumPrice;
	

	public BookSalesResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	public BookSalesResponse(String name, String isbn, String author, int price, int buyNum, int sumPrice) {
		super();
		this.name = name;
		this.isbn = isbn;
		this.author = author;
		this.price = price;
		this.buyNum = buyNum;
		this.sumPrice = sumPrice;
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

	public int getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}

	public int getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(int sumPrice) {
		this.sumPrice = sumPrice;
	}

	
	

	
}
