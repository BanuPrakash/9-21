# PART 1: Java 9 to 21

```
Banu Prakash C
Full Stack Architect, Corporate Trainer
Co-founder & Ex-CTO: Lucida Technologies Pvt Ltd.,
Email: banuprakashc@yahoo.co.in; banuprakash.cr@gmail.com; 
https://www.linkedin.com/in/banu-prakash-50416019/
https://github.com/BanuPrakash/9-21
```

Softwares Required:

JDK
```
openJDK 21 https://jdk.java.net/java-se-ri/21
Option 1: install and add path vi ~/.zshrc export JAVA_HOME=/Users/banuprakash/Desktop/jdk-21 export PATH="/Users/banuprakash/Desktop/jdk-21/bin:"$PATH
Option 2: [better]
USE SDKMAN to manage java
curl -s "https://get.sdkman.io" | bash
sdk install java 21.0.6-tem
sdk default java 21.0.6-tem

https://mydeveloperplanet.com/2022/04/05/how-to-manage-your-jdks-with-sdkman/#:~:text=Some%20time%20ago%2C%20a%20colleague%20of%20mine,maintain%20different%20versions%20of%20JDKs%2C%20Maven%2C%20etc.
```
IDE
```
IntelliJ Ultimate edition https://www.jetbrains.com/idea/download/?section=mac

```


```
Java 9 (September 2017):
1)	Modules
2)	JShell
3)	Improved try with resource Blocks
4)	Immutable Collection [of]
List<String> strList = List.of("A", "B", "C");
earlier we use Collections.toImmutableCollection(..);

Java 10 (March 2018):
1)	Using var keyword

Java 11 (September 2018):
1)	String API updates
a.	isBlank
String s = " ";
s.isBlank();

b.	lines

String str = """
    Hello World \n
    Good Day \n

""";
c.	stripLeading() and stripTrailing()
d.	repeat()

"*".repeat(10);

2)	isEmpty() on Optional class on top of existing isPresent() 

Java 12 (March 2019):
1)	Defaulting Class Data Sharing [CDS]
2)	Application Data Sharing

    Java 13 (September 2019):
1)	Pattern Matching with instanceof
2)	Better NullPointerException
3)	Text Blocks; multiline text


Java 14 (March 2020):
1)	records
2)	Hidden classes

Java 15: (September 2020): Garbage Collector Updates

Java 16(March 2021) : updates

Java 17 (September 2021):
1)	Sealed classes
2)	Pattern Matching switch statement

Java 18:
1)	Simple Server for the web

Java 19:
1)	Virtual Threads (preview)

Java 21 (September 2023):
1) Improvements for Pattern matching on sealed classes, 
2) virtual threads [stable]

```
Java 5 - Annotation
Java 8 - Stream

Java 9: JPMS -- Java Platform Module System - Project jigsaw

Issues with Java Packages: jar / war / ear / sar -- libraries
* Not so Modular
* packages - namespaces to group related classes
 com.cisco.prj.repo
 com.cisco.prj.service
 com.cisco.prj.util

 * Once we add a jar [library ] into classpath, everything is available depending on visibility [public]
 We can't make only classes present in "com.cisco.prj.service" visible to other projects.

 service --> repo
 service --> util

 ---------

 Solution before JPMS. -- OSGi 
 Modular System:
OSGi divides applications into independent, versioned modules called bundles. 

jar file will contain META-INF

```
Manifest-Version: 1.0
Bundle-ManifestVersion: 2
Bundle-Name: MyService bundle
Bundle-SymbolicName: com.sample.myservice
Bundle-Version: 1.0.0
Bundle-Activator: com.sample.myservice.Activator
Import-Package:  org.apache.commons.logging;version="1.0.4"
Export-Package:  com.sample.myservice.api;version="1.0.0"

```

Java 8 : we had rt.jar file [runtime libraries loaded on to the JRE]
Java 9: JPMS load only required modules on to JRE like java.base, java.sql

List all built-in java modules
% java --list-modules 
% java --describe-module java.sql
java.sql@21.0.6
```
exports java.sql
exports javax.sql
requires java.transaction.xa transitive
requires java.logging transitive
requires java.xml transitive
requires java.base mandated
uses java.sql.Driver [interface, implementation has to be be provided ..]
```
Type of modules:
* System modules [java --list-modules ]
* named modules : module-info.java [ we build ]
* unnamed modules: modules without module-info.java; added to classpath
* Automatic modules: jars added to module-path and not to class-path. [reqired for Spring / JPA / .. projects]

Also by using JPMS we can reduce the footprint of application in JRE / Container
Also the build [jar] will be self-contained [ minimalistic JRE]

```
# Use a Java 21 base image
FROM openjdk:21-jdk [Huge, waste of many loaded packages... problem]

# Set the working directory inside the container
WORKDIR /app

# Copy your compiled Java application (e.g., JAR file) into the container
COPY target/your-application.jar /app/your-application.jar

# Expose the port your application listens on (if applicable)
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "your-application.jar"]
```

Empty Project: modules
mylib and clientmodules are created
clientmodule --> Project Structure --> Modules --> dependencies --> Module path --> mylib

====

To Compile:
javac --module-source-path src -m mylib out

to Execute:
java --module-path out -m clientModule/client.Main

============================

JPMS Maven Multi-module project. Also ServiceLocator pattern.

Java Maven Project :maven-jpms

api module has one interface LogService and in module-info we exported

impl module requires api module.
```
 <dependency>
            <groupId>org.example</groupId>
            <artifactId>api</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>

module impl {
    requires api;
    exports com.cisco.api.impl;
    provides LogService with LogServiceStdOutImpl;
}
```
mvn package [pom level] creates jar files in target.
copied all jars into total folder
rename jars

In Total folder:

jlink --module-path api.jar:impl.jar:client.jar --add-modules client,api,impl --output myimage --launcher MYAPP=client/client.Main 


%myimage sh ./MYAPP 
Log Std Good Day!!!

=========

Automatic Modules:
Add your normal jars into module-path instead of class-path
Jar if added into module-path takes the name of JAR as module OR
META-INF/MANIFEST.MF -- here you can mention module name

=============





