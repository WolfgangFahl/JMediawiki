/**
 *
 * This file is part of the https://github.com/WolfgangFahl/Mediawiki-Japi open source project
 *
 * Copyright 2015-2021 BITPlan GmbH https://github.com/BITPlan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 *  You may obtain a copy of the License at
 *
 *  http:www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bitplan.mediawiki.japi;

import static org.junit.Assert.*;

import java.util.logging.Level;

import org.junit.Test;

/**
 * test page Title handling
 * 
 * @author wf
 *
 */
public class TestPageTitle extends APITestbase {

	@Test
	public void testCanonicalPageTitles() throws Exception {
		debug = true;
		for (ExampleWiki lwiki : getWikis()) {
			Mediawiki mw = (Mediawiki) lwiki.wiki;
			SiteInfo siteinfo = mw.getSiteInfo();
			PageInfo pageinfo = new PageInfo("Template:Testtemplate", siteinfo);
			if (debug) {
				LOGGER.log(Level.INFO, String.format("%s: lang: %s\nnamespaceId: %s\namespace: %s\npageTitle: %s\nCanonical PageTitle:%s ", 
						lwiki.wikiId, pageinfo.lang, pageinfo.namespaceId,
						pageinfo.nameSpaceName, pageinfo.pageTitle, pageinfo.canonicalPageTitle));
			}
			assertEquals("en", pageinfo.lang);
			assertEquals(10, pageinfo.namespaceId);
			assertEquals("Template", pageinfo.nameSpaceName);
			assertEquals("Template:Testtemplate", pageinfo.pageTitle);
			assertEquals("Template:Testtemplate", pageinfo.canonicalPageTitle);
		}
	}
}
