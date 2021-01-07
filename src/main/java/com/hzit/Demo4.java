package com.hzit;

import com.hzit.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * 插入用户信息
 */
public class Demo4 {

    public static void main(String[] args) throws Exception {
        // 如何执行sql语句
        //  加载配置文件 就能获取连接
        // 加载配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 创建sqlSession工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 获取一次会话 sqlSession
        SqlSession sqlSession = factory.openSession();
        User user = new User(7, "99", "88");
        // 修改用户信息
        int i = sqlSession.update("userMapper.updateById", user);

        if(i== 1){
            System.out.println("修改成功！！");
        }
        sqlSession.commit();



    }

}
