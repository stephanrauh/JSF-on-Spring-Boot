JSF-on-Spring-Boot
==================

Small template projects to get you started with JSF and Spring Boot quickly.

As a bonus, the projects demonstrate the differences between the JSF scopes
(including the more exotic sopes, such as @CustomScope or @NoneScope).

They also investigate several approaches to using Spring classes in a JSF class
(also see my article http://www.beyondjava.net/blog/integrate-jsf-2-spring-3-nicely/).

Please note that you have to configure your IDE correctly to debug Spring Boot JSF applications.
For instance, Eclipse puts the class files into the wrong directory by default. You have to
move them from "/bin" to "/src/webapp/WEB-INF/classes". To make things easier, I include
the .classpath and .project files of Eclipse in this repository.
