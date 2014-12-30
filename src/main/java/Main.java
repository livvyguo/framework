import com.google.common.math.IntMath;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by livvy on 14-4-24.
 */
public class Main {

    public static class Test{
        private int id;
        private String name;
    }
    public static final String DELIMITER = ",";

    public static void main(String[] args) throws IOException {



        Field[] fields = Test.class.getDeclaredFields();
        List<Field> ff = Arrays.asList(fields);
//        System.out.println("sss");
        ArrayList<String> list  = new ArrayList<String>();
        list.add("q");
//        list.add("w");
//        list.add("d");
//        list.add("z");
//        list.add("a");


        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0,len = list.size(); i < list.size(); i++) {
            stringBuilder.append(list.get(i)).append(DELIMITER);
        }



        System.out.println(stringBuilder.subSequence(0,stringBuilder.length() > 0 ? stringBuilder.lastIndexOf(DELIMITER) : 0));

        String []s = {};
        System.out.println(s);

        System.out.println(UUID.randomUUID());
//        ExecutorService service = Executors.newCachedThreadPool();
//
//        service.execute(new Run());
//        service.execute(new Run());
//        service.execute(new Run());
//        service.execute(new Run());
//        service.execute(new Run());
//        service.execute(new Run());

/*
        SpelExpressionParser parser = new SpelExpressionParser();
        int value = (Integer) parser.parseExpression("0x7FFFFFF").getValue();

        System.out.println(value);

        T t = new T();

        System.out.println(t.getId());

        Maps.newLinkedHashMap();
*/
        int mean = IntMath.mean(1, 12);
        System.out.println(mean);
        System.out.println("jj");


        FileUtils.writeLines(new File(""),Arrays.asList("1","2"));

    }

    public static class Run implements  Runnable {


        public void run() {
            for (int i = 0; i < 10; i++) {
                String name = Thread.currentThread().getName();
                System.out.println(name + " : " +  i);
            }
        }


    }

    public static class T {
        public final static int  XX = 100;
        private int id;
        public T() {
            id = XX;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
