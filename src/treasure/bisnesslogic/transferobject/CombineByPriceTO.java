package treasure.bisnesslogic.transferobject;

import treasure.bisnesslogic.transferobject.TransferObject;
import treasure.entity.Treasure;
import java.util.ArrayList;

/**
 * A {@link TransferObject} corresponding to {@link treasury.bisnesslogic.?ommand.CombineByPriceCommand} command.
 */
public class CombineByPriceTO extends TransferObject{
    public int targetPrice;
    public int resultingPrice;
    public ArrayList<Treasure> cart;

    /**
     * Constructs a new instance.
     *
     * @param targetPrice target cost of all items in the cart
     */
    public CombineByPriceTO(int targetPrice) {
        this.targetPrice = targetPrice;
        cart = new ArrayList<Treasure>();
    }
}
