package com.example.java_demo_book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.example.java_demo_book.Service.ifs.BookService;
import com.example.java_demo_book.entity.Book;
import com.example.java_demo_book.repository.BookDao;
import com.example.java_demo_book.vo.BookResponse;
import com.example.java_demo_book.vo.BookSalesResponse;
import com.example.java_demo_book.vo.BookTypeResponse;

/*
 * 錯誤測試
 */

@SpringBootTest(classes = JavaDemoBookApplication.class)
public class BookTest {
	
	// 注入: 透過Spring自動把屬性需要的對象找出來使用
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private BookService bookService;

	@Test
	public void addBookInfo() {
		
		// insert the data
		/*
		 * data(): String isbn, String name, String author,
		 *  int price, int stock, int sales, String category
		 */
		Book book = new Book("978-4-949999-12-0", "AAA", "A01", 140, 10, 150, "mystery");
		Book book1 = new Book("378-5-789287-32-0", "BBB", "B01", 250, 30, 50, "fantasy");
		Book book2 = new Book("478-4-748392-12-0", "CCC", "C01", 220, 15, 70, "mystery");
		Book book3 = new Book("423-3-472939-32-0", "DDD", "D01", 90, 7, 130, "comic");
		Book book4 = new Book("687-5-129375-49-0", "EEE", "E01", 120, 20, 110, "literary");
		Book book5 = new Book("234-1-938528-13-0", "FFF", "F01", 140, 10, 150, "literary");
		Book book6 = new Book("423-7-394820-63-0", "III", "I01", 140, 20, 130, "programing");
		// failed data
		Book bookF = new Book("", "AFF", "A03", 140, 10, 150, "novel");
		Book bookF1 = new Book(null, "AFF", "A03", 140, 10, 150, "novel");

		// list空陣列
		List<Book> list = new ArrayList<>();
		// 將書籍資料加入list
		list.add(bookF);
		 
		// 回傳至ServiceImpl處理
		BookResponse res = bookService.addBookInfo(list);
		
		// 檢查Test資料內容
//		Book resBook = res.getResBookInfo().get(0);
		List<Book> resBook = res.getResBookInfo();

//		Assert.isTrue(bookF.getIsbn().equals(resBook.getIsbn()), "Test Error!");
		Assert.isTrue(!CollectionUtils.isEmpty(resBook), "Test Error!");

		
	}
	@Test
	public void typeSearch() {
		
		String category = "friend";

		BookResponse res = bookService.typeSearch(category);
		
		BookTypeResponse resType = res.getBookTypeResponse().get(0);

		List<BookTypeResponse> resType1 = res.getBookTypeResponse();
		
//		resType1.add(resType);	
		
		Assert.isTrue(!CollectionUtils.isEmpty(resType1), "Test Error!");
		
	
	}
	
	/*
	 * 更新資料(庫存)
	 */
	@Test
	public void updateStockByIsbn() {
		
		// res: 更新結果判定
		int res = bookDao.updateStockByIsbn("378-5-789287-32-0", 33);
		
		if(res == 1) {
			System.out.println("結果： " + res + " Successful!");
			}
		
		else {
			System.out.println("Test error!");
			}
		
		}
	
	/*
	 * 更新資料(價格)
	 */
	@Test
	public void updatePriceByIsbn() {
		
		// res: 更新結果判定
		int res = bookDao.updatePriceByIsbn("378-5-789287-32-0", 33);
		
		if(res == 1) {
			System.out.println("結果： " + res + " Successful!");
			}
		
		else {
			System.out.println("Test error!");
		}
		
	}
	
	
	/*
	 * 更新資料(類別)
	 */
	@Test
	public void updateCategoryByIsbn() {
		
		// res: 更新結果判定
		int res = bookDao.updateCategoryByIsbn("378-5-789287-32-0", "programing");
		
		if(res == 1) {
			System.out.println("結果： " + res + " Successful!");
			}
		
		else {
			System.out.println("Test error!");
		}
		
	}
	
	
	@Test
	public void salesTheBook() {
		
		List<String> buyList = new ArrayList<>();
		buyList.add("378-5-789287-32-0");
		buyList.add("687-5-129375-49-0");
		
		
		List<Integer> buyNum = new ArrayList<>();
		buyNum.add(5);
//		buyNum.add(3);
		
		// 將預設購書明細傳入method並以"res"擷取結果
		BookResponse res = bookService.salesTheBook(buyList, buyNum);

		// 從結果(BookResponse)裡取得本method的設置結果(BookSalesResponse)
		List<BookSalesResponse> resSales = res.getBookSalesResponse();
		
		// 錯誤測試
		if(CollectionUtils.isEmpty(resSales)) {
			
			System.out.println("Test Error!");
		}
	
	}
	
	
	/*
	 * 書籍排行榜Test: 暫時不測試
	 */
//	@Test
//	public void bookRanking() {	
//	}
	
	
}
	
	
	
	
	



