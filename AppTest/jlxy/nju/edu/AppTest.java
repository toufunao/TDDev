package jlxy.nju.edu;

import java.io.IOException;
import java.util.List;

import org.jdom.JDOMException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

public class AppTest {
	
	
	//private String[] initFilters = new String[] { "UPPERCASE_FILTER",
		//	"LOWERCASE_FILTER", "TRIM_PREFIX_FILTER" };

	IFilter upper=new UpperCaseFilter();
	IFilter lower=new LowerCaseFilter();
	IFilter pre=new PrefixTrimFilter();
	IFilter[] ifilters=new IFilter[]{upper,lower,pre};
	private IFilter[] initFilters = new IFilter[] { upper,lower,pre };
	
	private App app;

	@Before
	public void setUp() throws SAXException, IOException, JDOMException {
		
		app = new App(ifilters);
	}
	
	
	@Test
	public void testAppInitByController() throws SAXException, IOException, JDOMException {
		setUp();
		Controller controller = app.getController();
		IFilter[] availableFilters = controller.getAvailableFilters();
		for (int i = 0; i < initFilters.length; i++) {
			Assert.assertEquals(initFilters[i], availableFilters[i]);
		}
	}
	
	@Test
	public void testAppInitByMockView() throws SAXException, IOException, JDOMException {
		setUp();
		MockView mockView = app.getView();
		IFilter[] availableFilters = mockView.getAvailableFilters();
		for (int i = 0; i < initFilters.length; i++) {
			Assert.assertEquals(initFilters[i], availableFilters[i]);
		}
	}
	
	@Test
	public void testAddAvailableFilterToFilterChain() throws SAXException, IOException, JDOMException {
		setUp();
		MockView view = app.getView();

		// ��ӡ�����ת����������ת����������
		view.addAvailFilterToFilterChain(ifilters[0]);

		// ��֤������ת�����б��еġ�ת������û�б仯
		IFilter[] availableFilters = view.getAvailableFilters();
		Assert.assertEquals(3, availableFilters.length);
		for (int i = 0; i < availableFilters.length; i++) {
			Assert.assertEquals(initFilters[i], availableFilters[i]);
		}

		// ��֤�û�����ӵġ�ת�������Ѿ����뵽��ת����������
		List<IFilter> filterChain = view.getFilterChain();
		Assert.assertEquals(1, filterChain.size());
		Assert.assertEquals(initFilters[0], filterChain.get(0));

		// �ظ������ͬ�ġ�ת������
		view.addAvailFilterToFilterChain(initFilters[0]);

		// ��֤������ת�����б��еġ�ת������û�б仯
		availableFilters = view.getAvailableFilters();
		Assert.assertEquals(3, availableFilters.length);
		for (int i = 0; i < availableFilters.length; i++) {
			Assert.assertEquals(initFilters[i], availableFilters[i]);
		}

		// ��֤��ת������������Ȼֻ��һ��ת�������ظ���ӡ�ת��������Ч
		filterChain = view.getFilterChain();
		Assert.assertEquals(1, filterChain.size());
		Assert.assertEquals(initFilters[0], filterChain.get(0));

		// �������һ����ת������
		view.addAvailFilterToFilterChain(initFilters[1]);

		// ��֤������ת�����б��еġ�ת������û�б仯
		availableFilters = view.getAvailableFilters();
		Assert.assertEquals(3, availableFilters.length);
		for (int i = 0; i < availableFilters.length; i++) {
			Assert.assertEquals(initFilters[i], availableFilters[i]);
		}

		// ��֤�û�����ӵġ�ת�������Ѿ����뵽��ת���������У�������ӵ�˳���Ǵ�ͷ׷�ӵ�β��
		filterChain = view.getFilterChain();
		Assert.assertEquals(2, filterChain.size());
		Assert.assertEquals(initFilters[0], filterChain.get(0));
		Assert.assertEquals(initFilters[1], filterChain.get(1));
	}

	
	@Test
	public void testRemoveFilterFromFilterChain() throws SAXException, IOException, JDOMException {
		setUp();
		MockView view = app.getView();

		// �Ƚ���ת��������ӵ���ת����������
		view.addAvailFilterToFilterChain(initFilters[0]);

		// ��֤�û�����ӵġ�ת�������Ѿ����뵽��ת����������
		List<IFilter> filterChain = view.getFilterChain();
		Assert.assertEquals(1, filterChain.size());
		Assert.assertEquals(initFilters[0], filterChain.get(0));

		// ����ת�������ӡ�ת����������ȥ��
		view.removeFilterFromFilterChain(initFilters[0]);

		// ��֤��ת�����������ޡ�ת������
		filterChain = view.getFilterChain();
		Assert.assertEquals(0, filterChain.size());
	}

	@Test
	public void testApplyFilterChain() throws SAXException, IOException, JDOMException {
		setUp();
		MockView view = app.getView();

		// �����ַ���"this is test text."
		view.input("this is test text.");

		// ���Сдת����д�ġ�ת������
		view.addAvailFilterToFilterChain(initFilters[0]);

		// Ӧ��ת���߼�
		view.apply();

		// ��ȡ����ַ���
		String output = view.getOutput();

		// ��֤Сд�Ѿ�ת��Ϊ��д
		Assert.assertEquals("THIS IS TEST TEXT.", output);
	}

	@Test
	public void testApplyFilterChain_2() {
		MockView view = app.getView();

		// �����ַ���"this is test text."
		view.input("this is test text.");

		// ���Сдת����д�ġ�ת������
		view.addAvailFilterToFilterChain(initFilters[0]);

		// ��Ӵ�дת��Сд�ġ�ת������
		view.addAvailFilterToFilterChain(initFilters[1]);

		// Ӧ��ת���߼�
		view.apply();

		// ��ȡ����ַ���
		String output = view.getOutput();

		// ��֤Сд�Ѿ�ת��Ϊ��д
		Assert.assertEquals("this is test text.", output);
	}


}
