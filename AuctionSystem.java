import java.util.List;
import java.rmi.Remote;

public interface AuctionSystem extends Remote {

    public String createAuction(AuctionItem item) throws java.rmi.RemoteException;

    public String bidItem(int id, int sum) throws java.rmi.RemoteException;

    public String getAllListings() throws java.rmi.RemoteException;
}
