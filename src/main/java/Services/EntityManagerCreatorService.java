package Services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerCreatorService {

    public static EntityManager createEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BankSystem");
        return emf.createEntityManager();
    }


}
