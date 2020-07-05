package utils;

/**
 * @author Jason
 * @version 1.0
 * @date 6/2/2020 11:07 AM
 */
public class R {
    public interface MYSQL_CONFIG{
        String JDBC_DRIVER="jdbc.driver";
        String JDBC_URL="jdbc.url";
        String JDBC_USER="jdbc.username";
        String JDBC_PASSWORD="jdbc.password";


    }
    public interface SQL_META_DATA{
        String VOTE_TABLE="vote_table";
        String VOTE_TABLE_ID="id";
        String VOTE_TABLE_POLL="poll";
    }
    public interface SQL_SYNTAX{
        //查询
        String PRE_QUERY_ALL_DATA="SELECT * FROM "+SQL_META_DATA.VOTE_TABLE+";";
        //修改
        String PRE_UPDATE_VOTE_DATA="UPDATE "+SQL_META_DATA.VOTE_TABLE+" SET "+SQL_META_DATA.VOTE_TABLE_POLL+"="+SQL_META_DATA.VOTE_TABLE_POLL+"+1 WHERE "+SQL_META_DATA.VOTE_TABLE_ID+"=?;";
    }

    public interface REQUEST{
        String REQUEST_METHOD="method";
        String REQUEST_VOTE_ID="vote_id";
    }
    public interface RESPONSE{
        String RESPONSE_SIGN_SUCCESS="success";
        String RESPONSE_SIGN_FAIL="fail";
    }
    public interface JSON{
        String VOTE_LIST_DATA="vote_list";
        String VOTE_POLL_TOTAL_DATA="poll_total";
        String VOTE_FORM_RADIO_NAME="radio_name";
        String VOTE_FORM_RADIO_NAME_VALUE="vote_id";
    }
}
