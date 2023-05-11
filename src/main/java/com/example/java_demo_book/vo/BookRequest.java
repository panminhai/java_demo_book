package com.example.java_demo_book.vo;

import java.util.List;

import com.example.java_demo_book.entity.Book;

public class BookRequest {
	
	// method: Vú‘Ğ‘—¿
	private List<Book> reqBookInfo;
	
	// method"—Ş•Êrq"request—p
	private String category;
	
	// method "‘Ğrq"request—p
	private String name;
	private String isbn; 
	private String author;
	private boolean isBuyer;
	
	// method "‘ĞXV"request: [isbn, stock][isbn, price][isbn, category]
	private int stock;
	private int price;
	
	private int sales;
	
	
	/*
	 *  method: ‘Ğç÷šS—p
	 */
	// w”ƒ‘“Iisbn
	private List<String> buyList;
	// ‘“Iw”ƒÉ—Ê
	private List<Integer> buyNum;
	
	
	
	public BookRequest() {
		super();
	}
	


	public BookRequest(List<String> buyList, List<Integer> buyNum) {
		super();
		this.buyList = buyList;
		this.buyNum = buyNum;
	}
	

	// method : ”ƒæÌ‰Ærq—p
	public BookRequest(String name, String isbn, String author, boolean isBuyer) {
		super();
		this.name = name;
		this.isbn = isbn;
		this.author = author;
		this.isBuyer = isBuyer;
	}



	public BookRequest(List<Book> reqBookInfo, String category, String name) {
		super();
		this.reqBookInfo = reqBookInfo;
		this.category = category;
		this.name = name;
	}

	public List<Book> getReqBookInfo() {
		return reqBookInfo;
	}
	public void setReqBookInfo(List<Book> reqBookInfo) {
		this.reqBookInfo = reqBookInfo;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
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



	public int getStock() {
		return stock;
	}



	public void setStock(int stock) {
		this.stock = stock;
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



	public List<String> getBuyList() {
		return buyList;
	}



	public void setBuyList(List<String> buyList) {
		this.buyList = buyList;
	}



	public List<Integer> getBuyNum() {
		return buyNum;
	}



	public void setBuyNum(List<Integer> buyNum) {
		this.buyNum = buyNum;
	}



	public boolean isBuyer() {
		return isBuyer;
	}



	public void setBuyer(boolean isBuyer) {
		this.isBuyer = isBuyer;
	}

	

	
}
