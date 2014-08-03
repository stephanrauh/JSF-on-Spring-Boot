package de.beyondjava.main;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;

public class MyEmbeddedServletContainerCustomizer implements EmbeddedServletContainerCustomizer {

//	@Value("${name}")
//	String name;
//  @Value("${servlet.container.maxThreads}") // doesn't work as described in http://callistaenterprise.se/blogg/teknik/2014/04/15/a-first-look-at-spring-boot/
  private int MAX_THREADS=20;

  @Override
  public void customize(ConfigurableEmbeddedServletContainer factory) {
    if(factory instanceof TomcatEmbeddedServletContainerFactory) {
      customizeTomcat((TomcatEmbeddedServletContainerFactory) factory);
    }
  }

  public void customizeTomcat(TomcatEmbeddedServletContainerFactory factory) {
    factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
      @Override
      public void customize(Connector connector) {
    	  connector.setPort(80);
//        Object defaultMaxThreads = connector.getAttribute("maxThreads");
//        connector.getAttribute("javax.faces.CLIENT_WINDOW_MODE")
        connector.setAttribute("maxThreads", MAX_THREADS);
      }
    });
  }
}