package com.flightapp.ticket_service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TicketServiceApplication}.
 */
@Generated
public class TicketServiceApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'ticketServiceApplication'.
   */
  public static BeanDefinition getTicketServiceApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TicketServiceApplication.class);
    beanDefinition.setInstanceSupplier(TicketServiceApplication::new);
    return beanDefinition;
  }
}
