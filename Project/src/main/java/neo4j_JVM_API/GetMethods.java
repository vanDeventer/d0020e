package neo4j_JVM_API;

import java.util.ArrayList;
import java.util.Map;

import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.StatementResult;

import Data.Course;
import Data.Course.CourseLabels;
import Data.CourseDate;
import Data.Credits;
import Data.KC;
import Data.LP;
import neoCommunicator.Neo4jCommunicator;

public class GetMethods {
	
	private final Neo4jCommunicator communicator;
	
	public GetMethods(Neo4jCommunicator communicator){
		this.communicator = communicator;
	}
	
	public String[] getTopics() {
		
		String query = "MATCH (node: Topic) RETURN node";
		
		StatementResult result = this.communicator.readFromNeo(query);
		
		ArrayList<String> resultArray = new ArrayList<String>();
		while ( result.hasNext() ) {
			
			Record row = result.next();
			System.out.println(row.get("node").get("title"));
            resultArray.add(row.get("node").get("title").toString());
        }
		return resultArray.toArray(new String[resultArray.size()]);
	}
	
	
	public boolean login() {
		return false;
	}
	
	public String getUser() {
		return "";
	}
	
	public String getProgram() {
		return "";
	}
	public Course getCourse(String courseCode, CourseDate courseDate) {
		String query = "MATCH (course: Course {courseCode: \"" + courseCode + "\", "+ CourseLabels.YEAR + " : \"" + courseDate.getYear() + "\" , " + CourseLabels.LP + " : \"" + courseDate.getPeriod() + "\" }) RETURN course";
		
		System.out.println(query);
		
		StatementResult result = this.communicator.readFromNeo(query);
		Record row = result.next();
		
		Course course = createCourse(row, "course");
		
		String developedQuery = "MATCH (course: Course {courseCode: \"" + courseCode + "\", "+ CourseLabels.YEAR + " : \"" + courseDate.getYear() + "\" , " + CourseLabels.LP + " : \"" + courseDate.getPeriod() + "\" }) ";
		developedQuery += "MATCH(developedKC : KC)<-[r: DEVELOPED]-(course) RETURN developedKC";
		System.out.println(developedQuery);
		result = this.communicator.readFromNeo(developedQuery);
		
		while(result.hasNext()) {
			course.setDevelopedKC(createKC(result.next(), "developedKC"));
		}
		
		String requiredQuery = "MATCH (course: Course {courseCode: \"" + courseCode + "\", "+ CourseLabels.YEAR + " : \"" + courseDate.getYear() + "\" , " + CourseLabels.LP + " : \"" + courseDate.getPeriod() + "\" }) ";
		requiredQuery += "MATCH(requiredKC : KC)<-[r: DEVELOPED]-(course) RETURN requiredKC";
		System.out.println(requiredQuery);
		result = this.communicator.readFromNeo(requiredQuery);
		
		while(result.hasNext()) {
			course.setRequiredKC(createKC(result.next(), "requiredKC"));
		}
		
		return course;
	}
	
	/**
	 * Help function for creating a KC
	 * 
	 * @param row
	 * @param nodename
	 * @return
	 */
	private KC createKC(Record row, String nodename) {
		
		String generalDescription = row.get(nodename).get("generalDescription").toString();
		String taxonomyDescription = row.get(nodename).get("taxonomyDescription").toString();
		int taxonomyLevel = Integer.parseInt(row.get(nodename).get("taxonomyLevel").toString().replaceAll("\"", ""));
		String name = row.get(nodename).get("name").asString();		
		
		KC kc = new KC(name, generalDescription, taxonomyLevel, taxonomyDescription);
		return kc;
	}
	/**
	 * Help function to createCourse
	 * 
	 * @param row
	 * @return
	 */
	private Course createCourse(Record row, String nodename) {
		
		String name = row.get(nodename).get("name").toString();
		String courseCode = row.get(nodename).get("courseCode").toString();
		String creds = row.get(nodename).get("credit").toString();
		
		creds = creds.replaceAll("\"", "");
		Credits credits = Credits.valueOf(creds);
		
		String description = row.get(nodename).get("description").toString();
		String examiner = row.get(nodename).get("examiner").toString();
		int year = Integer.parseInt(row.get(nodename).get("year").toString().replaceAll("\"", ""));
		LP lp = LP.valueOf(row.get(nodename).get("lp").toString().replaceAll("\"", ""));
		CourseDate startDate = new CourseDate(year, lp);
		
		Course course = new Course(name, courseCode, credits, description, examiner, startDate);
		
		return course;
	
	}
	
	/**
	 * Get KC from neo
	 * 
	 * @param name
	 * @param taxonomyLevel
	 * @return
	 */
	public KC getKCwithTaxonomyLevel(String name, int taxonomyLevel) {
		String query = "MATCH (node: Kc {name: \"" + name + "\", taxonomyLevel: \"" + taxonomyLevel + "\"}) RETURN node";
		
		StatementResult result = this.communicator.readFromNeo(query);
		
		Record row = result.next();

		
		KC kc = createKC(row, "node");
		return kc;
	}
		
	
}
