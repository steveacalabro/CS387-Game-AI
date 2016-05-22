package behaviorTree;

import ch.idsia.agents.controllers.BasicMarioAIAgent;

//CanShoot
public class CanGoForwardJump implements Task {
	
	@Override
	public boolean run(BasicMarioAIAgent b) {
		return Task.clearFront(b);
	}
}
