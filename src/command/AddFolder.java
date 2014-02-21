package command;


import entity.Folder;
import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.service.command.CommandSession;
import service.FolderService;
/**
 * Created by joanperny on 20/02/2014.
 */

@Command(scope = "dp", name = "add")
public class AddFolder {
    @Argument(index=0, name="Name", required=true, description="Name", multiValued=false)
    String name;

    private FolderService dpService;

    public void setDpService(FolderService dpService) {
        this.dpService = dpService;
    }

    public Object execute(CommandSession session) throws Exception {
        Folder dp = new Folder();
        dp.setSurname(name);
        dpService.add( dp );
        return null;
    }
}
