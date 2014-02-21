package command;

import org.apache.felix.gogo.commands.Action;

import entity.Folder;
import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.service.command.CommandSession;
import service.FolderService;
/**
 * Created by joanperny on 20/02/2014.
 */
@Command(scope = "dp", name = "update")
public class UpdateFolder implements Action {
    @Argument(index=0, name="Id", required=true, description="Id", multiValued=false)
    String id;

    @Argument(index=1, name="Name", required=true, description="Name", multiValued=false)
    String name;

    private FolderService dpService;

    public void setDpService(FolderService dpService) {
        this.dpService = dpService;
    }

    public Object execute(CommandSession session) throws Exception {
        Folder dp = dpService.get( Long.valueOf( id ) );
        dp.setSurname(name);
        dpService.update( dp );
        return null;
    }
}
