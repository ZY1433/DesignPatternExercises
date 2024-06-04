package dataAccess.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class MyBatisUtil {
    private static final String RESOURCE = "dataAccess/config/mybatis-config.xml";
    private static SqlSessionFactory sqlSessionFactory = null;
    private static final ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(RESOURCE);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = builder.build(reader);
        } catch (Exception e1) {
            e1.printStackTrace();
            throw new ExceptionInInitializerError("初始化MyBatis错误，请检查配置文件或数据");

        }
    }

    private MyBatisUtil() {
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public static SqlSession getSession() {
        SqlSession session = threadLocal.get();
        if (session == null) {
            session = (sqlSessionFactory != null) ? sqlSessionFactory
                    .openSession() : null;
            threadLocal.set(session);
        }
        return session;
    }

    public static void closeSession() {
        SqlSession session = threadLocal.get(); // 2
        threadLocal.set(null);
        if (session != null) {
            session.close();
        }
    }
}
