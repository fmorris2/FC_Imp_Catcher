package scripts.fc.missions.fcimpcatcher.tasks;

import org.tribot.api.General;
import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Game;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.generic.FCFilters;
import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.api.items.FCItem;
import scripts.fc.api.travel.Travel;
import scripts.fc.api.utils.InterfaceUtils;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.ItemsRequiredTask;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fcimpcatcher.FCImpCatcher;
import scripts.fc.missions.fcimpcatcher.data.ImpRequirements;

public class WizardDialogue extends Task implements ItemsRequiredTask
{
	private static final long serialVersionUID = 3957747663553367154L;
	
	private static final Positionable WIZARD_TILE = new RSTile(3104, 3163, 2);
	private static final RSArea WIZARD_AREA = new RSArea(WIZARD_TILE, 10);

	@Override
	public boolean execute()
	{
		if(!WIZARD_AREA.contains(Player.getPosition()))
			return Travel.webWalkTo(WIZARD_TILE);
		
		boolean isAtEnd = Game.getSetting(FCImpCatcher.SETTING) >= 1;
		boolean dialogueSuccess = new NpcDialogue("Talk-to", "Wizard Mizgog", 10, 0, 0).execute();
		
		if(isAtEnd)
			FCTiming.waitCondition(() -> InterfaceUtils.isQuestInterfaceUp(), 6000);
		
		return dialogueSuccess;
	}

	@Override
	public boolean shouldExecute()
	{
		return true;
	}

	@Override
	public String getStatus()
	{
		return "Wizard Dialogue";
	}
	
	@Override
	public FCItem[] getRequiredItems()
	{
		return new FCItem[]
		{
			new FCItem(1, false, ImpRequirements.RED_BEAD),
			new FCItem(1, false, ImpRequirements.BLACK_BEAD),
			new FCItem(1, false, ImpRequirements.WHITE_BEAD),
			new FCItem(1, false, ImpRequirements.YELLOW_BEAD),
		};
	}

}
