package com.imooc.utils;

import java.sql.Connection;
import java.sql.SQLException; 
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {

	    //ComboPooledDataSource(String configName)�Ĳ���configNameָ���������ļ�c3p0-config.xml�е� <named-config name="mysql">...</named-config>
	    //���û������configName��������ô�Ͳ���Ĭ�ϵ�<default-config>...</defalut-config>
	       private static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");
	       private static Connection con = null;
	       private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	     /**
	      * ��ȡ���Ӷ���
	      * @return
	     * @throws SQLException
	      */
	     public static Connection getConnection() throws SQLException{
	         con = tl.get();
	         if(con != null){return con;}
	         return (Connection) dataSource.getConnection();
	     }
     /**
	34      * ��ȡ���ӳض���
	35      * @return
	36      */
	     public static DataSource getDataSource(){
	         return dataSource;
	     }
	     /**
	41      * ��������
	42      * @throws SQLException
	43      */
	     public static void beginTransaction() throws SQLException{
	         con = tl.get();
	         if(con != null){throw new RuntimeException("�����Ѿ������������ظ�������");}
	        con = getConnection();
	         con.setAutoCommit(false);
	         tl.set(con);
	     }
	     /**
	52      * �ύ����
	53      * @throws SQLException
	54      */
	    public static void commitTransaction() throws SQLException{
	        con = tl.get();
	        if(con == null){throw new RuntimeException("����û�����������ύ��");}
	         con.commit();
	         con.close();//�黹���Ӷ������ӳ�
	         tl.remove();//�Ƴ����Ӷ���con����ôtl.get() == null
	     }
	     /**
	      * �ع�����
	64      * @throws SQLException
	65      */
	     public static void rollbackTransaction() throws SQLException{
	         con = tl.get();
	         if(con == null){throw new RuntimeException("����û���������ܻع���");}
	         con.rollback();
	         con.close();
	         tl.remove();
	     }
	     /**
	74      * �ر� ������ר�õ�����
	75      * @param connection
	76      * @throws SQLException
	77      */
	     public static void releaseConnection(Connection connection) throws SQLException{
	         con = tl.get();//��ȡ����ר������
	         if(con == null){connection.close();}
	         if(con != connection){connection.close();}
	     } 
}
