# Write a function that takes a number:
# 	- If that number is divisble by 3, return fizz
# 	- If that number is divisible by 5, return buzz
# 	- If that number is divisible by both, return fizzbuzz
# 	- Otherwise, return number as a string

# def fizzbuzz (num)
# 	if (num % 3 == 0) && (num % 5 == 0)
# 		return "FizzBuzz"
# 	elsif (num % 5 == 0)
# 		return "Buzz"
# 	elsif (num % 3 == 0)
# 		return "Fizz"
# 	else
# 		return num.to_s
# 	end
# end

def fizzbuzz (num)
 	return "FizzBuzz" if (num % 15 == 0)
	return "Buzz"  	  if (num % 5 == 0)
	return "Fizz" 	  if (num % 3 == 0)
	return num.to_s
end