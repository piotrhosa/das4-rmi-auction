import java.rmi.RemoteException;
import java.util.List;
import java.rmi.server.UnicastRemoteObject;

public class AuctionImpl extends UnicastRemoteObject implements AuctionSystem {

    public AuctionImpl() throws RemoteException {
        super();
        // Create database object
    }

    public int createAuction(AuctionItem item) throws RemoteException {
        // TODO Auto-generated method stub
        return 0;
    }

    public String bidItem(int id, int sum) throws RemoteException {
        // TODO Auto-generated method stub
        return "some item";
    }

    public List<AuctionItem> getAllListings() throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

}
