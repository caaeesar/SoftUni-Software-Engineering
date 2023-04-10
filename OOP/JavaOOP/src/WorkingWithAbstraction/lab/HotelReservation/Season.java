package WorkingWithAbstraction.lab.HotelReservation;

public enum Season {
    Spring(2),
    Summer(4),
    Autumn(1),
    Winter(3);

    int multiplier;

    private Season(int multiplier){
        this.multiplier = multiplier;
    }
}
