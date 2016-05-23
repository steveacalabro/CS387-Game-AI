package behaviorTree;

import ch.idsia.agents.controllers.BasicMarioAIAgent;
import ch.idsia.agents.controllers.BehaviorAgent;
import ch.idsia.benchmark.mario.engine.sprites.Mario;

public class ForwardJumpAction implements Task {
	public boolean run(BehaviorAgent b) {
		b.jumpKey();
		b.rightKey();

		System.out.println("Forward Jump");
		return true;
	}
}
