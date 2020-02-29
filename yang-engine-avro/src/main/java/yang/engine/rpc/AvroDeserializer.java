package yang.engine.rpc;

import example.avro.User;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;

import java.io.File;
import java.io.IOException;

public class AvroDeserializer {


    public  void deserialize(String location) throws IOException {
        User test = null;
        File file = new File(location);
        DatumReader<User> userDatumWriter = new SpecificDatumReader<>(User.class);
        DataFileReader<User> userDataFileReader = new DataFileReader<User>(file, userDatumWriter);
        while (userDataFileReader.hasNext()) {
            test = userDataFileReader.next(test);
            System.out.println(test);
        }
    }
}
