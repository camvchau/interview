/*
  Computes the factorial of the integer x.
  If x is less than 0, will return 0.
*/
int factorial(int x) {
  if(x < 0) return 0;

  int result = 1;
  while(x > 0){
    result *= x;
    x -= 1;
  }
  return result;
}
