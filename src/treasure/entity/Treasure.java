package treasure.entity;

/**
 * Represents a (golden?) treasure
 */
public class Treasure {
    private String name;
    private int price;

    /**
     * Constructs a new treasure of specified name and value
     *
     * @param name  Treasure name
     * @param price Treasure estimated value
     */
    public Treasure(String name, int price){
        this.name = name;
        this.price = price;        
    }

    /**
     * @return Treasure name
     */
    public String getName(){
        return this.name;
    }

    /**
     * @return Treasure price
     */
    public int getPrice(){
        return this.price;
    }

    @Override    
    public String toString(){
        StringBuilder str = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        str.append(this.getClass().getName() + " Object {" + NEWLINE);
        str.append("  name: " + name + NEWLINE);
        str.append("  price: " + price + NEWLINE);
        str.append("}");
        return str.toString();
    }

}
