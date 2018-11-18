package cn.shen.jpaday1.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
    private final static EntityManagerFactory ENTITY_MANAGER_FACTORY;

    static {
        ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("myJpa");
    }

    /**
     * 获取EntityManager对象
     * @return EntityManager em
     */
    public static EntityManager getEM() {
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }
}
