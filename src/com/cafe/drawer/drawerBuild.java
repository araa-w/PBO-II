/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafe.drawer;
import com.cafe.tabbed.windowsTabbed;
import com.cafe.view.*;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import raven.drawer.component.SimpleDrawerBuilder;
import raven.drawer.component.footer.SimpleFooterData;
import raven.drawer.component.header.SimpleHeaderData;
import raven.drawer.component.menu.MenuAction;
import raven.drawer.component.menu.MenuEvent;
import raven.drawer.component.menu.SimpleMenuOption;
import raven.popup.GlassPanePopup;
import raven.swing.AvatarIcon;

/**
 *
 * @author vvhal
 */
public class drawerBuild extends SimpleDrawerBuilder{

    @Override
    public SimpleHeaderData getSimpleHeaderData() {
        
        return new SimpleHeaderData()
                .setIcon(new AvatarIcon(getClass().getResource("/com/cafe/img/aset.png"), 70, 70, 999))
                .setTitle("Hello Guestt!!");
    }

    @Override
    public SimpleMenuOption getSimpleMenuOption() {
        String menus[][] = {
            {"~MAIN~"},
            {"Dashboard"},
            {"~CASHIER~"},
            {"Menus"},
            {"Order"},
            {"~ADMIN~"},
            {"Expense"},
            {"Profit"},
            {"~OTHER~"},
            {"Logout"}};

        String icons[] = {
            "dashboard.svg",
            "email.svg",
            "chat.svg",
            "page.svg",
            "forms.svg",
            "logout.svg"};
        return new SimpleMenuOption()
                .setMenus(menus)
                .setIcons(icons)
                .setBaseIconPath("com/cafe/drawer/icon")
                .setIconScale(0.45f)
                .addMenuEvent(new MenuEvent(){
                    @Override
                    public void selected(MenuAction action, int index, int subIndex) {
                        if (index==1 && subIndex==0) {
                            windowsTabbed.getInstance().addTab("Menus", new MenusForm());
                        }
                        if (index==2 && subIndex==0) {
                            windowsTabbed.getInstance().addTab("Orders", new OrdersForm());
                        }
                        if (index==3 && subIndex==0) {
                            windowsTabbed.getInstance().addTab("Expenses", new ExpensesForm());
                        }
                        if (index==4 && subIndex==0) {
                            windowsTabbed.getInstance().addTab("Profits", new ProfitsForm());
                        }
                        if (index==5 && subIndex==0) {
                            MainForm.main.login();
                            MainForm.main.login();
                        }
                        System.out.println("Menu Selected " + index  + subIndex);
                    }
                    
                });
    }

    @Override
    public SimpleFooterData getSimpleFooterData() {
        return new SimpleFooterData()
                .setTitle("Aplikasir")
                .setDescription("Demo Version 1.0");
    }
}
