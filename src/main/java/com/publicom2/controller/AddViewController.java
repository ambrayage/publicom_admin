/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.publicom2.controller;
import com.publicom2.vue.AddView;
import com.publicom2.vue.MainVue;

/**
 *
 * @author a.guillauma
 */
public class AddViewController {
    
    private AddView addView;
    
    public AddViewController(AddView addView){
        this.addView = addView;
    }
    
    public void backToMainView() throws Exception{
        MainVue mainView = new MainVue();
        mainView.setVisible(true);
        this.addView.dispose();
    }
}
