/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.framework.actions;

/**
 *
 * @author Paulo Gandra Sousa
 */
public class NullAction implements Action {

    private static final NullAction theInstance = new NullAction();
    
    public static NullAction getInstance() {
		return theInstance;
	}
    
    private NullAction() {}
    
    @Override
    public boolean execute() {
        return false;
    }
    
}
