package co.uk.jamiemerrills.src;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import co.uk.jamiemerrills.src.TimeManager;
import co.uk.jamiemerrills.src.FrameManager;

import java.time.LocalTime;

public class TimeManager {
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
