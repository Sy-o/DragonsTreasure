package treasure.bisnesslogic.command;

import treasure.entity.Treasure;
import treasure.entity.Storage;
import treasure.bisnesslogic.transferobject.FindTO;
import treasure.bisnesslogic.transferobject.TransferObject;
import java.util.ArrayList;

/**
 * A {@link Command} to find treasure in the storage
 */
public class FindCommand implements Command{
    public TransferObject execute(TransferObject to)
    {
        if (to.getClass().equals(FindTO.class)){
            FindTO findTO = (FindTO)to;
            findTO.findResult = null;
            for (Treasure treasure : Storage.getInstance().getTreasures()){
                    if(treasure.getName().equals(findTO.name)){
                        findTO.findResult = treasure;
                        return findTO;
                    }
            }
            return findTO;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}
