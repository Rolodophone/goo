package net.rolodophone.goo

import org.openrndr.MouseButton

abstract class Clickable: UIElement() {
	var hovered = false
	var pressed = false
	var enabled = true

	open fun onClick() {}

	override fun update() {
		val prevPressed = pressed

		hovered = pg.mouse.position in bounds
		pressed = hovered && MouseButton.LEFT in pg.mouse.pressedButtons

		if (hovered && prevPressed && !pressed && enabled) {
			onClick()
		}

		abstractUpdate()
	}
}