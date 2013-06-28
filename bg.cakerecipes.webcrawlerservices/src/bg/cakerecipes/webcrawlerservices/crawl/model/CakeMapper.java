package bg.cakerecipes.webcrawlerservices.crawl.model;

import java.util.ArrayList;
import java.util.List;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.parser.HtmlParseData;

/**
 * Class used to extract Cake-related value from the www.gotvismen.com site
 * 
 * @author Leni Kirilov
 * 
 */
public class CakeMapper {

	public static List<Cake> htmlCakes = new ArrayList<Cake>();

	public static void parseCakes(Page page) {
		String cakeXml = findCakeRecipe(page);

		//		System.out.println("cake title= " + );
//		System.out.println("cake imgUrl= " + getImageUrl(cakeXml));
//		System.out.println("cake recipe= " + getCakeRecipe(cakeXml));
//		System.out.println();
		
		Cake cake = new Cake();
		cake.setName(getCakeTitle(cakeXml));
		cake.setImageUrl(getImageUrl(cakeXml));
		cake.setRecipe(getCakeRecipe(cakeXml));
		
		htmlCakes.add(cake);
	}

	private static String findCakeRecipe(Page page) {
		String html = ((HtmlParseData) page.getParseData()).getHtml();
		html = html.substring(16);
		int index = html.indexOf("<div id=\"recipe\"");
		int endIndex = html.indexOf("<div class=\"box_f\">");

		return html.substring(index, endIndex);
	}

	private static String getCakeTitle(String html) {
		String startXml = "<h1 itemprop=\"name\">";
		String endXml = "</h1>";

		return getXmlValue(html, startXml, endXml);
	}

	private static String getImageUrl(String html) {
		String startXml = "a href=\"";
		String endXml = "\" class=\"thumb ";

		return getXmlValue(html, startXml, endXml);
	}

	private static String getXmlValue(String source, String startXml, String endXml) {
		int start = source.indexOf(startXml);
		int end = source.indexOf(endXml, start);

		return source.substring(start + startXml.length(), end);
	}

	private static String getCakeRecipe(String html) {
		String startXml = "<b>Приготвяне:</b><br/>";
		String endXml1 = "</div><div class=\"description\">";
		String endXml2 = "</div><div style=\"clear:both;\">";

		String rawRecipe = null;
		try {
			rawRecipe = getXmlValue(html, startXml, endXml1);
		} catch (Throwable e) {
			rawRecipe = getXmlValue(html, startXml, endXml2);
		}

		rawRecipe = rawRecipe.replaceAll("<br>", "");
		rawRecipe = rawRecipe.replaceAll("</br>", "");
		rawRecipe = rawRecipe.replaceAll("<br/>", "");
		rawRecipe = rawRecipe.replaceAll("• ", "");

		return rawRecipe;
	}
}
