/*
"Hello potential Pocketeer! At PocketMath we look for software engineers who can build simple and elegant solutions, " +

        "so we've designed these challenges to see what you can come up with." +
        " We'd like for you to build an application using one of " +
        "Java/Golang/Rust/Scala/Clojure with any framework(s) and/or toolchain(s) of your choice. " +
        "The application will need to invoke our REST endpoints for data and answer the following queries." +
        " Every run of the application should invoke the endpoints for data, i.e. don't persist the data for" +
        " repeated runs, the answers for each challenge can simply be printed on the console or written to a file. " +
        "Please provide your source code and a brief README.md on how to run your application to our recruiter." +
        " We are not interested in the actual answer to these queries," +
        " we're much more interested in how you've solved them! " +
        "These challenges are all of the same domain: traders executing transactions. " +
        "Traders have a name, a city, and a unique trader ID." +
        " Transactions have a UTC 0 UNIX epoch second timestamp, a value (representing the monetary value transacted in USD)," +
        " and a trader ID (identifying the trader who made the transaction)." +
        " There are REST endpoints which you can invoke GET to obtain the data. " +
        "The endpoints require the same API key for authorization." +
        " The REST endpoints are 'GET /prod/traders' (for all traders) and " +
        "'GET /prod/transactions' (for all transactions).",
        "challenges": [
        "Find all traders from Singapore and sort them by name.",
        "Find the transaction with the highest value.",
        "Find all transactions in the year 2016 and sort them by value (high to small).",
        "Find the average of transactions' values from the traders living in Beijing."
        ]
        }
        */

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Pocketeer {


    private static StringBuffer sendGet(String item) throws Exception {

        String url = " https://fvjkpkflnc.execute-api.us-east-1.amazonaws.com/prod/" + item;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("x-api-key", "gaqcRZE4bd58gSAJH3XsLYBo1EvwIQo88IfYL1L5");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        return response;
    }
    static List<Trader> getTraders() throws Exception {

        StringBuffer tradersInputStream = sendGet("traders");
        return Trader.parseTraders(tradersInputStream);
    }


    public List<Transaction> getTransactions() throws Exception {

        StringBuffer transactionInputStream = sendGet("transactions");
        return Transaction.parseTransactions(transactionInputStream);
    }
}
