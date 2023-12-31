package com.turingjavaee7.demo.model;

import lombok.Data;

@Data
public class Ingredient {
	private final String id="";
	private final String name="";
	private final Type type = null;

	public enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}
}
