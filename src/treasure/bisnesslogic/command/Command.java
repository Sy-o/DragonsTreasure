package treasure.bisnesslogic.command;
import treasure.bisnesslogic.transferobject.TransferObject;

/**
 * An implementation of ?ommand design pattern
 */
public interface Command {
    /**
     * Execute the command
     *
     * @param to Execution parameters encapsulated in a @see transferobject
     * @return Execution results encapsulated in a @see transferobject
     */
    TransferObject execute(TransferObject to);
}
