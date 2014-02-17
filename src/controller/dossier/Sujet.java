package controller.dossier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joanperny on 17/02/2014.
 */
public class Sujet {
    protected List<Sujet> sujets = new ArrayList<Sujet>();
    
    public void Add(Sujet sujet)
    {
        sujets.add(sujet);
    }
    
    public void Remove(Sujet sujet)
    {
        sujets.remove(sujet);
    }

    public void notifie()
    {
        for (Sujet sujet : sujets)
            sujet.actualise();
    }

    private void actualise() {
    }
}
