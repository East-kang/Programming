"""
[트리 순회]
1. 전위 순회(preOrder): 부모->왼자->오자
2. 중위 순회(inOrder): 왼자->부모->오자
3. 후위 순회(postOrder): 왼자->오자->부모
"""

import sys
input = sys.stdin.readline

N = int(input())
tree = dict()
for _ in range(N):
    parent, left, right = input().split()
    if parent not in tree:
        tree[parent] = []
    tree[parent].append(left)
    tree[parent].append(right)

def preOrder(root):
    if root != '.':
        print(root, end='')
        preOrder(tree[root][0])
        preOrder(tree[root][1])

def inOrder(root):
    if root != '.':
        inOrder(tree[root][0])
        print(root, end='')
        inOrder(tree[root][1])

def postOrder(root):
    if root != '.':
        postOrder(tree[root][0])
        postOrder(tree[root][1])
        print(root, end='')
preOrder('A')
print()
inOrder('A')
print()
postOrder('A')