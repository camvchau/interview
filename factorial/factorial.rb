def factorial(x)
  if x < 0
    0
  elsif x <= 1
    1
  else 
    x * factorial(x - 1)
  end
end
