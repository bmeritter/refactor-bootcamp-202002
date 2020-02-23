package cc.xpbootcamp.warmup.cashier;

public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append(printHeader());

        output.append(order.print());

        output.append(printFooter());
        return output.toString();
    }

    private String printFooter() {
        StringBuilder output = new StringBuilder();
        output.append("-----------------------------------\n");
        output.append("税额：").append(Util.formatPrice(order.totalSalesTax())).append('\n');

        if(order.discount() != 0) {
            output.append("折扣：").append(Util.formatPrice(order.discount())).append('\n');
        }

        output.append("总价：").append(Util.formatPrice(order.total()));
        return output.toString();
    }

    private String printHeader() {
        StringBuilder output = new StringBuilder();
        output.append("===== 老王超市,值得信赖 ======\n");
        output.append(Util.formatDate(order.getCreatedAt()));
        return output.toString();
    }


}