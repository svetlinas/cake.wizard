package bg.cakerecipes.webcrawlerservices.crawl;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import bg.cakerecipes.webcrawlerservices.crawl.model.CakeMapper;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;

public class BasicCrawler extends WebCrawler {

	private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|mid|mp2|mp3|mp4|wav|avi|mov|mpeg|ram|m4v|pdf"
	      + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");
	private Set<String> visitedPages = new HashSet<String>();

	/**
	 * You should implement this function to specify whether the given url should
	 * be crawled or not (based on your crawling logic).
	 */
	@Override
	public boolean shouldVisit(WebURL url) {
		String href = url.getURL().toLowerCase();
		if (visitedPages.contains(href)) {
			return false;
		}
		boolean shouldVisit = !FILTERS.matcher(href).matches() && !href.contains("comments")
		      && (href.startsWith("http://www.gotvetesmen.com/recipes/categories/desserts/recipe_"));
		if (shouldVisit) {
			visitedPages.add(href);
			return shouldVisit;
		}
		return shouldVisit;
	}

	/**
	 * This function is called when a page is fetched and ready to be processed
	 * by your program.
	 */
	@Override
	public void visit(Page page) {
		CakeMapper.parseCakes(page);
	}
}