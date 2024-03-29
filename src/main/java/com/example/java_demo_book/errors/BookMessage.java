package com.example.java_demo_book.errors;

public enum BookMessage {

	// 狀態: 成功為200, 以外的數字皆為錯誤
		SUCCESSFUL("200", "Successful!!!"), 
		CANNOT_EMPTY("403", "Account or password is empty!!"),
		DATALIST_ERROR("404", "DATALIST_ERROR: Can't find the Data!!"),
		STRING_ERROR("401", "STRING_ERROR: Don't have any word!"),
		INSERT_ERROR("404", "INSERT_ERROR: Can't find the book!"),
		DATA_ERROR("400", "Account or password is error!!"),
		ERROR_BOOK_DATA("403_1", "Input the complete data!"),
		BOOK_SALES_ERROR("405", "Book Data is error!!"),
		NOT_UPDATEDATA("404", "Input the complete update data!"), 
		TEST_ERROR("405", "Test Error!"),
		NOT_FOUND("404", "Not found!!");
		
		
		private String code;
		
		private String message;
		
		

		private BookMessage(String code, String message) {
			this.code = code;
			this.message = message;
		}
		
		public String getCode() {
			return code;
		}
		
		public void setCode(String code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}



}
