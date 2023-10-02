package com.example.java_demo_book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_demo_book.Service.ifs.BookService;
import com.example.java_demo_book.vo.BookRequest;
import com.example.java_demo_book.vo.BookResponse;

@CrossOrigin // 用於瀏覽器連接(前端)
@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	// PostMapping: 前端尋找輸入資料	, value: 貼在外端post連接用, RequestBody: 轉換成java語言格式方便後端程式使用
	@PostMapping(value = "add_book_info") 
	public BookResponse addBookInfo(@RequestBody BookRequest request) { // "()"內容為外端的request對象的呼叫
		
		return bookService.addBookInfo(request.getReqBookInfo());
	}
	
	
	
	// PostMapping: 前端尋找輸入資料	, value: 貼在外端post連接用, RequestBody: 轉換成java語言格式方便後端程式使用
	@PostMapping(value = "type_search_info") 
	public BookResponse typeSearch(@RequestBody BookRequest request) { // "()"內容為外端的request對象的呼叫
		
		return bookService.typeSearch(request.getCategory());
	}

	
	// PostMapping: 前端尋找輸入資料	, value: 貼在外端post連接用, RequestBody: 轉換成java語言格式方便後端程式使用
	@PostMapping(value = "name_search_buyer") 
	public BookResponse buyerSearch(@RequestBody BookRequest request) { // "()"內容為外端的request對象的呼叫
		
		return bookService.buyerSearch(request.getName(), request.getIsbn(), request.getAuthor());
	}
	
	// PostMapping: 前端尋找輸入資料	, value: 貼在外端post連接用, RequestBody: 轉換成java語言格式方便後端程式使用
	@PostMapping(value = "name_search_seller") 
	public BookResponse sellerSearch(@RequestBody BookRequest request) { // "()"內容為外端的request對象的呼叫
		
		return bookService.sellerSearch(request.getName(), request.getIsbn(), request.getAuthor());
	}
	
	
	// PostMapping: 前端尋找輸入資料	, value: 貼在外端post連接用, RequestBody: 轉換成java語言格式方便後端程式使用
	@PostMapping(value = "name_search_buySell") 
	public BookResponse buySellSearch(@RequestBody BookRequest request) { // "()"內容為外端的request對象的呼叫
		
		return bookService.buySellSearch(request.getName(), request.getIsbn(), request.getAuthor(), request.isBuyer());
	}
	
	// PostMapping: 前端尋找輸入資料	, value: 貼在外端post連接用, RequestBody: 轉換成java語言格式方便後端程式使用
	@PostMapping(value = "update_book_stock") 
	public BookResponse updateBookResponse(@RequestBody BookRequest request) { // "()"內容為外端的request對象的呼叫
		
		return bookService.updateBookInfo(request.getIsbn(), request.getStock());
	}
	
	
	
	@PostMapping(value = "update_book_price") 
	public BookResponse updateBookResponse1(@RequestBody BookRequest request) { // "()"內容為外端的request對象的呼叫
		
		return bookService.updateBookInfo1(request.getIsbn(), request.getPrice());
	}
	
	@PostMapping(value = "update_book_category") 
	public BookResponse updateBookResponse2(@RequestBody BookRequest request) { // "()"內容為外端的request對象的呼叫
		
		return bookService.updateBookInfo2(request.getIsbn(), request.getCategory());
	}
	
	
	
	@PostMapping(value = "buy_book_service") 
	public BookResponse bookSalesResponse(@RequestBody BookRequest request) { // "()"內容為外端的request對象的呼叫
		
		return bookService.salesTheBook(request.getBuyList(), request.getBuyNum());
	}
	
	
	@PostMapping(value = "book_ranking") 
	public BookResponse bookRanking() { // "()"內容為外端的request對象的呼叫
		
		return bookService.bookRanking();
		
	}
	

	
}
