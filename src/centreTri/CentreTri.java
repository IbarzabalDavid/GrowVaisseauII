package centreTri;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import main.Main;
import matiere.*;
import vaisseaux.Vaisseau;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 * Created by ibada1731710 on 2018-04-26.
 */
public class CentreTri{
    private int qMax=50;
    private Queue<Vaisseau> vaissoLine= new LinkedList<Vaisseau>() {};
    private Stack<Materiaux> stackPlut= new Stack<>();
    private Stack<Materiaux> stackGad= new Stack<>();
    private Stack<Materiaux> stackTerb= new Stack<>();
    private Stack<Materiaux> stackThul= new Stack<>();
    private Stack<Materiaux> stackNep= new Stack<>();

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
        int that=vaisso.getContenu().size();
        for (int i=0;i<that;i++){
            if (vaisso.getContenu().get(i).getNom().equals("plutonium")){
                stackPlut.add(vaisso.getContenu().get(i));
                if (stackPlut.size()==qMax){
                    recycler(new Plut(), vaissoLine.poll(),stackPlut);
                }
            }
            else  if (vaisso.getContenu().get(i).getNom().equals("neptium")){
                stackNep.add(vaisso.getContenu().get(i));
                if (stackNep.size()==qMax){
                    recycler(new Nep(), vaissoLine.poll(),stackNep);
                }
            }
            else if (vaisso.getContenu().get(i).getNom().equals("terbium")){
                stackTerb.add(vaisso.getContenu().get(i));
                if (stackTerb.size()==qMax){
                    recycler(new Terb(), vaissoLine.poll(),stackTerb);
                }
            }
            else if (vaisso.getContenu().get(i).getNom().equals("thulium")){
                stackThul.add(vaisso.getContenu().get(i));
                if (stackThul.size()==qMax){
                    recycler(new Thul(), vaissoLine.poll(),stackThul);
                }
            }
            else if(vaisso.getContenu().get(i).getNom().equals("gadolinium")){
                stackGad.add(vaisso.getContenu().get(i));
                if (stackGad.size()==qMax){
                    recycler(new Gad(), vaissoLine.poll(),stackGad);
                }
            }
        }
        vaisso.getContenu().clear();
    }

    public void recycler(Materiaux materiaux,Vaisseau vaisso, Stack<Materiaux> stack){
        int matRecy= (materiaux.getPourcentageRecyclabe()*qMax/100);
        int i=0;
        while (i<matRecy){
            vaisso.getContenu().add(materiaux);
            stack.pop();
            i++;
            if (vaisso.getCapacite()==i){
                vaisso.go(Main.next(this));
                i=matRecy;
            }

        }
        vaisso.go(Main.next(this));

    }
}
