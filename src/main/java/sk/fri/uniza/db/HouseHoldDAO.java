package sk.fri.uniza.db;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import sk.fri.uniza.model.HouseHold;

import java.util.List;

public class HouseHoldDAO extends AbstractDAO<HouseHold> {

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public HouseHoldDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public HouseHold create(HouseHold houseHold) {
        currentSession().save(houseHold);
        return houseHold;
    }

    public HouseHold update(HouseHold houseHold) {
        return (HouseHold) currentSession().merge(houseHold);
    }

    public List<HouseHold> findByZip(String zip) {
        return null;
    }

    public List<HouseHold> findByFirstName(String firstname) {
        return null;
    }

    public List<HouseHold> findByLastName(String lastname) {
        return null;
    }

    public HouseHold findById(Long ID) {
        return get(ID);
    }

    public List<HouseHold> findAll() {
        return null;
    }
}
