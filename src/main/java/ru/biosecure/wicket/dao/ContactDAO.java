package ru.biosecure.wicket.dao;

import ru.biosecure.wicket.global.domain.Contact;

import java.util.List;

public interface ContactDAO {

	public void  addContact(Contact contact);

	public List<Contact> listContact();

	public void removeContact(Integer id);
}