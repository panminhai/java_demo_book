package com.example.java_demo_book.Service.ifs;

import java.util.List;

import com.example.java_demo_book.entity.Book;
import com.example.java_demo_book.vo.BookResponse;
import com.example.java_demo_book.vo.BookTypeResponse;
import com.example.java_demo_book.vo.BuyBookResponse;

public interface BookService {
	// method: VϊΠ
	public BookResponse addBookInfo(List<Book> book);
	
	// method: νήrq 
	public BookResponse typeSearch(String category);
		
	// method: Ζrq
	public BookResponse buyerSearch(String name, String isbn, String author);	
	
	// method: ζΜΖrq
	public BookResponse sellerSearch(String name, String isbn, String author);
	
	// method: ζΜΖrq
	public BookResponse buySellSearch(String name, String isbn, String author, boolean isBuyer);

	// method: XVΠΏ(ΙΆ)
	public BookResponse updateBookInfo(String isbn, int stock);
	
	// method: XVΠΏ(Ji)
	public BookResponse updateBookInfo1(String isbn, int price);
	
	// method: XVΠΏ(ήΚ)
	public BookResponse updateBookInfo2(String isbn, String category);
	
	// method: ΠηχS
	public BookResponse salesTheBook(List<String> buyList, List<Integer> buyNum);

	// method: ΠrsΤ
	public BookResponse bookRanking();
	


}
