

#### postorder traversal binary search tree using stack
1. Create an empty stack
2.
    1. Do following while root is not NULL
  	 a. Push root's right child and then root to stack.
   	 b.  Set root as root's left child.
   	 
    2. Pop an item from stack and set it as root.
    	a.  If the popped item has a right child and the right child 
is at top of stack, then remove the right child from stack, push the root back and set root as root's right child.
   	 b.  Else print root's data and set root as NULL.
   	 
3  Repeat steps 2.1 and 2.2 while stack is not empty.

using two stack
1.  Push root to first stack.
2.  Loop while first stack is not empty

    1. Pop a node from first stack and push it to second stack
    2. Push left and right children of the popped node to first stack 
    
3. Print contents of second stack