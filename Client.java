import java.rmi.RMISecurityManager;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.net.MalformedURLException;

public class Client{

	public Client(){

	}



public static void main(String [] args){
// 1. If there is no security manager, start one
	//if (System.getSecurityManager() == null) {
	//System.setSecurityManager(new RMISecurityManager());
	//}
	
	try{
	Remote service = Naming.lookup("//127.0.0.1:1099/echo");
	EchoService echoService = (EchoService) service;
	String receivedEcho = echoService.echo("Hello!");
	}catch(NotBoundException ex){
		ex.printStackTrace();
	}catch(RemoteException ex){
		ex.printStackTrace();
	}catch(MalformedURLException ex){
		ex.printStackTrace();
	}

	
}

}