JSF-on-Spring-Boot
==================

Small template projects to get you started with JSF and Spring Boot quickly.

Run the Main.java class to start the server. The corresponding URL is http://localhost/index.jsf.

As a bonus, the project "Understanding Scopes" demonstrate the differences between the JSF scopes
(including the more exotic sopes, such as @CustomScope or @NoneScope).

They also investigate several approaches to using Spring classes in a JSF class
(also see my article http://www.beyondjava.net/blog/integrate-jsf-2-spring-3-nicely/).

Please note that you have to configure your IDE correctly to debug Spring Boot JSF applications.
For instance, Eclipse puts the class files into the wrong directory by default. You have to
move them from "/bin" to "/src/webapp/WEB-INF/classes". The pom.xml and the .gradle files
are a good start, but they aren't complete. To make things easier, I include
the .classpath and .project files of Eclipse in this repository.

You can switch from Oracle Mojarra to Apache MyFaces by setting the variable useMyFaces=true in 
the .gradle file. However, MyFaces doesn't seem to be compatible with the AOP advices at the
time of writing.