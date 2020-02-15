package cc.xpbootcamp.warmup.cashier;

public class LineItem {
	static char TAB = '\t';
	static char NEWLINE = '\n';

	private String desc;
	private double price;
	private int qty;

	public LineItem(String desc, double price, int qty) {
		super();
		this.desc = desc;
		this.price = price;
		this.qty = qty;
	}

	public String getDescription() {
		return desc;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return qty;
	}

    double totalAmount() {
        return price * qty;
    }

	StringBuilder print() {
		StringBuilder output = new StringBuilder();
		output.append(this.getDescription());
		output.append(TAB);
		output.append(this.getPrice());
		output.append(TAB);
		output.append(this.getQuantity());
		output.append(TAB);
		output.append(this.totalAmount());
		output.append(NEWLINE);
		return output;
	}
}