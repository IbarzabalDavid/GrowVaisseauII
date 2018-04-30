package centreTri;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import matiere.Gad;
import matiere.Materiaux;
import vaisseaux.Vaisseau;

import java.io.Serializable;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;


/**
 * Created by ibada1731710 on 2018-04-26.
 */
public class CentreTri{
    private int qMax=50;
    private Queue<Vaisseau> vaissoLine;
    private Stack<Materiaux> stackPlut;
    private Stack<Materiaux> stackGad;
    private Stack<Materiaux> stackTerb;
    private Stack<Materiaux> stackThul;
    private Stack<Materiaux> stackNep;

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

    public Stack<Materiaux> getStackPlut() {
        return stackPlut;
    }

    public void setStackPlut(Stack<Materiaux> stackPlut) {
        this.stackPlut = stackPlut;
    }

    public Stack<Materiaux> getStackGad() {
        return stackGad;
    }

    public void setStackGad(Stack<Materiaux> stackGad) {
        this.stackGad = stackGad;
    }

    public Stack<Materiaux> getStackTerb() {
        return stackTerb;
    }

    public void setStackTerb(Stack<Materiaux> stackTerb) {
        this.stackTerb = stackTerb;
    }

    public Stack<Materiaux> getStackThul() {
        return stackThul;
    }

    public void setStackThul(Stack<Materiaux> stackThul) {
        this.stackThul = stackThul;
    }

    public Stack<Materiaux> getStackNep() {
        return stackNep;
    }

    public void setStackNep(Stack<Materiaux> stackNep) {
        this.stackNep = stackNep;
    }

    public void viderVaisso(Vaisseau vaisso){
        for (int i=0;i<vaisso.getCapacite();i++){
            if (vaisso.getContenu().get(i).getNom().equals("plutonium")){
                stackPlut.add(vaisso.getContenu().get(i));
            }
            else  if (vaisso.getContenu().get(i).getNom().equals("neptium")){
                stackNep.add(vaisso.getContenu().get(i));
            }
            else if (vaisso.getContenu().get(i).getNom().equals("terbium")){
                stackTerb.add(vaisso.getContenu().get(i));
            }
            else if (vaisso.getContenu().get(i).getNom().equals("thulium")){
                stackThul.add(vaisso.getContenu().get(i));
            }
            else if(vaisso.getContenu().get(i).getNom().equals("gadolinium")){
                stackGad.add(vaisso.getContenu().get(i));
            }
        }
        vaisso.getContenu().clear();
    }

    public void recycler(Materiaux materiaux){

    }
}
