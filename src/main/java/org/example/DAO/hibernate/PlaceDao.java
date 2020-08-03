package org.example.DAO.hibernate;

import org.example.entity.Place;
import org.hibernate.Session;

import java.util.List;

public class PlaceDao implements IPlaceDao{
    @Override
    public Place addPlace(String placeName) {
        SessionControl sc = new SessionControl();
        Session session = sc.startSession();

        Place place = new Place();
        place.setName(placeName);

        session.save(place);

        sc.closeSession(session);
        return null;
    }

    @Override
    public void deletePlace() {
        SessionControl sc = new SessionControl();
        Session session = sc.startSession();

        sc.closeSession(session);
    }

    @Override
    public List<Place> getAll() {
        List<Place> listOfPlaces;
        SessionControl sc = new SessionControl();
        Session session = sc.startSession();

        sc.closeSession(session);
        return null;
    }
}
