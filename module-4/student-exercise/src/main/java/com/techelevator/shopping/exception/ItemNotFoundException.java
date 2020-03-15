package com.techelevator.shopping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6974644855556556894L;

	private int itemId;

	public ItemNotFoundException(int id, String message) {
		super(message);
		setItemId(id);
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

}
