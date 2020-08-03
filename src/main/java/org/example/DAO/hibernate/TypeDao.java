package org.example.DAO.hibernate;

import org.example.entity.Place;
import org.example.entity.Type;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

        SessionControl sc = new SessionControl();
        Session session = sc.startSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Type> cq = cb.createQuery(Type.class);
        Root<Type> root = cq.from(Type.class);
        cq.select(root);

        Query query = session.createQuery(cq);

        List<Type> typeList = query.getResultList();

        sc.closeSession(session);
        return typeList;
    }
}
