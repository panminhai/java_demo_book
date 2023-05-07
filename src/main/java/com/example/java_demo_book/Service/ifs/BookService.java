package com.example.java_demo_book.Service.ifs;

import java.util.List;

import com.example.java_demo_book.entity.Book;
import com.example.java_demo_book.vo.BookResponse;
import com.example.java_demo_book.vo.BookTypeResponse;
import com.example.java_demo_book.vo.BuyBookResponse;

public interface BookService {
	// method: �V������
	public BookResponse addBookInfo(List<Book> book);
	
	// method: ��ޝr�q 
	public BookResponse typeSearch(String category);
		
	// method: ���Ɲr�q
	public BookResponse buyerSearch(String name, String isbn, String author);	
	
	// method: �̉Ɲr�q
	public BookResponse sellerSearch(String name, String isbn, String author);	

	// method: �X�V���Ў���(�ɑ�)
	public BookResponse updateBookInfo(String isbn, int stock);
	
	// method: �X�V���Ў���(�J�i)
	public BookResponse updateBookInfo1(String isbn, int price);
	
	// method: �X�V���Ў���(�ޕ�)
	public BookResponse updateBookInfo2(String isbn, String category);
	
	// method: �������S
	public BookResponse salesTheBook(List<String> buyList, List<Integer> buyNum);

	// method: ���Дr�s��
	public BookResponse bookRanking();

}
