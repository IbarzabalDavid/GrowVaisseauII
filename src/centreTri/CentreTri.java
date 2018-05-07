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
        try {
            int that=vaisso.getContenu().size();
            for (int i=0;i<that;i++){
                if (vaisso.getContenu().get(i).getNom().equals("plutonium")){
                    stackPlut.add(vaisso.getContenu().get(i));
                    if (stackPlut.size()>=qMax){
                        recycler(new Plut(), vaissoLine.poll(),vaissoLine.peek(),stackPlut);
                    }
                }
                else  if (vaisso.getContenu().get(i).getNom().equals("neptium")){
                    stackNep.add(vaisso.getContenu().get(i));
                    if (stackNep.size()>=qMax){
                        recycler(new Nep(), vaissoLine.poll(),vaissoLine.peek(),stackNep);
                    }
                }
                else if (vaisso.getContenu().get(i).getNom().equals("terbium")){
                    stackTerb.add(vaisso.getContenu().get(i));
                    if (stackTerb.size()>=qMax){
                        recycler(new Terb(), vaissoLine.poll(),vaissoLine.peek(),stackTerb);
                    }
                }
                else if (vaisso.getContenu().get(i).getNom().equals("thulium")){
                    stackThul.add(vaisso.getContenu().get(i));
                    if (stackThul.size()>=qMax){
                        recycler(new Thul(), vaissoLine.poll(),vaissoLine.peek(),stackThul);
                    }
                }
                else if(vaisso.getContenu().get(i).getNom().equals("gadolinium")){
                    stackGad.add(vaisso.getContenu().get(i));
                    if (stackGad.size()>=qMax){
                        recycler(new Gad(), vaissoLine.poll(),vaissoLine.peek(),stackGad);
                    }
                }
            }
            vaisso.getContenu().clear();
        }catch (Exception oob){
            System.out.println("Il n'y a plus de vaisseau dans le centre de tri.");
            Main.fini=true;
        }



    }

    public void recycler(Materiaux materiaux,Vaisseau vaisso,Vaisseau vaisso2, Stack<Materiaux> stack){
        try {
            int matRecy= (materiaux.getPourcentageRecyclabe()*qMax/100);
            int i=0;
            boolean blabla1=false;
            while (i<matRecy){
                vaisso.getContenu().add(materiaux);
                stack.pop();
                i++;
                if (vaisso.getCapacite()==i && i!=matRecy){
                    while (i<matRecy){
                        vaisso2.getContenu().add(materiaux);
                        stack.pop();
                        i++;
                        vaissoLine.poll();
                        vaisso2.go(Main.next(this));

                    }
                }

            }
        }catch (Exception oob){
            System.out.println("Il n'y a plus de vaisseau dans le centre de tri.");
            Main.fini=true;
        }


        vaisso.go(Main.next(this));



    }
}