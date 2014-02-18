package service;

import model.UserFiche;

import java.util.List;

/**
 * Created by joanperny on 17/02/2014.
 */
public interface UserFicheService {
    List<UserFiche> searchUserFiche(String[] keywords);

    UserFiche getUserFiche(Long userFicheId);

    UserFiche updateUserFiche(UserFiche updatedUserFiche);
}
