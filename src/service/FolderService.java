package service;

import entity.Folder;

import java.util.List;

/**
 * Created by joanperny on 20/02/2014.
 */
public interface FolderService {
    public void add(Folder dp);

    public void update(Folder dp);

    public Folder get(long id);

    public Folder load(long id);

    public List<Folder> getAll();

    public void deleteAll();
}
