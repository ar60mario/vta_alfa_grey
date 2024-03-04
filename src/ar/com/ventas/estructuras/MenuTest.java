/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.estructuras;

import javax.swing.JFrame;

/**
 *
 * @author argia
 */
public enum MenuTest {
    A {
        @Override
        MenuTest transforString(String str) {
            MenuTest.values();
            return MenuTest.A;
        }

        @Override
        JFrame openJFrame() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    },
    B {
        @Override
        MenuTest transforString(String str) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        JFrame openJFrame() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
    
    abstract MenuTest transforString (String str);
        
    abstract JFrame openJFrame();
}
