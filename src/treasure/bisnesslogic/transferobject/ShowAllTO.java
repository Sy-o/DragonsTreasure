package treasure.bisnesslogic.transferobject;

import treasure.entity.Treasure;
import java.util.ArrayList;
/**
 * A {@link TransferObject} corresponding to {@link me.mikeroll.treasury.bl.?ommand.ShowAllCmd} command.
 */
public class ShowAllTO extends TransferObject{
     public ArrayList<Treasure> treasures;

    /**
     * Constructs a new instance
     */
    public ShowAllTO() {
        treasures = new ArrayList<Treasure>();
    }    
}
