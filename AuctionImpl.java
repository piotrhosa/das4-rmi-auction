import java.rmi.RemoteException;
import java.util.List;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class AuctionImpl extends UnicastRemoteObject implements AuctionSystem {

    private List<AuctionItem> list = new ArrayList<AuctionItem>();

    public AuctionImpl() throws RemoteException {
        super();
        // Create database object
    }

    public String createAuction(AuctionItem item) throws RemoteException {
        list.add(item);
        return item.toString();
    }

    public String bidItem(int id, int sum) throws RemoteException {
        // TODO Auto-generated method stub
        return Integer.toString(list.size());
    }

    public String getAllListings() throws RemoteException {
        StringBuffer sb = new StringBuffer();
        for(AuctionItem ai: list)
            sb.append(ai.toString());
        return sb.toString();
    }

}
