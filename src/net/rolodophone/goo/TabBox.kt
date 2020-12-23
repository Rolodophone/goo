package net.rolodophone.goo

import org.openrndr.Program

class TabBox(
	var tabs: List<Tab> = listOf(Tab("Tab 1", setOf()), Tab("Tab 2", setOf())),
	override var x: Double,
	override var y: Double,
	override var width: Double = 250.0,
	override var height: Double = 40.0
) : UIElement() {

	override fun abstractUpdate(drawer: Drawer, program: Program) {

	}

	override fun abstractDraw() {

	}


	class Tab(label: String, elements: Set<UIElement>)
}