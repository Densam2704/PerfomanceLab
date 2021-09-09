package model;

import java.util.HashMap;

public class Value {
  public int id;
  public String value;
  
  
  public Value() {
  }
  
  public Value(int id, String value) {
	this.id = id;
	this.value = value;
  }
  
  public int getId() {
	return id;
  }
  
  public void setId(int id) {
	this.id = id;
  }
  
  public String getValue() {
	return value;
  }
  
  public void setValue(String value) {
	this.value = value;
  }
  
  @Override
  public String toString() {
	return "id = " + id + "\n" +
			"value = " + value + "\n";
  }
}
