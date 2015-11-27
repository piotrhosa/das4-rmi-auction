import java.rmi.Naming;

public class AuctionServer {

    static int port = 1099;

    public AuctionServer() {
        try {
            AuctionSystem as = new AuctionImpl();
            Naming.rebind("rmi://localhost:" + port + "/CalculatorService", as);
        } catch (Exception e) {
            System.out.println("Server Error: " + e);
        }
    }

    public static void main(String args[]) {
        //Create the new Calculator server
        if (args.length == 1)
            port = Integer.parseInt(args[0]);

        new AuctionServer();
    }


}
