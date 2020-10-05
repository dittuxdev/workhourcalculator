package hours;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    static Calculator c = new Calculator();
    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        //todo: here consume calculate Week
        List<DateItem> items = new ArrayList<>();

        items.add(new DateItem(LocalDateTime.parse("2019-12-30 08:00", formatter), LocalDateTime.parse("2019-12-30 19:00", formatter)));
        items.add(new DateItem(LocalDateTime.parse("2019-12-31 08:00", formatter), LocalDateTime.parse("2019-12-31 19:00", formatter)));
        items.add(new DateItem(LocalDateTime.parse("2020-01-01 20:00", formatter), LocalDateTime.parse("2020-01-02 07:00", formatter)));
        items.add(new DateItem(LocalDateTime.parse("2020-01-03 08:00", formatter), LocalDateTime.parse("2020-01-03 19:00", formatter)));

        AggregatedHoursForPeriod h = c.calculate(filteredForWeek(1, items));
    }

    private static List<DateItem> filteredForWeek(int weekNumber, List<DateItem> dateItems) {
        final LocalDateTime firstDay = LocalDateTime.now()
                .with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, weekNumber)
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

        final LocalDateTime lastDay = LocalDateTime.now()
                .with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, weekNumber)
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));

        return dateItems.stream().filter(new Predicate<DateItem>() {
            @Override
            public boolean test(DateItem item) {
                return item.initDate.isAfter(firstDay) && item.endDate.isBefore(lastDay);
            }
        }).collect(Collectors.toList());
    }
}
