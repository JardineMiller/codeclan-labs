class Pub
	attr_reader :name, :drinks, :foods
	attr_accessor :till

	def initialize(name, drinks, foods)
		@name = name
		@drinks = drinks
		@foods = foods
		@till = 0
	end

	def check_customer_age(customer)
		return true if customer.age >= 18 
		return false
	end

	def check_customer_drunkeness(customer)
		return true if customer.drunkeness <= 14 
		return false
	end
end