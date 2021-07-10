package hibernateStudy.utils;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static Configuration configuration = null;
    private static SessionFactory sessionFactory = null;
    static{
        //加载核心配置文件 到src找到hibernate.cfg.xml 并加载到对象里
        configuration = new Configuration();
        configuration.configure();
        //创建sessionFactory 会根据对象，映射配置创建表 过程中很消耗性能 所以需要把这一步放在同步代码块中一次创建多次使用
        sessionFactory = configuration.buildSessionFactory();
    }

    public static Configuration getConfiguration() {
        return configuration;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
