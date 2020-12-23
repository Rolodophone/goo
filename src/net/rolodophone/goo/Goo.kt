package net.rolodophone.goo

import org.openrndr.Extension
import org.openrndr.Program
import org.openrndr.draw.Drawer

class Goo(private val root: UIElement): Extension {
	override var enabled = true

	override fun afterDraw(drawer: Drawer, program: Program) {
		root.update(drawer, program)
	}
}