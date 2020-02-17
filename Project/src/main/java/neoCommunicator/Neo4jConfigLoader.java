package neoCommunicator;

import neo4j_JVM_API.Neo4JAPI;

import java.io.*;

import java.util.Properties;

/**
 * Load Configurations to communicate to Database
 * @author Johan RH
 */
public class Neo4jConfigLoader {
    private static String CONF_PATH = "db.properties";
    private static config CONF = null;
    private static Neo4JAPI API;
    /**
     * Init New API, will load every time API does not hold and API, Object retaining API should not allow sharing of said api
     * @return
     * @throws IOException
     */
    public static Neo4JAPI getApi() throws IOException {
        config c = loadConfig();
        if(API == null) {
            API = new Neo4JAPI(new Neo4jCommunicator(c.getBOLTURL(),c.getUSERNAME(),c.getPWD()));
        }
        return API;
    }

    /**
     * Load config from disk if it is not already loaded.
     * @return
     * @throws IOException
     */
    private static config loadConfig() throws IOException {
        if(CONF!=null)
            return CONF;

        String uname;
        String pwd;
        String url;

        InputStream inputStream = null;
        try {

            File f = new File(System.getProperty("user.dir"));
            File[] matchingFiles = f.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.startsWith("db") && name.endsWith("properties");
                }
            });
            Properties prop = new Properties();
            inputStream = new FileInputStream(matchingFiles[0]);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + CONF_PATH + "' not found in the classpath");
            }

            // get the property value and print it out
            uname  = prop.getProperty("username").replaceAll("\"","");
            pwd = prop.getProperty("psw").replaceAll("\"","");
            url = prop.getProperty("db_server").replaceAll("\"","");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
            return null;
        } finally {
            inputStream.close();
        }

        config temp = new config(uname,pwd,url);
        return temp;
    }

    /**
     * Struct
     * @author JohanRH
     */
    private static class config{
        private String USERNAME;
        private String PWD;
        private String BOLTURL;

        public config(String USERNAME, String PWD, String BOLTURL) {
            this.USERNAME = USERNAME;
            this.PWD = PWD;
            this.BOLTURL = BOLTURL;
        }

        public String getUSERNAME() {
            return USERNAME;
        }

        public void setUSERNAME(String USERNAME) {
            this.USERNAME = USERNAME;
        }

        public String getPWD() {
            return PWD;
        }

        public void setPWD(String PWD) {
            this.PWD = PWD;
        }

        public String getBOLTURL() {
            return BOLTURL;
        }

        public void setBOLTURL(String BOLTURL) {
            this.BOLTURL = BOLTURL;
        }
    }
}