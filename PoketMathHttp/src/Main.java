import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {



    public static void main(String[] args) throws Exception {
        Pocketeer pocketeer = new Pocketeer();
        List<Trader> traders = pocketeer.getTraders();
        List<Transaction> transactions = pocketeer.getTransactions();
        
        printSingaporeanTraders(traders);
        printHighestTransactions(transactions);
        printHighestValuesIn2006(transactions);
        printAverageOfBeijingTraders(traders, transactions);
    }

    private static void printAverageOfBeijingTraders(List<Trader> traders, List<Transaction> transactions) {

        List<String> beijingTraders = new ArrayList<>();
        Map<String, String> beijingTradersNames = new HashMap<>();
        Map<String, Integer> transactionCount = new HashMap<>();
        Map<String, Double> transactionSum = new HashMap<>();

        for (Trader trader : traders) {
            if (trader.getCity().equals("Beijing")) {
                beijingTraders.add(trader.getId());
                beijingTradersNames.put(trader.getId(), trader.getName());
                transactionCount.put(trader.getId(), 0);
                transactionSum.put(trader.getId(), (double) 0);
            }
        }


        for (Transaction transaction : transactions) {
            String id = transaction.getTraderId();
            if (beijingTraders.contains(id)) {

                transactionCount.put(id, transactionCount.get(id) + 1);
                transactionSum.put(id, transactionSum.get(id) + transaction.getValue());
            }
        }

        System.out.println("\n\n\nBeijing averages: ");
        for(String traderId : beijingTraders) {
            System.out.println(beijingTradersNames.get(traderId) + " " + traderId +  "'s average over "
                    + transactionCount.get(traderId) + " transactions is: "
                    + transactionSum.get(traderId) / transactionCount.get(traderId));
        }
    }

    private static void printHighestValuesIn2006(List<Transaction> transactions) {


        List<Transaction> filtered = new ArrayList<>();
        for (Transaction transaction: transactions) {
            // filtering could be done nicely on any member of the class and one each value, but this would require
            // more testing.
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(transaction.getTimestamp() * (long) 1000);
            if (cal.get(Calendar.YEAR) == 2016){
                filtered.add(transaction);
            }
        }
        filtered.sort((a, b) -> a.value > b.value ? -1 : a.value.equals(b.value) ? 0 : 1);

        System.out.println("\n\n\n2016 transaction soted by value!");
        filtered.forEach(Transaction::print);
    }

    private static void printHighestTransactions(List<Transaction> transactions) {
        // From the request name there should only be one such transaction so will only print one if two have
        // the same value.

        if (transactions.size() == 0) {
            System.out.println("\n\n\nThere is no transaction! Can't print maximum value transaction!");
        }
        Transaction optim = transactions.get(0);

        for (Transaction transaction : transactions) {
            if (transaction.value > optim.value) {
                optim = transaction;
            }
        }
        System.out.println("\n\n\nHighest value transaction: !!!");
        optim.print();
    }

    private static void printSingaporeanTraders(List<Trader> traders) {

        List<Trader> singaporeTraders = new ArrayList<>();
        System.out.println("\n\n\nTraders from Singapore:");
        for (Trader trader: traders) {
            // filtering could be done nicely on any member of the class and one each value, but this would require
            // more testing.
            if (trader.getCity().equals("Singapore")) {
                singaporeTraders.add(trader);
            }
        }
        singaporeTraders.sort(Comparator.comparing(a -> a.name));
        singaporeTraders.forEach(Trader::print);
    }


}
