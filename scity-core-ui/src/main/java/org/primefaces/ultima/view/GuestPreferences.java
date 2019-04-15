/*
 * Copyright 2009-2014 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.ultima.view;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * The Class GuestPreferences.
 * @author jerome.nshimiyimana
 * @version 1.0
 */
@ManagedBean
@SessionScoped
public class GuestPreferences implements Serializable {
    
    /** The theme colors. */
    private Map<String,String> themeColors;
    
    /** The theme. */
    private String theme = "dark-green"; 
    
    /** The menu class. */
    private String menuClass = null;
    
    /** The profile mode. */
    private String profileMode = "inline";
    
    /** The menu layout. */
    private String menuLayout = "static";
    
    /** The compact. */
    private boolean compact = true;
    
    /** The orientation RTL. */
    private boolean orientationRTL;
    
    /**
     * Inits the.
     */
    @PostConstruct
    public void init() {
        themeColors = new HashMap<String,String>();
        themeColors.put("indigo", "#3F51B5");
        themeColors.put("blue", "#03A9F4");
        themeColors.put("blue-grey", "#607D8B");
        themeColors.put("brown", "#795548");
        themeColors.put("cyan", "#00bcd4");
        themeColors.put("green", "#4CAF50");
        themeColors.put("purple-amber", "#673AB7");
        themeColors.put("purple-cyan", "#673AB7");
        themeColors.put("teal", "#009688");
    }
    
    /**
     * Gets the menu class.
     *
     * @return the menu class
     */
    public String getMenuClass() {
        return this.menuClass;
    }
    
    /**
     * Gets the profile mode.
     *
     * @return the profile mode
     */
    public String getProfileMode() {
        return this.profileMode;
    }

	/**
	 * Gets the theme.
	 *
	 * @return the theme
	 */
	public String getTheme() {		
		return theme;
	}
    
    /**
     * Gets the menu layout.
     *
     * @return the menu layout
     */
    public String getMenuLayout() {	
        if(this.menuLayout.equals("static")){
            return "menu-layout-static";
        }else if(this.menuLayout.equals("overlay")){
            return "menu-layout-overlay";
        }else if(this.menuLayout.equals("horizontal")){
            return "menu-layout-static menu-layout-horizontal";
        }else{
            return "menu-layout-static";
        }
    }

	/**
	 * Sets the theme.
	 *
	 * @param theme the new theme
	 */
	public void setTheme(final String theme) {
		this.theme = theme;
	}
    
    /**
     * Sets the light menu.
     */
    public void setLightMenu() {
        this.menuClass = null;
    }
    
    /**
     * Sets the dark menu.
     */
    public void setDarkMenu() {
        this.menuClass = "layout-menu-dark";
    }
    
    /**
     * Sets the profile mode.
     *
     * @param profileMode the new profile mode
     */
    public void setProfileMode(final String profileMode) {
        this.profileMode = profileMode;
    }
    
    /**
     * Sets the menu layout.
     *
     * @param menuLayout the new menu layout
     */
    public void setMenuLayout(final String menuLayout) {
        this.menuLayout = menuLayout;
    }
    
    /**
     * Gets the theme colors.
     *
     * @return the theme colors
     */
    public Map getThemeColors() {
        return this.themeColors;
    }
    
    /**
     * Sets the compact.
     *
     * @param value the new compact
     */
    public void setCompact(final boolean value) {
        this.compact = value;
    }
    
    /**
     * Checks if is compact.
     *
     * @return true, if is compact
     */
    public boolean isCompact() {
        return this.compact;
    }

    /**
     * Checks if is orientation RTL.
     *
     * @return true, if is orientation RTL
     */
    public boolean isOrientationRTL() {
        return orientationRTL;
    }

    /**
     * Sets the orientation RTL.
     *
     * @param orientationRTL the new orientation RTL
     */
    public void setOrientationRTL(final boolean orientationRTL) {
        this.orientationRTL = orientationRTL;
    }
}
