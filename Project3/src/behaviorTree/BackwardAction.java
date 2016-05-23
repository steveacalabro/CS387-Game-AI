package behaviorTree;

import ch.idsia.agents.controllers.BasicMarioAIAgent;
import ch.idsia.agents.controllers.BehaviorAgent;
import ch.idsia.benchmark.mario.engine.sprites.Mario;

public class BackwardAction implements Task {
	public boolean run(BehaviorAgent b) {
		b.leftKey();
		System.out.println("Back");
		
		return true;
	}
}
