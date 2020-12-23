package net.rolodophone.goo

import org.openrndr.Program
import org.openrndr.draw.Drawer
import org.openrndr.shape.Rectangle

abstract class UIElement {
	abstract var bounds: Rectangle

	var visible = true


	open fun abstractUpdate(drawer: Drawer, program: Program) {}
	abstract fun abstractDraw(drawer: Drawer, program: Program)

	open fun update(drawer: Drawer, program: Program) {
		abstractUpdate(drawer, program)
		if (visible) abstractDraw(drawer, program)
	}
}