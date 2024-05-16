import com.mrjaffesclass.stockmarket.StockGetHistory;
import com.mrjaffesclass.stockmarket.StockPrice;
import java.util.Calendar;
import java.util.ArrayList;

public class StockPriceHistory
{
    private final String ticker = "TSLA";  
    public void run() {
        System.out.println("Date,Close");
        StockGetHistory stocks = new StockGetHistory("3GG3BZBD1ODPYZJA", ticker); 
        
        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.add(Calendar.MONTH, -1);
        
        ArrayList<StockPrice> prices = stocks.getStockPrices();

        for (StockPrice s : prices) {
            String formattedDate = formatDate(s.getDate());
            
            double close = s.getClose();
            double rounded = Math.round(close*100.0)/100.0;
            
            System.out.println(formattedDate + "," + rounded);
        }
    }

    public String formatDate(Calendar date) {
        int year = date.get(Calendar.YEAR);
        int month = date.get(Calendar.MONTH)+1;
        int day = date.get(Calendar.DATE);
        String monthStr = (month < 10) ? "0"+month : month+"";
        String dayStr = (day < 10) ? "0"+day : day+"";
        String dateStr = year+"-"+monthStr+"-"+dayStr;
        return dateStr;
    }
    
    public static void main(String[] args) {
        StockPriceHistory sph = new StockPriceHistory();
        sph.run();
    }
}
