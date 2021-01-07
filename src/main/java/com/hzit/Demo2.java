package com.hzit;

import com.hzit.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * 查询全部用户信息
 *
 */
public class Demo2 {

    public static void main(String[] args) throws Exception {
        // 如何执行sql语句
        //  加载配置文件 就能获取连接
        // 加载配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 创建sqlSession工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 获取一次会话 sqlSession
        SqlSession sqlSession = factory.openSession();

        // 执行sql语句
        // selectList 查询出多条记录的时候使用
        List<User> users =  sqlSession.selectList("userMapper.selectAll");

        System.out.println(users);


    }

}
