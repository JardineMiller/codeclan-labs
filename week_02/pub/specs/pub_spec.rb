require('minitest/autorun')
require('minitest/rg')
require_relative('../pub.rb')
require_relative('../drink.rb')
require_relative('../customer.rb')
require_relative('../food.rb')

class TestPub < MiniTest::Test
	def setup	
		@whisky = Drink.new("whisky", 5, 5)
		@nannystate = Drink.new("nannystate", 3, 0)
		@brewdog = Drink.new("brewdog", 3, 3)
		@joker_ipa = Drink.new("joker_ipa", 4, 3)
		@punk_ipa = Drink.new("punk_ipa", 4, 3)
		@drinks = {
			@whisky => 100,
			@nannystate => 90,
			@brewdog => 50,
			@joker_ipa => 20,
			@punk_ipa => 0
		}

		@veggie_burger = Food.new("veggie_burger", 8, 4)
		@carrot = Food.new("carrot", 1, 1)
		@foods = {
			@veggie_burger => 10, 
			@carrot => 500
		}

		@pub = Pub.new("Mont Blanc", @drinks, @foods)
		@jardine = Customer.new("Jardine", 28, 40)
		@billy = Customer.new("Billy", 14, 100)
	end

	def test_buy_drink__wallet_decrease
		@pub.serve(@jardine, @whisky)
		assert_equal(35, @jardine.wallet)
	end

	def test_buy_drink__till_increase
		@pub.serve(@jardine, @whisky)
		assert_equal(5, @pub.till)
	end

	def test_buy_drink__customer_drunkness_increase
		@pub.serve(@jardine, @whisky)
		@pub.serve(@jardine, @brewdog)
		assert_equal(8, @jardine.drunkeness)
	end

	def test_buy_drink__customer_too_young
		result = @pub.serve(@billy, @whisky)
		assert_nil(result)
	end

	def test_sobriety_too_drunk
		@pub.serve(@jardine, @whisky)
		@pub.serve(@jardine, @whisky)
		@pub.serve(@jardine, @whisky)
		result = @pub.serve(@jardine, @whisky)
		assert_nil(result)
	end

	def test_buy_food__wallet_decrease
		@pub.serve(@jardine, @veggie_burger)
		assert_equal(32, @jardine.wallet)
	end

	def test_child_can_buy_food
		@pub.serve(@billy, @veggie_burger)
		assert_equal(92, @billy.wallet)
	end

	def test_buy_food__till_increase
		@pub.serve(@jardine, @veggie_burger)
		assert_equal(8, @pub.till)
	end

	def test_buy_food__customer_drunkness_decreases
		@pub.serve(@jardine, @whisky)
		@pub.serve(@jardine, @carrot)
		assert_equal(4, @jardine.drunkeness)
	end

	def test_customer_age_check
		assert_equal(false, @billy.is_of_age?)
	end

	def test_customer_drunkeness_check
		@pub.serve(@jardine, @whisky)
		@pub.serve(@jardine, @whisky)
		@pub.serve(@jardine, @whisky)
		@pub.serve(@jardine, @brewdog)
		assert_equal(true, @jardine.is_drunk?)
	end

	def test_drink_stock_count
		assert_equal(100, @pub.stock_count(@whisky))
	end

	def test_drink_stock_count_after_purchase
		@pub.serve(@jardine, @whisky)
		assert_equal(99, @pub.stock_count(@whisky))
	end

	def test_food_stock_count
		assert_equal(10, @pub.stock_count(@veggie_burger))
	end

		def test_food_stock_count_after_purchase
		@pub.serve(@jardine, @veggie_burger)
		assert_equal(9, @pub.stock_count(@veggie_burger))
	end

	def test_out_of_stock
		assert_nil(@pub.serve(@jardine, @punk_ipa))
	end

	def test_stock_value
		assert_equal(1580, @pub.stock_value)
	end

end