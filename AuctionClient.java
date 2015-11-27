import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class AuctionClient {

    private static final String commandList =
    "help - show commands\n" +
    "create - create listing (usage: name + enter + minimum value + enter + closing date as dd/mm/yyy hh:mm + enter)\n" +
    "list - List all the auctions\n" +
    "bid - Place a bid for an item (usage: auctionId + enter + bid as integer)\n" +
    "quit - Quit";

    public static void main(String[] args) {

        String reg_host = "localhost";
        int reg_port = 1099;

        if (args.length == 1) {
            reg_port = Integer.parseInt(args[0]);
        } else if (args.length == 2) {
            reg_host = args[0];
            reg_port = Integer.parseInt(args[1]);
        }

        try {
            System.out.println("Welcome to the auction system. Type \"help\" to see available options.");

            // Create the reference to the remote object through the rmiregistry
            AuctionSystem as = (AuctionSystem)
            // Naming.lookup("rmi://localhost/CalculatorService");
            Naming.lookup("rmi://" + reg_host + ":" + reg_port + "/CalculatorService");

            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.print(">> ");

                String command;

                if (!sc.hasNextLine()) {
                    sc.close();
                    return;
                }

                command = sc.nextLine();
                try {
                    if (command.startsWith("create")) {
                    }
                    else if (command.startsWith("help"))
                    System.out.println(commandList);
                    else if (command.startsWith("list"))
                    System.out.println(as.getAllListings());
                    else if (command.startsWith("bid")) {
                        System.out.print("auction id: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("bid sum: ");
                        int sum = Integer.parseInt(sc.nextLine());
                        System.out.println(as.bidItem(id, sum));
                    }
                    else if (command.startsWith("quit")) {
                        sc.close();
                        System.exit(0);
                    } else
                    System.err
                    .println("No such commands. Type \"help\" for usage.");
                } catch(Exception e) {}
            }

            // Here do what the interface allows
        }
        // Catch the exceptions that may occur - rubbish URL, Remote exception
        // Not bound exception or the arithmetic exception that may occur in
        // one of the methods creates an arithmetic error (e.g. divide by zero)
        catch (MalformedURLException murle) {
            System.out.println();
            System.out.println("MalformedURLException");
            System.out.println(murle);
        } catch (RemoteException re) {
            System.out.println();
            System.out.println("RemoteException");
            System.out.println(re);
        } catch (NotBoundException nbe) {
            System.out.println();
            System.out.println("NotBoundException");
            System.out.println(nbe);
        }
    }
}
