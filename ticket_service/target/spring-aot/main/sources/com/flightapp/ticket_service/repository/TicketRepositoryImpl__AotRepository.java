package com.flightapp.ticket_service.repository;

import com.flightapp.ticket_service.entity.Booking;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.lang.String;
import java.util.Optional;
import org.springframework.aot.generate.Generated;
import org.springframework.data.jpa.repository.aot.AotRepositoryFragmentSupport;
import org.springframework.data.jpa.repository.query.QueryEnhancerSelector;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;

/**
 * AOT generated JPA repository implementation for {@link TicketRepository}.
 */
@Generated
public class TicketRepositoryImpl__AotRepository extends AotRepositoryFragmentSupport {
  private final RepositoryFactoryBeanSupport.FragmentCreationContext context;

  private final EntityManager entityManager;

  public TicketRepositoryImpl__AotRepository(EntityManager entityManager,
      RepositoryFactoryBeanSupport.FragmentCreationContext context) {
    super(QueryEnhancerSelector.DEFAULT_SELECTOR, context);
    this.entityManager = entityManager;
    this.context = context;
  }

  /**
   * AOT generated implementation of {@link TicketRepository#findByPnr(java.lang.String)}.
   */
  public Optional<Booking> findByPnr(String pnr) {
    String queryString = "SELECT b FROM Booking b WHERE b.pnr = :pnr";
    Query query = this.entityManager.createQuery(queryString);
    query.setParameter("pnr", pnr);

    return Optional.ofNullable((Booking) convertOne(query.getSingleResultOrNull(), false, Booking.class));
  }
}
