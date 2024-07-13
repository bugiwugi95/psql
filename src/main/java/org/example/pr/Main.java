package org.example.pr;

import controllers.MainControllers;
import models.Contact;
import models.User;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        var mainController = new MainControllers();
        User user = new User();
        user.setId(1);
        user.setName("Andry");

        Contact contact  = new Contact();
        contact.setPhone("7893239032");
        contact.setEmail("dfssdgdsgsde@212");
        contact.setContactName("sdcxzw");

        var meta = new HashMap<String, Object>();
        meta.put("traceId", "dsdsfsdsd231212refw");
        meta.put("userID", user.getId());
        meta.put("time",new Date().getTime());


mainController.addContact(user,contact,meta);

mainController.close();




    }
}
