package org.example.DAO.hibernate;

import org.example.entity.Item;
import org.hibernate.Session;

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
        SessionControl sc = new SessionControl();
        Session session = sc.startSession();

        sc.closeSession(session);
        return null;
    }

    @Override
    public Item getItemByItemId() {
        SessionControl sc = new SessionControl();
        Session session = sc.startSession();

        sc.closeSession(session);
        return null;
    }
}
