package model;

import com.google.gson.annotations.SerializedName;

import java.beans.Transient;
import java.util.List;

public class NestedTest {
  @SerializedName("id")
  private int id;
  @SerializedName("title")
  private String title;
  @SerializedName("value")
  private String value;
  @SerializedName("values")
  private List<NestedTest> values;
  
  public NestedTest(int id, String title, String value) {
	this.id = id;
	this.title = title;
	this.value = value;
  }
  
  public NestedTest(int id, String title, String value, List<NestedTest> values) {
	this.id = id;
	this.title = title;
	this.value = value;
	this.values = values;
  }
  
  public NestedTest() {
  }
  
  
  @Override
  public String toString() {
	return "{id = " + id + ", " +
			"title = " + title + ", " +
			"value = " + value +
			"}\n";
  }
  
  public int getId() {
	return id;
  }
  
  public void setId(int id) {
	this.id = id;
  }
  
  public String getTitle() {
	return title;
  }
  
  public void setTitle(String title) {
	this.title = title;
  }
  
  public String getValue() {
	return value;
  }
  
  public void setValue(String value) {
	this.value = value;
  }
  
  public List<NestedTest> getValues() {
	return values;
  }
  
  public void setValues(List<NestedTest> values) {
	this.values = values;
  }
}
