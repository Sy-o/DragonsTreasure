package treasure.controller;

import treasure.bisnesslogic.transferobject.TransferObject;
import treasure.bisnesslogic.command.*;
import java.util.HashMap;
/**
 * Created by IntelliJ IDEA.
 * User: Alice
 * Date: Mar 20, 2014
 * Time: 3:57:33 AM
 * To change this template use File | Settings | File Templates.
 */

/**
 * Dispatches storage-related commands. Singleton class.
 */
public class Controller {
    private HashMap<CommandId, Command> cmds;

    private Controller() {
        cmds = new HashMap<CommandId, Command>();
        cmds.put(CommandId.CREATE_STORAGE, new CreateStorageCommand());
        cmds.put(CommandId.SHOW_ALL, new ShowAllCommand());
        cmds.put(CommandId.COMBINE_BY_PRICE, new CombineByPriceCommand());
        cmds.put(CommandId.NO_COMMAND, new NoCommand());
        cmds.put(CommandId.FIND, new FindCommand());
    }

    private static class InstanceHolder {
        private static final Controller INSTANCE = new Controller();
    }

    /**
     * @return Singleton instance of this class.
     */
    public static Controller getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /**
     * Runs the specified command with provided arguments
     *
     * @param id   The id of @see Command to run
     * @param to Execution parameters encapsulated in a @see transferobject
     * @return Execution results encapsulated in a @see transferobject
     */
    public TransferObject runCommand(CommandId id, TransferObject to) {
            return cmds.get(id).execute(to);
    }
}
