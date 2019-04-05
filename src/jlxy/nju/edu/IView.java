package jlxy.nju.edu;

import java.util.List;

public interface IView {
	void updateAvailableFilters(IFilter[] availableFilters);

	void updateFilterChain(List<IFilter> filterChain);
	
	public void updateOutput(String outputText);
}
