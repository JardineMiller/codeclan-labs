class Pub
	attr_reader :name, :foods
	attr_accessor :till, :drinks

	def initialize(name, drinks, foods)
		@name = name
		@drinks = drinks || {}
		@foods = foods || {}
		@till = 0
	end

	def serve(customer, item)
		return if has_stock?(item) == false
		if @drinks.include?(item)
				return if customer.is_drunk? == true
				return if customer.is_of_age? == false
				customer.buy_drink(item)
				@till += item.price
				@drinks[item] -= 1
		end
		if @foods.include?(item)
			customer.buy_food(item)
			@till += item.price
			@foods[item] -= 1
		end
	end

	def stock_count(item)
		if @drinks.include?(item)
			return @drinks[item]
		end
		if @foods.include?(item)
			return @foods[item]
		end
	end

	def stock_value
		total_drinks = @drinks.reduce(0) {|sum, (item, quantity)| sum + (quantity * item.price)}
		total_foods = @foods.reduce(0) {|sum, (item, quantity)| sum + (quantity * item.price)}
		return total_drinks + total_foods
	end

end