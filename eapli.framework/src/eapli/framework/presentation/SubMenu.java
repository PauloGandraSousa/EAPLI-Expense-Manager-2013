/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.framework.presentation;

/**
 * allows for the composition of menus (Composite pattern)
 * 
 * @author Paulo Gandra Sousa
 */
public class SubMenu extends MenuItem {
    public SubMenu(int option, Menu menu) {
        super(option, menu.title, new SubMenuAction(menu));
    }
}
