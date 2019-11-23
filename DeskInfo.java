import java.util.*;
import java.lang.*;
import java.net.*;

public class DeskInfo {

    public static void main(String[] args) throws SocketException {
        System.out.println("Hello User");
        
        Properties java = System.getProperties(); 
        java.list(System.out); 
        System.out.println();

            Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
            NetworkInterface inter;
            while (networks.hasMoreElements()) {
                inter = networks.nextElement();
                byte[] mac = inter.getHardwareAddress();
                    if (mac != null) {
                        for (int i = 0; i < mac.length; i++) {
                            System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
                        }
                    System.out.println("");
                    }
                }
        
        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        
        for (NetworkInterface netint : Collections.list(nets))
            displayInterfaceInformation(netint);

        /* speedtester(); */

    }

     static void displayInterfaceInformation(NetworkInterface netint) throws SocketException {
        System.out.printf("Display name: %s\n", netint.getDisplayName());
        System.out.printf("Name: %s\n", netint.getName());
        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
            System.out.printf("InetAddress: %s\n", inetAddress);
        }
        System.out.printf("\n");
     }


    /* 
     static void speedtester(){
        TODO: actualmente las funciones de obtencion de ancho de banda y otras especificaciones mas completas se encuentrasn desarrolladas...
        por un equipo? que se llama OSHI y sus paquetes de librerias proveen de las herramientas y codigos para obtener tales datos
        la info se encuentra en la linea 57
     }

        All the resources for system propieties come from: https://www.geeksforgeeks.org/getproperty-and-getproperties-methods-of-system-class-in-java/ 
        the mac addres code come from https://gist.github.com/timendum/1109057 with added SocketExcpetion 
        the name of the networks adapters come from https://docs.oracle.com/javase/tutorial/networking/nifs/listing.html       
        for a more complete system output is there a library from https://github.com/oshi/oshi or https://raw.githubusercontent.com/oshi/oshi/master/oshi-core/src/test/java/oshi/SystemInfoTest.java 

        */ 
        
        
    

}