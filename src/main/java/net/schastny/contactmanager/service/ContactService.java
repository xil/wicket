package net.schastny.contactmanager.service;

import net.schastny.contactmanager.domain.Contact;

import java.util.List;

public interface ContactService {

	public void addContact(Contact contact);

	public List<Contact> listContact();

	public void removeContact(Integer id);
}
