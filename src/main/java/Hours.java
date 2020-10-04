public class Hours {
    private long normal;
    private long night;
    private long sunday;
    private long extraNormal;
    private long extraNight;
    private long extraSunday;
    private long total;

    public Hours() {
    }

    public long getNormal() {
        return normal;
    }

    public void setNormal(long normal) {
        this.normal += normal;
    }

    public long getNight() {
        return night;
    }

    public void setNight(long night) {
        this.night += night;
    }

    public long getSunday() {
        return sunday;
    }

    public void setSunday(long sunday) {
        this.sunday += sunday;
    }

    public long getExtraNormal() {
        return extraNormal;
    }

    public void setExtraNormal(long extraNormal) {
        this.extraNormal += extraNormal;
    }

    public long getExtraNight() {
        return extraNight;
    }

    public void setExtraNight(long extraNight) {
        this.extraNight += extraNight;
    }

    public long getExtraSunday() {
        return extraSunday;
    }

    public void setExtraSunday(long extraSunday) {
        this.extraSunday += extraSunday;
    }

    public Long total() {
        this.total = this.night + this.normal + this.sunday + this.extraNormal + this.extraNight + this.extraSunday;
        return total;
    }

    public long getTotal() {
        return total;
    }
}
