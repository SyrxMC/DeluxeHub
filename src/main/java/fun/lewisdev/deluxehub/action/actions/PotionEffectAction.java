package fun.lewisdev.deluxehub.action.actions;

import fun.lewisdev.deluxehub.DeluxeHubPlugin;
import fun.lewisdev.deluxehub.action.Action;
import fun.lewisdev.deluxehub.utility.universal.XPotion;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class PotionEffectAction implements Action {

    @Override
    public String getIdentifier() {
        return "EFFECT";
    }

    @Override
    public void execute(DeluxeHubPlugin plugin, Player player, String data) {

        String[] args = data.split(";", 3);

        String type = args[0];

        int duration = args.length >= 2 ? Integer.parseInt(args[1]) : 10000;
        int amplifier = args.length >= 3 ? Integer.parseInt(args[2]) : 1;

        XPotion potion = XPotion.matchXPotion(type).orElse(null);

        if (potion == null) {
            DeluxeHubPlugin.getInstance().getLogger().warning("The potion effect: " + type + " is invalid.");
            return;
        }

        PotionEffect potionEffect = potion.parsePotion(duration, amplifier);

        if (potionEffect == null) {
            DeluxeHubPlugin.getInstance().getLogger().warning("The potion effect: " + type + " is invalid.");
            return;
        }

        player.addPotionEffect(potionEffect);
    }
}
