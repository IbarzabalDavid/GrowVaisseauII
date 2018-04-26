import vaisseaux.Vaisseau;
import java.util.Queue;


/**
 * Created by ibada1731710 on 2018-04-26.
 */
public class CentreTri {
    private int qMax=50;
    private Queue<Vaisseau> vaissoLine;
    private int qPlut;
    private int qTer;
    private int qGad;
    private int qNep;
    private int qThul;

    public int getqMax() {
        return qMax;
    }

    public void setqMax(int qMax) {
        this.qMax = qMax;
    }

    public Queue<Vaisseau> getVaissoLine() {
        return vaissoLine;
    }

    public void setVaissoLine(Queue<Vaisseau> vaissoLine) {
        this.vaissoLine = vaissoLine;
    }

    public int getqPlut() {
        return qPlut;
    }

    public void setqPlut(int qPlut) {
        this.qPlut = qPlut;
    }

    public int getqTer() {
        return qTer;
    }

    public void setqTer(int qTer) {
        this.qTer = qTer;
    }

    public int getqGad() {
        return qGad;
    }

    public void setqGad(int qGad) {
        this.qGad = qGad;
    }

    public int getqNep() {
        return qNep;
    }

    public void setqNep(int qNep) {
        this.qNep = qNep;
    }

    public int getqThul() {
        return qThul;
    }

    public void setqThul(int qThul) {
        this.qThul = qThul;
    }

}
