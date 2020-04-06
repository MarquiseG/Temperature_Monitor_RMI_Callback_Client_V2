import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TemperatureMonitor extends UnicastRemoteObject implements TemperatureListener
{

    protected TemperatureMonitor() throws RemoteException
    {
    }

    public static void main(String[] args)
    {
        try
        {
            //Lookup for the service
            String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + ":52369/Hello";
            Remote lRemote = Naming.lookup(url);
            TemperatureServer lRemoteServer = (TemperatureServer) lRemote;

            //Display the current temperature
            System.out.println("Origin Temperature " + lRemoteServer.getTemperature());

            //Create a temperature monitor and register it as a Listener
            TemperatureMonitor lTemperatureMonitor = new TemperatureMonitor();
            lRemoteServer.addTemperatureListener(lTemperatureMonitor);

        }
        catch (Exception aInE)
        {
            System.out.println(aInE);
        }
    }

    @Override
    public void temperatureChanged(double temperature) throws RemoteException
    {
        System.out.println("Temperature change event " + temperature);
    }
}
