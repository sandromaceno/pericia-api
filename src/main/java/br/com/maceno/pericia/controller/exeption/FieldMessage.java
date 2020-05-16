package br.com.maceno.pericia.controller.exeption;

import java.io.Serializable;

public class FieldMessage implements Serializable {

	private static final long serialVersionUID = 4704176368925589177L;
	
	private String fieldName;
	private String message;
	
	public FieldMessage() {}
	
	public FieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
