package com.example.java_demo_book.Service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.java_demo_book.Service.ifs.BookService;
import com.example.java_demo_book.entity.Book;
import com.example.java_demo_book.errors.BookMessage;
import com.example.java_demo_book.repository.BookDao;
import com.example.java_demo_book.vo.BookRankingResponse;
import com.example.java_demo_book.vo.BookResponse;
import com.example.java_demo_book.vo.BookSalesResponse;
import com.example.java_demo_book.vo.BookTypeResponse;
import com.example.java_demo_book.vo.BuyBookResponse;
import com.example.java_demo_book.vo.SellBookResponse;
import com.example.java_demo_book.vo.UpdateBookResponse;

/*
 * Service實作 
 */

@Service
public class BookServiceImpl implements BookService {
	
	
	private Logger logger = LoggerFactory.getLogger(getClass()); // import: slf4j 
																//ex: logger.info()
	
	
	// 使用Dao和數據庫做接觸
	@Autowired
	private BookDao bookDao;

	/*
	 * method1: 新增書籍
	 */
	@Override
	public BookResponse addBookInfo(List<Book> book) {

		// 資料集合防呆處理
		if (CollectionUtils.isEmpty(book)) {

			return new BookResponse(BookMessage.DATALIST_ERROR.getMessage());
		}
		
		// 重複書籍防呆
		

		// 個別資料防呆處理
		List<String> bookCheck = new ArrayList<>();
		for (Book check : book) {
			if (!StringUtils.hasText(check.getIsbn()) || !StringUtils.hasText(check.getName())
					|| !StringUtils.hasText(check.getAuthor()) || !StringUtils.hasText(check.getCategory())
					|| check.getPrice() < 0 || check.getStock() < 0 || check.getSales() < 0) {

				return new BookResponse(BookMessage.ERROR_BOOK_DATA.getMessage());
				}

			{

			}
		}
		bookDao.saveAll(book);
//		List<Book> res = bookDao.saveAll(book);
		return new BookResponse(BookMessage.SUCCESSFUL.getMessage());
	}

	/*
	 * method2: 類別查詢
	 */
	@Override
	public BookResponse typeSearch(String category) {
		// 防呆: 沒輸入category的錯誤處理
		if (!StringUtils.hasText(category)) {
			return new BookResponse(BookMessage.STRING_ERROR.getMessage());

		}

		// booklist: 在資料庫尋找相同類別的書籍並收集起來
		List<Book> booklist = bookDao.findAllByCategory(category);

		if (booklist.isEmpty()) {

			return new BookResponse(BookMessage.INSERT_ERROR.getMessage());

		}
		
		// 空值list: 用來裝booklist
		List<BookTypeResponse> resTypeList = new ArrayList<>();

		/*
		 * 用item收集每個資料
		 */
		for (Book item : booklist) {
			// 建構式"resType"取得資料: name, Isbn, Author, Price, Stock資料
			BookTypeResponse resType = new BookTypeResponse(item.getName(), item.getIsbn(), item.getAuthor(),
					item.getPrice(), item.getStock());

			// 將resType加入空list: resTypeList擁有要顯示的資料
			resTypeList.add(resType);
		}

//		System.out.println("TheBookInfo: " + resTypeList);

		return new BookResponse(resTypeList);
	}

