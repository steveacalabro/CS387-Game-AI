package behaviorTree;

import ch.idsia.agents.controllers.BasicMarioAIAgent;
import ch.idsia.agents.controllers.BehaviorAgent;
import ch.idsia.benchmark.mario.engine.sprites.Mario;

public class ShootAction implements Task {
	public boolean run(BehaviorAgent b) {
		b.shootKey();
		
		System.out.println("Shoot");
		return true;
	}
}
