package jlxy.nju.edu;

import java.io.IOException;

import org.jdom.JDOMException;
import org.xml.sax.SAXException;

public class App {
	private IController controller;

	private IView view;

	public App(IFilter[] initFilters) throws SAXException, IOException, JDOMException {
		
		controller = new Controller(initFilters);
		view = new ViewSwingImpl(controller);
		controller.setView(view);
		((ViewSwingImpl) view).createView();
	}

	public static void main(String[] args) throws SAXException, IOException, JDOMException {
		IFilter[] initFilters = new IFilter[] { new UpperCaseFilter(),
				new LowerCaseFilter(), new PrefixTrimFilter() };
		new App(initFilters);
	}


	/*public App(IFilter[] initFilters) {
		controller = new Controller(initFilters);
		view = new MockView(controller);
		controller.setView(view);
	}*/

	public Controller getController() {
		return (Controller)controller;
	}

	public MockView getView() {
		return (MockView)view;
	}


}
