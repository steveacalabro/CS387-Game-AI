package behaviorTree;

import ch.idsia.agents.controllers.BasicMarioAIAgent;

//CanShoot
public class CanGoBackwardJump implements Task {
	
	@Override
	public boolean run(BasicMarioAIAgent b) {
		return Task.clearBack(b);
	}
}
