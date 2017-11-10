class Customer
	attr_reader :name, :age, :hand
	attr_accessor :wallet, :drunkeness

	def initialize(name, age, wallet)
		@name = name
		@age = age
		@wallet = wallet
		@drunkeness = 0	
	end

	def is_drunk?
		@drunkeness <= 14 ? false : true
	end

	def is_of_age?
		@age >= 18 ? true : false
	end

	def sufficient_funds?(drink)
		@wallet >= drink.price
	end

	def buy_drink(drink)
		if sufficient_funds?(drink)
			@wallet -= drink.price
			@drunkeness += drink.alcohol_level
		end
	end

	def buy_food(food)
		if sufficient_funds?(food)
			@wallet -= food.price
			@drunkeness -= food.rejuvenation
		end
	end

end