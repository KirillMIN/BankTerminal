package Main;

import Entities.User;
import Services.DAO.UserDML;
import Services.EntityManagerCreatorService;
import jakarta.persistence.EntityManager;

public class MainWork {
    public static void main(String[] args) {
        EntityManager em =  EntityManagerCreatorService.createEntityManager();
        UserDML user = new UserDML();
        user.delete(em, 2L);
        em.close();


    }
}
