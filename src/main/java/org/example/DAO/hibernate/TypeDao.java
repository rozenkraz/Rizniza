package org.example.DAO.hibernate;

import org.example.entity.Place;
import org.example.entity.Type;
import org.hibernate.Session;

import java.util.List;

public class TypeDao implements ITypeDao{
    @Override
    public Type addType(String typeName) {
        SessionControl sc = new SessionControl();
        Session session = sc.startSession();

        Type type = new Type();
       type.setName(typeName);

        session.save(type);

        sc.closeSession(session);
        return null;
    }

    @Override
    public void deleteType() {
        SessionControl sc = new SessionControl();
        Session session = sc.startSession();

        sc.closeSession(session);
    }

    @Override
    public List<Type> getAll() {

        List<Type> listOfTypes;
        SessionControl sc = new SessionControl();
        Session session = sc.startSession();

        sc.closeSession(session);
        return null;
    }
}
