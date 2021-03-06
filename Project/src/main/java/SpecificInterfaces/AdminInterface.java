package SpecificInterfaces;

import Data.CourseProgram;
import Data.KC;
import Data.User;
import neo4j_JVM_API.Neo4JAPI;

public class AdminInterface extends TeacherInterface {

    /**
     * Constructor
     *
     */
    public AdminInterface(Data.User user) {
        super(user);
    }

    public boolean addProgram(CourseProgram data){
        try {
            neoapi.createMethods.createProgram(data);
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean addKC(KC data){
        try {
            neoapi.createMethods.createKC(data);
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    @Deprecated
    public boolean addProgramSpecialization(){

        try {
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    /**
     * Modify Knowelage component
     * @param newdata New Data
     * @return
     */
    public boolean modifyKC(KC newdata){
        try {
            //neoapi.modifyMethodseditKC(newdata);
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