	/*
	 * method3: 買書者搜尋
	 */
	@Override
	public BookResponse buyerSearch(String name, String isbn, String author) {

//		int isConsumer;
//		if(boolean isConsumer == 0) {
//			
//		}
		
		/*
		 * 全部資料取出
		 */

		List<Book> allBookInfo = bookDao.findAll();
		
		// 裝查詢結果書單
		List<BuyBookResponse> buyerList = new ArrayList<>();

		// 全部資訊沒輸入的情況(要更改: 輸入沒關係的變數也會跑出全部結果)
		if (!StringUtils.hasText(name) && !StringUtils.hasText(isbn) && !StringUtils.hasText(author)) {
			for (Book item : allBookInfo) {
				BuyBookResponse buyerInfo = new BuyBookResponse(item.getName(), item.getIsbn(), item.getAuthor(),
						item.getPrice());
				buyerList.add(buyerInfo);

			}
		}
		// 只輸入name
		else if (StringUtils.hasText(name) && !StringUtils.hasText(isbn) && !StringUtils.hasText(author)) {
			/*
			 * 資料抽取比對
			 */
			for (Book item : allBookInfo) {
				
				// 對照前端的名字是否和資料庫相同 item: 資料庫的書名, name: 輸入端的書名
				if (item.getName().equals(name)) {

					BuyBookResponse buyerInfo = new BuyBookResponse(item.getName(), item.getIsbn(), item.getAuthor(),
							item.getPrice());

					buyerList.add(buyerInfo);
				}
				
			}
			
				// buyerList沒收到任何書籍: 資料庫找不到對應的書
			if(CollectionUtils.isEmpty(buyerList)) {
				
				return new BookResponse(BookMessage.DATALIST_ERROR.getMessage());

			}
			
		}
		
		// 只輸入isbn的情況
		else if (!StringUtils.hasText(name) && StringUtils.hasText(isbn) && !StringUtils.hasText(author)) {
			for (Book item : allBookInfo) {
				// item: 資料庫的isbn, isbn: 輸入端的isbn
				if (item.getIsbn().equals(isbn)) {

					BuyBookResponse buyerInfo = new BuyBookResponse(item.getName(), item.getIsbn(), item.getAuthor(),
							item.getPrice());

					buyerList.add(buyerInfo);

				}
				
			}
			
			// buyerList沒收到任何書籍: 資料庫找不到對應的書
			if(CollectionUtils.isEmpty(buyerList)) {
			
				return new BookResponse(BookMessage.DATALIST_ERROR.getMessage());

			}
		}

		// 只輸入author的情況
		else if (!StringUtils.hasText(name) && !StringUtils.hasText(isbn) && StringUtils.hasText(author)) {
			for (Book item : allBookInfo) {
				// item: 資料庫的author, isbn: 輸入端的author
				if (item.getAuthor().equals(author)) {

					BuyBookResponse buyerInfo = new BuyBookResponse(item.getName(), item.getIsbn(), item.getAuthor(),
							item.getPrice());

					buyerList.add(buyerInfo);

				}
				
			}
			
			// buyerList沒收到任何書籍: 資料庫找不到對應的書
			if(CollectionUtils.isEmpty(buyerList)) {
				
				return new BookResponse(BookMessage.DATALIST_ERROR.getMessage());

			}
			
			// 預計: 輸入以外的資訊
		// else{}
		
		}
		// 負責回傳
		return new BookResponse("successful!", buyerList);
	}

	/*
	 * method4: 賣書者搜尋
	 */
	@Override
	public BookResponse sellerSearch(String name, String isbn, String author) {
		/*
		 * 全部資料取出
		 */
		List<Book> allBookInfo = bookDao.findAll();

		List<SellBookResponse> sellerList = new ArrayList<>();

		BookResponse bookResponse = new BookResponse();

		// 全部資訊沒輸入的情況(要更改)
		if (!StringUtils.hasText(name) && !StringUtils.hasText(isbn) && !StringUtils.hasText(author)) {

			for (Book item : allBookInfo) {
				SellBookResponse sellerInfo = new SellBookResponse(item.getName(), item.getIsbn(), item.getAuthor(),
						item.getPrice(), item.getSales(), item.getStock());

				sellerList.add(sellerInfo);
			}

		}

		else if (StringUtils.hasText(name) && !StringUtils.hasText(isbn) && !StringUtils.hasText(author)) {

			for (Book item : allBookInfo) {
				if (item.getName().equals(name)) {
					SellBookResponse sellerInfo = new SellBookResponse(item.getName(), item.getIsbn(), item.getAuthor(),
							item.getPrice(), item.getSales(), item.getStock());

					sellerList.add(sellerInfo);

				}
			}
		}

		else if (!StringUtils.hasText(name) && StringUtils.hasText(isbn) && !StringUtils.hasText(author)) {

			for (Book item : allBookInfo) {
				if (item.getIsbn().equals(isbn)) {
					SellBookResponse sellerInfo = new SellBookResponse(item.getName(), item.getIsbn(), item.getAuthor(),
							item.getPrice(), item.getSales(), item.getStock());

					sellerList.add(sellerInfo);
				}

			}

		}

		else if (!StringUtils.hasText(name) && !StringUtils.hasText(isbn) && StringUtils.hasText(author)) {

			for (Book item : allBookInfo) {
				if (item.getAuthor().equals(author)) {

					SellBookResponse sellerInfo = new SellBookResponse(item.getName(), item.getIsbn(), item.getAuthor(),
							item.getPrice(), item.getSales(), item.getStock());

					sellerList.add(sellerInfo);
				}

			}

		}

		// 設置銷售員的Response(List<SellBookResponse>)去接收for迴圈的list(sellerList)
		bookResponse.setＳellBookResponse(sellerList);
		return bookResponse;
	}

