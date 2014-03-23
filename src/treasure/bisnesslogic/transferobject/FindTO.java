package treasure.bisnesslogic.transferobject;

import treasure.entity.Treasure;
/**
 * A {@link TransferObject} corresponding to {@link treasury.bisnesslogic.?ommand.FindCommand} command.
 */
public class FindTO extends TransferObject{
    public String name;
    public Treasure findResult; 

    /**
     * Constructs a new instance
     *
     * @param name of treasure to find
     */
    public FindTO(String name)
    {
        this.name = name;
    }
}
