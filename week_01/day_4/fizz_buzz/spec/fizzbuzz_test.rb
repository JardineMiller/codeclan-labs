require('minitest/autorun')
require('minitest/rg')
require_relative('../fizzbuzz.rb')

class FizzBuzzPractice < MiniTest::Test
	def test_fizzbuzz_3_returns_fizz
		assert_equal("Fizz", fizzbuzz(3))
	end

	def test_fizzbuzz_5_returns_buzz
		# skip
		assert_equal("Buzz", fizzbuzz(5))
	end

	def test_fizzbuzz_15_returns_fizzbuzz
		# skip
		assert_equal("FizzBuzz", fizzbuzz(15))
	end

	def test_fizzbuzz_16_returns_num_as_string
		# skip
		assert_equal("16", fizzbuzz(16))
	end
end