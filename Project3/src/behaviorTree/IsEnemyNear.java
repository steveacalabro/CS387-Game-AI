package behaviorTree;

import ch.idsia.agents.controllers.BasicMarioAIAgent;

//CanShoot
public class IsEnemyNear implements Task {
	
	@Override
	public boolean run(BasicMarioAIAgent b) {
		int x = b.getMarioEgoRow();
	    int y = b.getMarioEgoCol();
	    
	    boolean enemyNear = false;
	    for(int i = 0; i < 3; i++) {
	    	if((Task.isCreature(b.getEnemiesCellValue(x+i, y)) || Task.isCreature(b.getEnemiesCellValue(x, y + i)) || Task.isCreature(b.getEnemiesCellValue(x + i, y + i)))) {
	    		enemyNear = true;
	    		break;
	    	}
	    }
	   
		return enemyNear && b.isMarioAbleToShoot();
	}
}