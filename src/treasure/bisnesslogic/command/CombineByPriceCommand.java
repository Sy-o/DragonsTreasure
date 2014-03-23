package treasure.bisnesslogic.command;

import treasure.bisnesslogic.transferobject.CombineByPriceTO;
import treasure.bisnesslogic.transferobject.TransferObject;
import treasure.entity.Storage;
import treasure.entity.Treasure;

/**
 * A {@link Command} to pick a bunch of items of specified total value
 */
public class CombineByPriceCommand implements Command{
    public TransferObject execute(TransferObject to){
        if (to.getClass().equals(CombineByPriceTO.class)) {
            CombineByPriceTO pTO = (CombineByPriceTO) to;
            int currentPrice = 0;
            for (Treasure treasure : Storage.getInstance().getTreasures()) {
                if (treasure.getPrice() < pTO.targetPrice - currentPrice) {
                    pTO.cart.add(treasure);
                    currentPrice += treasure.getPrice();
                    pTO.resultingPrice = currentPrice;
                }
                if (currentPrice == pTO.targetPrice) break;
            }
            return pTO;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
