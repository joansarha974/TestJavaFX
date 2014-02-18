package controller.dossier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joanperny on 17/02/2014.
 */
public class SujetsController {
    protected List<SujetsController> sujets = new ArrayList<SujetsController>();
    
    public void Add(SujetsController sujet)
    {
        sujets.add(sujet);
    }
    
    public void Remove(SujetsController sujet)
    {
        sujets.remove(sujet);
    }

    public void notifie()
    {
        for (SujetsController sujet : sujets)
            sujet.actualise();
    }

    private void actualise() {
    }
}
