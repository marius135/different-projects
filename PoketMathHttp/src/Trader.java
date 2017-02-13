import net.maritimecloud.internal.core.javax.json.Json;
import net.maritimecloud.internal.core.javax.json.JsonArray;
import net.maritimecloud.internal.core.javax.json.JsonObject;
import net.maritimecloud.internal.core.javax.json.JsonReader;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class Trader {
    String name;
    String city;
    String id;

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getId() {
        return id;
    }

    public Trader(String name, String city, String id) {
        this.name = name;
        this.city = city;
        this.id = id;
    }

    public void print() {
        System.out.println(this.name + " " + this.city + " " + this.id);
    }

    static List<Trader> parseTraders(StringBuffer inputStream) throws IOException {

        StringReader stringReader = new StringReader(inputStream.toString());
        JsonReader reader = Json.createReader(stringReader);
        JsonArray arr = reader.readArray();
        List<Trader> traders = new ArrayList<>();

        for(int i=0; i < arr.toArray().length; i++){
            JsonObject obj = arr.getJsonObject(i);
            Trader trader = new Trader(obj.getString("name"), obj.getString("city")
                    , obj.getString("id"));
            traders.add(trader);
        }
        return traders;
    }
}
