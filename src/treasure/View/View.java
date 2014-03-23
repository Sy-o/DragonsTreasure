package treasure.View;

import treasure.bisnesslogic.command.CommandId;
import treasure.bisnesslogic.transferobject.*;
import treasure.controller.Controller;
import treasure.entity.Treasure;

import java.io.PrintStream;

/**
 * Provides user interaction and data output.
 */
public class View {
    private final PrintStream out;
    private final Controller ctrl;

    /**
     * Class constructor, bonds a view to provided I/O streams
     *
     * @param out Output stream to attach to
     */
    public View(PrintStream out) {
        this.out = out;
        this.ctrl = Controller.getInstance();
    }

    /**
     * Display menu
     */
    public void showMenu(){
        out.println("Welcome!");

        out.println("Menu:");
        out.println("----------------");
        out.println("1 - Create Storage");
        out.println("2 - Find Treasure");
        out.println("3 - Combine by price");
        out.println("4 - Show all treasures");
        out.println("0 - Exit");
        out.println("----------------");

        doCommand(1);
        doCommand(3);
        doCommand(4);
        doCommand(2);
        doCommand(7);
        doCommand(0);
    }

    /**
     * Process user commands 
     */

    private void doCommand(int index)
    {
        switch(index){
            case 0:
                out.println("Exit...");    
                break;
            case 1:
                int count = 5;
                createStorage(count);
                break;
            case 2:
                String name = "Golden thingy 55";
                find(name);
                break;
            case 3:
                int price = 500;
                combineByPrice(price);
                break;
            case 4:
                showAll();
                break;
            default:
                noCmd();
                break;
        }
    }

    private void createStorage(int count)
    {
        ctrl.runCommand(CommandId.CREATE_STORAGE, new CreateStorageTO(count));
        out.format("> Now guarding %d treasures.\n", count);
    }

    private void find(String name)
    {
        TransferObject to;
        to = ctrl.runCommand(CommandId.FIND, new FindTO(name));
        if( ((FindTO)to).findResult!= null)
            out.format("> Treasure found: name - %s, price - %d.\n", ((FindTO)to).findResult.getName(),((FindTO)to).findResult.getPrice());
        else
            out.format("> No such treasure.\n");
    }

    private void combineByPrice(int price){
        CombineByPriceTO to = (CombineByPriceTO) ctrl.runCommand(CommandId.COMBINE_BY_PRICE, new CombineByPriceTO(price));
        for (Treasure treasure : to.cart) {
            out.format("> %s\n", viewTreasure(treasure));
        }
        out.format("> $%d total.\n", to.resultingPrice);
    }

    private String viewTreasure(Treasure t) {
        return String.format("%s worth $%d", t.getName(), t.getPrice());
    }

    private void showAll(){
        ShowAllTO to = (ShowAllTO) ctrl.runCommand(CommandId.SHOW_ALL, new ShowAllTO());
        out.format("> All list of treasures:\n");
        for (Treasure treasure : to.treasures) {
            out.format("> %s\n", viewTreasure(treasure));
        }
    }

    private void noCmd(){
        NoCommandTO to = (NoCommandTO) ctrl.runCommand(CommandId.NO_COMMAND, new NoCommandTO());
        out.format(">%s\n", to.message);
    }




}
