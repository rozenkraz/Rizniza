package org.example.DAO.hibernate;

import org.hibernate.Session;

public interface ISessionControl {
    Session startSession();


    void closeSession(Session session);
}
