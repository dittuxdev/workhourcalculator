package hours;

import hours.rules.AggregateNormalHours;
import hours.rules.AggregateRule;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<AggregateRule> rules = new ArrayList<>();

    public static enum HourType {NORMAL, EXTRA}

    public Calculator() {
        rules.add(new AggregateNormalHours());
        //
        //
    }

    public static int getMinuteInDay(LocalDateTime dateTime) {
        return dateTime.getHour()*60+dateTime.getMinute();
    }

//    @Override
//    public long nightHours(LocalDateTime init, LocalDateTime end) {
//        if (init.getDayOfWeek().getValue() == 7) return 0;
//
//        LocalDateTime start = LocalDateTime.of(init.getYear(), init.getMonth(), init.getDayOfMonth(), 18, 0);
//        LocalDateTime finish = LocalDateTime.of(init.getYear(), init.getMonth(), init.getDayOfMonth(), 7, 0);
//        finish.plusDays(1);
//
//        if (init.isBefore(start)) init = start;
//        if (end.isAfter(finish)) end = finish;
//
//        return (Math.abs(Duration.between(init, end).getSeconds())/3600);
//    }
//
//    @Override
//    public long sundaylHours(LocalDateTime init, LocalDateTime end) {
//
//        if (init.getDayOfWeek().getValue() != 7) return 0;
//
//        LocalDateTime start = LocalDateTime.of(init.getYear(), init.getMonth(), init.getDayOfMonth(), 8, 0);
//        LocalDateTime finish = LocalDateTime.of(init.getYear(), init.getMonth(), init.getDayOfMonth(), 23, 0);
//
//        if (init.isBefore(start)) init = start;
//        if (end.isAfter(finish)) end = finish;
//
//
//        return (Math.abs(Duration.between(init, end).getSeconds())/3600);
//    }
//
//    @Override
//    public long normalExtraHours(LocalDateTime init, LocalDateTime end, int totalHours) {
//        if (totalHours < 48) return 0;
//        return normalHours(init, end);
//    }
//
//    @Override
//    public long nightExtraHours(LocalDateTime init, LocalDateTime end, int totalHours) {
//        if (totalHours < 48) return 0;
//        return nightHours(init, end);
//    }
//
//    @Override
//    public long sundayExtraHours(LocalDateTime init, LocalDateTime end, int totalHours) {
//        if (totalHours < 48) return 0;
//        return sundaylHours(init, end);
//    }

    public AggregatedHoursForPeriod calculate(List<DateItem> filteredForWeek) {
        AggregatedHoursForPeriod hoursForPeriod = new AggregatedHoursForPeriod();
        for (AggregateRule rule: rules) {
            rule.aggregateHours(filteredForWeek, hoursForPeriod);
        }
        return hoursForPeriod;
    }
}
