JSF on Spring Boot
==================

Small template projects to get you started with JSF and Spring Boot quickly. You may
also be interested to read the article describing the project on the 
<a href="http://www.beyondjava.net/blog/jsf-2-2-primefaces-5-spring-boot/">BeyondJava.net blog</a>.

Run the Main.java class to start the server. The corresponding URL is http://localhost/index.jsf.

As a bonus, the project "Understanding Scopes" demonstrate the differences between the JSF scopes
(including the more exotic sopes, such as @CustomScope or @NoneScope).

They also investigate several approaches to using Spring classes in a JSF class
(also see my article http://www.beyondjava.net/blog/integrate-jsf-2-spring-3-nicely/).

<b>Important note:</b>

If the JSF views are shown without data from the back-end, check whether your IDE put the
class files into the wrong folde.

For instance, Eclipse puts the class files into the wrong directory by default. You have to
move them from "/bin" to "/src/webapp/WEB-INF/classes". The pom.xml and the .gradle files
are a good start, but they aren't complete. To make things easier, I include
the .classpath and .project files of Eclipse in this repository.

<b>Update Oct 11, 2014:</b> Good news for Maven users: The latest update of the Maven pom.xml files should make sure
the folder setup is correct from start.

You can switch from Oracle Mojarra to Apache MyFaces by setting the variable useMyFaces=true in 
the .gradle file. 