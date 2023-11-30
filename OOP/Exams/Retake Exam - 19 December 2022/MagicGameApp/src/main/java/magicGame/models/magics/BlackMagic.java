package magicGame.models.magics;

public class BlackMagic extends MagicImpl{

    public BlackMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (getBulletsCount() - 10 < 0) {
            setBulletsCount(0);
            return 0;
        } else {
        int newBulletsCount = getBulletsCount() - 10;
        setBulletsCount(newBulletsCount);
        return 10;
        }
    }
}
