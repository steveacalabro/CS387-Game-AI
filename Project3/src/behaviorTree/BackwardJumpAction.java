package behaviorTree;

import ch.idsia.agents.controllers.BasicMarioAIAgent;
import ch.idsia.benchmark.mario.engine.sprites.Mario;

public class BackwardJumpAction implements Task {
	public boolean run(BasicMarioAIAgent b) {
		b.getAction()[Mario.KEY_JUMP] = true;
		b.getAction()[Mario.KEY_LEFT] = true;
		
		return true;
	}
}
