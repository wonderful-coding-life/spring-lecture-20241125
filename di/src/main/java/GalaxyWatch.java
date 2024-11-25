import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class GalaxyWatch implements Watch {
    public String getDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
    }
    public String getTime() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("hh시 mm분 ss초"));
    }
}
