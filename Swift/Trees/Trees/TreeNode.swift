//
//  TreeNode.swift
//  Trees
//

import Foundation

public class TreeNode<T> {
  public var value: T
  public var children: [TreeNode] = []

  public init(_ value: T) {
    self.value = value
  }
  
  public func add(_ child: TreeNode) {
    children.append(child)
  }
}

// #####     #####      #####     #####     #####
//      #####      #####     #####     #####
// #####     #####      #####     #####     #####

extension TreeNode {
  public func forEachDepthFirst(visit: (TreeNode) -> Void) {
    visit(self)
    children.forEach {
      $0.forEachDepthFirst(visit: visit)
    }
  }
}

// #####     #####      #####     #####     #####
//      #####      #####     #####     #####
// #####     #####      #####     #####     #####

extension TreeNode {
  public func forEachBreadthFirst(visit: (TreeNode) -> Void)
  {
    var queue : [TreeNode] = []
    
    visit(self)
    for child in children {
      queue.append(child)
    }
    
    var idx = 0
    while (idx < queue.count)
    {
      let node = queue[idx]
      visit(node)
      idx += 1
      for grandChild in node.children
      {
        queue.append(grandChild)
      }
    }
  }
}
