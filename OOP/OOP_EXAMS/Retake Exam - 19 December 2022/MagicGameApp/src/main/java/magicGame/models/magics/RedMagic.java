package magicGame.models.magics;

public class RedMagic extends MagicImpl {

    public RedMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
       if (getBulletsCount() - 1 < 0) {
           setBulletsCount(0);
           return 0;
       } else {
       int newBulletsCount =  getBulletsCount() - 1;
       setBulletsCount(newBulletsCount);
       return 1;
       }
    }
}
