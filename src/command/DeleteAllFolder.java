package command;

import org.apache.felix.gogo.commands.Action;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.service.command.CommandSession;
import service.FolderService;

/**
 * Created by joanperny on 20/02/2014.
 */
@Command(scope = "dp", name = "deleteAll")
public class DeleteAllFolder implements Action {
    private FolderService dpService;

    public void setDpService(FolderService dpService) {
        this.dpService = dpService;
    }

    public Object execute(CommandSession session) throws Exception {
        dpService.deleteAll();
        return null;
    }
}
