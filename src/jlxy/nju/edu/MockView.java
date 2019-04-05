package jlxy.nju.edu;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

public class MockView implements IView{

	private IFilter[] availableFilters;
	private List<IFilter> filterChain;

	private IController controller;
	
	private String inputText;
	private String outputText;

	public MockView(IController controller) {
		this.controller = controller;
		filterChain = new ArrayList<IFilter>();
	}
	
	public MockView(){
		
	}

	public IFilter[] getAvailableFilters() {
		return availableFilters;
	}

	public void updateAvailableFilters(IFilter[] availableFilters) {
		this.availableFilters = availableFilters;
	}

	public void addAvailFilterToFilterChain(IFilter filter) {
		controller.addAvailFilterToFilterChain(filter);
	}

	public List<IFilter> getFilterChain() {
		return filterChain;
	}
	
	@Override
	public void updateFilterChain(List<IFilter> filterChain) {
		this.filterChain = filterChain;
	}

	public void removeFilterFromFilterChain(IFilter filter) {
		controller.removeFilterFromFilterChain(filter);		
	}

	public void input(String inputText) {
		this.inputText = inputText;
		
	}
	
	@Override
	public void updateOutput(String outputText) {
		this.outputText = outputText;
	}



	public void apply() {
		// TODO Auto-generated method stub
		controller.apply(this.inputText);
	}

	public String getOutput() {
		// TODO Auto-generated method stub
		return outputText;
	}


}
