package model;

import java.util.List;

public class NestedTestWrapper {
  private List<NestedTest>tests;
  
  public NestedTestWrapper() {
  }
  
  public NestedTestWrapper(List<NestedTest> tests) {
	this.tests = tests;
  }
  
  public List<NestedTest> getTests() {
	return tests;
  }
  
  public void setTests(List<NestedTest> tests) {
	this.tests = tests;
  }
}
