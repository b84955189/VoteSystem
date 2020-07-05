package dao.implement;

import bean.Vote;

import dao.interfaces.VoteDaoInter;
import org.apache.commons.beanutils.BeanUtils;
import utils.JDBCUtils;
import utils.R;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jason
 * @version 1.0
 * @date 6/2/2020 11:01 AM
 */
public class VoteDaoInterImpl implements VoteDaoInter {

    /**
     * 修改更新
     *
     * @param id 修改ID
     * @return
     * @author Jason
     * @date 11:05 AM 6/2/2020
     */
    public synchronized void update(int id) throws Exception {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(R.SQL_SYNTAX.PRE_UPDATE_VOTE_DATA);
        preparedStatement.setInt(1,id);
        if(preparedStatement.executeUpdate()<=0) {
            throw new Exception();
        }
        preparedStatement.close();
        JDBCUtils.closeConnection();

    }


    /**
     * 查询
     *
     * @return
     * @author Jason
     * @date 10:53 AM 6/2/2020
     */
    public List<Vote> query() throws SQLException, InvocationTargetException, IllegalAccessException {
        ArrayList<Vote> list = new ArrayList<Vote>();
        Connection connection= JDBCUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(R.SQL_SYNTAX.PRE_QUERY_ALL_DATA);
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        while(resultSet.next()){
            Vote vote = new Vote();
            for(int i=1;i<=metaData.getColumnCount();i++){
                BeanUtils.setProperty(vote,metaData.getColumnName(i),resultSet.getObject(i));
            }
            list.add(vote);
        }

        resultSet.close();
        preparedStatement.close();
        JDBCUtils.closeConnection();

        return list;
    }

    public static void main(String[] args) throws IllegalAccessException, SQLException, InvocationTargetException {
        System.out.println(new VoteDaoInterImpl().query());;
    }
}

