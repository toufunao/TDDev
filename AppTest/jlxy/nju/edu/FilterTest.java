package jlxy.nju.edu;

import org.junit.Assert;
import org.junit.Test;


public class FilterTest {
	@Test
	public void testUpperCaseFilter() {
		IFilter upperCaseFilter = new UpperCaseFilter();

		Assert.assertEquals("大写转换器", upperCaseFilter.toString());

		//Assert.assertEquals("ABCD", upperCaseFilter.filter("abcd"));

		IFilter anotherUpperCaseFilter = new UpperCaseFilter();

		Assert.assertEquals(anotherUpperCaseFilter, upperCaseFilter);
	}
	
	@Test
	public void testLowerCaseFilter() {
		IFilter lowerCaseFilter = new LowerCaseFilter();

		Assert.assertEquals("小写转换器", lowerCaseFilter.toString());

		//Assert.assertEquals("abcd", lowerCaseFilter.filter("ABCD"));

		IFilter anotherLowerCaseFilter = new LowerCaseFilter();

		Assert.assertEquals(anotherLowerCaseFilter, lowerCaseFilter);
	}
	
	@Test
	public void testPrefixTrimFilter() {
		IFilter prefixTrimFilter = new PrefixTrimFilter();

		Assert.assertEquals("去除前缀空格转换器", prefixTrimFilter.toString());

		//Assert.assertEquals("ABCD", prefixTrimFilter.filter("  ABCD"));

		IFilter anotherPrefixTrimFilter = new PrefixTrimFilter();

		Assert.assertEquals(anotherPrefixTrimFilter, prefixTrimFilter);
	}

}
