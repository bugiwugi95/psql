package services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Closeable;
import java.io.IOException;

public class EntityService implements Closeable {
    private final EntityManagerFactory managerFactory;
    public final EntityManager em;

    public EntityService() {
        this.managerFactory = Persistence.createEntityManagerFactory("def");
        this.em = managerFactory.createEntityManager();
    }

    @Override
    public void close() throws IOException {
        em.close();
        managerFactory.close();
    }
}
