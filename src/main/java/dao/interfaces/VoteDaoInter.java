package dao.interfaces;

import bean.Vote;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Jason
 * @version 1.0
 * @date 6/2/2020 10:53 AM
 */
public interface VoteDaoInter {
    /**
     * 查询
     * @author Jason
     * @date 10:53 AM 6/2/2020
     * @param
     * @return
     */
     List<Vote> query() throws SQLException, InvocationTargetException, IllegalAccessException;
    /**
     * 修改更新
     * @author Jason
     * @date 11:05 AM 6/2/2020
     * @param  id 修改ID
     * @return
     */
    public void update(int id) throws Exception;
}
