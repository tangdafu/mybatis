package com.hzit;

import com.hzit.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

// # 根据id查询用户信息‘
// mybatis ： sql 语句和代码进行分离 sql 一般写在 xml配置文件
public class Demo {

    public static void main(String[] args) throws Exception {
        // 如何执行sql语句
        //  加载配置文件 就能获取连接
        // 加载配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");


        // 创建sqlSession工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 获取一次会话 sqlSession
        SqlSession sqlSession = factory.openSession();

        // 执行sql语句操作数据库
        // selectOne(执行那条sql语句,这条sql语句需要什么值)
        // 通过命名空间 找到命名空间下面的sql语句
        User user =  sqlSession.selectOne("userMapper.selectById",1);
        /*  */
        System.out.println("666");
        System.out.println(user);
    }

}
