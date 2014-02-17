package controller.dossier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joanperny on 17/02/2014.
 */
public class Sujets {
    protected List<Sujets> sujets = new ArrayList<Sujets>();
    
    public void Add(Sujets sujet)
    {
        sujets.add(sujet);
    }
    
    public void Remove(Sujets sujet)
    {
        sujets.remove(sujet);
    }

    public void notifie()
    {
        for (Sujets sujet : sujets)
            sujet.actualise();
    }

    private void actualise() {
    }
}
