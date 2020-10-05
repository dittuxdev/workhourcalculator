package hours.rules;

import hours.AggregatedHoursForPeriod;
import hours.DateItem;

import java.util.List;

public interface AggregateRule {
    void aggregateHours(List<DateItem> dateItems, AggregatedHoursForPeriod hoursForPeriod);
}
