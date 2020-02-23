package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {
    @Test
    void shouldPrintCustomerInformationOnOrder() throws ParseException {
        Date orderDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-18");
        Order order = new Order("Mr X", "Chicago, 60601", new ArrayList<LineItem>(), orderDate);
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();

        assertThat(output, containsString("===== 老王超市,值得信赖 ======"));
        assertThat(output, containsString("2020年2月18日,星期二"));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformationWithoutDiscount() throws ParseException {
        Date orderDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-18");

        List<LineItem> goods = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.5, 2));
            add(new LineItem("小白菜", 10.00, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, goods, orderDate));

        String output = receipt.printReceipt();

        assertThat(output, containsString("2020年2月18日,星期二"));
        assertThat(output, containsString("巧克力，21.50 x 2，43.00"));
        assertThat(output, containsString("小白菜，10.00 x 1，10.00"));
        assertThat(output, containsString("-----------------------------------"));
        assertThat(output, containsString("税额：5.30"));
        assertThat(output, containsString("总价：58.30"));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformationWithDiscount() throws ParseException {
        Date createdAt = new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-19");

        List<LineItem> goods = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.5, 2));
            add(new LineItem("小白菜", 10.00, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, goods, createdAt));

        String output = receipt.printReceipt();

        assertThat(output, containsString("2020年2月19日,星期三"));
        assertThat(output, containsString("巧克力，21.50 x 2，43.00"));
        assertThat(output, containsString("小白菜，10.00 x 1，10.00"));
        assertThat(output, containsString("-----------------------------------"));
        assertThat(output, containsString("税额：5.30"));
        assertThat(output, containsString("折扣：1.17"));
        assertThat(output, containsString("总价：58.30"));
    }

}