	// method5: 更新書籍(庫存)
	@Override
	public BookResponse updateBookInfo(String isbn, int stock) {
		
		List<Book> allBookInfo = bookDao.findAll();

		// 取得最終結果
		List<UpdateBookResponse> updateBookResponse = new ArrayList<>();

		BookResponse bookResponse = new BookResponse();

		// 若都沒輸入內容的情況: 顯示目前書庫情報
		if (stock == 0 && !StringUtils.hasText(isbn)) {

			for (Book item : allBookInfo) {
				UpdateBookResponse updateBook = new UpdateBookResponse(item.getName(), item.getIsbn(), item.getAuthor(),
						item.getPrice(), item.getStock());

				updateBookResponse.add(updateBook);
			}
			bookResponse.setUpdateBookResponse("目前書庫情報:", updateBookResponse);

			return bookResponse;
		
		}
		
		
		// 輸入單邊資訊: 錯誤訊息回報
		else if(stock == 0 || !StringUtils.hasText(isbn)) {
			
			return new BookResponse(BookMessage.NOT_UPDATEDATA.getMessage());
		
		}

	
		// 更新資料庫(書庫存)
		int res = bookDao.updateStockByIsbn(isbn, stock);

		// 從更新後的資料庫中找書(用isbn)
		Book updateBookInfo = bookDao.findByIsbn(isbn);

		// DataBase找到書:
		if (res == 1) {
			
			//		bookDao.saveAll(book);
			UpdateBookResponse updateBook = new UpdateBookResponse(updateBookInfo.getName(), updateBookInfo.getIsbn(),
					updateBookInfo.getAuthor(), updateBookInfo.getPrice(), updateBookInfo.getStock());

			updateBookResponse.add(updateBook);

		}
		
		
		
		
		// res = 0: DataBase找不到書
		else {
			return new BookResponse(BookMessage.DATALIST_ERROR.getMessage());
		}
		
		// 設置更新書籍的Response(setUpdateBookResponse)去接收
		bookResponse.setUpdateBookResponse("更新後書庫情報成功!", updateBookResponse);

		return bookResponse;
	}
	
