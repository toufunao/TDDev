package jlxy.nju.edu;

import org.junit.Assert;
import org.junit.Test;


public class FilterTest {
	@Test
	public void testUpperCaseFilter() {
		IFilter upperCaseFilter = new UpperCaseFilter();

		Assert.assertEquals("��дת����", upperCaseFilter.toString());

		//Assert.assertEquals("ABCD", upperCaseFilter.filter("abcd"));

		IFilter anotherUpperCaseFilter = new UpperCaseFilter();

		Assert.assertEquals(anotherUpperCaseFilter, upperCaseFilter);
	}
	
	@Test
	public void testLowerCaseFilter() {
		IFilter lowerCaseFilter = new LowerCaseFilter();

		Assert.assertEquals("Сдת����", lowerCaseFilter.toString());

		//Assert.assertEquals("abcd", lowerCaseFilter.filter("ABCD"));

		IFilter anotherLowerCaseFilter = new LowerCaseFilter();

		Assert.assertEquals(anotherLowerCaseFilter, lowerCaseFilter);
	}
	
	@Test
	public void testPrefixTrimFilter() {
		IFilter prefixTrimFilter = new PrefixTrimFilter();

		Assert.assertEquals("ȥ��ǰ׺�ո�ת����", prefixTrimFilter.toString());

		//Assert.assertEquals("ABCD", prefixTrimFilter.filter("  ABCD"));

		IFilter anotherPrefixTrimFilter = new PrefixTrimFilter();

		Assert.assertEquals(anotherPrefixTrimFilter, prefixTrimFilter);
	}

}
