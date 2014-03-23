package treasure.entity;
import java.util.ArrayList;
import treasure.entity.Treasure;

/**
 * Represents a collection of @see Treasure objects. Singleton class.
 */
public class Storage {
    private ArrayList<Treasure> treasures;

    private Storage(){
        treasures = new ArrayList<Treasure>();
    }   

    private static class StorageHolder{
           private static final Storage INSTANCE = new Storage();
    }

     /**
     * @return Singleton instance of this class.
     */
    public static Storage getInstance(){
        return StorageHolder.INSTANCE;
    }
    
    /**
     * Add a treasure to the storage
     *
     * @param treasure Treasure to add
     */
    public void addTreasure(Treasure treasure){
        treasures.add(treasure);
    }

    /**
     * @return A list of all treasures
     */
    public ArrayList<Treasure> getTreasures(){
        return treasures;
    }
}
