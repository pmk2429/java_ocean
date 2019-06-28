package hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class StockData {

  private Deque<Stock> stockPrices;
  private Stock min; // represents min price of the day
  private Stock max; // represents max price of the day

  protected StockData() {
    stockPrices = new ArrayDeque<>();
    min = new Stock(11222, Integer.MAX_VALUE);
    max = new Stock(33333, Integer.MIN_VALUE);
  }

  public void push(Stock stock) {
    // insert into DS
    stockPrices.offer(stock);

    if (stock.price >= max.price) {
      max = stock;
    }

    if (stock.price <= min.price) {
      min = stock;
    }
  }

  public Stock getMin() {
    return min;
  }

  public Stock getMax() {
    return max;
  }
}

class Stock {
  long timestamp;
  double price;

  Stock(long timestamp, double price) {
    this.timestamp = timestamp;
    this.price = price;
  }
}

public class MonkeyDataEntry {

  private Map<String, StockData> tickerMap;

  private MonkeyDataEntry() {
    tickerMap = new HashMap<>();
  }

  public void addticker(String ticker, long timestamp, double price) {
    if (ticker != null && ticker.trim().length() >= 1) {
      Stock stock = new Stock(timestamp, price);
      StockData data;
      if (tickerMap.containsKey(ticker)) {
        data = tickerMap.get(ticker);
        data.push(stock);
      } else {
        data = new StockData();
        data.push(stock);
        tickerMap.put(ticker, data);
      }
    } else {
      System.out.println("Invalid TICKER. Cannot add to system");
    }
  }

  protected Stock getStockMinData(String ticker) {
    if (tickerMap.containsKey(ticker)) {
      return tickerMap.get(ticker).getMin();
    }
    return null;
  }

  protected Stock getStockMaxData(String ticker) {
    if (tickerMap.containsKey(ticker)) {
      return tickerMap.get(ticker).getMax();
    }
    return null;
  }

  public static void main(String[] args) {
//
    MonkeyDataEntry dataEntry = new MonkeyDataEntry();
    dataEntry.addticker("UBER", 123450, 40.5);
    dataEntry.addticker("UBER", 868686, 44.6);
    dataEntry.addticker("UBER", 997970, 37.8);
    dataEntry.addticker("UBER", 575789, 39.9);
    dataEntry.addticker("UBER", 999002, 36.6);
    dataEntry.addticker("UBER", 234556, 45.9);

    Stock uberMin = dataEntry.getStockMinData("UBER");
    Stock uberMax = dataEntry.getStockMaxData("UBER");

    System.out.println(uberMax.price);
    System.out.println(uberMin.price);
  }
}
