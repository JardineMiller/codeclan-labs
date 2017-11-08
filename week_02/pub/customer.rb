class Customer
	attr_reader :name, :age
	attr_accessor :wallet, :drunkeness

	def initialize(name, age, wallet)
		@name = name
		@age = age
		@wallet = wallet
		@drunkeness = 0		
	end

	def buy_drink(drink_name, pub)
		if @age > 18 && @drunkeness <= 14
			for drink in pub.drinks
				if drink.name == drink_name
					@wallet -= drink.price
					@drunkeness += drink.alcohol_level
					pub.till += drink.price
				end
			end
		else
			return false
		end
	end

	def buy_food(food_name, pub)
		for food in pub.foods
			if food.name == food_name
				@wallet -= food.price
				@drunkeness -= food.rejuvenation
				pub.till += food.price
			end
		end
	end

end