import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static Calculator c = new Calculator();
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime ldt = LocalDateTime.parse("2020-10-04 08:00", formatter);

        //todo: here consume calculate Week
        List<DateItem> items = new ArrayList<>();

        items.add(new DateItem(LocalDateTime.parse("2019-12-30 08:00", formatter), LocalDateTime.parse("2019-12-30 19:00", formatter)));
        items.add(new DateItem(LocalDateTime.parse("2019-12-31 08:00", formatter), LocalDateTime.parse("2019-12-31 19:00", formatter)));
        items.add(new DateItem(LocalDateTime.parse("2020-01-01 20:00", formatter), LocalDateTime.parse("2020-01-02 07:00", formatter)));
        items.add(new DateItem(LocalDateTime.parse("2020-01-03 08:00", formatter), LocalDateTime.parse("2020-01-03 19:00", formatter)));

        calculateWeek(1, items);

    }

    /**
     *
     * @param weekNumber
     * @param dates
     * @return an object with hours calculation.
     */
    public static Hours calculateWeek(int weekNumber, List<DateItem> dates) {
        LocalDateTime firstDay = LocalDateTime.now()
                .with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, weekNumber)
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

        LocalDateTime lastDay = LocalDateTime.now()
                .with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, weekNumber)
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
        Hours h = new Hours();

        for (DateItem item: dates) {
            if (item.initDate.isAfter(firstDay) && item.initDate.isAfter(firstDay) && item.endDate.isAfter(lastDay) && item.endDate.isAfter(lastDay)) {
                h.setNormal(c.normalHours(item.initDate, item.endDate));
                h.setNight(c.nightHours(item.initDate, item.endDate));
                h.setSunday(c.sundaylHours(item.initDate, item.endDate));
                h.setExtraNormal(c.normalExtraHours(item.initDate, item.endDate, h.total().intValue()));
                h.setExtraNight(c.nightExtraHours(item.initDate, item.endDate, h.total().intValue()));
                h.setExtraSunday(c.sundayExtraHours(item.initDate, item.endDate, h.total().intValue()));
            }
        }

        return h;
    }
}
