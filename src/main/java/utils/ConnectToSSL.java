package utils;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.util.Properties;

/**
 * Created by bill.witt on 11/7/2016.
 */
public class ConnectToSSL {

    public static void connectToSSHTunnel() throws Exception{
        String host = "10.119.7.146";
        String user = "devappsadmin";
        String password="20-sided die";
        int port = 22;

        int tunnelLocalPort = 9080;
        String tunnelRemoteHost = "10.119.7.146";
        int tunnelRemotePort = 80;

        JSch jsch = new JSch();
        Session session = jsch.getSession(user, host, port);
        session.setPassword(password);
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();
        session.setPortForwardingL(tunnelLocalPort,tunnelRemoteHost,tunnelRemotePort);
        System.out.println("Connected");
    }

}
