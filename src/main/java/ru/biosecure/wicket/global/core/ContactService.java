package ru.biosecure.wicket.global.core;

import ru.biosecure.wicket.global.domain.Contact;

import java.util.List;

public interface ContactService {

	public void addContact(Contact contact);

	public List<Contact> listContact();

	public void removeContact(Integer id);
}
