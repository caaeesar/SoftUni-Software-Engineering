package fairyShop.models;

import static fairyShop.common.ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO;

public class InstrumentImpl implements Instrument {

    private int power;

    public InstrumentImpl(int power) {
        this.setPower(power);
    }

    private void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException(INSTRUMENT_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public void use() {
        int currentPower = this.getPower() - 10;
        if (currentPower < 0){
            currentPower = 0;
        }
        this.setPower(currentPower);
    }

    @Override
    public boolean isBroken() {
        return this.getPower() == 0;
    }
}
