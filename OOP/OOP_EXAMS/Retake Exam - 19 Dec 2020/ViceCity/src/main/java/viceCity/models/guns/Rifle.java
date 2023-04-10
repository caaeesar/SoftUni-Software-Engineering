package viceCity.models.guns;

public class Rifle extends BaseGun {

    private static final int BULLETS_PER_BARREL = 50;
    private static final int CAPACITY = BULLETS_PER_BARREL;
    private static final int TOTAL_BULLETS = 500;
    private static final int SHOOT_BULLETS = 5;

    public Rifle(String name) {
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

        return SHOOT_BULLETS; // shoots 5 bullets
    }
}
