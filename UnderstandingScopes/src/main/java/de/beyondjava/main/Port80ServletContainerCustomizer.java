/**
 *  (C) 2013-2014 Stephan Rauh http://www.beyondjava.net
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.beyondjava.main;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;

public class Port80ServletContainerCustomizer implements EmbeddedServletContainerCustomizer {

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