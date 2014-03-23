package treasure;

import treasure.View.View;

/**
 * Demo application main class
 */
public class Main {
    /**
     * Demo application entry point
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        View view = new View(System.out);
        view.showMenu();        
    }

    
}
