package service;

import bean.Vote;
import dao.implement.VoteDaoInterImpl;
import org.json.JSONObject;
import utils.R;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jason
 * @version 1.0
 * @date 6/2/2020 12:34 PM
 */
public class VoteService {
    VoteDaoInterImpl dao=new VoteDaoInterImpl();

    public String getList() throws IllegalAccessException, SQLException, InvocationTargetException {
        Map<String,Object> jsonMap=new HashMap<String,Object>();
        List<Vote> queryData = dao.query();
        //统计总票数
        int pollTotal=0;
        for(Vote vote:queryData){
            pollTotal+=vote.getPoll();
        }
        jsonMap.put(R.JSON.VOTE_POLL_TOTAL_DATA,pollTotal);
        jsonMap.put(R.JSON.VOTE_FORM_RADIO_NAME,R.JSON.VOTE_FORM_RADIO_NAME_VALUE);
        jsonMap.put(R.JSON.VOTE_LIST_DATA,queryData.toArray(new Vote[queryData.size()]));

        return new JSONObject(jsonMap).toString();
    }
    public void vote(int id) throws Exception {
        dao.update(id);
    }

    public static void main(String[] args) throws IllegalAccessException, SQLException, InvocationTargetException {
        System.out.println(new VoteService().getList());
    }
}
