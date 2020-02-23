package cc.xpbootcamp.warmup.cashier;

public class LineItem {
	public static final double RATE = .10;

	private String description;
	private double price;
	private int quantity;

	public LineItem(String desc, double price, int quantity) {
		super();
		this.description = desc;
		this.price = price;
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

    double totalAmount() {
        return price * quantity;
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
		output.append('，');
		output.append(Util.formatPrice(getPrice()));
		output.append(" x ");
		output.append(getQuantity());
		output.append('，');
		output.append(Util.formatPrice(totalAmount()));
		output.append('\n');
		return output;
	}
}