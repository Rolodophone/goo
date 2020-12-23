package net.rolodophone.goo

import org.openrndr.MouseButton
import org.openrndr.Program
import org.openrndr.draw.Drawer

abstract class Clickable: UIElement() {
	var hovered = false
	var pressed = false

	open fun onClick() {}


	override fun update(drawer: Drawer, program: Program) {
		abstractUpdate(drawer, program)

		val prevPressed = pressed

		hovered = program.mouse.position in bounds
		pressed = hovered && MouseButton.LEFT in program.mouse.pressedButtons

		if (hovered && prevPressed && !pressed) {
			onClick()
		}

		abstractDraw(drawer, program)
	}
}