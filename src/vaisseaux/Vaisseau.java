package vaisseaux;

import centreTri.CentreTri;
import main.Main;
import matiere.*;
import planetes.Planet;

import java.util.ArrayList;

/**
 * Created by ibada1731710 on 2018-04-26.
 */
public  class Vaisseau {
    private String type;
    private int capacite;
    private ArrayList<Materiaux> contenu=new ArrayList<>();




    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public ArrayList<Materiaux> getContenu() {
        return contenu;
    }

    public void setContenu(ArrayList<Materiaux> contenu) {
        this.contenu = contenu;
    }

    public void remplir(Planet planete){
        int i=0;
        int chiffre=0;
        while (i<capacite){
            chiffre=(int)(Math.random()* 101);
            if (chiffre<planete.getNbGad()){
                contenu.add(new Gad());
            }
            else if (chiffre>=planete.getNbGad()&&chiffre< (planete.getNbGad()+planete.getNbNep())){
                contenu.add(new Nep());
            }
            else if (chiffre>= (planete.getNbGad()+planete.getNbNep()) && chiffre<  (planete.getNbGad()+planete.getNbNep()+planete.getNbPlut())){
                contenu.add(new Plut());
            }
            else if (chiffre>=(planete.getNbGad()+planete.getNbNep()+planete.getNbPlut())  &&  chiffre<  (planete.getNbGad()+planete.getNbNep()+planete.getNbPlut()+planete.getNbTer())){
                contenu.add(new Terb());
            }
            else {
                contenu.add(new Thul());
            }

            i++;
        }

    }

    public void go(CentreTri centreTri){
        centreTri.viderVaisso(this);
        centreTri.getVaissoLine().add(this);
        if (centreTri.getVaissoLine().size()==10){
            centreTri.getVaissoLine().peek().remplir(Main.getRandomPlanet());
            centreTri.viderVaisso(centreTri.getVaissoLine().poll());
        }
    }

}