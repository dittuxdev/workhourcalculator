package hours.rules;

import hours.Agenda;
import hours.AggregatedHoursForPeriod;
import hours.DateItem;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class AggregateNormalHours implements AggregateRule {
    final int startHourNormal = 7;
    final int endHourNormal = 19;

    @Override
    public void aggregateHours(List<DateItem> dateItems, AggregatedHoursForPeriod aggregatedHoursForPeriod) {
        double result = 0;
        // exclude domingos y festivos
        for (DateItem dateItem: dateItems) {
            if (Agenda.isSundayOrHoliday(dateItem)) continue;

            LocalDateTime limitStart = LocalDateTime.of(
                    dateItem.getInitDate().getYear(),
                    dateItem.getInitDate().getMonth(),
                    dateItem.getInitDate().getDayOfMonth(), startHourNormal, 0);
            LocalDateTime limitUpper = LocalDateTime.of(
                    dateItem.getInitDate().getYear(),
                    dateItem.getInitDate().getMonth(),
                    dateItem.getInitDate().getDayOfMonth(), endHourNormal, 0);

            LocalDateTime start = dateItem.getInitDate().isBefore(limitStart) ? limitStart : dateItem.getInitDate();
            LocalDateTime end = dateItem.getEndDate().isAfter(limitUpper) ? limitUpper : dateItem.getEndDate();

            result += (Math.abs(Duration.between(start, end).getSeconds())/3600);
        }
        aggregatedHoursForPeriod.setNormal(result);
    }
}
