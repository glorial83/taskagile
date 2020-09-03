package com.taskagile.repository;

import javax.persistence.EntityManager;

import org.hibernate.Session;

abstract class HibernateSupport {
  EntityManager entityManager;

  HibernateSupport(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  Session getSession() {
    return this.entityManager.unwrap(Session.class);
  }
}
