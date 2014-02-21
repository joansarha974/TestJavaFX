package service;

import entity.Folder;
import org.hibernate.envers.DefaultRevisionEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by joanperny on 20/02/2014.
 */
public interface FolderService {
    public void add(Folder dp);

    public void update(Folder dp);

    public Folder get(long id);

    public Folder load(long id);

    public List<Folder> getAll();

    public Map<Number, DefaultRevisionEntity> getRevisions(long id);

    public void deleteAll();
}
