package at.asna.asnabuild.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherTimeListener implements Listener {

    @EventHandler
    public void OnWeather(WeatherChangeEvent e){
        if (e.getWorld().getName().equals("CityBuild")){
            e.setCancelled(true);
        }
    }

}
