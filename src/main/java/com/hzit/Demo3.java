package com.hzit;

import com.hzit.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * 插入用户信息
 */
public class Demo3 {

    public static void main(String[] args) throws Exception {
        // 如何执行sql语句
        //  加载配置文件 就能获取连接
        // 加载配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 创建sqlSession工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 获取一次会话 sqlSession
        SqlSession sqlSession = factory.openSession();

        User user = new User();
        user.setUserName("xiaotiantian");
        user.setPassword("654321789");
        // 执行sql语句

        int i = sqlSession.insert("userMapper.insert", user);
        if(i == 1){
            System.out.println("添加成功！！！！");
        }
        // 添加修改删除需要提交
        sqlSession.commit();

    }

}
