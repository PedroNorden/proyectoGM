package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

	public class GameLluviaMenu extends Game {

		private static GameLluviaMenu instance;
		
		private SpriteBatch batch;
		private BitmapFont font;
		private int higherScore;
		private Nivel nivelActual;
		private int nivelNumero;

		private GameLluviaMenu() {}
		
		public void create() {
			batch = new SpriteBatch();
			font = new BitmapFont(); // use libGDX's default Arial font
			this.setScreen(new MainMenuScreen(this));
			nivelNumero = 1;
		}
		
		private void cargarNivel(int nivelNumero) {
			switch(nivelNumero) {
			case 1:
				nivelActual = new NivelUno(this);
				break;
			case 2:
				nivelActual = new NivelDos(this);
				break;
			case 3:
				nivelActual = new NivelTres(this);
				break;
			}
			setScreen(nivelActual);
		}
		
		public void avanzarAlSiguienteNivel() {
			nivelNumero++;
			cargarNivel(nivelNumero);
		}

		public void render() {
			super.render(); // important!
		}

		public void dispose() {
			batch.dispose();
			font.dispose();
		}

		public SpriteBatch getBatch() {
			return batch;
		}

		public BitmapFont getFont() {
			return font;
		}

		public int getHigherScore() {
			return higherScore;
		}

		public void setHigherScore(int higherScore) {
			this.higherScore = higherScore;
		}
		
		public static GameLluviaMenu getInstance() {
			if(instance == null) {
				instance = new GameLluviaMenu();
			}
			return instance;
		}

	}
