package cc.xpbootcamp.warmup.cashier;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Order {
    private static final int DISCOUNT_DATE = Calendar.WEDNESDAY;
    public static final double DISCOUNT_RATE = .98;
    String cName;
    String addr;
    List<LineItem> lineItemList;
    private Date date;

    public Order(String cName, String addr, List<LineItem> lineItemList, Date date) {
        this.cName = cName;
        this.addr = addr;
        this.lineItemList = lineItemList;
        this.date = date;
    }

    public String getCustomerName() {
        return cName;
    }

    public String getCustomerAddress() {
        return addr;
    }

    public List<LineItem> getLineItems() {
        return lineItemList;
    }

    double total() {
        double tot = 0d;

        for (LineItem lineItem : getLineItems()) {
            tot += lineItem.total();
        }
        return tot;
    }

    double totalSalesTax() {
        double totSalesTx = 0d;

        for (LineItem lineItem : getLineItems()) {
            totSalesTx += lineItem.salesTax();
        }
        return totSalesTx;
    }

    double discount() {
        return DISCOUNT_DATE == Util.getCurrentWeek(date) ? total() * (1 - DISCOUNT_RATE) : 0;
    }

    StringBuilder print() {
        StringBuilder output = new StringBuilder();
        for (LineItem lineItem : this.getLineItems()) {
            output.append(lineItem.print());
        }
        return output;
    }

    public Date getDate() {
        return date;
    }
}
