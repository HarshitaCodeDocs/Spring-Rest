package com.hcl.rest.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.rest.model.Country;

@Repository
public class CountryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Country> getAllCountries() {
		@SuppressWarnings("unchecked")
		List<Country> countryList = getSession().createCriteria(Country.class).list();
		return countryList;
	}

	public Country getCountry(int id) {
		Country country = (Country) getSession().load(Country.class, new Integer(id));
		return country;
	}

	public Country addCountry(Country country) {
		getSession().save(country);
		return country;
	}

	public void updateCountry(Country country) {
		getSession().update(country);
	}

	public void deleteCountry(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Country p = (Country) session.load(Country.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}
    public Session getSession()
    {
    	Session session = null;
    	try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
		  session = sessionFactory.openSession();
		}
    	return session;
    }
}
