package org.example.DAO.hibernate;

import org.example.entity.Item;
import org.example.entity.Place;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import java.util.List;

public class ItemDao implements IItemDao{
    @Override
    public Item addItem(Item item) {
        SessionControl sc = new SessionControl();
        Session session = sc.startSession();

        session.save(item);

        sc.closeSession(session);
        return null;
    }

    @Override
    public void deleteItem() {
        SessionControl sc = new SessionControl();
        Session session = sc.startSession();

        sc.closeSession(session);
    }

    @Override
    public List<Item> getAllByPlace(String placeName) {
        List<Item> listOfItems;

        SessionControl sc = new SessionControl();
        Session session = sc.startSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Item> cq = cb.createQuery(Item.class);
        Root<Item> root = cq.from(Item.class);

        //Selection[] selections = {root.get("name"), root.get("photo")};

        cq.select(root)
            .where(cb.like(root.get("currentPlace"), placeName));

        Query query = session.createQuery(cq);

        listOfItems = query.getResultList();

        sc.closeSession(session);
        return listOfItems;
    }

    @Override
    public List<Item> getAllByType(String typeName) {
        List<Item> listOfItems;

        SessionControl sc = new SessionControl();
        Session session = sc.startSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Item> cq = cb.createQuery(Item.class);
        Root<Item> root = cq.from(Item.class);

        //Selection[] selections = {root.get("name"), root.get("photo")};

        cq.select(root)
                .where(cb.like(root.get("type"), typeName));

        Query query = session.createQuery(cq);

        listOfItems = query.getResultList();

        sc.closeSession(session);
        return listOfItems;
    }

    @Override
    public Item getItemByItemId() {
        SessionControl sc = new SessionControl();
        Session session = sc.startSession();



        sc.closeSession(session);
        return null;
    }

    @Override
    public void moveItemById(String itemId, String distination) {
        SessionControl sc = new SessionControl();
        Session session = sc.startSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Item> cq = cb.createQuery(Item.class);
        Root<Item> root = cq.from(Item.class);

        //Selection[] selections = {root.get("name"), root.get("photo")};

        cq.select(root)
                .where(cb.like(root.get("itemId"), itemId));

        Query query = session.createQuery(cq);

        List<Item> listOfItems = query.getResultList();

        for (Item item: listOfItems) {
            item.setCurrentPlace(distination);
            session.update(item);
        }


        sc.closeSession(session);
    }
}
