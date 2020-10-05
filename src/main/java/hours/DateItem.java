package hours;

import java.time.LocalDateTime;

public class DateItem {
    LocalDateTime initDate;
    LocalDateTime endDate;

    public DateItem() {
    }

    public DateItem(LocalDateTime initDate, LocalDateTime endDate) {
        this.initDate = initDate;
        this.endDate = endDate;
    }

    public LocalDateTime getInitDate() {
        return initDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }
}
