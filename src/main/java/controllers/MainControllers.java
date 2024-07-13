package controllers;

import models.Contact;
import models.User;
import services.EntityService;
import services.LogService;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainControllers implements Closeable {
    LogService logService;
    EntityService entityService;

    public MainControllers() {
        this.logService = new LogService();
        this.entityService = new EntityService();
    }

    @Override
    public void close() throws IOException {
        entityService.close();
        logService.close();
    }

    public void addContact(User user, Contact contact, Map<String, Object> meta) {
        contact.setUser(user);
        entityService.em.getTransaction().begin();
        entityService.em.persist(contact);
        entityService.em.getTransaction().commit();
        meta.put("action", "createdcontact");
        meta.put("newId", contact.getId());

        logService.add(meta);
    }
}
