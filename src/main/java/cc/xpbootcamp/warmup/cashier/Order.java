package cc.xpbootcamp.warmup.cashier;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Order {
    private static final int DISCOUNT_DATE = Calendar.WEDNESDAY;
    public static final double DISCOUNT_RATE = .98;
    String customName;
    String address;
    List<LineItem> goods;
    private Date createdAt;

    public Order(String cName, String addr, List<LineItem> goods, Date createdAt) {
        this.customName = cName;
        this.address = addr;
        this.goods = goods;
        this.createdAt = createdAt;
    }

    public List<LineItem> getLineItems() {
        return goods;
    }

    double total() {
        double total = 0d;

        for (LineItem lineItem : getLineItems()) {
            total += lineItem.total();
        }
        return total;
    }

    double totalSalesTax() {
        double totSalesTx = 0d;

        for (LineItem lineItem : getLineItems()) {
            totSalesTx += lineItem.salesTax();
        }
        return totSalesTx;
    }

    double discount() {
        return DISCOUNT_DATE == Util.getDayOfCurrentWeek(createdAt) ? total() * (1 - DISCOUNT_RATE) : 0;
    }

    StringBuilder print() {
        StringBuilder output = new StringBuilder();
        for (LineItem lineItem : this.getLineItems()) {
            output.append(lineItem.print());
        }
        return output;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
