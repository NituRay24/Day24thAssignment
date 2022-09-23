public class Hotel {
    enum Customer {
        REWORD,REGULAR
    }

    Customer customerType;
    private String hotelName;
    private int rating;
    private int weekDayRate;
    private int weekEndRate;

    public Customer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Customer customerType) {
        this.customerType = customerType;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getWeekDayRate() {
        return weekDayRate;
    }

    public void setWeekDayRate(int weekDayRate) {
        this.weekDayRate = weekDayRate;
    }

    public int getWeekEndRate() {
        return weekEndRate;
    }

    public void setWeekEndRate(int weekEndRate) {
        this.weekEndRate = weekEndRate;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "customerType=" + customerType +
                ", hotelName='" + hotelName + '\'' +
                ", rating=" + rating +
                ", weekDayRate=" + weekDayRate +
                ", weekEndRate=" + weekEndRate +
                '}';
    }
}
