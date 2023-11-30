package viceCity.models.guns;

public class Pistol extends BaseGun {

    private static final int BULLETS_PER_BARREL = 10;
    private static final int CAPACITY = BULLETS_PER_BARREL;
    private static final int TOTAL_BULLETS = 100;
    private static final int SHOOT_BULLETS = 1;

    public Pistol(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {

        if (this.getBulletsPerBarrel() >= SHOOT_BULLETS) {
            this.setBulletsPerBarrel(this.getBulletsPerBarrel() - SHOOT_BULLETS);
        } else { // empty bullet
            // reloading
            this.setBulletsPerBarrel(CAPACITY); // full
            this.setTotalBullets(this.getTotalBullets() - CAPACITY); // take
            this.setBulletsPerBarrel(this.getBulletsPerBarrel() - SHOOT_BULLETS); // shoots
        }

       return SHOOT_BULLETS; // shoots 1 bullet
    }
}
