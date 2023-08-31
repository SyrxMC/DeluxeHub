package fun.lewisdev.deluxehub.action.actions;

import fun.lewisdev.deluxehub.DeluxeHubPlugin;
import fun.lewisdev.deluxehub.action.Action;
import fun.lewisdev.deluxehub.utility.TextUtil;
import fun.lewisdev.deluxehub.utility.reflection.ActionBar;
import io.github.cruciblemc.vitatempus.VitaTempus;
import io.github.cruciblemc.vitatempus.necrotempus.NecroTempus;
import org.bukkit.entity.Player;

public class ActionbarAction implements Action {

    @Override
    public String getIdentifier() {
        return "ACTIONBAR";
    }

    @Override
    public void execute(DeluxeHubPlugin plugin, Player player, String data) {

        if(NecroTempus.getInstance().hasNecroTempus(player)){
            io.github.cruciblemc.vitatempus.packets.ActionBar actionBar = io.github.cruciblemc.vitatempus.packets.ActionBar.of(TextUtil.color(data));
            VitaTempus.getInstance().getNecroTempusPacketDeliver().deliverTo(player, actionBar);
            return;
        }

        ActionBar.sendActionBar(player, TextUtil.color(data));
    }
}
