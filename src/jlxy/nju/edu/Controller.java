package jlxy.nju.edu;

import java.util.ArrayList;
import java.util.Iterator;

public class Controller implements IController{

	private IFilter[] availableFilters;
	private ArrayList<IFilter> filterChain=new ArrayList();
	private IView view;
	
	public Controller(IFilter[] initFilters) {
		availableFilters = initFilters;
	}

	public IFilter[] getAvailableFilters() {
		return availableFilters;
	}

	public void setView(IView view) {
		this.view = view;
		this.view.updateAvailableFilters(availableFilters);
	}
	
	@Override
	public void addAvailFilterToFilterChain(IFilter filter) {
		if (!filterChain.contains(filter)) {
			filterChain.add(filter);
			this.view.updateFilterChain(filterChain);
		}
	}
	
	@Override
	public void removeFilterFromFilterChain(IFilter filter) {
		filterChain.remove(filter);
		this.view.updateFilterChain(filterChain);
	}

	@Override
	public void apply(String inputText) {

		String output = "";

		for (Iterator<IFilter> iterator = filterChain.iterator(); iterator
				.hasNext();) {
			IFilter filter = iterator.next();
			inputText = filter.filter(inputText);
		}

		output = inputText;

		this.view.updateOutput(output);
	}






}
