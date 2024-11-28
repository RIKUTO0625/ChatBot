package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.SendMail;

public class SendMailDao extends Dao {


    public boolean createMail(SendMail sendmail)throws Exception {

    	int count = 0;

		//コネクションを確立
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement statement = null;


		try {

			String sql = "insert into sendmail"
			+ "(mail_id, mail_address, ad_cd)"
		    + "values (? ,? ,?)";

			//プリペアードステートメントにINSERT文をセット
			statement = connection
			.prepareStatement (sql);
			// プリペアードステートメントに値をバインド
			statement.setString(1,sendmail.getMail_id());
			statement.setString(2,sendmail.getSend_mail());
			statement.setString(3,sendmail.getAdmin().getAd_cd());


			//プリペアードステートメントを実行
			count = statement.executeUpdate ();

		}catch(Exception e) {
				throw e;
		}finally {
			// プリペアードステートメントを閉じる
			if (statement != null) {
				try {
					statement. close ();
				}catch (SQLException sqle) {
					throw sqle;
				}
			}
			//コネクションを閉じる
			if (connection != null) {
				try {
					connection.close ();
				}catch (SQLException sqle) {
					throw sqle;
				}
			}
		}
		if (count > 0) {
			//実行件数が1件以上ある場合
			return true;
		}else{
		    //実行件数が0件の場合
		    return false;
		}

    }

	public boolean deleteMail (SendMail sendmail) throws Exception {
		//コネクションを確立
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement statement = null;
		// 実行件数
		Boolean success = false;

		try {
			//プリペアードステートメントにUPDATE文をセット
			statement = connection
			.prepareStatement ("delete from sendmail where mail_id = ?;");
			// プリペアードステートメントに値をバインド
			statement.setString(1,sendmail.getMail_id());

			statement.executeUpdate ();

			success = true;

		}catch(Exception e) {
				throw e;

		}finally {
			// プリペアードステートメントを閉じる
			if (statement != null) {
				try {
					statement. close ();
				}catch (SQLException sqle) {
					throw sqle;
				}
			}
			//コネクションを閉じる
			if (connection != null) {
				try {
					connection.close ();
				}catch (SQLException sqle) {
					throw sqle;
				}
			}
		}

		return success;

	}

	public List<SendMail> viewMail(String ad_cd) throws Exception {

		//リスト
		List<SendMail> mail_list = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet rSet = null;

        try {
            statement = connection.prepareStatement(
            "SELECT * FROM sendmail " +
            	" where ad_cd = ? " +
				" ORDER BY mail_address ASC ");

            statement.setString(1, ad_cd) ;

            rSet = statement.executeQuery();

	        // リザルトセットを全権走査
	        while (rSet.next()) {
	            // 職員インスタンスを初期化
	            SendMail sendmail = new SendMail();

	            // メールインスタンスにリストをセット
	            sendmail.setMail_id(rSet.getString("mail_id"));
	            sendmail.setMail_id(rSet.getString("mail_address"));
	            sendmail.setAd_cd(rSet.getString("ad_cd"));

	            // リストに追加
	            mail_list.add(sendmail);
	        }

        }catch(Exception e){
			throw e;

		}finally {

            if (statement != null) {
            	try {
            		statement.close();
				} catch (SQLException sqle) {
					throw sqle;
				}

            }
            if (connection != null) {
            	try {
            		 connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
            }
        }

        return mail_list;
	}

}