import java.io.IOException;
import java.util.ArrayList;

import Data.*;
import neo4j_JVM_API.Neo4JAPI;
import neoCommunicator.Neo4jConfigLoader;
import org.json.JSONException;

public class Main {

    final static int AMOUNT_OF_COURSE_CREATED = 24;
    final static int AMOUNT_OF_KCS_CREATED = 24;
    static Course[] courses;
    static KC[] kcs;
    static String[] topics = {"MATH", "PHYSICS", "COMPUTER_SCIENCE", "ECONOMY", "SPACE", "MATH_SOMETHING"};
    static CourseProgram courseOrder;
    static Neo4JAPI neoapi;

    public static void main(String[] args) throws IOException { 
    	
    	/*
    	User admin = new User("admin", "password");
    	admin.hashPassword();
    	admin.setAdmintag(true);
    	
    	Neo4jConfigLoader.getApi().userMethods.addUser(admin);*/
    	
    	
    	Neo4jConfigLoader.getApi().createMethods.createCourse(new Course(new CourseInformation("Introduktion Till Programmering","D0009E",(float) 7.5, "This is the Desc", "Bengtsson", new CourseDate(2017,LP.ONE))));
    	Neo4jConfigLoader.getApi().createMethods.createCourse(new Course(new CourseInformation("Datateknik och Ingenjörsvetenskap","D0015E",(float) 7.5, "This is the Desc", "Håkan Jonsson", new CourseDate(2017,LP.ONE))));
    	Neo4jConfigLoader.getApi().createMethods.createCourse(new Course(new CourseInformation("Fysik 1","F0004T",(float) 7.5, "This is the Desc", "Gustavsson", new CourseDate(2017,LP.TWO))));
    	Neo4jConfigLoader.getApi().createMethods.createCourse(new Course(new CourseInformation("Diskret matematik", "M0009E",(float) 7.5, "This is the Desc", "Stefan Ericsson", new CourseDate(2017,LP.TWO))));
    	  
    	Neo4jConfigLoader.getApi().createMethods.createCourse(new Course(new CourseInformation("Objektorienterad programmering och design","D0010E",(float) 7.5, "This is the Desc", "Håkan Jonsson", new CourseDate(2018,LP.THREE))));
    	Neo4jConfigLoader.getApi().createMethods.createCourse(new Course(new CourseInformation("Grundkurs i projekt- och industriell ekonomi","R0005N",(float) 7.5, "This is the Desc", "Posten Anders", new CourseDate(2018,LP.THREE))));
    	Neo4jConfigLoader.getApi().createMethods.createCourse(new Course(new CourseInformation("Digitalteknik","D0011E",(float) 7.5, "This is the Desc", "Ulf Bodin", new CourseDate(2018,LP.FOUR))));
    	Neo4jConfigLoader.getApi().createMethods.createCourse(new Course(new CourseInformation("Matematik 1 - Differentialkalkyl","M0038M",(float) 7.5, "This is the Desc", "Ove Edlund", new CourseDate(2018,LP.FOUR))));
    	  
    	Neo4jConfigLoader.getApi().createMethods.createCourse(new Course(new CourseInformation("Mikrodatorteknik","D0013E",(float) 7.5, "This is the Desc", "Per Lindgren", new CourseDate(2018,LP.ONE))));
    	Neo4jConfigLoader.getApi().createMethods.createCourse(new Course(new CourseInformation("Nätverksprogrammering","D0036D",(float) 7.5, "This is the Desc", "Typ Ulf", new CourseDate(2018,LP.ONE))));
    	Neo4jConfigLoader.getApi().createMethods.createCourse(new Course(new CourseInformation("Algoritmer och datastrukturer","D0012E",(float) 7.5, "This is the Desc", "Jingsen Chen", new CourseDate(2018,LP.TWO))));
    	Neo4jConfigLoader.getApi().createMethods.createCourse(new Course(new CourseInformation("Matematik 2 - Integralkalkyl och linjär algebra", "M0043M",(float) 7.5, "This is the Desc", "Ove Edlund", new CourseDate(2018,LP.TWO))));
    	  
    	Neo4jConfigLoader.getApi().createMethods.createCourse(new Course(new CourseInformation("Realtidssystem","D0003E",(float) 7.5, "This is the Desc", "Bengtsson", new CourseDate(2019,LP.THREE))));
    	Neo4jConfigLoader.getApi().createMethods.createCourse(new Course(new CourseInformation("Matematik 3 - Differentialekvationer, komplexa tal och transformteori","M0039M",(float) 7.5, "This is the Desc", "Ove Edlund", new CourseDate(2019,LP.THREE))));
    	Neo4jConfigLoader.getApi().createMethods.createCourse(new Course(new CourseInformation("Datorkommunikation","D0002E",(float) 7.5, "This is the Desc", "Evgeny Osipov", new CourseDate(2019,LP.FOUR))));
    	
    	  
    	//Neo4jConfigLoader.getApi().createMethods.createCourse(new Course(new CourseInformation("Mikrodatorteknik","D0013E",(float) 7.5, "This is the Desc", "Per Lindgren", new CourseDate(2019,LP.ONE))));
    	//Neo4jConfigLoader.getApi().createMethods.createCourse(new Course(new CourseInformation("Nätverksprogrammering","D0036D",(float) 7.5, "This is the Desc", "Typ Ulf", new CourseDate(2019,LP.ONE))));
    	Neo4jConfigLoader.getApi().createMethods.createCourse(new Course(new CourseInformation("Databasteknik","D0018E",(float) 7.5, "This is the Desc", "Olof Schelen", new CourseDate(2019,LP.TWO))));
    	Neo4jConfigLoader.getApi().createMethods.createCourse(new Course(new CourseInformation("Projekt i datateknik", "D0020E",(float) 15, "This is the Desc", "Ulf Bodin", new CourseDate(2019,LP.TWO))));
    	  
    	Neo4jConfigLoader.getApi().createMethods.createCourse(new Course(new CourseInformation("Nätverk och Mobilitet","D0021E",(float) 7.5, "This is the Desc", "Christer Åhlund", new CourseDate(2020,LP.THREE))));
    	Neo4jConfigLoader.getApi().createMethods.createCourse(new Course(new CourseInformation("Examensarbete i datateknik","X0001E",(float) 15, "This is the Desc", "Josef Hallberg", new CourseDate(2020,LP.FOUR))));
    	

    }
}
        /*Course test = new Course("hello", "ddddd", 7.5f, "hello there cowboy", "man", new CourseDate(102, LP.ONE));
        test.setRequiredKC(new KC("wow", "wowowo", 2, "no"));
        test.setRequiredKC(new KC("2323", "wowo33wo", 25, "n2o"));
        test.setDevelopedKC(new KC("wow", "wowowo", 3, "yes"));

        try {
            System.out.println(test.getAsJson());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        neoapi = Neo4jConfigLoader.getApi();


        // Setup database connection
        //neoapi = new Neo4JAPI("");

        //neoapi.createMethods.clear(); <-- I moved this to Deletemethods. Greetings from Robin the code cop.
        //createCourses();
        //createTopics();
        //createKCs();

        //createRelationsBetweenCoursesAndKCs();






        readCourses();

        readKCs();
        readTopics();
        addTopicsToCourses();
        addTopicsToKCs();
        //createCourseProgram("courseprgroma 1", "TIDAG");
        filterTest();
        courseOrder = new CourseProgram(new ArrayList<Course>());
        Course temp = new Course(new CourseInformation("test","xxxx",-1,"test","test",new CourseDate(1207,LP.ONE)));
		KC t;
		t = new KC("Test 1","test desc",1,"wow");
        temp.setDevelopedKC(t);
        neoapi.createMethods.createKC(t);
        t = new KC("Test 2","test desc",1,"wow");
        temp.setDevelopedKC(t);
        neoapi.createMethods.createKC(t);

        t = new KC("Test 3","test desc",1,"wow");
        temp.setDevelopedKC(t);
        neoapi.createMethods.createKC(t);

        t = new KC("Test 4","test desc",1,"wow");
        temp.setDevelopedKC(t);
        neoapi.createMethods.createKC(t);

        neoapi.createMethods.createCourse(temp);
        neoapi.createMethods.createCourseKCrelation(temp);

        courseOrder.setCode("xyxy");
        courseOrder.setCredits(30);
        courseOrder.setDescription("test");
        courseOrder.setName("test");
        courseOrder.setStartDate(new CourseDate(1111,LP.ONE));
        courseOrder.setProgramType(CourseProgram.ProgramType.PROGRAM);
        //neoapi.createMethods.createProgram(courseOrder);
		neoapi.createMethods.createProgramCourseRelation(courseOrder, temp);
		CourseProgram data = neoapi.getMethods.getProgram(courseOrder.getCode(),courseOrder.getStartDate());
        try {
            System.out.println(data.getAsJson());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //System.in.read();


    }

    public static void print(String s) {
        System.out.println(s);
    }

    public static void createCourses() {
        // -------- CREATE COURSES ------------ //
        // Genereate courses for writing to DB
        courses = new Course[AMOUNT_OF_COURSE_CREATED];

        int year = 2017;
        int lpcounter = 0;
        LP lp = LP.ONE;
        for (int i = 0; i < AMOUNT_OF_COURSE_CREATED; i++) {
            if (i % 8 == 0) {
                year++;
            }
            CourseDate cd = new CourseDate(year, lp);
            courses[i] = new Course("CourseNameNum " + i, "D000" + i + "E", 7.5f, "DESCRIPTION FOR COURSE" + i, "HÅKAN J", cd);

            lpcounter++;
            if (lpcounter % 2 == 0) {
                if (lp == LP.ONE) {
                    lp = LP.TWO;
                } else if (lp == LP.TWO) {
                    lp = LP.THREE;
                } else if (lp == LP.THREE) {
                    lp = LP.FOUR;
                } else if (lp == LP.FOUR) {
                    lp = LP.ONE;
                }
            }
        }

        for (Course c : courses) {
            neoapi.createMethods.createCourse(c);
        }
        print(AMOUNT_OF_COURSE_CREATED + " courses should have been created");
        // ------- CREATE COURSE COMPLETE -------- //

    }

    public static void createTopics() {
        // ------- CREATE TOPICS --------- //

        for (String topic : topics) {
            neoapi.createMethods.addTopic(topic);
        }

        print(topics.length + " topics created ");
        // ----- CREATE TOPICS COMPLETE --- //
    }

    public static void createKCs() {
        // ------ CREATE KCs ---------- //


        kcs = new KC[AMOUNT_OF_KCS_CREATED * 3];

        for (int i = 0; i < AMOUNT_OF_KCS_CREATED; i += 3) {
            kcs[i] = new KC("KC num " + i, "GENERAL DESC" + i, 1, "TAXONOMY DESC" + i);
            kcs[i + 1] = new KC("KC num " + i, "GENERAL DESC" + i, 2, "TAXONOMY DESC" + i + 1);
            kcs[i + 2] = new KC("KC num " + i, "GENERAL DESC" + i, 3, "TAXONOMY DESC" + i + 2);
        }

        for (KC kc : kcs) {
            if (kc != null) {
                neoapi.createMethods.createKC(kc);
            }
        }
        print("kcs created");
    }

    public static void createRelationsBetweenCoursesAndKCs() {
        print("starting creating relations");
        boolean toggle = true;
        for (KC kc : kcs) {
            if (kc != null) {
                for (Course course : courses) {
                    if (toggle) {
                        toggle = !toggle;
                        course.setDevelopedKC(kc);
                    } else {
                        toggle = !toggle;
                        course.setRequiredKC(kc);
                    }

                }
            }

        }
        for (Course course : courses) {

            neoapi.createMethods.createCourseKCrelation(course);
        }

        print("created A lot of relations between courses and kcs");

    }

    public static void addTopicsToCourses() {

        int i = 0;
        for (Course course : courses) {
            //neoapi.createMethods.addTopicToCourse(course, topics[i%topics.length]);
            i++;
        }

    }

    public static void addTopicsToKCs() {

        int i = 0;
        for (KC kc : kcs) {
            //neoapi.createMethods.addTopicToKC(kc, topics[i%topics.length]);
            i++;
        }

    }

    public static void createCourseProgram(String name, String code) {
        ArrayList<Course> co = new ArrayList<>();
        int x = 0;
        int y = 0;
        int count = 0;
        for (Course course : courses) {
            co.add(course);
        }


        CourseDate courseDate = new CourseDate(2018, LP.ONE);

        CourseProgram courseProgram = new CourseProgram(co);
        courseProgram.setStartDate(courseDate);
        courseProgram.setCode(code);
        courseProgram.setName(name);
        courseProgram.setDescription("descrtiption for course" + name);
        courseProgram.setCredits(-1);

        neoapi.createMethods.createProgram(courseProgram);
        neoapi.createMethods.createProgramCourseRelations(courseProgram);
        print("A program named " + name + "is created");

    }

    private static void printCourse(Course course) {

        print("--Print course--");
        print("name :" + course.getName());
        print("courseCode :" + course.getCourseCode());
        print("LP : " + course.getStartPeriod().getPeriod());
        print("year : " + course.getStartPeriod().getYear());
        print("description : " + course.getDescription());
        print("examiner :" + course.getExaminer());
        print("credits :" + course.getCredit());
        print("**********************************");
    }

    private static void printKCs(ArrayList<KC> kc_s) {
        for (KC kc : kc_s) {
            printKC(kc);
        }
    }

    private static void printKC(KC kc) {
        print("name :" + kc.getName());
        print("general desc :" + kc.getGeneralDescription());
        print("taxonomy desc : " + kc.getTaxonomyDescription());
        print("taxonomy level : " + kc.getTaxonomyLevel());
        print("************");
    }

    public static void readCourses() {

        CourseInformation[] temp = neoapi.filterMethods.filterCourseByTag(Course.CourseLabels.NAME, "");
        courses = new Course[temp.length];
        for (int i = 0; i < temp.length; i++) {
            courses[i] = neoapi.getMethods.getCourse(temp[i].getCourseCode(), temp[i].getStartPeriod());
        }

			/*printCourse(c);
			print("Developed KCs");
			printKCs(c.getDevelopedKC());
			print("Required KCs");
			printKCs(c.getRequiredKC());*//*

    }

    public static void readKCs() {
        kcs = neoapi.filterMethods.filterKCByTag(KC.KCLabel.NAME, "");
    }

    public static void readTopics() {
        String[] titles = neoapi.getMethods.getTopics();
        print("-- Topics in Neo --");
        for (String t : titles) {
            print(t);
        }
        print("*************");
    }

    public static void filterTest() {
        String[] res = neoapi.filterMethods.filterCourseByCode("D0001");
        print("filter course returned  : " + res.length);


        res = neoapi.filterMethods.filterCourseByName("Cour");
        print("filter course returned  : " + res.length);

        res = neoapi.filterMethods.filterProgramByCode("TID");
        print("filter programs returned  : " + res.length);


        res = neoapi.filterMethods.filterProgramByName("cour");
        print("filer programs returned : " + res.length);

        res = neoapi.filterMethods.filterTopic("MAT");
        print("filer topic returned : " + res.length);

    }

    public static void deleteCourses() {
        for (Course course : courses) {
            neoapi.modifyMethods.removeCourse(course.getCourseCode(), course.getStartPeriod());
        }
        print("courses deleted");

    }

    public static void deleteKCs() {
        for (KC kc : kcs) {
            if (kc != null) {
                neoapi.modifyMethods.removeKC(kc.getName(), kc.getTaxonomyLevel());
            }
        }
        print("kcs deleted");
    }

    public static void editKC(KC[] kcs) {


        for (KC kc : kcs) {

            String temp = kc.getName();
            //kc.setDescription(kc.getDescription()+"newDescription");
            kc.setName(kc.getName() + "newName");
            neoapi.modifyMethods.editKCName(kc, temp);

            neoapi.modifyMethods.editKCDescription(kc);

        }
        print("kcs edited");


    }

}*/
