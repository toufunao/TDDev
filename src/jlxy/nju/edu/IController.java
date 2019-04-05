package jlxy.nju.edu;

public interface IController {

	void setView(IView view);

	void addAvailFilterToFilterChain(IFilter filter);
	
	void removeFilterFromFilterChain(IFilter filter);

	void apply(String inputText);
	
	
}
