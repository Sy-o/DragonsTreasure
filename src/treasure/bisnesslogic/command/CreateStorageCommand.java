package treasure.bisnesslogic.command;

import treasure.bisnesslogic.transferobject.CreateStorageTO;
import treasure.bisnesslogic.transferobject.TransferObject;
import treasure.entity.Storage;
import treasure.entity.Treasure;
/**
 * A {@link Command} to fill the storage with random objects
 */
public class CreateStorageCommand implements Command{
    public TransferObject execute(TransferObject to){
        if (to.getClass().equals(CreateStorageTO.class)){
            Storage st = Storage.getInstance();
            for(int i = 0; i < ((CreateStorageTO)to).count; ++i){
                  st.addTreasure(CreateTreasure());              
            }
            return to;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public static Treasure CreateTreasure() {
        String name = String.format("Golden thingy %d", (int) (Math.random() * 100) + 1);
        int value = (int) (Math.random() * 1000) + 1;
        return new Treasure(name, value);
    }
}
