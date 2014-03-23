package treasure.bisnesslogic.command;

import treasure.bisnesslogic.transferobject.NoCommandTO;
import treasure.bisnesslogic.transferobject.TransferObject;
/**
 * A {@link Command} in case of an unexpected command
 */
public class NoCommand implements Command{
    public TransferObject execute(TransferObject to){
        if (to.getClass().equals(NoCommandTO.class)) {
            return (NoCommandTO)to;
        }
        else {
            throw new IllegalArgumentException();
        }

    }
}
