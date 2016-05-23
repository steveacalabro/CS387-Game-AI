package behaviorTree;

import ch.idsia.agents.controllers.BasicMarioAIAgent;
import ch.idsia.agents.controllers.BehaviorAgent;
import ch.idsia.benchmark.mario.engine.sprites.Mario;

public class BackwardJumpAction implements Task {
	public boolean run(BehaviorAgent b) {
		b.jumpKey();
		b.leftKey();
		System.out.println("Back Jump");
		
		return true;
	}
}
