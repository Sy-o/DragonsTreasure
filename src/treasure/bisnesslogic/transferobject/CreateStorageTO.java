package treasure.bisnesslogic.transferobject;

/**
 * A {@link TransferObject} corresponding to {@link treasury.bisnesslogic.?ommand.CreateStorageCommand} command.
 */
public class CreateStorageTO extends TransferObject{
    public int count;

    /**
     * Constructs a new instance
     *
     * @param count number of objects to create
     */
    public CreateStorageTO(int count){
        this.count = count;
    }


        
}
