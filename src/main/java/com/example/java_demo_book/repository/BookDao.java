package com.example.java_demo_book.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.java_demo_book.entity.Book;

/*
 * 專注於和資料庫(MySQL)的連接
 */
@Repository
public interface BookDao extends JpaRepository<Book, String>{
	
	// 安裝JPA文法(在資料庫裡對照有對上前端"類別"的書籍)
	public List<Book> findAllByCategory (String category) ;
	
	
	public Book findByIsbn(String isbn); 
	
	// 找出資料庫排行榜前5大銷售
	public List<Book> findTop5ByOrderBySalesDesc();
	
//	public Book findBySales(int sales);
	
//	public Book findByStock(int stock);
	
	
	// 更改資料:
	@Transactional
	@Modifying //sql: set_更新目標&內容... where_更新對象欄位
	@Query("update Book b set b.isbn = :newIsbn, b.name = :newName, b.author = :newAuthor, b.price = :newPrice, b.stock = :newStock, b.sales = :newSales, b.category = :newCategory where b.isbn = :newIsbn")
	
	// test端的參數
	public int updateNameByIsbn (@Param("newIsbn") String inputIsbn,
			@Param("newName") String inputName,@Param("newAuthor") String inputAuthor,
			@Param("newPrice") int inputPrice, @Param("newStock") int inputStock,
			@Param("newSales") int inputSales, @Param("newCategory") String inputCategory);

	/*
	 * 更改書庫庫存(stock)
	 */
	@Transactional
	@Modifying 		
	// nativeQuery(True: 直接使用資料庫名稱做修改, false: 用Entity名稱)
	//sql語法: update(數據更新)_DB名_b set_b.(更改目標&內容)... where_b.(更新對象欄位)
	@Query(value = "update book b set b.stock = :newStock where b.ISBN = :newIsbn", nativeQuery = true)	
	
	public int updateStockByIsbn (
								// test端的參數
			@Param("newIsbn") String inputIsbn, 
			@Param("newStock") int inputStock);
	
	
	/*
	 * 更改書庫價格(price)
	 */
	@Transactional
	@Modifying
	@Query(value = "update book b set b.price = :newPrice where b.ISBN = :newIsbn", nativeQuery = true)
	public int updatePriceByIsbn(
			@Param("newIsbn") String inputIsbn, 
			@Param("newPrice") int inputPrice); 

	
	/*
	 * 更改書庫分類(category)
	 */
	@Transactional
	@Modifying
	@Query(value = "update book b set b.category = :newCategory where b.ISBN = :newIsbn", nativeQuery = true)
	public int updateCategoryByIsbn(
			@Param("newIsbn") String inputIsbn, 
			@Param("newCategory") String inputCategory); 






}	

	
		


