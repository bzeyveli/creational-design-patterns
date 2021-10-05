package com.example.creationaldesignpatterns.factory.business;

import com.example.creationaldesignpatterns.factory.entitiy.Arcade;
import com.example.creationaldesignpatterns.factory.entitiy.Game;
import com.example.creationaldesignpatterns.factory.entitiy.Pc;
import com.example.creationaldesignpatterns.factory.entitiy.Ps;

public class GameFactory {

	public Game gameFactory(Games gameType) {

			switch (gameType) {
			case ARCADE:return new Arcade();
			case PS: return new Ps();
			case PC: return new Pc();
			default:
				throw new UnsupportedOperationException();
			}

	}
		public enum  Games{
			ARCADE,PS,PC
		}
}