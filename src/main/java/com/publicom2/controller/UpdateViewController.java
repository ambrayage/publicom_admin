/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.publicom2.controller;
import com.publicom2.vue.UpdateUser;
import com.publicom2.vue.MainVue;

/**
 *
 * @author a.guillauma
 */
public class UpdateViewController {
    
    private UpdateUser updateView;
    
    public UpdateViewController(UpdateUser updateView){
        this.updateView = updateView;
    }
    
    public void backToMainView(){
        MainVue mainView = new MainVue();
        mainView.setVisible(true);
        this.updateView.dispose();
    }
}
