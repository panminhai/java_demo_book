package com.example.java_demo_book.vo;

public class UpdateBookResponse {
	
	private String name;
	
	private String isbn;
	
	private String author;
	
	private int price;
	
	private int stock;
	
	private String category;
	


	public UpdateBookResponse() {
		super();
	}
	// 更新書籍資料(庫存量, 價格顯示結果)
	public UpdateBookResponse(String name, String isbn, String author, int price, int stock) {
		super();
		this.name = name;
		this.isbn = isbn;
		this.author = author;
		this.price = price;
		this.stock = stock;
	}
	
	
	// 更新書籍資料(分類顯示結果)
	public UpdateBookResponse(String name, String isbn, String author, int price, String category) {
		super();
		this.name = name;
		this.isbn = isbn;
		this.author = author;
		this.price = price;
		this.category = category;
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

	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
