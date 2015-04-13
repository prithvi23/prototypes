# prototypes
All short prototypes

#CodingExcersiseWebApp
Simple CRUD web services App using the following:
   Java 8
   Maven -for project bootstrapping
   Spring 4 for everything
   Mongo DB - as a repository
   Jongo - The Mongo DB java abstraction layer
   Jackson/Json - All marshall and unmarshall logic
   Jersey - For restful web services
   Junit - For unit testing
   Tomcat8 - Web application server
   
#Tomcat server config
In order to externalize the mongo db parameters, I've used Tomcat parameters and also the app itself is deployed using the context. Simply edit the Tomcat server.xml and add the following entries - make sure that you change the path of the target as per your workstation

```xml
<Context docBase="C:\workspaces\proto\com.sagacstech.interview.prithvi\CodingExcersiseWebApp\target\codingexcerciseweb" 
		logEffectiveWebXml="true" path="/codingexcerciseweb" reloadable="true">
			<Parameter name="db.host" value="localhost"/>
			<Parameter name="db.port" value="27017"/>
			<Parameter name="app.db.name" value="prithvi"/>
		</Context>
```
   
#Junit testing
In order to test this using the Junit follow the steps
In eclipse right click on the Junit Debug As or Run as and choose Debug Configuration / Run Configuration
Choose new 
In the Environment tab add the above environment variables.
