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
		@drinks = [@whisky, @nannystate, @brewdog, @joker_ipa]

		@veggie_burger = Food.new("veggie_burger", 8, 4)
		@carrot = Food.new("carrot", 1, 1)
		@foods = [@veggie_burger, @carrot]

		@pub = Pub.new("Mont Blanc", @drinks, @foods)
		@jardine = Customer.new("Jardine", 28, 40)
		@billy = Customer.new("Billy", 14, 100)
	end

	def test_pub_name
		assert_equal("Mont Blanc", @pub.name)
	end

	def test_pub_first_drink
		first_drink = @pub.drinks[0].name
		assert_equal("whisky", first_drink)
	end

	def test_buy_drink__wallet_decrease
		@jardine.buy_drink("whisky", @pub)
		assert_equal(35, @jardine.wallet)
	end

	def test_buy_drink__till_increase
		@jardine.buy_drink("whisky", @pub)
		assert_equal(5, @pub.till)
	end

	def test_buy_drink__customer_drunkness_increase
		@jardine.buy_drink("whisky", @pub)
		@jardine.buy_drink("brewdog", @pub)
		assert_equal(8, @jardine.drunkeness)
	end

	def test_buy_drink__customer_too_young
		result = @billy.buy_drink("whisky", @pub)
		assert_equal(false, result)
	end

	def test_sobriety_too_drunk
		@jardine.buy_drink("whisky", @pub)
		@jardine.buy_drink("whisky", @pub)
		@jardine.buy_drink("whisky", @pub)
		result = @jardine.buy_drink("brewdog", @pub)
		assert_equal(false, result)
	end

	def test_buy_food__wallet_decrease
		@jardine.buy_food("veggie_burger", @pub)
		assert_equal(32, @jardine.wallet)
	end

	def test_buy_food__till_increase
		@jardine.buy_food("veggie_burger", @pub)
		assert_equal(8, @pub.till)
	end

	def test_buy_food__customer_drunkness_decreases
		@jardine.buy_drink("whisky", @pub)
		@jardine.buy_food("carrot", @pub)
		assert_equal(4, @jardine.drunkeness)
	end

	def test_customer_age_check
		assert_equal(false, @pub.check_customer_age(@billy))
	end

	def test_customer_drunkeness_check
		@jardine.buy_drink("whisky", @pub)
		@jardine.buy_drink("whisky", @pub)
		@jardine.buy_drink("whisky", @pub)
		@jardine.buy_drink("brewdog", @pub)
		assert_equal(false, @pub.check_customer_drunkeness(@jardine))
	end

end