	// method5: 更新書籍(價格)
	@Override
	public BookResponse updateBookInfo1(String isbn, int price) {
		
		
			
		// 取得全部資料
		List<Book> allBookInfo = bookDao.findAll();

		// 取得最終結果
		List<UpdateBookResponse> updateBookResponse = new ArrayList<>();

		BookResponse bookResponse = new BookResponse();
		
		
		// 若都沒輸入更新內容的情況: 顯示目前書庫情報
		if(price == 0 && !StringUtils.hasText(isbn)) {
			
			for (Book item : allBookInfo) {
				UpdateBookResponse updateBook = new UpdateBookResponse(item.getName(), item.getIsbn(), item.getAuthor(),
						item.getPrice(), item.getStock());

				updateBookResponse.add(updateBook);
			}
			bookResponse.setUpdateBookResponse("目前書庫情報:", updateBookResponse);

			return bookResponse;
			
		}

		// 輸入單邊資訊: 錯誤訊息回報
		else if(price == 0 || !StringUtils.hasText(isbn)) {
			
			return new BookResponse(BookMessage.NOT_UPDATEDATA.getMessage());

		}
		
		// 更新資料庫(書價格)
		int res = bookDao.updatePriceByIsbn(isbn, price);

		// 從更新後的資料庫中找書
		Book updateBookInfo = bookDao.findByIsbn(isbn);
		
		// DataBase找到書:
		if (res == 1) {
			
			//		bookDao.saveAll(book);
			UpdateBookResponse updateBook = new UpdateBookResponse(updateBookInfo.getName(), updateBookInfo.getIsbn(),
					updateBookInfo.getAuthor(), updateBookInfo.getPrice(), updateBookInfo.getStock());

			updateBookResponse.add(updateBook);
		}
		
		
		// res = 0: DataBase找不到書
		else {
			
			return new BookResponse(BookMessage.DATALIST_ERROR.getMessage());
		}
		
		
		bookResponse.setUpdateBookResponse("更新後書庫情報成功!", updateBookResponse);

		return bookResponse;
	}
	
	
	// method5: 更新書籍(類別)
	@Override
	public BookResponse updateBookInfo2(String isbn, String category) {
		
		
		// 取得全部資料
		List<Book> allBookInfo = bookDao.findAll();

		// 取得最終結果
		List<UpdateBookResponse> updateBookResponse = new ArrayList<>();

		BookResponse bookResponse = new BookResponse();
		
		
		// 若都沒輸入更新內容的情況: 顯示目前書庫情報
		if(!StringUtils.hasText(isbn) && !StringUtils.hasText(category)) {
			
			for (Book item : allBookInfo) {
				UpdateBookResponse updateBook = new UpdateBookResponse(item.getName(), item.getIsbn(), item.getAuthor(),
						item.getPrice(), item.getCategory());

				updateBookResponse.add(updateBook);
			}
			bookResponse.setUpdateBookResponse("目前書庫情報:", updateBookResponse);

			return bookResponse;
			
		}
		
		// 輸入單邊資訊: 錯誤訊息回報
		else if(!StringUtils.hasText(isbn) || !StringUtils.hasText(category)) {
			
			return new BookResponse(BookMessage.NOT_UPDATEDATA.getMessage());
	
		}

		// 更新資料庫(書類別)
		int res = bookDao.updateCategoryByIsbn(isbn, category);

		// 從更新後的資料庫中找書
		Book updateBookInfo = bookDao.findByIsbn(isbn);
		
		
		// DataBase找到書:
		if (res == 1) {
			
			//		bookDao.saveAll(book);
			UpdateBookResponse updateBook = new UpdateBookResponse(updateBookInfo.getName(), updateBookInfo.getIsbn(),
					updateBookInfo.getAuthor(), updateBookInfo.getPrice(), updateBookInfo.getCategory());

			updateBookResponse.add(updateBook);
		}
		
		
		// res = 0: DataBase找不到書
		else {
			
			return new BookResponse(BookMessage.DATALIST_ERROR.getMessage());
		}
		
		
		bookResponse.setUpdateBookResponse("更新後書庫情報成功!", updateBookResponse);

		return bookResponse;
		
		
		}

	// method6: 銷售書籍
	@Override
	public BookResponse salesTheBook(List<String> buyList, List<Integer> buyNum) {

//		Book resStock = bookDao.findByStock(buyNum) ;
		// 取得全部資料
		
		List<BookSalesResponse> resBuyBook = new ArrayList<>();

		BookResponse bookResponse = new BookResponse();
		
		// 書的isbn和購買數2者都要輸入
		if(CollectionUtils.isEmpty(buyList) || CollectionUtils.isEmpty(buyNum)) {

			return new BookResponse(BookMessage.NOT_UPDATEDATA.getMessage());

			
		}
		
		if(!(buyList.size() == buyNum.size())) {
			
			return new BookResponse(BookMessage.BOOK_SALES_ERROR.getMessage());
		}
		
		
//		for(String item : buyList) {
		/*	購買書&書的數量共用同一個迴圈	*/
		for(int i = 0; i < buyList.size(); i++) {
			// 把list的每個isbn取出在資料庫尋找
			Book storeBook = bookDao.findByIsbn(buyList.get(i));
			
			// 取出在資料庫的銷售量
			int oldSales = storeBook.getSales();
			
			// 取出在資料庫的庫存量
			int oldStock = storeBook.getStock();
			
			// 取出在資料庫的價格
			int oldPrice = storeBook.getPrice();
			
			
//			bookList.add(item);
//		for(Integer itemNum : buyNum) {
			
			int newPrice = oldPrice * buyNum.get(i);

			int newSales = oldSales + buyNum.get(i);
			
			int newStock = oldStock - buyNum.get(i);
			
			storeBook.setSales(newSales);
			storeBook.setStock(newStock);
			
			bookDao.save(storeBook);
			
			
			BookSalesResponse bookSales = new BookSalesResponse(storeBook.getName(), storeBook.getIsbn()
					, storeBook.getAuthor(), storeBook.getPrice(), buyNum.get(i), newPrice);

			resBuyBook.add(bookSales);
			
			bookResponse.setBookSalesResponse(resBuyBook);
			
			
			}
			
			
			return bookResponse;
//		}
		
//		if(!CollectionUtils.isEmpty(salesBook)) {
//			for(Entry<String, Integer> item : salesBook.entrySet()) {
//				
//				List<Book> isbnList = bookDao.findByIsbn(item.getKey());
//				
//				Integer buyNum = item.getValue();
//
//				int oldStock = isbnList.getStock();
//				
//				int newStock = oldStock - buyNum;
//				
//				isbnList.setStock(newStock);
//				
//				
//				
//				int oldSales = isbnList.getSales();
//				
//				int newSales = oldSales + buyNum;
//
//				isbnList.setSales(newSales);
//
//				bookDao.save(isbnList);
//				
//				resBuyBook.add(isbnList);
//				}
//			
//			bookResponse.setBookSalesResponse(resBuyBook);
//			
//			return bookResponse;
//			
//			
//		}
//			for (Book item : allBookInfo) {
//				UpdateBookResponse updateBook = new UpdateBookResponse(item.getName(), item.getIsbn(), item.getAuthor(),
//						item.getPrice(), item.getCategory());
//
//			}
//			bookResponse.setUpdateBookResponse("目前書庫情報:", updateBookResponse);
//
//			return bookResponse;
//			
//		}
				
//		}
	}

