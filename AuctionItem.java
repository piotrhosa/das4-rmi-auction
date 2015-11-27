import java.util.Date;
import java.io.Serializable;

public class AuctionItem implements Serializable {

    private String name;
    private int minValue;
    private Date closingDate;
    private int itemId;
    private static int nextId = 0;

    public AuctionItem(String name, int minValue, Date closingDate) {
        this.name = name;
        this.minValue = minValue;
        this.closingDate = closingDate;
        this.itemId = getNextId();
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getMinValue() {return minValue;}

    public void setMinValue(int minValue) {this.minValue = minValue;}

    public Date getClosingDate() {return closingDate;}

    public void setClosingDate(Date closingDate) {this.closingDate = closingDate;}

    public int getItemId() {return itemId;}

    private int getNextId() {return ++nextId;}
}
