import Data.Course;
import Data.CourseDate;
import Data.Credits;
import Data.KC;
import Data.LP;
import neo4j_JVM_API.Neo4JAPI;

public class Main {
	
	final static int AMOUNT_OF_COURSE_CREATED = 24;
	final static int AMOUNT_OF_KCS_CREATED = 24;
	static Course[] courses;
	static KC[] kcs;
	
	static Neo4JAPI neoapi;
	
	public static void main(String[] args) {
		
		
		
		// Setup database connection
		neoapi = new Neo4JAPI("bolt://localhost:7687", "neo4j", "admin");
		
		createCourses();
		createTopics();
		createKCs();
		
		createDevelopedRelations();
		
		
		
	}
	
	public static void print(String s ) {
		System.out.println(s);
	}
	
	public static void createCourses() {
		// -------- CREATE COURSES ------------ //
		// Genereate courses for writing to DB
		courses = new Course[AMOUNT_OF_COURSE_CREATED];
		
		int year = 2017;
		int lpcounter = 0;
		LP lp = LP.ONE;
		for(int i = 0; i < AMOUNT_OF_COURSE_CREATED; i++) {
			if(i % 8 == 0) {
				year ++;
			}
			CourseDate cd = new CourseDate(year, lp);
			courses[i] = new Course("CourseNameNum " + i, "D000" + i + "E", Credits.SEVEN, "DESCRIPTION FOR COURSE" + i, "HÅKAN J", cd);
			
			lpcounter ++;
			if(lpcounter % 2 == 0) {
				if(lp == LP.ONE) {
					lp = LP.TWO;
				} else if(lp == LP.TWO) {
					lp = LP.THREE;
				} else if (lp == LP.THREE) {
					lp = LP.FOUR;
				} else if(lp == LP.FOUR) {
					lp = LP.ONE;
				}
			}
		}
		
		for(Course c : courses) {
			neoapi.createMethods.createCourse(c);
		}
		print(AMOUNT_OF_COURSE_CREATED + " should have been created");
		// ------- CREATE COURSE COMPLETE -------- //
		
	}
	public static void createTopics() {
		// ------- CREATE TOPICS --------- // 
		
		neoapi.createMethods.addTopic("MATH");
		neoapi.createMethods.addTopic("PHYSICS");
		neoapi.createMethods.addTopic("COMPUTER_SCIENCE");
		neoapi.createMethods.addTopic("ECONOMY");
		neoapi.createMethods.addTopic("SPORT");
		
		print("5 topics created ");
		// ----- CREATE TOPICS COMPLETE --- //
	}
	public static void createKCs() {
		// ------ CREATE KCs ---------- //
		
		
		kcs = new KC[AMOUNT_OF_KCS_CREATED * 3];
		
		for(int i = 0; i < AMOUNT_OF_KCS_CREATED; i += 3) {
			kcs[i] = new KC("KC num " + i, "GENERAL DESC"+ i,1, "TAXONOMY DESC" + i);
			kcs[i+1] = new KC("KC num " + i+1, "GENERAL DESC"+ i+1, 2, "TAXONOMY DESC" + i+1);
			kcs[i+2] = new KC("KC num " + i+1, "GENERAL DESC"+ i+2, 3, "TAXONOMY DESC" + i+2);
		}
		
		for(KC kc: kcs) {
			neoapi.createMethods.createKC(kc);
		}
	}
	
	public static void createDevelopedRelations() {
		
		for(Course course: courses) {
			neoapi.createMethods
		}
		
	}
	

}
