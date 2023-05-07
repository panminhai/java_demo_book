package com.example.java_demo_book.vo;

import java.util.ArrayList;
import java.util.List;

import com.example.java_demo_book.entity.Book;

/*
 * 給外端訊息回應
 */
public class BookResponse {

	// 回傳內容(resBookInfo, message)
	// resBookInfo: 回復訊息&結果(前端會顯示)
	private List<Book> resBookInfo;
		
	private BuyBookResponse resBuyBook;
	
	private SellBookResponse resSellBook;
	
	private UpdateBookResponse updateBook;
	
	

	
	private List<BuyBookResponse> buyBookResponse;
	
	private List<SellBookResponse> ｓellBookResponse;
	
	private List<BookTypeResponse> bookTypeResponse;
	
	private List<UpdateBookResponse> updateBookResponse;
	
	private List<BookSalesResponse> bookSalesResponse;

	private List<BookRankingResponse> bookRankingResponse;

	
//	private List<UpdateTypeBookResponse> updateTypeBookResponse;
	
	private String message;

	public BookResponse() {
		super();
	}

	public BookResponse(BuyBookResponse resBuyBook, String message) {
		super();
		this.resBuyBook = resBuyBook;
		this.message = message;

	}



	public BookResponse(UpdateBookResponse updateBook) {
		super();
		this.updateBook = updateBook;
	}

	public BookResponse(String message) {
		super();
		this.message = message;
	}

	
	
	public BookResponse(String message,List<BuyBookResponse> buyBookResponse) {
		super();
		this.buyBookResponse = buyBookResponse;
		this.message = message;
	}




	public BookResponse(List<Book> resBookInfo, String message) {
		super();
		this.resBookInfo = resBookInfo;
		this.message = message;
	}
	


	public BookResponse(SellBookResponse resSellBook) {
		super();
		this.resSellBook = resSellBook;
	}



	public BookResponse(BuyBookResponse resBuyBook) {
		super();
		this.resBuyBook = resBuyBook;
	}



	public BookResponse(List<BookTypeResponse> bookTypeResponse) {
		super();
		this.bookTypeResponse = bookTypeResponse;
	}


	public List<Book> getResBookInfo() {
		return resBookInfo;
	}

	public void setResBookInfo(List<Book> resBookInfo) {
		this.resBookInfo = resBookInfo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<BookTypeResponse> getBookTypeResponse() {
		return bookTypeResponse;
	}

	public void setBookTypeResponse(List<BookTypeResponse> bookTypeResponse) {
		this.bookTypeResponse = bookTypeResponse;
	}



	public BuyBookResponse getResBuyBook() {
		return resBuyBook;
	}



	public void setResBuyBook(BuyBookResponse resBuyBook) {
		this.resBuyBook = resBuyBook;
	}



	public SellBookResponse getResSellBook() {
		return resSellBook;
	}



	public void setResSellBook(SellBookResponse resSellBook) {
		this.resSellBook = resSellBook;
	}

	public List<BuyBookResponse> getBuyBookResponse() {
		return buyBookResponse;
	}

	public void setBuyBookResponse(List<BuyBookResponse> buyBookResponse) {
		this.buyBookResponse = buyBookResponse;
	}

	public List<SellBookResponse> getＳellBookResponse() {
		return ｓellBookResponse;
	}

	public void setＳellBookResponse(List<SellBookResponse> ｓellBookResponse) {
		this.ｓellBookResponse = ｓellBookResponse;
	}

	public UpdateBookResponse getUpdateBook() {
		return updateBook;
	}

	public void setUpdateBook(UpdateBookResponse updateBook) {
		this.updateBook = updateBook;
	}

	public List<UpdateBookResponse> getUpdateBookResponse() {
		return updateBookResponse;
	}
	// 顯示更新書單
	public void setUpdateBookResponse(String message, List<UpdateBookResponse> updateBookResponse) {
		this.message = message;
		this.updateBookResponse = updateBookResponse;
	}

	public List<BookSalesResponse> getBookSalesResponse() {
		return bookSalesResponse;
	}

	public void setBookSalesResponse(List<BookSalesResponse> bookSalesResponse) {
		this.bookSalesResponse = bookSalesResponse;
	}

	public void setUpdateBookResponse(List<UpdateBookResponse> updateBookResponse) {
		this.updateBookResponse = updateBookResponse;
	}

	public List<BookRankingResponse> getBookRankingResponse() {
		return bookRankingResponse;
	}

	public void setBookRankingResponse(String message, List<BookRankingResponse> bookRankingResponse) {
		
		this.message = message;
		this.bookRankingResponse = bookRankingResponse;
	}
	

	
	

}
