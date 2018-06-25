package com.algorithms.zoren2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 811. Subdomain Visit Count
 * 
 * A website domain like "discuss.leetcode.com" consists of various subdomains.
 * At the top level, we have "com", at the next level, we have "leetcode.com",
 * and at the lowest level, "discuss.leetcode.com". When we visit a domain like
 * "discuss.leetcode.com", we will also visit the parent domains "leetcode.com"
 * and "com" implicitly.
 * 
 * Now, call a "count-paired domain" to be a count (representing the number of
 * visits this domain received), followed by a space, followed by the address.
 * An example of a count-paired domain might be "9001 discuss.leetcode.com".
 * 
 * We are given a list cpdomains of count-paired domains. We would like a list
 * of count-paired domains, (in the same format as the input, and in any order),
 * that explicitly counts the number of visits to each subdomain.
 * 
 * @author Jack Tsang
 */

public class SubdomainVisitCount {

	public List<String> subdomainVisits(String[] cpdomains) {
		Map<String, Integer> domainHash = new HashMap<String, Integer>(); // Contains String, Integer key value pairs 
		List<String> output = new ArrayList<String>();

		for (String domain : cpdomains) {
			String[] cpinfo = domain.split("\\s+"); // Split input by whitespace
			String[] domainName = cpinfo[1].split("\\.");
			int viewCount = Integer.valueOf(cpinfo[0]);
			String siteAccumulator = ""; // Temporary String to build domain name

			for (int i = domainName.length - 1; i >= 0; i--) { // Add subdomain and counts to hashmap, starting at the end for convenience
				siteAccumulator = domainName[i] + (i < domainName.length - 1 ? "." : "") + siteAccumulator;
				domainHash.put(siteAccumulator, domainHash.getOrDefault(siteAccumulator, 0) + viewCount); // getOrDefault gets value if key already exists
			}
		}

		for (String domain : domainHash.keySet())
			output.add("" + domainHash.get(domain) + " " + domain);
		return output;
	}
}
