//
//  main.swift
//  Trees
//

import Foundation

func makeBeverageTree() -> TreeNode<String> { let tree = TreeNode("beverages")
  let hot = TreeNode("hot")
  let cold = TreeNode("cold")
  let tea = TreeNode("tea")
  let coffee = TreeNode("coffee")
  let chocolate = TreeNode("cocoa")
  let blackTea = TreeNode("black")
  let greenTea = TreeNode("green")
  let chaiTea = TreeNode("chai")
  let limo = TreeNode("lemonade")
  let milk = TreeNode("milk")
  let gingerAle = TreeNode("orange")
  let bitterLemon = TreeNode("citrone")
  
  tree.add(hot)
  tree.add(cold)
  hot.add(tea)
  hot.add(coffee)
  hot.add(chocolate)
  cold.add(limo)
  cold.add(milk)
  tea.add(blackTea)
  tea.add(greenTea)
  tea.add(chaiTea)
  limo.add(gingerAle)
  limo.add(bitterLemon)

  return tree
}

let tree = makeBeverageTree()
tree.forEachDepthFirst{print($0.value)}
print()
tree.forEachBreadthFirst{print($0.value)}
