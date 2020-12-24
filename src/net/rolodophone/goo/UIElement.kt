package net.rolodophone.goo

import org.openrndr.shape.Rectangle

abstract class UIElement {
	abstract val bounds: Rectangle

	var visible = true


	open fun abstractUpdate() {}
	abstract fun abstractDraw()

	open fun update() {
		abstractUpdate()
	}

	open fun draw() {
		if (visible) abstractDraw()
	}
}