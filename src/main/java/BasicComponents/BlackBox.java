package BasicComponents;
import Configuration.*;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BlackBox {

    public PrintStream stream;
    public DateTimeFormatter dateTimeFormatter;
    public LocalDateTime localDateTime;

    public String localDateTimeString;

    public  BlackBox(){
        try {
            stream=new PrintStream(Configuration.INSTANCE.filename);
        }
        catch (Exception e){
            e.getStackTrace();
        }
        dateTimeFormatter = DateTimeFormatter.ofPattern(Configuration.INSTANCE.dateTimeFormat);
    }

    public String getLocalDateTime(){
        localDateTime=LocalDateTime.now();
        return localDateTimeString=dateTimeFormatter.format(localDateTime);
    }

    public void streamToFile(){
        System.setOut(stream);
    }

}
