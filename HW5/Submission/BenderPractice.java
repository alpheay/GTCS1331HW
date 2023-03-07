public class BenderPractice {
    public static void main(String[] args) {
        WaterBender katara = new WaterBender("Katara", 80, 100, true);
        WaterBender mermaidman = new WaterBender("Mermaid Man");
        FireBender ace = new FireBender("Ace", 120, 20);
        FireBender mushu = new FireBender("Mushu");
        EarthBender whitebeard = new EarthBender("Whitebeard", 100, 80, true);
        System.out.println(katara);
        System.out.println(mushu);
        System.out.println(whitebeard);
        ace.attack(mermaidman);
        whitebeard.attack(mermaidman);
        katara.heal(mermaidman);
        mermaidman.attack(mushu);
        Bender[] b = {whitebeard, katara};
        mushu.flameCircle(b);
        katara.recover(5);
        System.out.println(katara);
        System.out.println(mushu);
        System.out.println(whitebeard);
        System.out.println(WaterBender.getWaterPoints());
        System.out.println(EarthBender.getEarthPoints());
        System.out.println(FireBender.getFirePoints());

    }

}
