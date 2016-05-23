package behaviorTree;

import ch.idsia.agents.controllers.BasicMarioAIAgent;
import ch.idsia.agents.controllers.BehaviorAgent;

//CanShoot
public class CanGoBackwardJump implements Task {
	
	@Override
	public boolean run(BehaviorAgent b) {
		return b.clearBack();
	}
}
