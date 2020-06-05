//
//  BinaryNode.swift
//  BinaryTrees
//

import Foundation

public class BinaryNode<Element> {
  public var value: Element
  public var leftChild: BinaryNode?
  public var rightChild: BinaryNode?
  public init(value: Element) {
    self.value = value
  }
}
