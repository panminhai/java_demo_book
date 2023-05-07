package com.example.java_demo_book.vo;

import java.util.List;


public class BookTypeResponse {

	// 回傳內容(resBookInfo, message)
	// resBookInfo: 回復訊息&結果(前端要輸入)

	private String name;

	private String isbn;

	private String author;

	private int price;

	private int stock;



	public BookTypeResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookTypeResponse(String name, String isbn, String author, int price, int stock) {
		super();
		this.name = name;
		this.isbn = isbn;
		this.author = author;
		this.price = price;
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
