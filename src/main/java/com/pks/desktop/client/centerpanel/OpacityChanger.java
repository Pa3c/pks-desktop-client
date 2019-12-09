package com.pks.desktop.client.centerpanel;


import javafx.animation.AnimationTimer;
import javafx.scene.Node;

public class OpacityChanger extends AnimationTimer {
		Node node;
		double opacity = 0;

		public OpacityChanger(Node node) {
			super();
			this.node = node;
		}

		@Override
		public void handle(long now) {
			doHandle();
		}

		private void doHandle() {
			if (node == null) {
				System.out.println("Can't change opacity of null");
				return;
			}

			opacity += 0.01;
			node.opacityProperty().set(opacity);
			if (opacity >= 1) {
				stop();
			}
		}
	}