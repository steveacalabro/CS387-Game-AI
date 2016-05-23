package behaviorTree;

import ch.idsia.agents.controllers.BasicMarioAIAgent;
import ch.idsia.agents.controllers.BehaviorAgent;

//CanShoot
public class IsEnemyNear implements Task {
	
	@Override
	public boolean run(BehaviorAgent b) {
		int x = b.getMarioEgoRow();
	    int y = b.getMarioEgoCol();
	    
	    boolean enemyNear = false;
	    for(int i = 0; i < 3; i++) {
	    	if((b.isCreature(b.getEnemiesCellValue(x+i, y)) || b.isCreature(b.getEnemiesCellValue(x, y + i)) || b.isCreature(b.getEnemiesCellValue(x + i, y + i)))) {
	    		enemyNear = true;
	    		break;
	    	}
	    }
	   
		return enemyNear && b.isMarioAbleToShoot();
	}
}
