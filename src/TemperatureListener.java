import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TemperatureListener extends Remote
{
    void temperatureChanged(double temperature) throws RemoteException;
}
