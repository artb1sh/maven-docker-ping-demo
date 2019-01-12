# define resource
ContextResource resource = new ContextResource();

Name comming better from system env or propeties with defualt...

resource.setName("jdbc/db");
resource.setAuth("Container");
resource.setType("javax.sql.DataSource");
resource.setScope("Sharable");
resource.setProperty("driverClassName",
        "org.hsqldb.jdbc.JDBCDriver");
resource.setProperty("url", "jdbc:hsqldb:hsql://localhost:1234/mydb1");

#tomcat.getServer().getGlobalNamingResources().addResource(resource);
# the mus link

 
# better add resource diretly to context 
Context rootCtx = tomcat.addContext("", base.getAbsolutePath());
rootCtx.getNamingResources().addResource(resource);
 
# find better parameter...
 
# usage
 
 
 Connection conn = null;
    try {
        Context initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:/comp/env");
        DataSource ds = (DataSource) envContext.lookup("jdbc/db");

        conn = ds.getConnection();
        conn.createStatement()....
    } catch (Exception e) {
        e.printStackTrace();
    }

# add mysql lib to your lib


# get parameter from env link?

docker line? --link MYDB:MYDB

TCP
PORT
NAME


http://blog.rasc.ch/?p=1144

mysql:

ContextResource res = new ContextResource();
        res.setName("jdbc/mydb");
        res.setType("javax.sql.DataSource");
        res.setAuth("Container");
 
        res.setProperty("username", "dbuser");
        res.setProperty("password", "dbpassword");
        res.setProperty("driverClassName", "com.mysql.jdbc.Driver");
 
        res.setProperty("url", "jdbc:mysql://localhost:3306/mydb?characterEncoding=UTF-8");
        res.setProperty("maxActive", "10");
        res.setProperty("maxIdle", "3");
        res.setProperty("maxWait", "10000");
        res.setProperty("defaultAutoCommit", "false");
 
        ctx.getNamingResources().addResource(res);
 
 # other config parameter !!
 Verzeichnis parameter:
 
        ContextEnvironment environment = new ContextEnvironment();
        environment.setType("java.lang.String");
        environment.setName("app/exportDir");
        environment.setValue("c:/exportdir");
        ctx.getNamingResources().addEnvironment(environment);
        
        
pom.xml

<dependency>
    <groupId>org.apache.tomcat</groupId>
    <artifactId>tomcat-dbcp</artifactId>
    <version>8.0.9</version>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.15</version>
</dependency> 

---

# default servlet konfig
Woher kommen resourcen?
aus den Jar's aber wie werden dieses gesanned?

quellen
srv/main/resources/META-INF/resources/
Da kommt alles rein was die Anwenundg an statischen dateien hat.
Mann kann auch weiter jar mit statischen resourcen haben -> disjunkter content
#webapp einbinden

public class WebApp {
    public static void main(String[] args) throws LifecycleException, ServletException {        
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.setBaseDir(".");
        tomcat.addWebapp("/test", "webapp");                
        tomcat.start();
        tomcat.getServer().await();
    }
}

    