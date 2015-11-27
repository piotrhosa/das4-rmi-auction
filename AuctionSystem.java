import java.util.List;
import java.rmi.Remote;

public interface AuctionSystem extends Remote {

    public int createAuction(AuctionItem item) throws java.rmi.RemoteException;

    public String bidItem(int id, int sum) throws java.rmi.RemoteException;

    public List<AuctionItem> getAllListings() throws java.rmi.RemoteException;
}
