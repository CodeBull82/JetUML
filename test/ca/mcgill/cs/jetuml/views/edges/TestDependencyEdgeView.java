/*******************************************************************************
 * JetUML - A desktop application for fast UML diagramming.
 *
 * Copyright (C) 2015-2018 by the contributors of the JetUML project.
 *
 * See: https://github.com/prmr/JetUML
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package ca.mcgill.cs.jetuml.views.edges;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.mcgill.cs.jetuml.JavaFXLoader;
import ca.mcgill.cs.jetuml.diagram.ClassDiagram;
import ca.mcgill.cs.jetuml.diagram.edges.DependencyEdge;
import ca.mcgill.cs.jetuml.diagram.nodes.ClassNode;
import ca.mcgill.cs.jetuml.geom.Rectangle;

public class TestDependencyEdgeView
{
	private ClassNode aNode1;
	private ClassNode aNode2;
	private DependencyEdge aEdge;
	private ClassDiagram aDiagram;
	
	/**
	 * Load JavaFX toolkit and environment.
	 */
	@BeforeClass
	@SuppressWarnings("unused")
	public static void setupClass()
	{
		JavaFXLoader loader = JavaFXLoader.instance();
	}
	
	@Before
	public void setup()
	{
		aNode1 = new ClassNode(); // Bounds [x=0,y=0, w=100, h=60]
		aNode2 = new ClassNode(); // Bounds [x=200,y=0, w=100, h=60]
		aEdge = new DependencyEdge();
		aDiagram = new ClassDiagram();
		
		aDiagram.restoreRootNode(aNode1);
		aDiagram.restoreRootNode(aNode2);
		aDiagram.restoreEdge(aEdge, aNode1, aNode2);
		
		aNode2.translate(200, 0);
	}
	
	@Test
	public void testEdgeViewBounds()
	{
		assertEquals(new Rectangle(99,23,102,12), aEdge.view().getBounds());

	}
}