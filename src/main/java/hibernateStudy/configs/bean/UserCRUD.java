package hibernateStudy.configs.bean;

import hibernateStudy.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import java.sql.Date;

public class UserCRUD {
    @Test
    public void test(){
        UserCRUD userCRUD = new UserCRUD();
//        userCRUD.addUserIntoDB();
        System.out.println(userCRUD.getUserFromDBById(1));

    }
    //增加User进入数据库
    public void addUserIntoDB(){
        //获取session session 类似于JDBC的连接
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
        //开启事务
        Transaction transaction = session.beginTransaction();

        //添加
        User user = new User();
        //user.setId(1); 主键无序设置
        user.setUsername("James");
        user.setPassword("9525541");
        user.setAge(20);
        user.setCreateDate(new Date(System.currentTimeMillis()));
        //session save方法
        session.save(user);
        //提交事务
        transaction.commit();
        }
        //关闭session资源
    }
    public User getUserFromDBById(int i){
        try(Session session = HibernateUtils.getSessionFactory().openSession()) {
            //开启事务
            Transaction transaction = session.beginTransaction();

            //查询
            //调用session get方法. 第一个参数是实体类class，第二个是id
            return session.get(User.class, i);
        }
    }
    public void deleteUserById(){

    }
    public void modifyUserById(){

    }
}
