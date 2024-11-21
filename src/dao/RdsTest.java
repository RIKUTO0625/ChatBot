package dao;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class RdsTest {

    public static void main(String[] args) {
        // API Gatewayのエンドポイント
        String apiEndpoint = "https://ra5sco93jb.execute-api.ap-northeast-1.amazonaws.com/test/account";

        // JSONペイロード（改行やクォートのエスケープが必要）
        String jsonPayload = "{\n" +
                             "  \"userId\": \"12345\",\n" +
                             "  \"email\": \"user@example.com\",\n" +
                             "  \"name\": \"John Doe\"\n" +
                             "}";

        // HTTPクライアントの作成
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // POSTリクエストの作成
            HttpPost postRequest = new HttpPost(apiEndpoint);
            postRequest.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            postRequest.setEntity(new StringEntity(jsonPayload));

            // リクエストの送信
            HttpResponse response = httpClient.execute(postRequest);

            // ステータスコードを取得
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("HTTP Status Code: " + statusCode);

            // レスポンスボディを取得
            String responseBody = EntityUtils.toString(response.getEntity());
            System.out.println("Response Body: " + responseBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
