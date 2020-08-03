package org.example.DAO.hibernate;

import org.example.entity.Place;
import org.hibernate.Session;

import java.util.List;

public class PlaceDao implements IPlaceDao{
    @Override
    public Place addPlace() {
        return null;
    }

    @Override
    public void deletePlace() {

    }

    @Override
    public List<Place> getAll() {
        List<Place> listOfPlaces;
        SessionControl sc = new SessionControl();
        return null;
    }
}
