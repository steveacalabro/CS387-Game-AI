package behaviorTree;

import ch.idsia.agents.controllers.BasicMarioAIAgent;

//CanShoot
public class CanGoBackward implements Task {
	
	@Override
	public boolean run(BasicMarioAIAgent b) {
		return Task.clearBack(b);
	}
}
