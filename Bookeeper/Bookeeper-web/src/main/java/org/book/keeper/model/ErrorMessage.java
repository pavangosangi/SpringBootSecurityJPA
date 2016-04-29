package org.book.keeper.model;

import java.io.Serializable;

public class ErrorMessage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String errorMsg;

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
