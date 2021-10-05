package com.example.creationaldesignpatterns.factory.runner;

import com.example.creationaldesignpatterns.factory.business.GameFactory;
import com.example.creationaldesignpatterns.factory.business.GameFactory.Games;
import com.example.creationaldesignpatterns.factory.entitiy.Game;

public class Runner {
	public static void main(String[] args) {
		
		Game game = null;
		GameFactory factory = new GameFactory();
		
		game = factory.gameFactory(Games.ARCADE);
		game.platform();
		
		game = factory.gameFactory(Games.PC);
		game.platform();
		
		game = factory.gameFactory(Games.PS);
		game.platform();

	}

}
