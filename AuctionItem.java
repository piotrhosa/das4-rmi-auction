import java.util.Date;
import java.io.Serializable;
import java.lang.StringBuilder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AuctionItem implements Serializable {

    private String name;
    private int minValue;
    private int currentValue;
    private long closingDate;
    private int itemId;
    private static int nextId = 0;

    public AuctionItem(String name, int minValue, long closingDate) {
        this.name = name;
        this.minValue = minValue;
        this.currentValue = 0;
        this.closingDate = closingDate;
        this.itemId = getNextId();
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getMinValue() {return minValue;}

    public void setMinValue(int minValue) {this.minValue = minValue;}

    public int getCurrentValue() {return currentValue;}

    public void setCurrentValue(int currentValue) {this.currentValue = currentValue;}

    public long getClosingDate() {return closingDate;}

    public void setClosingDate(long closingDate) {this.closingDate = closingDate;}

    public int getItemId() {return itemId;}

    private int getNextId() {return ++nextId;}

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Item id: ");
        sb.append(Integer.toString(getItemId()));
        sb.append(", item name: ");
        sb.append(getName());
        sb.append(", current value: ");
        sb.append(Integer.toString(getCurrentValue()));
        sb.append(", min value acheived: ");
        sb.append(getCurrentValue() >= getMinValue() ? "true" : "false");
        sb.append(", closing date: ");
        Calendar c = new GregorianCalendar();
        c.setTimeInMillis(getClosingDate());
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        sb.append(df.format(c.getTime()));
        sb.append("\n");
        return sb.toString();
    }
}