	// method7: 書籍排名
	@Override
	public BookResponse bookRanking() {
				
		// 在資料庫找出前5大銷售量的書
		List<Book> topSales = bookDao.findTop5ByOrderBySalesDesc();

		// 裝前5大銷售量書回傳資料
		List<BookRankingResponse> resTopSales = new ArrayList<>();

		
		BookResponse bookResponse = new BookResponse();
	
				
		
		for(Book item: topSales ) {
			
		BookRankingResponse	bookRanking = new BookRankingResponse(item.getName(), item.getIsbn(), 
				item.getAuthor(), item.getPrice());
		
			resTopSales.add(bookRanking);
			
			bookResponse.setBookRankingResponse("排行榜前5名書單", resTopSales);
			
		}
		
		
		return bookResponse;
	}

	//method3-1: 買賣家搜尋 
	@Override
	public BookResponse buySellSearch(String name, String isbn, String author, boolean isBuyer) {

		/*
		 * 全部資料取出
		 */
		List<Book> allBookInfo = bookDao.findAll();
		
		// 裝查詢結果書單: 買家
		List<BuyBookResponse> buyerList = new ArrayList<>();
		
		List<SellBookResponse> sellerList = new ArrayList<>();

		BookResponse bookResponse = new BookResponse();

		
		// 在資料庫尋找相同書名的書
		Book resName = bookDao.findByName(name);
		
		Book resIsbn = bookDao.findByIsbn(isbn);
		
		Book resAuthor = bookDao.findByAuthor(author);
		
		
		if(!StringUtils.hasText(name) && !StringUtils.hasText(isbn) && !StringUtils.hasText(author)) {
			
			return new BookResponse(BookMessage.NOT_UPDATEDATA.getMessage());
		}
		
		
		/*
		 * 買家處理
		 */
		for(Book item : allBookInfo) {
		
			if((!(resName== null) || !(resIsbn==null)) || !(resAuthor==null) && isBuyer == true) {
				
				BuyBookResponse buyerInfo = new BuyBookResponse(item.getName(), item.getIsbn(), item.getAuthor(),
						item.getPrice());
				buyerList.add(buyerInfo);
				
				// 負責回傳
				return new BookResponse("successful!", buyerList);
			}
			
			else {
				return new BookResponse(BookMessage.INSERT_ERROR.getMessage());

			}
			
		}	
			
		
		/*
		 * 賣家處理
		 */
		for(Book item : allBookInfo) {
			
			if((!(resName== null) || !(resIsbn==null)) || !(resAuthor==null) && isBuyer == false) {
				
				SellBookResponse sellerInfo = new SellBookResponse(item.getName(), item.getIsbn(), item.getAuthor(),
						item.getPrice(), item.getSales(), item.getStock());

				sellerList.add(sellerInfo);
				
				// 設置銷售員的Response(List<SellBookResponse>)去接收for迴圈的list(sellerList)
				bookResponse.setＳellBookResponse(sellerList);
				return bookResponse;

			}
			
			else {
				return new BookResponse(BookMessage.INSERT_ERROR.getMessage());

			}
			
			
		}
		return bookResponse;
		
		
	}

}
