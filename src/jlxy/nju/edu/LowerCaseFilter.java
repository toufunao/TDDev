package jlxy.nju.edu;

import org.jdom.JDOMException;

import java.io.IOException;

public class LowerCaseFilter implements IFilter{
	Internationalize internationalize=new Internationalize();
	private String name = internationalize.item.get("edu.jlxy.stringfilter.LOWERCASEFILTER");


	@Override
	public String filter(String text) {
		return text.toLowerCase();
	}

	@Override
	public String toString(){
		return getName();
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LowerCaseFilter other = (LowerCaseFilter) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
