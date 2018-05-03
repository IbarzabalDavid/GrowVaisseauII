package main;

import centreTri.CentreTri;
import matiere.Materiaux;
import planetes.*;
import vaisseaux.Light;
import vaisseaux.Lourd;
import vaisseaux.Normal;
import vaisseaux.Vaisseau;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by ibada1731710 on 2018-04-26.
 */
public class Main {
    public static LinkedList<CentreTri> tabC=new LinkedList<>();
    public static void main(String[] args) {

        Vaisseau tabV[]=new Vaisseau[50];

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
        for (int i=0;i<90;i++){
            tabC.add(new CentreTri());
        }
        boolean fini=false;
        int nb=0;
        int nb1=0;
        while (!fini){
            tabV[nb].remplir(getRandomPlanet());
            tabV[nb].go(tabC.getFirst());
            nb++;
            if (nb>=tabV.length){
                fini=true;
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
}

