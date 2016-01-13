The Solver can be compiled using ./sudoku && make from the root directory.
It can be called using 'java Solve' followed by the input.
The number 0 will be considered as a blank space, same as the character '-'. 
Otherwise, only numbers 1 through 9 will be accepted as valid board entries.

1. The algorithm is using a backtracking approach.  It will go through each
blank space and iterate through all 9 possible values.  After finding the first
valid number for that slot, the same steps is repeated for the next blank slot.
If it does not find a valid value for the current slot, it will return to the 
previous slot and try the next possible value there.

2. The algorithm is a depth-first search with n levels deep where n is the 
number of blank spaces, and m branches where m is the number of possible values
for each blank space.  At each of the nodes, it will check
whether the current value is valid, meaning 3 iterations of m comparisons. 
In the worst case, it will have a performance of O(n*m*m).  But since m is a 
constant 9 for this 9x9 sudoku board, it reduces to O(n) where n is the number 
of blank spaces.  In the best case, it will only have to try one value for each
blank space, but the complexity remains O(n).  The expected run time complexity
will be O(n) if the size of the board is fixed at 9x9.

3. I designed the algorithm this way because it was the most intuitive way
of solving the board without needing additional mathematical properties that
may reduce the number of possible values at each blank space.  Since it is
a depth-first search, it will cut down on the number of searches when
earlier solutions are found to be invalid.

4. I could potentially improve the performance by adding rules that try to 
reduce the number of possible values at each stage before iterating over them.
This will reduce the number of computations but will increase the complexity of
the code, making it harder to debug when edge cases happen.

 
