package yang.engine.rpc.avro.protocol;

import org.apache.avro.AvroRemoteException;
import org.apache.avro.ipc.NettyTransceiver;
import org.apache.avro.ipc.specific.SpecificRequestor;
import org.apache.avro.util.Utf8;
import org.gbif.ecat.ws.NubLookup;
import org.gbif.ecat.ws.Request;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Client {

    private NettyTransceiver client;
    private NubLookup proxy;

    public Client(int port) throws IOException {
        client = new NettyTransceiver(
                new InetSocketAddress(port));
    }

    public void send(String data) throws AvroRemoteException, IOException {

        proxy = (NubLookup) SpecificRequestor.getClient(NubLookup.class, client);
        Request req = new Request();
        req.name = new Utf8(data);
        System.out.println("Result: " + proxy.send(req).kingdomId);

    }

    public static void main(String[] args) throws IOException, AvroRemoteException {
        Client client = new Client(7001);
        client.send("huyang");
    }

}
