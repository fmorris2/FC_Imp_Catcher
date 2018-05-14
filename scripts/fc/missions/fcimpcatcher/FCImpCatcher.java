package scripts.fc.missions.fcimpcatcher;

import java.util.Arrays;
import java.util.LinkedList;

import org.tribot.api2007.Game;

import scripts.fc.framework.quest.QuestScriptManager;
import scripts.fc.framework.requirement.Requirement;
import scripts.fc.framework.script.FCMissionScript;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fcimpcatcher.data.ImpRequirements;
import scripts.fc.missions.fcimpcatcher.tasks.WizardDialogue;

public class FCImpCatcher extends QuestScriptManager
{
	public static final int SETTING = 160;
	
	public FCImpCatcher(FCMissionScript fcScript)
	{
		super(fcScript);
	}

	@Override
	public boolean hasReachedEndingCondition()
	{
		return Game.getSetting(SETTING) >= 2;
	}

	@Override
	public String getMissionName()
	{
		return "FC Imp Catcher";
	}

	@Override
	public String getEndingMessage()
	{
		return "FC Imp Catcher has ended";
	}

	@Override
	public String[] getMissionSpecificPaint()
	{
		return new String[]{};
	}

	@Override
	public void resetStatistics()
	{
	}

	@Override
	public Requirement[] getRequirements()
	{
		return new Requirement[]{new ImpRequirements(missionScript)};
	}

	@Override
	public LinkedList<Task> getTaskList()
	{
		return new LinkedList<>(Arrays.asList(new WizardDialogue()));
	}
	
	public String toString()
	{
		return "Imp Catcher";
	}

	@Override
	public boolean canStart()
	{
		return true;
	}

	@Override
	public int getQuestPointReward() {
		return 1;
	}

}
