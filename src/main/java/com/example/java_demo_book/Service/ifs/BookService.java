package com.example.java_demo_book.Service.ifs;

import java.util.List;

import com.example.java_demo_book.entity.Book;
import com.example.java_demo_book.vo.BookResponse;
import com.example.java_demo_book.vo.BookTypeResponse;
import com.example.java_demo_book.vo.BuyBookResponse;

public interface BookService {
	// method: Vú‘Ğ
	public BookResponse addBookInfo(List<Book> book);
	
	// method: í—Şrq 
	public BookResponse typeSearch(String category);
		
	// method: ”ƒ‰Ærq
	public BookResponse buyerSearch(String name, String isbn, String author);	
	
	// method: æÌ‰Ærq
	public BookResponse sellerSearch(String name, String isbn, String author);	

	// method: XV‘Ğ‘—¿(ŒÉ‘¶)
	public BookResponse updateBookInfo(String isbn, int stock);
	
	// method: XV‘Ğ‘—¿(™JŠi)
	public BookResponse updateBookInfo1(String isbn, int price);
	
	// method: XV‘Ğ‘—¿(—Ş•Ê)
	public BookResponse updateBookInfo2(String isbn, String category);
	
	// method: ‘Ğç÷šS
	public BookResponse salesTheBook(List<String> buyList, List<Integer> buyNum);

	// method: ‘Ğ”rsÔ
	public BookResponse bookRanking();

}
