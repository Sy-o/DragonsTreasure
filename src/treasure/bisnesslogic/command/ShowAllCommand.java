package treasure.bisnesslogic.command;

import treasure.bisnesslogic.transferobject.ShowAllTO;
import treasure.bisnesslogic.transferobject.TransferObject;
import treasure.entity.Storage;

/**
 * A {@link Command} to retrieve the list of all items in the storage
 */
public class ShowAllCommand implements Command{
    public TransferObject execute(TransferObject to) {
        if (to.getClass().equals(ShowAllTO.class)) {
            ((ShowAllTO)to).treasures = Storage.getInstance().getTreasures();
            return to;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
