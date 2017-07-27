package scripts.fc.missions.fcimpcatcher.data;

import scripts.fc.framework.requirement.item.ItemRequirement;
import scripts.fc.framework.requirement.item.ReqItem;
import scripts.fc.framework.requirement.item.SingleReqItem;
import scripts.fc.framework.script.FCMissionScript;

public class ImpRequirements extends ItemRequirement
{
	public static int RED_BEAD = 1470, YELLOW_BEAD = 1472, BLACK_BEAD = 1474, WHITE_BEAD = 1476;
	
	public ImpRequirements(FCMissionScript script)
	{
		super(script);
	}

	@Override
	public ReqItem[] getReqItems()
	{
		return new ReqItem[]
		{
			new SingleReqItem(RED_BEAD, 1, true, true),
			new SingleReqItem(YELLOW_BEAD, 1, true, true),
			new SingleReqItem(BLACK_BEAD, 1, true, true),
			new SingleReqItem(WHITE_BEAD, 1, true, true),
		};
	}
}
