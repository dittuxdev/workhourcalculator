package hours;

import java.time.LocalDateTime;

public interface CalculateHoursStrategy {

    long normalHours(LocalDateTime init, LocalDateTime end);
    long nightHours(LocalDateTime init, LocalDateTime end);
    long sundaylHours(LocalDateTime init, LocalDateTime end);
    long normalExtraHours(LocalDateTime init, LocalDateTime end, int totalHours);
    long nightExtraHours(LocalDateTime init, LocalDateTime end, int totalHours);
    long sundayExtraHours(LocalDateTime init, LocalDateTime end, int totalHours);

}
