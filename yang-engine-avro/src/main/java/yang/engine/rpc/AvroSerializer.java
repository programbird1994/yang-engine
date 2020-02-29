package yang.engine.rpc;

import example.avro.User;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AvroSerializer {


    public  void serializeToFile(List<User> users, String location) throws IOException {
        DatumWriter<User> datumWriter = new SpecificDatumWriter<>(User.class);
        DataFileWriter<User> dataFileWriter = new DataFileWriter<>(datumWriter);
        dataFileWriter.create(User.getClassSchema(),new File(location));
        for(User user : users) {
            dataFileWriter.append(user);
        }
        dataFileWriter.close();
    }


}
