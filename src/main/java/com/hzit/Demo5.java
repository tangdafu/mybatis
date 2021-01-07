package com.hzit;

import com.hzit.mapper.UserMapper;
import com.hzit.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Demo5 {
    public static void main(String[] args) throws Exception {
        // 如何执行sql语句
        //  加载配置文件 就能获取连接
        // 加载配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 创建sqlSession工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 获取一次会话 sqlSession
        SqlSession sqlSession = factory.openSession();

        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

        List<User> userList=userMapper.selectAll();

        System.out.println(userList);


        sqlSession.close();



    }
}
