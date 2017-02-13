import net.maritimecloud.internal.core.javax.json.Json;
import net.maritimecloud.internal.core.javax.json.JsonArray;
import net.maritimecloud.internal.core.javax.json.JsonObject;
import net.maritimecloud.internal.core.javax.json.JsonReader;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Transaction {

    Integer timestamp;

    public Integer getTimestamp() {
        return timestamp;
    }

    public String getTraderId() {
        return traderId;
    }

    public Double getValue() {
        return value;
    }

    String traderId;
    Double value;

    public Transaction(Integer timestamp, String traderId, Double value) {
        this.timestamp = timestamp;
        this.traderId = traderId;
        this.value = value;
    }


    static List<Transaction> parseTransactions(StringBuffer inputStream) throws IOException {

        StringReader stringReader = new StringReader(inputStream.toString());
        JsonReader reader = Json.createReader(stringReader);
        JsonArray arr = reader.readArray();
        List<Transaction> transactions = new ArrayList<>();

        for(int i=0; i < arr.toArray().length; i++){
            JsonObject obj = arr.getJsonObject(i);
            Transaction transaction = new Transaction(obj.getInt("timestamp"), obj.getString("traderId")
                    , obj.getJsonNumber("value").doubleValue());
            transactions.add(transaction);
        }
        return transactions;
    }

    public void print() {
        System.out.println(this.timestamp + " " + this.traderId + " " + this.value);
    }
}
