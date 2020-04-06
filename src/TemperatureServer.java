import java.rmi.Remote;
import java.rmi.RemoteException;

interface TemperatureServer extends Remote
{

    void addTemperatureListener(TemperatureListener addTemperatureListener) throws RemoteException;

    void removeTemperatureListener(TemperatureListener addTemperatureListener) throws RemoteException;

    Double getTemperature() throws RemoteException;
}
