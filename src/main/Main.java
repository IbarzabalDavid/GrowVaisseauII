package main;

import centreTri.CentreTri;
import planetes.*;
import vaisseaux.Light;
import vaisseaux.Lourd;
import vaisseaux.Normal;
import vaisseaux.Vaisseau;

import java.util.LinkedList;

/**
 * Created by ibada1731710 et pagni1731620 on 2018-04-26.
 */
public class Main {
    public static boolean fini=false;
    public static LinkedList<CentreTri> tabC=new LinkedList<>();
    public static void main(String[] args) {

        Vaisseau tabV[]=new Vaisseau[30];

        for (int i=0;i<tabV.length;i++){
            int sa=(int)(Math.random()*3)+1;
            if (sa==1){
                tabV[i]=new Light();
            }
            else if (sa==2){
                tabV[i]=new Normal();
            }
            else if (sa==3) {
                tabV[i]=new Lourd();
            }
        }
        for (int i=0;i<100;i++){
            tabC.add(new CentreTri());
        }

        int nb=0;
        while (!fini){
            tabV[nb].remplir(getRandomPlanet());
            tabV[nb].go(tabC.get(0));
            nb++;
            if (nb>=tabV.length){
                fini=true;
            }

        }
        for (int i=0;i<tabC.size();i++){
            System.out.println("Centre de tri "+(i+1)+": ");
            System.out.println("Gad: "+tabC.get(i).getStackGad().size());
            System.out.println("Plut: "+tabC.get(i).getStackPlut().size());
            System.out.println("Nep: "+tabC.get(i).getStackNep().size());
            System.out.println("Thul: "+tabC.get(i).getStackThul().size());
            System.out.println("Terb: "+tabC.get(i).getStackTerb().size());
            System.out.println("VaissoLine: ");
            int blabla=tabC.get(i).getVaissoLine().size();
            for (int j=0;j<blabla;j++){
                System.out.println("   -"+(j+1)+"- "+tabC.get(i).getVaissoLine().poll().getType());
            }

        }


    }

    public static Planet getRandomPlanet(){
        Planet p1=new Pluton();
        Planet p2=new Gadolile();
        Planet p3=new Thulipe();
        Planet p4=new Terrbe();
        Planet p5=new Neptune();
        int sa=(int)(Math.random()*(5)+1);
        if (sa==1){
            return p1;
        }
        else  if (sa==2){
            return p2;
        }
        else  if (sa==3){
            return p3;
        }
        else  if (sa==4){
            return p4;
        }
        else  {
            return p5;
        }
    }
    public static CentreTri next(CentreTri ici){
        return tabC.get(tabC.indexOf(ici)+1);
    }
     public static Vaisseau nextVais(CentreTri center){
        return center.getVaissoLine().poll();
     }
}