package cc.xpbootcamp.warmup.cashier;

public class LineItem {
	public static final char TAB = '\t';
	public static final char NEWLINE = '\n';
	public static final double RATE = .10;

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

    double salesTax() {
		return totalAmount() * RATE;
	}

	double total() {
		return totalAmount() + salesTax();
	}

	StringBuilder print() {
		StringBuilder output = new StringBuilder();
		output.append(getDescription());
		output.append(TAB);
		output.append(getPrice());
		output.append(TAB);
		output.append(getQuantity());
		output.append(TAB);
		output.append(totalAmount());
		output.append(NEWLINE);
		return output;
	}
}