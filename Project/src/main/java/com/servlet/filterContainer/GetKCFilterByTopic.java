package com.servlet.filterContainer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neoCommunicator.Neo4jConfigLoader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Data.KC;
import Data.KC.KCLabel;
import neo4j_JVM_API.Neo4JAPI;

/**
 * Find all kc's by topic from request
 */
@WebServlet("/GetKCs/FilterByTopic")
public class GetKCFilterByTopic extends HttpServlet {

	private static final long serialVersionUID = 1L;


	/**
	 * Send JSON array with all matching kc when searching for kc by topic
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		KC[] kcs = Neo4jConfigLoader.getApi().filterMethods.filterKCByTopic(request.getParameter("filter"));
		
		ArrayList<String> namesToSend = new ArrayList<String>();
		try {
			JSONArray array = new JSONArray();
			for (KC kc : kcs) {
				if(!namesToSend.contains(kc.getName())) {
					namesToSend.add(kc.getName());
					JSONObject obj = new JSONObject();
				    obj.put(KCLabel.NAME.toString(), kc.getName());
				    obj.put(KCLabel.TAXONOMYLEVEL.toString(), kc.getTaxonomyLevel());
				    obj.put(KCLabel.TAXONOMY_DESCRIPTION.toString(), kc.getTaxonomyDescription());
				    obj.put(KCLabel.GENERAL_DESCRIPTION.toString(), kc.getGeneralDescription());
				    array.put(obj);
				}
			    
			}
			response.setContentType("text/json");
			response.getWriter().write(array.toString());
		} catch (JSONException exception) {}
		
	}
	
}
