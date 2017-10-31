package assignment3.jdbc.model;

import java.util.ArrayList;

public enum Role {
	owner,
	admin,
	writer,
	editor,
	reviewer;

	@Override
	  public String toString() {
	    switch(this) {
	      case owner: return "owner";
	      case admin: return "admin";
	      case writer: return "writer";
	      case editor: return "editor";
	      case reviewer: return "reviewer";

	      default: throw new IllegalArgumentException();
	    }
	  }
	 

}
