package hours;

public class AggregatedHoursForPeriod {
    private double normal;
    private double night;
    private double sunday;
    private double extraNormal;
    private double extraNight;
    private double extraSunday;
    private double total;

    public AggregatedHoursForPeriod() {
    }

    public double getNormal() {
        return normal;
    }

    public void setNormal(double normal) {
        this.normal += normal;
    }

    public double getNight() {
        return night;
    }

    public void setNight(double night) {
        this.night += night;
    }

    public double getSunday() {
        return sunday;
    }

    public void setSunday(double sunday) {
        this.sunday += sunday;
    }

    public double getExtraNormal() {
        return extraNormal;
    }

    public void setExtraNormal(double extraNormal) {
        this.extraNormal += extraNormal;
    }

    public double getExtraNight() {
        return extraNight;
    }

    public void setExtraNight(double extraNight) {
        this.extraNight += extraNight;
    }

    public double getExtraSunday() {
        return extraSunday;
    }

    public void setExtraSunday(double extraSunday) {
        this.extraSunday += extraSunday;
    }

    public double total() {
        this.total = this.night + this.normal + this.sunday + this.extraNormal + this.extraNight + this.extraSunday;
        return total;
    }

    public double getTotal() {
        return total;
    }
}
