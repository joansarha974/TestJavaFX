package service;

import model.UserFiche;
import model.UserLogin;
import model.Gender;

import java.util.*;

/**
 * Created by joanperny on 19/02/2014.
 */



public class UserFicheServiceImpl implements UserFicheService {

    private long nextId = 0;
    private long newId = 0;
    private Map<Long, UserFiche> userFiches;
    private Gender gender;


    public UserFicheServiceImpl()
    {
        this.userFiches = new HashMap<Long, UserFiche>();

        UserLogin userLogin;
        userLogin = new UserLogin();

        Date aujourdhui;
        aujourdhui = new Date();

        createUserFiche(gender.female,"user1", "useruser", userLogin,
                "1", aujourdhui);
        createUserFiche(gender.female,"Joan Sarha", "perny", userLogin,
                "2", aujourdhui);
        createUserFiche(gender.male,"Patrice", "hoareau", userLogin,
                "3", aujourdhui);
        createUserFiche(gender.male,"Thomas-Alexandre", "Perny-Hoareau", userLogin,
                "4", aujourdhui);
        createUserFiche(gender.male,"William", "Perny-Hoareau", userLogin,
                "5", aujourdhui);
    }

    private UserFiche createUserFiche(Gender gender, String user1, String useruser, UserLogin userLogin, String noDossier, Date aujourdhui) {
        UserFiche userFiche = new UserFiche(nextId++, gender, user1, useruser, userLogin, noDossier, aujourdhui);
        userFiche.put(userFiche.getId(), userFiche);
        return userFiche;
    }

    @Override
    public List<UserFiche> searchUserFiche(String[] keywords) {
        List<UserFiche> matches = new ArrayList<UserFiche>();
        if (keywords != null && keywords.length > 0)
        {
            outer:
            for (UserFiche userFiche : userFiches.values())
            {
                for (String keyword : keywords)
                {
                    keyword = keyword.toLowerCase();
                    if (!(userFiche.getSurname().toLowerCase().contains(keyword)
                            || userFiche.getLastname().toLowerCase().contains(keyword)))
                    {
                        // keyword not found on userFiche
                        continue outer;
                    }
                }
                matches.add(userFiche);
            }
        }
        else
        {
            matches.addAll(userFiches.values());
        }

        return matches;
    }

    @Override
    public UserFiche getUserFiche(Long userFicheId) {
        return userFiches.get(userFicheId);
    }

    @Override
    public UserFiche updateUserFiche(UserFiche updatedUserFiche) {
        userFiches.put(updatedUserFiche.getId(),updatedUserFiche);
        return updatedUserFiche;
    }
}
