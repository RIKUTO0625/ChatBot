package test;

import java.util.HashMap;
import java.util.Map;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

public class YamaniAction {

    public static void main(String[] args) {

        // 1. DynamoDBクライアントを作成
        DynamoDbClient dynamoDbClient = DynamoDbClient.builder()
                .region(Region.AP_NORTHEAST_1) // リージョンを指定（例: 東京）
                .build();

        // 2. テーブル名を指定
        String tableName = "test-db";

        // 3. データを設定
        Map<String, AttributeValue> itemValues = new HashMap<>();
        itemValues.put("test_id", AttributeValue.builder().s("unique_id_123").build()); // プライマリキー
        itemValues.put("test-name", AttributeValue.builder().s("SampleName").build()); // その他の属性
        itemValues.put("Age", AttributeValue.builder().n("25").build());
        itemValues.put("Active", AttributeValue.builder().bool(true).build());

        // 4. PutItemリクエストを作成
        PutItemRequest request = PutItemRequest.builder()
                .tableName(tableName)
                .item(itemValues)
                .build();

        // 5. データを追加
        try {
            dynamoDbClient.putItem(request);
            System.out.println("データを追加しました！");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("データ追加に失敗しました: " + e.getMessage());
        } finally {
            // クライアントを閉じる
            dynamoDbClient.close();
        }
    }
}
