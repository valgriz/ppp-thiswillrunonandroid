package com.twopercent.main;

import java.io.Serializable;

public class Stat implements Serializable {

	private String id;
	private int value;

	public Stat(String id, int value) {
		this.id = id;
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
