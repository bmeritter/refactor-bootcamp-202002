package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    String cName;
    String addr;
    List<LineItem> lineItemList;

    public Order(String cName, String addr, List<LineItem> lineItemList) {
        this.cName = cName;
        this.addr = addr;
        this.lineItemList = lineItemList;
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

    StringBuilder print() {
        StringBuilder output = new StringBuilder();
        for (LineItem lineItem : this.getLineItems()) {
            output.append(lineItem.print());
        }
        return output;
    }
}
