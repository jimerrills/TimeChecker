import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.management.monitor.StringMonitor;

import java.time.LocalTime;

public class TimeManager {
    //TODO: Get time based on  timezone entry
    //public String getTime(String timezone) {
    //    return time;
    //}

    public static Set<String> getTimeZonesInList() {
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        return zoneIds;
    }

    public static String getTime(String timezone) {
        LocalTime time = java.time.LocalTime.now(ZoneId.of(timezone));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

        return dtf.format(time);

    }
}
