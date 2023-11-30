package WorkingWithAbstraction.lab.HotelReservation;

public enum Discount {
    None(0),
    SecondVisit(10),
    VIP(20);

    int percent;

    private Discount(int percent) {
        this.percent = percent;
    }

}
