package jlxy.nju.edu;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import java.io.IOException;
import java.util.*;

/**
 * @author wurj
 * @time 2019/4/5 11:20
 * @description
 */
public class Internationalize {

    public static Map<String,String> item=new HashMap<>();

    public Internationalize(){
        init();
    }

    public void init(){
       // Locale currentLocale=Locale.getDefault();
        Locale currentLocale=Locale.US;
        //System.out.println(currentLocale);
        SAXBuilder builder=new SAXBuilder();

        Document document= null;
        try {
            document = builder.build(".\\res\\stringfilter-i18n.xml");
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println(document);
        Element rootElement=document.getRootElement();

        Element currentLocaleElement=getLocaleElement(rootElement,currentLocale);
        System.out.println(currentLocaleElement);

        if (currentLocaleElement!=null){
            for (Iterator it=currentLocaleElement.getChildren().iterator();it.hasNext();){
                Element xmlPairsElement= (Element) it.next();
                String key=getAttribute(xmlPairsElement,"label-key");
                System.out.println("key:"+key);
                String value=getAttribute(xmlPairsElement,"label-value");
                System.out.println("value:"+key);

                if (key!=null){
                    item.put(key,value);
                }
            }
        }
    }

    private String getAttribute(Element xmlPairsElement, String s) {
        return xmlPairsElement.getAttribute(s).getValue();
    }

    private Element getLocaleElement(Element rootElement, Locale currentLocale) {
        List<Element> elements=rootElement.getChildren();
     //   System.out.println(currentLocale.getLanguage()+"_"+currentLocale.getCountry());
        for (Element e:elements){
            System.out.println(e.getAttribute("language-country").getValue());
            if (e.getAttribute("language-country").getValue().equals(currentLocale.getLanguage()+"_"+currentLocale.getCountry())){
                System.out.println(e);
                return e;
            }
        }
        return null;
    }
}
