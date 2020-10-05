package hours;

import java.time.DayOfWeek;

public class Agenda {
    public static boolean isSundayOrHoliday(DateItem item) {
        if (item.initDate.getDayOfWeek() == DayOfWeek.SUNDAY) return true;
        // other rule to determine Holiday
        return false;
    }
}
