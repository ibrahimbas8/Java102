public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("------------------------------------------");
        System.out.println("Güvenli evdeyiz");
        System.out.println("Can yenilendi");
        this.getPlayer().setHealth(getPlayer().getMaxHealth());
        return true;
    }
}
