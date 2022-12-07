package com;

public class ToDo {
	private int id;
	private String description;
	
	public ToDo(int id, String description) {
		this.setId(id);
		this.setDescription(description);
	}
	
	public ToDo(String description) {
		this.setDescription(description);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "id = " + id + "  description = " + description;
	}
}
