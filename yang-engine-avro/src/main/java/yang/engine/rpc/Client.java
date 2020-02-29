package yang.engine.rpc;

import example.avro.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Client {

    static  private Student student;

    public static void main(String[] args) throws IOException {
//        AvroSerializer avroSerializer = new AvroSerializer();
//        List<User> lists = new ArrayList<User>();
//        for (int i = 1; i < 1; i++) {
//            lists.add(new User("yang" + 1, i, "red" + i));
//        }
//        avroSerializer.serializeToFile(lists, "test.avro");
//
////        AvroDeserializer avroDeserializer = new AvroDeserializer();
////        avroDeserializer.deserialize("test.avro");

        student = getMock(new Student("yang"));
    }

    private static Student getMock(Student a) {
        return  new Student("yang");
    }

    static class Student {
        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
