package yang.engine.rpc.avro.protocol;

import org.apache.avro.AvroRemoteException;
import org.apache.avro.ipc.NettyServer;
import org.apache.avro.ipc.specific.SpecificResponder;
import org.gbif.ecat.ws.NubLookup;
import org.gbif.ecat.ws.Request;
import org.gbif.ecat.ws.Response;

import java.net.InetSocketAddress;

public class Server {

    private  NettyServer server;

    public void start() throws InterruptedException {
        server = new NettyServer(new SpecificResponder(
                NubLookup.class,
                new Server.NubLookupImpl()),
                new InetSocketAddress(7001));
        server.start();
        server.join();
    }

    public static void main(String[] args) throws InterruptedException {
        Server server = new Server();
        server.start();
    }


    // A mock implementation
    public static class NubLookupImpl implements NubLookup {
        public Response send(Request request) throws AvroRemoteException {
            Response r = new Response();
            r.kingdomId = 100;
            return r;
        }
    }

}
