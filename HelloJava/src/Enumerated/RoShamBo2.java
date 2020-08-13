package Enumerated;

import static Enumerated.Outcome.*;

public enum  RoShamBo2 implements Competitor<RoShamBo2> {

    PAPER(DRAW,LOSE,WIN),
    SCISSORS(WIN,DRAW,LOSE),
    ROCK(WIN,DRAW,LOSE);

    private Outcome vPAPER,vSCISSOR,vROCK;
    RoShamBo2(Outcome vPAPER,Outcome vSCISSOR,Outcome vROCK)
    {
        this.vPAPER = vPAPER;
        this.vSCISSOR = vSCISSOR;
        this.vROCK = vROCK;
    }
    @Override
    public Outcome compete(RoShamBo2 Competitor) {
        switch (Competitor)
        {
            default:
            case ROCK:return vROCK;
            case PAPER:return vPAPER;
            case SCISSORS:return vSCISSOR;
        }
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo2.class,20);
    }
}
