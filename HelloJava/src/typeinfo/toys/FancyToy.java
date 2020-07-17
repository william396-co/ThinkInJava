package typeinfo.toys;

public class FancyToy extends Toy implements HasBatteries, WaterProof, Shoots {
    FancyToy() {
        super(1);
    }
}