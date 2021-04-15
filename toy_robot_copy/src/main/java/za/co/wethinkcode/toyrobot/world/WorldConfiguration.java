package za.co.wethinkcode.toyrobot.world;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import za.co.wethinkcode.toyrobot.Position;


public class WorldConfiguration {

    private Properties properties;
    private FileInputStream configFileInput;

    public WorldConfiguration() {

        this.properties = new Properties();

        try {
            this.configFileInput = new FileInputStream("config.properties");
            properties.load(configFileInput);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not load the properties file");
        }

    }

    public Position getPositionConfigValue(String key) {

        String containerVariable;
        containerVariable = properties.getProperty(key);
        Position position = new Position(Integer.parseInt(String.valueOf(containerVariable.charAt(1))), Integer.parseInt(String.valueOf(containerVariable.charAt(3))));
        
        return position;

    }

    public String getStringConfigValue(String key) {

        String containerVariable;
        containerVariable = properties.getProperty(key);
        
        return containerVariable;

    }

    public Position getCentre() {

        return getPositionConfigValue("centre");

    }

    public Position getTopLeft() {

        return getPositionConfigValue("top_left");
    }

    public Position getBottomRight() {

        return getPositionConfigValue("bottom_right");
    }

    public int getVisibility() {

        int visibility = Integer.parseInt(getStringConfigValue("visibility"));
        return visibility;
    }

    public int getRepairTime() {

        int repairTime = Integer.parseInt(getStringConfigValue("repair_time"));
        return repairTime;
    }

    public int getWeaponReloadTime() {

        int reloadDelta = Integer.parseInt(getStringConfigValue("weapon_reload"));
        return reloadDelta;
    }

    public int getMineSetupTime() {

        int mineSetupDelta = Integer.parseInt(getStringConfigValue("mine_set_time"));
        return mineSetupDelta;
    }

    public int getMaxShieldStrength() {
        
        int maxShieldStrength = Integer.parseInt(getStringConfigValue("max_shieldStrength"));
        return maxShieldStrength;
    }

}